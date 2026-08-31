import os
import fitz
import pytest
from app.services.font_converter import font_converter
from app.services.pdf_text_extractor import PDFTextExtractor
from app.services.text_cleaner import BanglaTextCleaner
from app.services.image_preprocessor import ImagePreprocessor


def test_font_converter_unicode_safety():
    # Verify that valid Unicode Bangla words are never corrupted
    sample_words = ["একটি", "ছোট", "মাটি", "ডাক্তার", "বট", "শিক্ষা", "বাংলাদেশ"]
    for word in sample_words:
        converted = font_converter.convert(word)
        assert converted == word, f"Expected '{word}', but got '{converted}'"


def test_text_cleaner_paragraph_joining_and_cleaning():
    cleaner = BanglaTextCleaner()

    raw_text = """ - ১২ - 
বাংলাদেশ একটি সুন্দর
এবং নদীমাতৃক দেশ।

পৃষ্ঠা: ১৩"""

    cleaned = cleaner.clean(raw_text)

    # Verify line joining within paragraph and removal of page header/footer
    assert "বাংলাদেশ একটি সুন্দর এবং নদীমাতৃক দেশ।" in cleaned
    assert "- ১২ -" not in cleaned
    assert "পৃষ্ঠা: ১৩" not in cleaned


def test_multi_column_reading_order(tmp_path):
    pdf_path = str(tmp_path / "multi_column_test.pdf")
    doc = fitz.open()
    page = doc.new_page(width=600, height=800)

    # Header spanning across top
    page.insert_text(fitz.Point(50, 50), "Header Chapter 1 - Introduction", fontsize=16)

    # Left Column
    page.insert_text(fitz.Point(50, 120), "Left Column line 1 text", fontsize=12)
    page.insert_text(fitz.Point(50, 160), "Left Column line 2 text", fontsize=12)

    # Right Column
    page.insert_text(fitz.Point(350, 120), "Right Column line 1 text", fontsize=12)
    page.insert_text(fitz.Point(350, 160), "Right Column line 2 text", fontsize=12)

    # Footer spanning across bottom
    page.insert_text(fitz.Point(50, 750), "Footer Page 1", fontsize=10)

    doc.save(pdf_path)
    doc.close()

    extractor = PDFTextExtractor()
    raw_text, _, _ = extractor.extract_page_text(pdf_path, 1)

    # Verify order: Header -> Left Column -> Right Column -> Footer
    pos_header = raw_text.find("Header Chapter 1")
    pos_col1 = raw_text.find("Left Column line 1")
    pos_col2 = raw_text.find("Right Column line 1")
    pos_footer = raw_text.find("Footer Page 1")

    assert pos_header != -1 and pos_col1 != -1 and pos_col2 != -1 and pos_footer != -1
    assert pos_header < pos_col1 < pos_col2 < pos_footer, "Reading order must follow Header -> Col 1 -> Col 2 -> Footer"


def test_image_preprocessor_rendering(tmp_path):
    pdf_path = str(tmp_path / "img_test.pdf")
    doc = fitz.open()
    page = doc.new_page(width=400, height=600)
    page.insert_text(fitz.Point(50, 100), "বাংলা ওসিআর টেস্ট", fontsize=14)
    doc.save(pdf_path)
    doc.close()

    preprocessor = ImagePreprocessor(dpi=150)
    img = preprocessor.render_page_to_image(pdf_path, 1)
    assert img is not None
    assert img.width > 0 and img.height > 0

    prep_img = preprocessor.preprocess_image(img)
    assert prep_img is not None
