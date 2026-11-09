# -*- coding: utf-8 -*-
"""
Master compiler that reads:
- data_c01_c05.py
- data_c06_c10.py
- data_c11_c15.py
- data_c16_c20.py
and generates:
- EnglishVocabData.kt
- GermanVocabData.kt
- HindiVocabData.kt
- UrduVocabData.kt
- JapaneseVocabData.kt
- VocabRepository.kt
"""
import os
import sys

# Add current directory to path
CURR_DIR = r"c:\Users\Team Gigabyte\Documents\audio_book_library\android\tools\vocab"
sys.path.insert(0, CURR_DIR)

from data_c01_c05 import DATA_1_5
from data_c06_c10 import DATA_6_10
from data_c11_c15 import DATA_11_15
from data_c16_c20 import DATA_16_20

ALL_DATA = DATA_1_5 + DATA_6_10 + DATA_11_15 + DATA_16_20
print(f"Total concepts loaded: {len(ALL_DATA)}")
assert len(ALL_DATA) == 1000, f"Expected 1000 items, got {len(ALL_DATA)}"

OUT_DIR = r"c:\Users\Team Gigabyte\Documents\audio_book_library\android\app\src\main\java\com\gigabyte\bookstore\learning\presentation\vocab"
os.makedirs(OUT_DIR, exist_ok=True)

def escape_str(s):
    if s is None:
        return ""
    return s.replace('\\', '\\\\').replace('"', '\\"').replace('\n', ' ')

def generate_english():
    chunks = [ALL_DATA[i:i+100] for i in range(0, 1000, 100)]
    file_path = os.path.join(OUT_DIR, "EnglishVocabData.kt")
    with open(file_path, "w", encoding="utf-8") as f:
        f.write('''package com.gigabyte.bookstore.learning.presentation.vocab

import com.gigabyte.bookstore.learning.domain.model.SpeechLang

object EnglishVocabData {
''')
        for idx, chunk in enumerate(chunks):
            f.write(f'    private val chunk{idx + 1} = listOf(\n')
            for item in chunk:
                num = item["num"]
                cat = item["cat"]
                bn = escape_str(item["bn"])
                en_tuple = item["en"]
                sg, pl, psg, ppl, gender = en_tuple
                f.write('        VocabItem(\n')
                f.write(f'            id = "en_vocab_{num}",\n')
                f.write(f'            category = VocabCategory.{cat},\n')
                f.write(f'            singularTarget = "{escape_str(sg)}",\n')
                f.write(f'            singularBnPron = "{escape_str(psg)}",\n')
                if pl:
                    f.write(f'            pluralTarget = "{escape_str(pl)}",\n')
                if ppl:
                    f.write(f'            pluralBnPron = "{escape_str(ppl)}",\n')
                f.write(f'            bnMeaning = "{bn}",\n')
                f.write(f'            gender = GrammaticalGender.{gender}\n')
                f.write('        ),\n')
            f.write('    )\n\n')

        chunk_sum = " + ".join([f"chunk{i+1}" for i in range(len(chunks))])
        f.write(f'''    val config = VocabLanguageConfig(
        langCode = "en",
        speechLang = SpeechLang.EN,
        titleBn = "ইংরেজি শব্দভাণ্ডার",
        subtitleBn = "১,০০০টি দৈনন্দিন প্রয়োজনীয় ইংরেজি শব্দ (একবচন ও বহুবচন সহ)",
        nativeTitle = "English Vocabulary Vault",
        accentColorHex = 0xFF1976D2,
        items = {chunk_sum}
    )
}}
''')
    print("EnglishVocabData.kt generated.")

def generate_german():
    chunks = [ALL_DATA[i:i+100] for i in range(0, 1000, 100)]
    file_path = os.path.join(OUT_DIR, "GermanVocabData.kt")
    with open(file_path, "w", encoding="utf-8") as f:
        f.write('''package com.gigabyte.bookstore.learning.presentation.vocab

import com.gigabyte.bookstore.learning.domain.model.SpeechLang

object GermanVocabData {
''')
        for idx, chunk in enumerate(chunks):
            f.write(f'    private val chunk{idx + 1} = listOf(\n')
            for item in chunk:
                num = item["num"]
                cat = item["cat"]
                bn = escape_str(item["bn"])
                de_tuple = item["de"]
                if len(de_tuple) == 7:
                    sg, pl, art_sg, art_pl, psg, ppl, gender = de_tuple
                else:
                    sg, pl, art_sg, art_pl, psg, ppl, gender = de_tuple[0], de_tuple[1], de_tuple[2], de_tuple[3], de_tuple[4], de_tuple[5], de_tuple[6]
                
                f.write('        VocabItem(\n')
                f.write(f'            id = "de_vocab_{num}",\n')
                f.write(f'            category = VocabCategory.{cat},\n')
                f.write(f'            singularTarget = "{escape_str(sg)}",\n')
                f.write(f'            singularBnPron = "{escape_str(psg)}",\n')
                if pl:
                    f.write(f'            pluralTarget = "{escape_str(pl)}",\n')
                if ppl:
                    f.write(f'            pluralBnPron = "{escape_str(ppl)}",\n')
                f.write(f'            bnMeaning = "{bn}",\n')
                f.write(f'            gender = GrammaticalGender.{gender},\n')
                if art_sg:
                    f.write(f'            germanArticleSingular = "{escape_str(art_sg)}",\n')
                if art_pl:
                    f.write(f'            germanArticlePlural = "{escape_str(art_pl)}"\n')
                else:
                    # remove trailing comma if needed
                    pass
                f.write('        ),\n')
            f.write('    )\n\n')

        chunk_sum = " + ".join([f"chunk{i+1}" for i in range(len(chunks))])
        f.write(f'''    val config = VocabLanguageConfig(
        langCode = "de",
        speechLang = SpeechLang.DE,
        titleBn = "জার্মান শব্দভাণ্ডার",
        subtitleBn = "১,০০০টি প্রয়োজনীয় জার্মান শব্দ (der/die/das ও বহুবচন সহ)",
        nativeTitle = "Deutscher Wortschatz",
        accentColorHex = 0xFFE65100,
        items = {chunk_sum}
    )
}}
''')
    print("GermanVocabData.kt generated.")

def generate_hindi():
    chunks = [ALL_DATA[i:i+100] for i in range(0, 1000, 100)]
    file_path = os.path.join(OUT_DIR, "HindiVocabData.kt")
    with open(file_path, "w", encoding="utf-8") as f:
        f.write('''package com.gigabyte.bookstore.learning.presentation.vocab

import com.gigabyte.bookstore.learning.domain.model.SpeechLang

object HindiVocabData {
''')
        for idx, chunk in enumerate(chunks):
            f.write(f'    private val chunk{idx + 1} = listOf(\n')
            for item in chunk:
                num = item["num"]
                cat = item["cat"]
                bn = escape_str(item["bn"])
                hi_tuple = item["hi"]
                sg, pl, psg, ppl, gender = hi_tuple
                f.write('        VocabItem(\n')
                f.write(f'            id = "hi_vocab_{num}",\n')
                f.write(f'            category = VocabCategory.{cat},\n')
                f.write(f'            singularTarget = "{escape_str(sg)}",\n')
                f.write(f'            singularBnPron = "{escape_str(psg)}",\n')
                if pl:
                    f.write(f'            pluralTarget = "{escape_str(pl)}",\n')
                if ppl:
                    f.write(f'            pluralBnPron = "{escape_str(ppl)}",\n')
                f.write(f'            bnMeaning = "{bn}",\n')
                f.write(f'            gender = GrammaticalGender.{gender}\n')
                f.write('        ),\n')
            f.write('    )\n\n')

        chunk_sum = " + ".join([f"chunk{i+1}" for i in range(len(chunks))])
        f.write(f'''    val config = VocabLanguageConfig(
        langCode = "hi",
        speechLang = SpeechLang.HI,
        titleBn = "হিন্দি শব্দভাণ্ডার",
        subtitleBn = "১,০০০টি প্রয়োজনীয় হিন্দি শব্দ (একবচন, বহুবচন ও লিঙ্গ সহ)",
        nativeTitle = "हिन्दी शब्दकोश",
        accentColorHex = 0xFFD84315,
        items = {chunk_sum}
    )
}}
''')
    print("HindiVocabData.kt generated.")

def generate_urdu():
    chunks = [ALL_DATA[i:i+100] for i in range(0, 1000, 100)]
    file_path = os.path.join(OUT_DIR, "UrduVocabData.kt")
    with open(file_path, "w", encoding="utf-8") as f:
        f.write('''package com.gigabyte.bookstore.learning.presentation.vocab

import com.gigabyte.bookstore.learning.domain.model.SpeechLang

object UrduVocabData {
''')
        for idx, chunk in enumerate(chunks):
            f.write(f'    private val chunk{idx + 1} = listOf(\n')
            for item in chunk:
                num = item["num"]
                cat = item["cat"]
                bn = escape_str(item["bn"])
                ur_tuple = item["ur"]
                sg, pl, psg, ppl, gender = ur_tuple
                f.write('        VocabItem(\n')
                f.write(f'            id = "ur_vocab_{num}",\n')
                f.write(f'            category = VocabCategory.{cat},\n')
                f.write(f'            singularTarget = "{escape_str(sg)}",\n')
                f.write(f'            singularBnPron = "{escape_str(psg)}",\n')
                if pl:
                    f.write(f'            pluralTarget = "{escape_str(pl)}",\n')
                if ppl:
                    f.write(f'            pluralBnPron = "{escape_str(ppl)}",\n')
                f.write(f'            bnMeaning = "{bn}",\n')
                f.write(f'            gender = GrammaticalGender.{gender}\n')
                f.write('        ),\n')
            f.write('    )\n\n')

        chunk_sum = " + ".join([f"chunk{i+1}" for i in range(len(chunks))])
        f.write(f'''    val config = VocabLanguageConfig(
        langCode = "ur",
        speechLang = SpeechLang.UR,
        titleBn = "উর্দু শব্দভাণ্ডার",
        subtitleBn = "১,০০০টি প্রয়োজনীয় উর্দু শব্দ (একবচন, বহুবচন ও লিঙ্গ সহ)",
        nativeTitle = "اردو الفاظ کا خزانہ",
        accentColorHex = 0xFF00695C,
        items = {chunk_sum}
    )
}}
''')
    print("UrduVocabData.kt generated.")

def generate_japanese():
    chunks = [ALL_DATA[i:i+100] for i in range(0, 1000, 100)]
    file_path = os.path.join(OUT_DIR, "JapaneseVocabData.kt")
    with open(file_path, "w", encoding="utf-8") as f:
        f.write('''package com.gigabyte.bookstore.learning.presentation.vocab

import com.gigabyte.bookstore.learning.domain.model.SpeechLang

object JapaneseVocabData {
''')
        for idx, chunk in enumerate(chunks):
            f.write(f'    private val chunk{idx + 1} = listOf(\n')
            for item in chunk:
                num = item["num"]
                cat = item["cat"]
                bn = escape_str(item["bn"])
                ja_tuple = item["ja"]
                sg, pl, psg, ppl, sec_sg, sec_pl = ja_tuple
                f.write('        VocabItem(\n')
                f.write(f'            id = "ja_vocab_{num}",\n')
                f.write(f'            category = VocabCategory.{cat},\n')
                f.write(f'            singularTarget = "{escape_str(sg)}",\n')
                f.write(f'            singularBnPron = "{escape_str(psg)}",\n')
                if sec_sg:
                    f.write(f'            singularSecondary = "{escape_str(sec_sg)}",\n')
                if pl:
                    f.write(f'            pluralTarget = "{escape_str(pl)}",\n')
                if ppl:
                    f.write(f'            pluralBnPron = "{escape_str(ppl)}",\n')
                if sec_pl:
                    f.write(f'            pluralSecondary = "{escape_str(sec_pl)}",\n')
                f.write(f'            bnMeaning = "{bn}",\n')
                f.write('            gender = GrammaticalGender.NONE\n')
                f.write('        ),\n')
            f.write('    )\n\n')

        chunk_sum = " + ".join([f"chunk{i+1}" for i in range(len(chunks))])
        f.write(f'''    val config = VocabLanguageConfig(
        langCode = "ja",
        speechLang = SpeechLang.JA,
        titleBn = "জাপানি শব্দভাণ্ডার",
        subtitleBn = "১,০০০টি প্রয়োজনীয় জাপানি শব্দ (কাঞ্জি ও হিরাগানা সহ)",
        nativeTitle = "日本語 必須単語 1000",
        accentColorHex = 0xFFAD1457,
        items = {chunk_sum}
    )
}}
''')
    print("JapaneseVocabData.kt generated.")

def generate_repository():
    file_path = os.path.join(OUT_DIR, "VocabRepository.kt")
    with open(file_path, "w", encoding="utf-8") as f:
        f.write('''package com.gigabyte.bookstore.learning.presentation.vocab

object VocabRepository {
    fun getConfigForLanguage(langCode: String): VocabLanguageConfig {
        return when (langCode.lowercase()) {
            "en", "english" -> EnglishVocabData.config
            "de", "german" -> GermanVocabData.config
            "hi", "hindi" -> HindiVocabData.config
            "ur", "urdu" -> UrduVocabData.config
            "ja", "japanese" -> JapaneseVocabData.config
            else -> EnglishVocabData.config
        }
    }
}
''')
    print("VocabRepository.kt generated.")

if __name__ == "__main__":
    generate_english()
    generate_german()
    generate_hindi()
    generate_urdu()
    generate_japanese()
    generate_repository()
    print("All 5 Kotlin vocab data files + VocabRepository generated successfully!")
