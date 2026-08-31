import fitz  # PyMuPDF
from typing import Dict, List, Tuple
from app.models.schemas import PageType
from app.services.font_converter import font_converter


class PDFAnalyzer:
    """
    Analyzes PDF document pages to detect whether pages are text-based,
    scanned images, garbled font encoding, or mixed layout.
    """

    def analyze_pdf(self, pdf_path: str) -> Tuple[Dict[str, int], List[Dict[str, str]]]:
        """
        Analyzes every page of the given PDF file.
        Returns:
            - summary dict with counts: total_pages, text_pages, scanned_pages, mixed_pages
            - list of page details containing page_number and classified PageType
        """
        doc = fitz.open(pdf_path)
        total_pages = len(doc)

        text_pages = 0
        scanned_pages = 0
        mixed_pages = 0

        page_analysis = []

        for i in range(total_pages):
            page = doc[i]
            page_num = i + 1
            p_type = self.classify_page(page)

            if p_type == PageType.TEXT:
                text_pages += 1
            elif p_type == PageType.SCANNED:
                scanned_pages += 1
            else:
                mixed_pages += 1

            page_analysis.append({
                "page_number": page_num,
                "page_type": p_type.value
            })

        doc.close()

        summary = {
            "total_pages": total_pages,
            "text_pages": text_pages,
            "scanned_pages": scanned_pages,
            "mixed_pages": mixed_pages
        }

        return summary, page_analysis

    def classify_page(self, page: fitz.Page) -> PageType:
        """
        Classifies a single PDF page into TEXT, SCANNED, or MIXED.
        """
        text = page.get_text("text").strip()
        non_space_chars = len([c for c in text if not c.isspace()])
        
        # Check if text layer contains garbled legacy font encoding (e.g. Bornopata/Bijoy ASCII)
        if text and font_converter.is_legacy_bijoy(text):
            return PageType.SCANNED

        images = page.get_images(full=True)
        page_area = abs(page.rect.width * page.rect.height)
        
        # Calculate image area coverage if page has images
        image_area_coverage = 0.0
        if images and page_area > 0:
            for img in images:
                try:
                    # Get drawing rects for image if available
                    rects = page.get_image_rects(img[0])
                    for r in rects:
                        image_area_coverage += abs(r.width * r.height)
                except Exception:
                    pass
            image_area_ratio = min(image_area_coverage / page_area, 1.0)
        else:
            image_area_ratio = 0.0

        # Classification heuristics
        if non_space_chars < 20 and (images or len(page.get_drawings()) > 0 or image_area_ratio > 0.3):
            return PageType.SCANNED
        elif non_space_chars < 15:
            # Very little text - check if rendering produces non-white background/scanned content
            return PageType.SCANNED if images else PageType.TEXT
        elif non_space_chars >= 50 and image_area_ratio > 0.4:
            return PageType.MIXED
        else:
            return PageType.TEXT
