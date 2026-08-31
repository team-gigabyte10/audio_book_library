import os
import fitz
import pytest
from app.services.pdf_analyzer import PDFAnalyzer
from app.services.pdf_text_extractor import PDFTextExtractor


def create_sample_pdf(pdf_path: str):
    doc = fitz.open()

    # Page 1: Text page with English and Bangla content
    page1 = doc.new_page()
    page1.insert_text(fitz.Point(50, 100), "Chapter 1 - Introduction", fontsize=16)
    page1.insert_text(fitz.Point(50, 150), "This is a text-based PDF page for testing.", fontsize=12)
    page1.insert_text(fitz.Point(50, 180), "Bangla Book Extractor Engine Test.", fontsize=12)

    # Page 2: Text page with chapter 2
    page2 = doc.new_page()
    page2.insert_text(fitz.Point(50, 100), "Chapter 2 - History", fontsize=16)
    page2.insert_text(fitz.Point(50, 150), "Testing PDF Text Extraction and Analysis.", fontsize=12)

    doc.save(pdf_path)
    doc.close()


def test_pdf_analyzer_and_extractor_integration(tmp_path):
    sample_pdf_path = str(tmp_path / "sample_test.pdf")
    create_sample_pdf(sample_pdf_path)

    # Test Analyzer
    analyzer = PDFAnalyzer()
    summary, page_analysis = analyzer.analyze_pdf(sample_pdf_path)

    assert summary["total_pages"] == 2
    assert summary["text_pages"] == 2
    assert summary["scanned_pages"] == 0

    # Test Extractor
    extractor = PDFTextExtractor()
    raw_text, char_count, word_count = extractor.extract_page_text(sample_pdf_path, 1)

    assert "Chapter 1" in raw_text
    assert "This is a text-based PDF page for testing." in raw_text
    assert char_count > 0
    assert word_count > 0
