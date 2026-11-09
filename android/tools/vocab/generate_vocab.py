# -*- coding: utf-8 -*-
"""
1,000 Essential Vocabulary Generator for 5 Languages:
English, German, Hindi, Urdu, Japanese
"""
import sys

# Define the 20 categories and 50 concepts per category
CATEGORIES = [
    ("FAMILY", "family", "পরিবার ও মানুষ", "👨‍👩‍👧‍👦"),
    ("BODY", "body", "শরীর ও স্বাস্থ্য", "🩺"),
    ("FOOD", "food", "খাবার ও পানীয়", "🍲"),
    ("FRUITS", "fruits", "ফল ও শাকসবজি", "🍎"),
    ("HOME", "home", "বাড়ি ও আসবাবপত্র", "🏠"),
    ("CLOTHES", "clothes", "পোশাক ও পরিধান", "👕"),
    ("PLACES", "places", "শহর ও স্থান", "🏙️"),
    ("TRAVEL", "travel", "ভ্রমণ ও যাতায়াত", "✈️"),
    ("EDUCATION", "education", "শিক্ষা ও পড়াশোনা", "📚"),
    ("WORK", "work", "পেশা ও জীবিকা", "💼"),
    ("NATURE", "nature", "প্রকৃতি ও আবহাওয়া", "🌳"),
    ("ANIMALS", "animals", "পশুপাখি ও প্রাণী", "🐾"),
    ("ACTIONS", "actions", "দৈনন্দিন কাজ (Verbs)", "🏃"),
    ("EMOTIONS", "emotions", "অনুভূতি ও অবস্থা", "😊"),
    ("ADJECTIVES", "adjectives", "বিশেষণ ও বিপরীত", "⚖️"),
    ("COLORS", "colors", "রং ও আকার", "🎨"),
    ("KITCHEN", "kitchen", "রান্নাঘর ও তৈজসপত্র", "🍳"),
    ("SHOPPING", "shopping", "কেনাকাটা ও অর্থ", "🛒"),
    ("TECH", "tech", "যোগাযোগ ও প্রযুক্তি", "📱"),
    ("EMERGENCY", "emergency", "জরুরি ও প্রয়োজনীয়", "🚨")
]

print(f"Total categories defined: {len(CATEGORIES)}")
