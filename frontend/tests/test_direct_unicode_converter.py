import pytest
from app.services.font_converter import direct_unicode_converter


def test_split_vowel_combining():
    # Split O-kar: 'ে' + 'া' -> 'ো'
    raw = "ক\u09c7\u09be"  # ক + ে + া
    converted = direct_unicode_converter.convert(raw)
    assert converted == "কো"


def test_ocr_punctuation_fixing():
    raw = "বাংলাদেশ একটি সুন্দর দেশ |"
    converted = direct_unicode_converter.convert(raw)
    assert "বাংলাদেশ একটি সুন্দর দেশ।" in converted


def test_sutonny_toc_repair():
    garbled_toc = """সূর্িপত্র

১. ভূটেিা: দুই বাবার টবপরীত দর্টন

২. পাঠ ১: ধনীরা র্ািার জনয িাজ িয়র না

৩. পাঠ ২: আটথটি শিক্ষার গুরুত্ব এবং েূল টভটি

৪. পাঠ ৩: নিজের বযবসার যত্ন টনন

৫. পাঠ ৪: টযাক্স এবং ির্পোরেশনের গোপন র্টি

৬. পাঠ ৫: ধনীরা র্ািা উদ্ভাবন িয়র

৭. পাঠ ৬: টর্খতে িাজ িরুন, র্ািার জনয নয

৮. সাফল্যের পথে প্রধান বাধাগুলো

৯. যাত্রা শুরু করার ১০র্ট পদিয়েপ

১০. উপসংহার: আপনার ভটবষযৎ আপনার হাতে"""

    reconstructed = direct_unicode_converter.convert(garbled_toc)

    assert "সূচিপত্র" in reconstructed
    assert "জন্য" in reconstructed
    assert "ব্যবসার" in reconstructed
    assert "১০টি" in reconstructed
    assert "ভবিষ্যৎ" in reconstructed
