import pytest
from app.services.text_cleaner import BanglaTextCleaner


def test_bangla_text_cleaner_whitespace_and_punctuation():
    cleaner = BanglaTextCleaner()

    raw = "  বাংলাদেশ   আমার   জন্মভূমি  । \n\n\n\n  আমি আমার  দেশকে ভালোবাসি  ।  "
    cleaned = cleaner.clean(raw)

    assert "বাংলাদেশ আমার জন্মভূমি।" in cleaned
    assert "আমি আমার দেশকে ভালোবাসি।" in cleaned
    assert "\n\n\n" not in cleaned


def test_bangla_text_cleaner_page_number_removal():
    cleaner = BanglaTextCleaner()

    raw = " - ১২ - \nবাংলাদেশ একটি সুন্দর দেশ।\n\nপৃষ্ঠা ১৩"
    cleaned = cleaner.clean(raw)

    assert "বাংলাদেশ একটি সুন্দর দেশ।" in cleaned
    assert "- ১২ -" not in cleaned
    assert "পৃষ্ঠা ১৩" not in cleaned


def test_bangla_unicode_preservation():
    cleaner = BanglaTextCleaner()

    raw = "শিক্ষা জাতির মেরুদণ্ড। অধ্যায় ১"
    cleaned = cleaner.clean(raw)

    assert cleaned == "শিক্ষা জাতির মেরুদণ্ড। অধ্যায় ১"
