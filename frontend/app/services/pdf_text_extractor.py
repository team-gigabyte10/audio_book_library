import fitz  # PyMuPDF
from typing import Tuple, List, Dict, Any


class PDFTextExtractor:
    """
    Extracts text directly from vector/text-based PDF pages using PyMuPDF (fitz),
    preserving Bangla Unicode characters, paragraphs, and correct reading order.
    """

    def extract_page_text(self, pdf_path: str, page_number: int) -> Tuple[str, int, int]:
        """
        Extracts selectable text from a specific 1-indexed page number in proper reading order.
        Returns (raw_text, character_count, word_count)
        """
        doc = fitz.open(pdf_path)
        page_idx = page_number - 1

        if page_idx < 0 or page_idx >= len(doc):
            doc.close()
            raise ValueError(f"Page number {page_number} is out of range [1, {len(doc)}]")

        page = doc[page_idx]

        # Extract blocks with PyMuPDF sort=True
        blocks = page.get_text("blocks", sort=True)
        # Blocks format: (x0, y0, x1, y1, "text", block_no, block_type)
        # Filter for text blocks (block_type == 0 and non-empty text)
        text_blocks = [b for b in blocks if b[6] == 0 and b[4].strip()]

        sorted_blocks = self._sort_blocks_reading_order(text_blocks, page.rect.width)
        extracted_texts = [b[4].strip() for b in sorted_blocks]

        raw_text = "\n\n".join(extracted_texts).strip()
        doc.close()

        # Compute character and word metrics
        char_count = len(raw_text)
        word_count = len(raw_text.split())

        return raw_text, char_count, word_count

    def _sort_blocks_reading_order(self, blocks: List[Any], page_width: float) -> List[Any]:
        """
        Sorts text blocks in natural human reading order (detecting multi-column layouts).
        """
        if not blocks:
            return []

        mid_x = page_width / 2.0
        
        # Identify blocks on left vs right side
        left_blocks = [b for b in blocks if b[0] < mid_x and b[2] <= mid_x + 50]
        right_blocks = [b for b in blocks if b[0] >= mid_x - 50 and b[2] > mid_x]

        # Find vertical overlap between left and right side blocks to detect multi-column area
        overlapping_pairs = []
        for l_b in left_blocks:
            for r_b in right_blocks:
                overlap_top = max(l_b[1], r_b[1])
                overlap_bottom = min(l_b[3], r_b[3])
                if overlap_bottom - overlap_top > 10:
                    overlapping_pairs.append((l_b, r_b))

        if not overlapping_pairs:
            # Single-column page: sort purely top-to-bottom by y0, then left-to-right by x0
            return sorted(blocks, key=lambda b: (round(b[1], 1), round(b[0], 1)))

        # Determine the vertical range of the multi-column area
        col_overlap_min_y = min([min(l[1], r[1]) for l, r in overlapping_pairs])
        col_overlap_max_y = max([max(l[3], r[3]) for l, r in overlapping_pairs])

        top_blocks = []
        col1_blocks = []
        col2_blocks = []
        bottom_blocks = []

        for b in blocks:
            # Block is entirely above the multi-column area -> Top header block
            if b[3] <= col_overlap_min_y + 5:
                top_blocks.append(b)
            # Block is entirely below the multi-column area -> Bottom footer block
            elif b[1] >= col_overlap_max_y - 5:
                bottom_blocks.append(b)
            else:
                # Within multi-column Y range
                if b[2] <= mid_x + 30:
                    col1_blocks.append(b)
                elif b[0] >= mid_x - 30:
                    col2_blocks.append(b)
                else:
                    col1_blocks.append(b)

        top_blocks.sort(key=lambda b: (b[1], b[0]))
        col1_blocks.sort(key=lambda b: (b[1], b[0]))
        col2_blocks.sort(key=lambda b: (b[1], b[0]))
        bottom_blocks.sort(key=lambda b: (b[1], b[0]))

        return top_blocks + col1_blocks + col2_blocks + bottom_blocks

