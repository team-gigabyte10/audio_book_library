#!/usr/bin/env python3
"""
Sanitizes Bengali pronunciation (`bn_pron`) strings across all course JSON assets:
1. Replaces foreign scripts (Devanagari, Katakana, Arabic/Persian, Gujarati, Telugu, Oriya)
   that leaked into Bengali transliterations.
2. Replaces Devanagari Danda (`U+0964`) with Bengali Dari (`U+09F7`).
3. Preserves Japanese Kana readings before ' · ' in standard Japanese courses.
4. Preserves Urdu vocalized readings before ' · ' in standard Urdu courses.
"""

import json
import glob
import os
import re
import unicodedata

# Explicit word / substring replacements for known corruptions
EXACT_REPLACEMENTS = {
    # Gujarati
    "સ્ટેઇડ": "স্টেইড",
    "ચૂમે": "ছুমে",
    "ছুপાયে": "ছুপায়ে",
    
    # German corruptions
    "ফাইネン": "ফাইনেন",
    "ব্যুরোザইন": "ব্যুরোজাইন",
    "লয়গネン": "লয়গনেন",
    "ক্যোয়ネン": "ক্যোয়নেন",
    "ৎস্সুফালザইন": "ৎস্সুফালজাইন",
    "ৎসিমারলাউটশ्टের্কে": "ৎসিমারলাউটশটের্কে",
    "গে\u0947য়ার্ন": "গেয়ার্ন",
    "গে\u0947য়ার্নে": "গেয়ার্নে",
    "गेয়ার্ন": "গেয়ার্ন",
    "गेয়ার্নে": "গেয়ার্নে",

    # Japanese leaks inside Bengali transliteration
    "উৎसुकুশি": "উৎসুকুশি",
    "উৎसुकুশিই।": "উৎসুকুশিই।",
    "নারিマス।": "নারিমাস।",
    "নেগাএماس": "নেগাএ মাস",
    "মোতোমেরাレル": "মোতোমেরারেরু",
    "কিমেরাれない।": "কিমেরারেনাই।",
    "ইত্তেইনাいで,": "ইত্তেইনাই দে,",
    "ওশিতসুকেরাれた": "ওশিতসুকেরারেতা",
    "কাকাওয়ারাず,": "কাকাওয়ারাজু,",
    "নারীかねমাসেন।": "নারী কানেমাসেন।",
    "ৎসুける": "ৎসুকেরু",
    "কাッテ": "কাত্তে",
    "কারাओके": "কারাওকে",
    "রেপো-তো": "রেপো-তো",
    "আইসুকুরি‑ইমু": "আইসক্রিম",
    "নিউউネン": "নিউ নেন",
    "নেনネン": "নেন নেন",
    "গোレンরাকুসাকি": "গোরেনরাকুসাকি",

    # Hindi corruptions
    "সাঝা": "সাঝা",
    "साझा": "সাঝা",
    "মাँग": "মাং",
    "আँगন": "আঙ্গন",
    "আপূর্তি": "আপূর্তি",
    "आपूर्ति": "আপূর্তি",
    "বচনা": "বচনা",
    "बचना": "বচনা",
    "সৌদোঁ": "সওদোঁ",
    "সୌদোঁ": "সওদোঁ",
    "হওয়ালে": "হওয়ালে",
    "হवाले": "হওয়ালে",
    "दिल": "দিল",
    "ধড়কন": "ধড়কন",
    "धड़कन": "ধড়কন",
    "धड़कन": "ধড়কন",
    "ধड़कন": "ধড়কন",
    "আঁখোঁ": "আঁখোঁ",
    "आँखों": "আঁখোঁ",
    "बँটবারা": "বাটোয়ারা",
    "হজ়ারোঁ": "হাজারোঁ",
    "হজ়ার": "হাজার",
    "হজ়িরত": "হজরত",

    # Urdu corruptions
    "রাস্তে": "রাস্তে",
    "रास्ते": "রাস্তে",
    "হওসলা": "হওসলা",
    "हौসালাহ": "হওসলা",
    "হौসলাহ": "হওসলা",
    "পড়ায়": "পড়ায়",
    "पड़ाও": "পড়াও",
    "नজরে": "নজরে",
    "অরমান": "অরমান",
    "অرمان": "অরমান",
    "বজলা সঞ্জনী": "বজলা সঞ্জনী",
    "বজলা سنجী": "বজলা সঞ্জনী",
    "শখ্স": "শখ্স",
    "শখস": "শখ্স",
    "शख्स": "শখ্স",
    "খীঁচী": "খীঁচী",
    "खींची": "খীঁচী",
    "মন্টো": "মন্টো",
    "মंटो": "মন্টো",
    "মনজর কশী": "মনজর কশী",
    "মনজর": "মনজর",
    "منظر کشী": "মনজর কশী",
    "منظر": "মনজর",
    "হুকূক": "হুকূক",
    "হুকूक": "হুকূক",
    "বান্দা": "বান্দা",
    "বందా": "বান্দা",
    "বందা": "বান্দা",
    "মন্দী": "মন্দী",
    "মందী": "মন্দী",
    "মুকাম্মাল": "মুকাম্মাল",
    "মুকम्मল": "মুকাম্মাল",
    "কহতে": "কহতে",
    "কহते": "কহতে",
    "রকম": "রকম",
    "রকَم": "রকম",
    "ঘণ্টে": "ঘণ্টে",
    "ঘণ্টے": "ঘণ্টে",
    "বগৈর": "বগৈর",
    "বগैर": "বগৈর",
    "করওয়ানে": "করওয়ানে",
    "করوانے": "করওয়ানে",
    "করूँ": "করূঁ",
    "করूँগা": "করূঁগা",
    "চাহूँগা": "চাহূঁগা",
    "দूँগা": "দূঁগা",
    "সকूँ": "সকূঁ",
    "মিলूँগা": "মিলূঁগা",
    "পার্কিং": "পার্কিং",
    "পার্কنگ": "পার্কিং",
    "নিরখ": "নিরখ",
    "আতে": "আতে",
    "বাঢ়না": "বাঢ়না",
    "बढ़ना": "বাঢ়না",
    "سماআত": "সমাআত",
    "سماঅতেঁ": "সমাঅতেঁ",
    "سنجیدگی": "সঞ্জীদগী",
    "سنجী": "সঞ্জনী",
    "আঁধী": "আঁধী",
    "आँधी": "আঁধী",
    "आदी": "আদী",
}

# Individual char fallback transliterations for isolated Devanagari / Arabic
CHAR_MAP = {
    # Devanagari vowels & consonants
    '\u0905': 'অ', '\u0906': 'আ', '\u0907': 'ই', '\u0908': 'ঈ', '\u0909': 'উ', '\u090a': 'ঊ',
    '\u090f': 'এ', '\u0910': 'ঐ', '\u0913': 'ও', '\u0914': 'ঔ',
    '\u0915': 'ক', '\u0916': 'খ', '\u0917': 'গ', '\u0918': 'ঘ', '\u0919': 'ঙ',
    '\u091a': 'চ', '\u091b': 'ছ', '\u091c': 'জ', '\u091d': 'ঝ', '\u091e': 'ঞ',
    '\u091f': 'ট', '\u0920': 'ঠ', '\u0921': 'ড', '\u0922': 'ঢ', '\u0923': 'ণ',
    '\u0924': 'ত', '\u0925': 'থ', '\u0926': 'দ', '\u0927': 'ধ', '\u0928': 'ন',
    '\u092a': 'প', '\u092b': 'ফ', '\u092c': 'ব', '\u092d': 'ভ', '\u092e': 'ম',
    '\u092f': 'য', '\u0930': 'র', '\u0932': 'ল', '\u0935': 'ব',
    '\u0936': 'শ', '\u0937': 'ষ', '\u0938': 'স', '\u0939': 'হ',
    '\u093e': 'া', '\u093f': 'ি', '\u0940': 'ী', '\u0941': 'ু', '\u0942': 'ূ',
    '\u0947': 'ে', '\u0948': 'ৈ', '\u094b': 'ো', '\u094c': 'ৌ',
    '\u094d': '্', '\u0901': 'ঁ', '\u0902': 'ং', '\u093c': '',

    # Arabic / Urdu isolated letters
    '\u0622': 'আ', '\u0627': 'আ', '\u0628': 'ব', '\u067e': 'প', '\u062a': 'ত',
    '\u0679': 'ট', '\u062b': 'স', '\u062c': 'জ', '\u0686': 'চ', '\u062d': 'হ',
    '\u062e': 'খ', '\u062f': 'দ', '\u0688': 'ড', '\u0630': 'জ', '\u0631': 'র',
    '\u0698': 'ঝ', '\u0632': 'জ', '\u0691': 'ড়', '\u0633': 'স', '\u0634': 'শ',
    '\u0635': 'স', '\u0636': 'জ', '\u0637': 'ত', '\u0638': 'জ', '\u0639': 'আ',
    '\u063a': 'গ', '\u0641': 'ফ', '\u0642': 'ক', '\u06a9': 'ক', '\u06af': 'গ',
    '\u0644': 'ল', '\u0645': 'ম', '\u0646': 'ন', '\u06ba': 'ঁ', '\u0648': 'ও',
    '\u06c1': 'হ', '\u06be': 'হ', '\u06cc': 'ই', '\u06d2': 'ে',
    '\u064e': '', '\u0650': '', '\u064f': '', '\u0651': '', '\u064b': '',
    
    # Katakana / Hiragana
    '\u30cd': 'নে', '\u30f3': 'ন', '\u30b6': 'জা', '\u30de': 'মা', '\u30b9': 'সু',
    '\u30ec': 'রে', '\u30eb': 'রু', '\u308c': 'রে', '\u306a': 'না', '\u3044': 'ই',
    '\u305a': 'জু', '\u3051': 'কে', '\u3063': '',
    
    # Arrows / Punctuation
    '\u2197': '', '\u2198': '', '\u2011': '-',
    
    # Telugu leaks
    '\u0c02': 'ং', '\u0c26': 'দ',
    
    # Oriya leaks
    '\u0b4c': 'ৌ',
}

def sanitize_string(s: str) -> str:
    # First apply exact string replacements
    res = s
    for k, v in EXACT_REPLACEMENTS.items():
        if k in res:
            res = res.replace(k, v)
    
    # Then replace remaining bad characters
    cleaned = []
    for ch in res:
        code = ord(ch)
        # If standard Bengali or valid ASCII punctuation/whitespace, keep
        if (0x0980 <= code <= 0x09FF) or (0x20 <= code <= 0x7E) or code in [0x09F7, 0x200C, 0x200D, 0x2018, 0x2019, 0x201C, 0x201D, 0x2014, 0x2013, 0x00B7, 0x2022]:
            cleaned.append(ch)
        elif ch in CHAR_MAP:
            cleaned.append(CHAR_MAP[ch])
        elif code == 0x0964: # Devanagari danda -> Bengali dari
            cleaned.append('\u09F7')
        else:
            # Drop unmapped non-Bengali noise
            pass
    return "".join(cleaned)

def process_file(file_path: str) -> int:
    with open(file_path, "r", encoding="utf-8") as f:
        data = json.load(f)
    
    is_jp_std = "japanese_standard_n" in file_path
    is_ur_std_a1 = "spoken_urdu_standard_a1.json" in file_path
    
    modified_count = 0
    for part in data.get("parts", []):
        for lesson in part.get("lessons", []):
            for item in lesson.get("items", []):
                pron = item.get("bn_pron")
                if not pron:
                    continue
                
                new_pron = pron
                if is_jp_std and " · " in pron:
                    reading, bn_part = pron.split(" · ", 1)
                    clean_bn = sanitize_string(bn_part)
                    new_pron = f"{reading} · {clean_bn}"
                elif is_ur_std_a1 and " · " in pron:
                    ur_reading, bn_part = pron.split(" · ", 1)
                    clean_bn = sanitize_string(bn_part)
                    new_pron = f"{ur_reading} · {clean_bn}"
                else:
                    new_pron = sanitize_string(pron)
                
                # Replace any devanagari danda with bengali dari
                new_pron = new_pron.replace("\u0964", "\u09F7")
                
                if new_pron != pron:
                    item["bn_pron"] = new_pron
                    modified_count += 1
    
    if modified_count > 0:
        with open(file_path, "w", encoding="utf-8") as f:
            json.dump(data, f, ensure_ascii=False, indent=2)
            f.write("\n")
    
    return modified_count

def main():
    assets_dir = os.path.join("android", "app", "src", "main", "assets")
    files = sorted(glob.glob(os.path.join(assets_dir, "spoken_*.json")))
    
    total_modified = 0
    for f in files:
        cnt = process_file(f)
        if cnt > 0:
            print(f"Sanitized {cnt} items in {os.path.basename(f)}")
            total_modified += cnt
    
    print(f"\nTotal items sanitized across all courses: {total_modified}")

if __name__ == "__main__":
    main()
