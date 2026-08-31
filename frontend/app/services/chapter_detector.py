import re
from typing import List, Dict, Any
from app.models.schemas import ChapterInfo


class ChapterDetector:
    """
    Heuristic detector for Bangla and English chapter headings across document pages.
    """

    # Regex patterns for Bangla & English chapter titles
    CHAPTER_PATTERNS = [
        # Bangla patterns: অধ্যায় ১, অধ্যায়-১, অধ্যায় ২, ইত্যাদি
        r"^(?:অধ্যায়|অধ্যায়)\s*[-—:\s]*\s*(?:[০-৯]+|[0-9]+|[এক|দুই|তিন|চার|পাঁচ|ছয়|সাত|আট|নয়|দশ]+)(?:.*)?$",
        # Bangla lesson patterns: পাঠ ১, পাঠ-১, পাঠ ২
        r"^(?:পাঠ)\s*[-—:\s]*\s*(?:[০-৯]+|[0-9]+)(?:.*)?$",
        # Common structural sections: ভূমিকা, উপসংহার, সূচিপত্র, মানসিকতা, সাফল্যের পথে, ইত্যাদি
        r"^(?:ভূমিকা|সূচিপত্র|উপসংহার|মানসিকতার পার্থক্য|সাফল্যের পথে|যাত্রা শুরু করার|আর্থিক স্বাধীনতার|মূল লেখক)(?:.*)?$",
        # Ordinal patterns: প্রথম অধ্যায়, দ্বিতীয় অধ্যায়
        r"^(?:প্রথম|দ্বিতীয়|তৃতীয়|চতুর্থ|পঞ্চম|ষষ্ঠ|সপ্তম|অষ্টম|নবম|দশম)\s+(?:অধ্যায়|অধ্যায়)(?:.*)?$",
        # English patterns: Chapter 1, CHAPTER - 2
        r"^CHAPTER\s*[-—:\s]*\s*[0-9]+(?:.*)?$",
        r"^Chapter\s*[-—:\s]*\s*[0-9]+(?:.*)?$"
    ]

    def detect_chapters(self, pages: List[Dict[str, Any]]) -> List[ChapterInfo]:
        """
        Analyzes a list of page dicts (containing page_number and cleaned_text)
        and detects chapter boundaries.
        Returns a list of ChapterInfo objects.
        """
        detected: List[Dict[str, Any]] = []

        for page in pages:
            page_num = page.get("page_number", 1)
            text = page.get("cleaned_text") or page.get("raw_text") or ""
            
            lines = [line.strip() for line in text.split("\n") if line.strip()]
            
            # Check the first few lines of each page for chapter headings
            for line in lines[:3]:
                for pattern in self.CHAPTER_PATTERNS:
                    if re.match(pattern, line, re.IGNORECASE):
                        title = line[:60]  # Cap title length
                        detected.append({
                            "title": title,
                            "start_page": page_num
                        })
                        break
                else:
                    continue
                break

        if not detected:
            return []

        # Calculate end_page for each detected chapter
        chapters: List[ChapterInfo] = []
        total_pages = max([p.get("page_number", 1) for p in pages], default=1)

        for i in range(len(detected)):
            start_p = detected[i]["start_page"]
            if i < len(detected) - 1:
                end_p = detected[i + 1]["start_page"] - 1
                if end_p < start_p:
                    end_p = start_p
            else:
                end_p = total_pages

            chapters.append(ChapterInfo(
                title=detected[i]["title"],
                start_page=start_p,
                end_page=end_p
            ))

        return chapters
