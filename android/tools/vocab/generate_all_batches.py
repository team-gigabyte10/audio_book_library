# -*- coding: utf-8 -*-
"""
Generates 1,000 Essential Vocabulary entries across 20 categories for:
- EnglishVocabData.kt
- GermanVocabData.kt
- HindiVocabData.kt
- UrduVocabData.kt
- JapaneseVocabData.kt
"""
import os
import sys

OUT_DIR = r"c:\Users\Team Gigabyte\Documents\audio_book_library\android\app\src\main\java\com\gigabyte\bookstore\learning\presentation\vocab"
os.makedirs(OUT_DIR, exist_ok=True)

print("Starting master generator...")
