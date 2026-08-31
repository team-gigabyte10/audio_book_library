import pytest
from app.services.chapter_detector import ChapterDetector


def test_detect_bangla_chapters():
    detector = ChapterDetector()

    pages = [
        {"page_number": 1, "cleaned_text": "অধ্যায় ১ — পরিচয়\nবাংলাদেশ আমাদের দেশ।"},
        {"page_number": 2, "cleaned_text": "আমাদের দেশে অনেক নদী আছে।"},
        {"page_number": 3, "cleaned_text": "অধ্যায় ২ — ইতিহাস\n১৯৭১ সালের কথা।"},
        {"page_number": 4, "cleaned_text": "স্বাধীনতা অর্জিত হলো।"}
    ]

    chapters = detector.detect_chapters(pages)

    assert len(chapters) == 2
    assert chapters[0].title.startswith("অধ্যায় ১")
    assert chapters[0].start_page == 1
    assert chapters[0].end_page == 2

    assert chapters[1].title.startswith("অধ্যায় ২")
    assert chapters[1].start_page == 3
    assert chapters[1].end_page == 4


def test_detect_english_chapters():
    detector = ChapterDetector()

    pages = [
        {"page_number": 1, "cleaned_text": "Chapter 1 - Introduction\nThis is a test book."},
        {"page_number": 5, "cleaned_text": "CHAPTER 2 - History\nThis is chapter two."}
    ]

    chapters = detector.detect_chapters(pages)

    assert len(chapters) == 2
    assert chapters[0].start_page == 1
    assert chapters[0].end_page == 4
    assert chapters[1].start_page == 5
    assert chapters[1].end_page == 5
