import os
import json
import time
import datetime
import threading
import traceback
from typing import Dict, Any, List, Optional

from app.models.schemas import ProcessingStatusEnum, JobSummary, PageResult, PageType
from app.services.pdf_analyzer import PDFAnalyzer
from app.services.pdf_text_extractor import PDFTextExtractor
from app.services.image_preprocessor import ImagePreprocessor
from app.services.ocr_service import OCRService
from app.services.text_cleaner import BanglaTextCleaner
from app.services.chapter_detector import ChapterDetector


class JobManager:
    """
    Thread-safe background job processing manager.
    Tracks processing progress, maintains job status, and persists intermediate results.
    """

    def __init__(self, data_dir: str = "data"):
        self.data_dir = data_dir
        self.uploads_dir = os.path.join(data_dir, "uploads")
        self.processed_dir = os.path.join(data_dir, "processed")
        self.exports_dir = os.path.join(data_dir, "exports")

        for d in [self.uploads_dir, self.processed_dir, self.exports_dir]:
            os.makedirs(d, exist_ok=True)

        self._jobs: Dict[str, Dict[str, Any]] = {}
        self._lock = threading.Lock()
        self._active_threads: Dict[str, threading.Thread] = {}
        self._cancel_flags: Dict[str, bool] = {}

        # Load existing jobs from disk
        self._load_jobs_from_disk()

    def _load_jobs_from_disk(self):
        with self._lock:
            if not os.path.exists(self.processed_dir):
                return
            for filename in os.listdir(self.processed_dir):
                if filename.endswith(".json"):
                    job_id = filename[:-5]
                    filepath = os.path.join(self.processed_dir, filename)
                    try:
                        with open(filepath, "r", encoding="utf-8") as f:
                            data = json.load(f)
                            self._jobs[job_id] = data
                    except Exception:
                        pass

    def create_job(self, job_id: str, original_filename: str, stored_filepath: str, file_size: int) -> Dict[str, Any]:
        with self._lock:
            ocr_service = OCRService()
            ocr_avail, ocr_msg = ocr_service.check_availability()

            job_data = {
                "job_id": job_id,
                "original_filename": original_filename,
                "stored_filepath": stored_filepath,
                "file_size": file_size,
                "total_pages": 0,
                "text_pages": 0,
                "scanned_pages": 0,
                "mixed_pages": 0,
                "status": ProcessingStatusEnum.UPLOADED.value,
                "progress_percent": 0.0,
                "processed_pages": 0,
                "current_operation": "Uploaded",
                "estimated_remaining_seconds": None,
                "error_message": None,
                "chapters": [],
                "pages": [],
                "created_at": datetime.datetime.now().isoformat(),
                "completed_at": None,
                "ocr_available": ocr_avail,
                "ocr_message": ocr_msg
            }
            self._jobs[job_id] = job_data
            self._save_job_to_disk_unlocked(job_id)
            return job_data

    def get_job(self, job_id: str) -> Optional[Dict[str, Any]]:
        with self._lock:
            if job_id in self._jobs:
                return self._jobs[job_id]

            # Try fallback read from disk
            filepath = os.path.join(self.processed_dir, f"{job_id}.json")
            if os.path.exists(filepath):
                try:
                    with open(filepath, "r", encoding="utf-8") as f:
                        data = json.load(f)
                        self._jobs[job_id] = data
                        return data
                except Exception:
                    pass

            return None

    def list_jobs(self, limit: int = 10) -> List[Dict[str, Any]]:
        self._load_jobs_from_disk()
        with self._lock:
            jobs = list(self._jobs.values())
            jobs.sort(key=lambda j: j.get("created_at", ""), reverse=True)
            return jobs[:limit]

    def cancel_job(self, job_id: str) -> bool:
        with self._lock:
            if job_id in self._jobs:
                self._cancel_flags[job_id] = True
                self._jobs[job_id]["status"] = ProcessingStatusEnum.CANCELLED.value
                self._jobs[job_id]["current_operation"] = "Cancelled by user"
                self._save_job_to_disk_unlocked(job_id)
                return True
            return False

    def update_page_text(self, job_id: str, page_number: int, new_cleaned_text: str) -> bool:
        with self._lock:
            job = self._jobs.get(job_id)
            if not job:
                return False

            cleaner = BanglaTextCleaner()
            new_cleaned_text = cleaner.clean(new_cleaned_text)

            for p in job.get("pages", []):
                if p.get("page_number") == page_number:
                    p["cleaned_text"] = new_cleaned_text
                    p["character_count"] = len(new_cleaned_text)
                    p["word_count"] = len(new_cleaned_text.split())
                    self._save_job_to_disk_unlocked(job_id)
                    return True
            return False

    def start_processing(self, job_id: str):
        thread = threading.Thread(target=self._run_pipeline, args=(job_id,), daemon=True)
        self._active_threads[job_id] = thread
        thread.start()

    def _run_pipeline(self, job_id: str):
        job = self.get_job(job_id)
        if not job:
            return

        pdf_path = job["stored_filepath"]

        try:
            # 1. ANALYZING STAGE
            with self._lock:
                job["status"] = ProcessingStatusEnum.ANALYZING.value
                job["current_operation"] = "Analyzing PDF structure..."
                self._save_job_to_disk_unlocked(job_id)

            analyzer = PDFAnalyzer()
            summary, page_analysis = analyzer.analyze_pdf(pdf_path)

            with self._lock:
                job["total_pages"] = summary["total_pages"]
                job["text_pages"] = summary["text_pages"]
                job["scanned_pages"] = summary["scanned_pages"]
                job["mixed_pages"] = summary["mixed_pages"]
                self._save_job_to_disk_unlocked(job_id)

            # Services setup
            extractor = PDFTextExtractor()
            preprocessor = ImagePreprocessor(dpi=300)
            ocr_service = OCRService()
            cleaner = BanglaTextCleaner()
            detector = ChapterDetector()

            ocr_available, ocr_msg = ocr_service.check_availability()

            processed_pages = []
            total = summary["total_pages"]
            start_time = time.time()

            # 2. EXTRACTING & OCR STAGE
            for i, p_info in enumerate(page_analysis):
                if self._cancel_flags.get(job_id):
                    return

                page_num = p_info["page_number"]
                page_type_str = p_info["page_type"]
                page_start = time.time()

                # Status update
                with self._lock:
                    if page_type_str == PageType.SCANNED.value or page_type_str == PageType.MIXED.value:
                        job["status"] = ProcessingStatusEnum.OCR_PROCESSING.value
                        job["current_operation"] = f"Running Bangla OCR (Page {page_num}/{total})"
                    else:
                        job["status"] = ProcessingStatusEnum.EXTRACTING.value
                        job["current_operation"] = f"Extracting Bangla text (Page {page_num}/{total})"

                    job["processed_pages"] = i
                    job["progress_percent"] = round((i / max(total, 1)) * 90.0, 1)

                    # Estimate remaining time
                    elapsed = time.time() - start_time
                    if i > 0:
                        avg_per_page = elapsed / i
                        rem_pages = total - i
                        job["estimated_remaining_seconds"] = round(avg_per_page * rem_pages, 1)

                    self._save_job_to_disk_unlocked(job_id)

                # Page execution logic
                raw_text = ""
                cleaned_text = ""
                ocr_used = False
                confidence = None
                processing_method = "text_extraction"
                fallback_used = False
                fallback_reason = None

                if page_type_str == PageType.TEXT.value:
                    try:
                        raw_text, _, _ = extractor.extract_page_text(pdf_path, page_num)
                        processing_method = "text_extraction"
                        
                        # Check if extracted text is garbled by legacy font encoding
                        if raw_text and font_converter.is_legacy_bijoy(raw_text):
                            if ocr_available:
                                try:
                                    img = preprocessor.render_page_to_image(pdf_path, page_num)
                                    prep_img = preprocessor.preprocess_image(img)
                                    ocr_text, _, _, confidence = ocr_service.process_image(prep_img)
                                    if ocr_text and len(ocr_text.strip()) > 10:
                                        raw_text = ocr_text
                                        ocr_used = True
                                        processing_method = "ocr"
                                except Exception:
                                    pass
                    except Exception as ex:
                        if ocr_available:
                            try:
                                img = preprocessor.render_page_to_image(pdf_path, page_num)
                                prep_img = preprocessor.preprocess_image(img)
                                raw_text, _, _, confidence = ocr_service.process_image(prep_img)
                                ocr_used = True
                                processing_method = "ocr"
                            except Exception:
                                fallback_used = True
                                fallback_reason = "extraction_and_ocr_failed"
                        else:
                            fallback_used = True
                            fallback_reason = "text_extraction_failed"

                elif page_type_str in [PageType.SCANNED.value, PageType.MIXED.value]:
                    if not ocr_available:
                        raw_text, _, _ = extractor.extract_page_text(pdf_path, page_num)
                        processing_method = "text_extraction"
                        fallback_used = True
                        fallback_reason = "ocr_unavailable"
                    else:
                        try:
                            img = preprocessor.render_page_to_image(pdf_path, page_num)
                            prep_img = preprocessor.preprocess_image(img)
                            raw_text, _, _, confidence = ocr_service.process_image(prep_img)
                            ocr_used = True
                            processing_method = "ocr"
                        except Exception as ocr_ex:
                            raw_text, _, _ = extractor.extract_page_text(pdf_path, page_num)
                            processing_method = "text_extraction"
                            fallback_used = True
                            fallback_reason = "ocr_failed"

                # Clean text
                cleaned_text = cleaner.clean(raw_text)
                duration = round(time.time() - page_start, 2)

                page_res = {
                    "page_number": page_num,
                    "processing_method": processing_method,
                    "page_type": page_type_str,
                    "raw_text": raw_text,
                    "cleaned_text": cleaned_text,
                    "character_count": len(cleaned_text),
                    "word_count": len(cleaned_text.split()),
                    "processing_time": duration,
                    "ocr_used": ocr_used,
                    "confidence_if_available": confidence,
                    "fallback_used": fallback_used,
                    "fallback_reason": fallback_reason
                }

                processed_pages.append(page_res)
                with self._lock:
                    job["pages"] = processed_pages
                    self._save_job_to_disk_unlocked(job_id)

            # 3. CLEANING & CHAPTER DETECTION STAGE
            with self._lock:
                job["status"] = ProcessingStatusEnum.CLEANING.value
                job["current_operation"] = "Detecting chapter headings..."
                job["progress_percent"] = 95.0
                self._save_job_to_disk_unlocked(job_id)

            chapters = detector.detect_chapters(processed_pages)

            # 4. COMPLETED STAGE
            with self._lock:
                job["status"] = ProcessingStatusEnum.COMPLETED.value
                job["progress_percent"] = 100.0
                job["processed_pages"] = total
                job["current_operation"] = "Processing completed successfully!"
                job["estimated_remaining_seconds"] = 0
                job["chapters"] = [c.model_dump() for c in chapters]
                job["completed_at"] = datetime.datetime.now().isoformat()
                self._save_job_to_disk_unlocked(job_id)

        except Exception as err:
            tb = traceback.format_exc()
            with self._lock:
                job["status"] = ProcessingStatusEnum.FAILED.value
                job["current_operation"] = "Failed"
                job["error_message"] = f"Processing failed: {str(err)}"
                self._save_job_to_disk_unlocked(job_id)

    def _save_job_to_disk_unlocked(self, job_id: str):
        if job_id in self._jobs:
            file_path = os.path.join(self.processed_dir, f"{job_id}.json")
            try:
                with open(file_path, "w", encoding="utf-8") as f:
                    json.dump(self._jobs[job_id], f, ensure_ascii=False, indent=2)
            except Exception:
                pass


# Global singleton instance
job_manager = JobManager()
