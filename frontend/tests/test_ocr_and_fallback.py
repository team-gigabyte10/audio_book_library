import pytest
from app.models.schemas import PageResult, PageType
from app.services.ocr_service import OCRService
from app.services.job_manager import JobManager


def test_page_result_fallback_fields():
    res = PageResult(
        page_number=1,
        processing_method="text_extraction",
        page_type=PageType.SCANNED,
        fallback_used=True,
        fallback_reason="ocr_unavailable"
    )
    assert res.fallback_used is True
    assert res.fallback_reason == "ocr_unavailable"
    assert res.processing_method == "text_extraction"

    d = res.model_dump()
    assert d["fallback_used"] is True
    assert d["fallback_reason"] == "ocr_unavailable"


def test_ocr_service_check_availability():
    service = OCRService()
    avail, msg = service.check_availability()
    assert isinstance(avail, bool)
    assert isinstance(msg, str)
    assert len(msg) > 0


def test_job_manager_page_result_formatting(tmp_path):
    jm = JobManager(data_dir=str(tmp_path))
    job = jm.create_job(
        job_id="test_job_1",
        original_filename="sample.pdf",
        stored_filepath="dummy.pdf",
        file_size=1024
    )
    assert job["job_id"] == "test_job_1"
    assert "ocr_available" in job
