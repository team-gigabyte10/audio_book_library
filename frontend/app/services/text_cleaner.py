import re
import unicodedata
from app.services.font_converter import font_converter, direct_unicode_converter


class BanglaTextCleaner:
    """
    Cleans raw extracted Bangla text (from PDF text extraction or Tesseract OCR)
    to normalize whitespace, convert legacy Bijoy/ANSI fonts, remove page headers/footers/numbers,
    and clean OCR artifacts without corrupting Bangla Unicode glyphs or paragraph structures.
    """

    # Bengali digits: ০ ১ ২ ৩ ৪ ৫ ৬ ৭ ৮ ৯
    BENGALI_DIGITS = r"[০-৯]"
    
    def clean(self, raw_text: str) -> str:
        if not raw_text:
            return ""

        # 0. Convert legacy Bijoy/ANSI fonts or fix corrupted glyph patterns
        text = font_converter.convert(raw_text)

        # 0b. Direct Bangla Unicode reconstruction (vowels, conjuncts, OCR punctuation)
        text = direct_unicode_converter.convert(text)

        # 1. Normalize line endings (\r\n -> \n)
        text = text.replace("\r\n", "\n").replace("\r", "\n")

        # 2. Fix multiple horizontal spaces/tabs (keep line breaks)
        text = re.sub(r"[ \t]+", " ", text)

        # 3. Strip spaces at the beginning and end of each line
        lines = [line.strip() for line in text.split("\n")]
        total_lines = len(lines)

        cleaned_lines = []
        for i, line in enumerate(lines):
            # Check for page numbers in top 2 lines or bottom 2 lines
            if (i < 2 or i >= total_lines - 2) and self._is_page_number_line(line):
                continue
            
            # Remove typical header/footer lines if trivial noise
            if self._is_header_footer_artifact(line):
                continue

            cleaned_lines.append(line)

        text = "\n".join(cleaned_lines)

        # 4. Join hyphenated words split across line breaks (e.g. "শব্দ-\nশেষ" -> "শব্দশেষ")
        text = re.sub(r"([ক-হ০-৯a-zA-Z])-\n([ক-হ০-৯a-zA-Z])", r"\1\2", text)

        # 5. Join soft line wraps within paragraphs (lines not ending in punctuation)
        text = self._join_paragraph_lines(text)

        # 6. Normalize multiple consecutive blank lines (max 2 consecutive newlines)
        text = re.sub(r"\n{3,}", "\n\n", text)

        # 7. Fix common OCR spaces before punctuation (e.g. "শব্দ ।" -> "শব্দ।")
        text = re.sub(r"\s+([।?!.,;:])", r"\1", text)

        # 8. Final Unicode NFC normalization
        text = unicodedata.normalize('NFC', text)

        return text.strip()

    def _join_paragraph_lines(self, text: str) -> str:
        """
        Joins soft line breaks within paragraphs while preserving double newlines (paragraph breaks).
        """
        paragraphs = text.split("\n\n")
        joined_paragraphs = []

        for p in paragraphs:
            lines = [l.strip() for l in p.split("\n") if l.strip()]
            if not lines:
                continue
            
            p_text = lines[0]
            for next_line in lines[1:]:
                # If current text ends with punctuation or next line starts with a list bullet/heading, keep newline
                if re.search(r"[।?!.:;]$", p_text) or re.match(r"^(?:[০-৯0-9]+[\.\)]|[-•*])", next_line):
                    p_text += "\n" + next_line
                else:
                    p_text += " " + next_line

            joined_paragraphs.append(p_text)

        return "\n\n".join(joined_paragraphs)

    def _is_page_number_line(self, line: str) -> bool:
        """
        Checks if a single line contains only a page number (Bangla or English digits).
        """
        line_clean = line.strip(" -—_|[|]:.")
        if not line_clean:
            return False
        
        # Check if line matches Bangla or English digits only (e.g. "১২", "12", "পৃষ্ঠা ১২", "Page - 12")
        page_pattern = r"^(?:page|পৃষ্ঠা|পৃঃ)?\s*[-—:]?\s*(?:[0-9]+|[০-৯]+)\s*$"
        return bool(re.match(page_pattern, line_clean, re.IGNORECASE))

    def _is_header_footer_artifact(self, line: str) -> bool:
        """
        Detects repetitive OCR boundary artifacts like '---', '___', etc.
        """
        if re.match(r"^[-=_*\s~|]{3,}$", line):
            return True
        return False
