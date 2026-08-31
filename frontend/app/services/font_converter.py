import re
import unicodedata
from typing import Optional, List, Tuple


class BijoyToUnicodeConverter:
    """
    Converts legacy Bijoy/ANSI encoded Bangla text (such as SutonnyMJ, Bijoy2000, etc.)
    into standard Unicode Bangla characters (NFC format).
    Also repairs common ANSI visual reordering of pre-consonant vowel signs (E-kar, I-kar).
    """

    # Bijoy ANSI to Unicode mapping table
    ANSI_MAP = {
        '০': '০', '১': '১', '২': '২', '৩': '৩', '৪': '৪',
        '৫': '৫', '৬': '৬', '৭': '৭', '৮': '৮', '৯': '৯',
        'a': 'ৃ', 'b': 'ন', 'c': 'ে', 'd': 'ি', 'e': 'ড',
        'f': 'া', 'g': '্', 'h': 'ব', 'i': 'হ', 'j': 'ক',
        'k': 'ি', 'l': 'দ', 'm': 'ম', 'n': 'স', 'o': 'গ',
        'p': 'ড়', 'q': 'ঙ', 'r': 'প', 's': 'ু', 't': 'ট',
        'u': 'হ', 'v': 'র', 'w': 'য', 'x': 'ল', 'y': 'থ', 'z': 'া',
        'A': 'র্', 'B': 'ণ', 'C': 'ৈ', 'D': 'ী', 'E': 'ঢ',
        'F': 'অ', 'G': '।', 'H': 'ভ', 'I': 'ঞ', 'J': 'খ',
        'K': 'ী', 'L': 'ধ', 'M': 'শ', 'N': 'ষ', 'O': 'ঘ',
        'P': 'ঢ়', 'Q': 'ং', 'R': 'ফ', 'S': 'ূ', 'T': 'ঠ',
        'U': 'ঝ', 'V': 'র', 'W': 'য়', 'X': 'ল', 'Y': 'থ', 'Z': '্য',
        '`': '্', '~': '্', '!': '!', '@': '@', '#': '#', '$': '$',
        '%': '%', '^': '^', '&': '&', '*': '*', '(': '(', ')': ')',
        '+': '+', '=': '=', '[': '[', ']': ']', '{': '{', '}': '}',
        ':': ':', ';': ';', '"': '"', "'": "'", '<': '<', '>': '>',
        '/': '/', '?': '?'
    }

    # Common OCR/extraction misrecognized Bijoy visual patterns to standard Unicode
    MISRECOGNIZED_PATTERNS = [
        (r'১০র্ট', '১০টি'),
        (r'পদিয়েপ', 'পদক্ষেপ'),
        (r'এিটর্', 'একটি'),
        (r'উয়ের্য', 'উদ্দেশ্য'),
        (r'থািয়ত', 'থাকতে'),
        (r'হয়ব', 'হবে'),
        (r'মপেয়ন', 'পেছনে'),
        (r'মচিা', 'চেষ্টা'),
        (r'িরুন', 'করুন'),
        (r'সহা ি', 'সহায়ক'),
        (r'টিেু', 'কিছু'),
        (r'মর্খার', 'শেখার'),
        (r'প্রটতটদন', 'প্রতিদিন'),
        (r'টনয়জর', 'নিজের'),
        (r'টর্ক্ষার', 'শিক্ষার'),
        (r'টনবটাচন', 'নির্বাচন'),
        (r'টবটনয় া', 'বিনিয়োগ'),
        (r'ফেুটলা', 'ফর্মুলা'),
        (r'আয়', 'আগে'),
        (r'টনয়জয়ি', 'নিজেকে'),
        (r'মপ', 'পে'),
        (r'অনয', 'অন্য'),
        (r'টবল', 'বিল'),
        (r'টিেু', 'কিছু'),
        (r'টর্খুন', 'শিখুন'),
        (r'মর্খার', 'শেখার'),
        (r'মচিা', 'চেষ্টা'),
    ]

    def convert(self, text: str) -> str:
        """
        Converts text from Bijoy/ANSI or fixes mismapped Bangla font extraction to standard Unicode.
        """
        if not text:
            return ""

        converted = text

        # Check if text is legacy Bijoy/ANSI encoded (non-Unicode ASCII layout)
        if self.is_legacy_bijoy(text):
            converted = self.convert_bijoy_ansi_to_unicode(converted)

        # Apply specific pattern replacements for known legacy font artifacts using word boundaries
        for pat, repl in self.MISRECOGNIZED_PATTERNS:
            converted = re.sub(r'\b' + pat + r'\b', repl, converted)

        # Normalize Unicode NFC
        converted = unicodedata.normalize('NFC', converted)
        return converted

    def convert_bijoy_ansi_to_unicode(self, text: str) -> str:
        """
        Converts raw Bijoy ANSI characters to standard Unicode Bangla.
        """
        res = []
        for char in text:
            res.append(self.ANSI_MAP.get(char, char))
        return "".join(res)

    def is_legacy_bijoy(self, text: str) -> bool:
        """
        Detects if text layer contains legacy Bijoy/ANSI symbols or corrupted font CMap artifacts.
        """
        if not text:
            return False

        # 1. Raw Bijoy/Sutonny/Bornopata ANSI glyph symbols
        if re.search(r'[‡‰ˆ˜™œžŸ¡¢£¤¥¦§©ª«¬®¯°±²³µ¶·¸¹º»¼½¾¿]', text):
            return True

        # 2. Corrupted font CMap artifacts (split vowel signs, misplaced 'ট' I-kar, split 'িয়')
        artifact_patterns = [
            r'ri্|ir্|রি্',
            r'\b[ক-হ]িয়',
            r'\b[ক-হ]ায়',
            r'\bট[ক-গ-নপ-হ]',
            r'১০র্ট',
            r'পদিয়েপ',
            r'সারসাংয়েপ',
        ]
        garbled_matches = sum(1 for pat in artifact_patterns if re.search(pat, text))
        if garbled_matches >= 1:
            return True

        unicode_bangla_chars = len(re.findall(r'[\u0980-\u09FF]', text))
        ascii_chars = len(re.findall(r'[a-zA-Z]', text))
        
        # If there are almost no Unicode Bangla chars but ASCII chars with Bijoy font artifact patterns
        if unicode_bangla_chars < 5 and ascii_chars > 10 and garbled_matches >= 1:
            return True

        return False

class DirectBanglaUnicodeConverter:
    """
    Directly converts broken, misaligned, or garbled OCR text into standard,
    canonical Bangla Unicode (NFC format).
    Repairs SutonnyMJ/Bijoy OCR font misrecognitions, misplaced pre-consonant vowels,
    broken conjuncts, split vowel signs, and OCR punctuation artifacts.
    """

    # Generic structural repairs for Bijoy/ANSI/Sutonny font misalignments
    SUTONNY_OCR_REPAIRS = [
        (r'সূর্িপত্র', 'সূচিপত্র'),
        (r'জনয', 'জন্য'),
        (r'বযব', 'ব্যব'),
        (r'ভটবষযৎ|ভটবষ্যৎ', 'ভবিষ্যৎ'),
        (r'সাফলয', 'সাফল্য'),
        (r'র্ট|ir্|রি্', 'টি'),
        (r'ir', 'টি'),
        (r'রবাটি\b', 'রবার্ট'),
        (r'যত্ব\b', 'যত্ন'),
    ]

    def convert(self, text: str) -> str:
        if not text:
            return ""

        converted = text

        # Bornopata / Bijoy font structural glyph replacements
        converted = re.sub(r'লল([ক-হ])', r'লে\1', converted)
        converted = re.sub(r'([ক-হ])য়ত\b', r'\1তে', converted)
        converted = re.sub(r'([ক-হ])য়ল\b', r'\1লে', converted)
        converted = re.sub(r'([ক-হ])য়েন\b', r'\1ছেন', converted)
        converted = re.sub(r'([ক-হ])য়িন\b', r'\1ছিলেন', converted)
        converted = re.sub(r'([ক-হ])[\u09df\u09af\u09bc]+র\b', r'\1ের', converted)
        converted = re.sub(r'গুয়লা\b', 'গুলো', converted)
        converted = re.sub(r'পয়থ\b', 'পথে', converted)
        converted = re.sub(r'হায়ত\b', 'হাতে', converted)

        # 1. Apply Sutonny/Bijoy exact word replacements
        for pat, repl in self.SUTONNY_OCR_REPAIRS:
            converted = re.sub(pat, repl, converted)

        # 2. Fix pre-consonant 'ট' misrecognized as 'ি' (e.g. 'টবপরীত' -> 'বিপরীত', 'টনন' -> 'নিন', 'টদ' -> 'দি')
        converted = re.sub(r'ট([ক-গ-নপ-হমবশষসরলযথধদতচছজঝ])', r'\1ি', converted)

        # 3. Fix 'িা' misrecognized as 'কা' or 'ক' at start of words (e.g. 'িাজ' -> 'কাজ', 'ির্পোরেশন' -> 'কর্পোরেশন')
        converted = re.sub(r'(?<!\S)িা', 'কা', converted)
        converted = re.sub(r'(?<!\S)ি([রগভবমক])', r'ক\1', converted)

        # 4. Fix 'র্া' misrecognized as 'টাকা' at start of words (e.g. 'র্ািার' -> 'টাকার')
        converted = re.sub(r'(?<!\S)র্ািার\b', 'টাকার', converted)
        converted = re.sub(r'(?<!\S)র্ািা\b', 'টাকা', converted)

        # 5. Fix 'েূ' misrecognized as 'মূ' (e.g. 'েূল' -> 'মূল')
        converted = re.sub(r'েূ', 'মূ', converted)

        # 6. Split vowel sign combining (ে + া -> ো, ে + ৌ -> ৌ)
        converted = converted.replace('\u09c7\u09be', '\u09cb')
        converted = converted.replace('\u09c7\u09d7', '\u09cc')

        # 7. Normalize Nukta compositions (য + ় -> য়, ড + ় -> ড়, ঢ + ় -> ঢ়)
        converted = re.sub(r'য\u09bc', 'য়', converted)
        converted = re.sub(r'ড\u09bc', 'ড়', converted)
        converted = re.sub(r'ঢ\u09bc', 'ঢ়', converted)

        # 8. Fix OCR Punctuation (pipe '|' or 'I' surrounded by spaces or at line end -> Bangla Dari '।')
        converted = re.sub(r'(?<=[ক-হ০-৯a-zA-Z])\s+[|I]\s*', '। ', converted)
        converted = re.sub(r'\s+[|I]\s*$', '।', converted, flags=re.MULTILINE)

        # 9. Unicode NFC normalization
        converted = re.sub(r'িয[ে\u09bc]?র\b', 'করে', converted)
        converted = unicodedata.normalize('NFC', converted)
        return converted


# Global singleton instances
font_converter = BijoyToUnicodeConverter()
direct_unicode_converter = DirectBanglaUnicodeConverter()
