package com.gigabyte.bookstore.learning.presentation.numbers

import com.gigabyte.bookstore.learning.domain.model.SpeechLang

object UrduNumberData {

    private fun toUrduDigits(n: Int): String {
        val urduDigits = charArrayOf('۰', '۱', '۲', '۳', '۴', '۵', '۶', '۷', '۸', '۹')
        return n.toString().map { urduDigits[it - '0'] }.joinToString("")
    }

    private val RAW_DATA = listOf(
        Triple("ایک", "aik", "আইক / এক"),
        Triple("دو", "do", "দো / দুই"),
        Triple("تین", "teen", "তিন"),
        Triple("چار", "chaar", "চার"),
        Triple("پانچ", "paanch", "পাঁচ"),
        Triple("چھ", "chhe", "ছে / ছয়"),
        Triple("سات", "saat", "সাত"),
        Triple("آٹھ", "aath", "আট"),
        Triple("نو", "nau", "নও / নয়"),
        Triple("دس", "das", "দশ"),

        Triple("گیارہ", "gyarah", "গিয়ারহ (১১)"),
        Triple("بارہ", "baarah", "বারহ (১২)"),
        Triple("تیرہ", "terah", "তেরহ (১৩)"),
        Triple("چودہ", "chaudah", "চৌদহ (১৪)"),
        Triple("پندرہ", "pandrah", "পন্দ্রহ (১৫)"),
        Triple("سولہ", "solah", "সোলহ (১৬)"),
        Triple("سترہ", "satrah", "সত্রহ (১৭)"),
        Triple("اٹھارہ", "athaarah", "আঠারহ (১৮)"),
        Triple("انیس", "unnees", "উন্নিস (১৯)"),
        Triple("بیس", "bees", "বিস / বিশ (২০)"),

        Triple("اکیس", "ikkees", "ইক্কিস (২১)"),
        Triple("بائیس", "baees", "বাইস (২২)"),
        Triple("تیئیس", "teees", "তেইস (২৩)"),
        Triple("چوبیس", "chaubees", "চৌব্বিস (২৪)"),
        Triple("پچیس", "pachees", "পঁচিশ (২৫)"),
        Triple("چھبیس", "chhabees", "ছাব্বিশ (২৬)"),
        Triple("ستائیس", "sataees", "সাতাইস (২৭)"),
        Triple("اٹھائیس", "athaees", "আঠাইস (২৮)"),
        Triple("انتیس", "untees", "উনত্রিশ (২৯)"),
        Triple("تیس", "tees", "তিস / ত্রিশ (৩০)"),

        Triple("اکتیس", "iktees", "একত্রিশ (৩১)"),
        Triple("بتیس", "battees", "বত্রিশ (৩২)"),
        Triple("تینتیس", "taintees", "তেত্রিশ (৩৩)"),
        Triple("چونتیس", "chauntees", "চৌত্রিশ (৩৪)"),
        Triple("پینتیس", "paintees", "পঁয়ত্রিশ (৩৫)"),
        Triple("چھتیس", "chhattees", "ছত্রিশ (৩৬)"),
        Triple("سینتیس", "saintees", "সাঁইত্রিশ (৩৭)"),
        Triple("اڑتیس", "artees", "আটত্রিশ (৩৮)"),
        Triple("انتالیس", "untaalees", "উনচল্লিশ (৩৯)"),
        Triple("چالیس", "chaalees", "চল্লিশ (৪০)"),

        Triple("اکتالیس", "iktaalees", "একচল্লিশ (৪১)"),
        Triple("بیالیس", "byaalees", "বিয়াল্লিশ (৪২)"),
        Triple("تیتالیس", "taitaalees", "তেতাল্লিশ (৪৩)"),
        Triple("چوالیس", "chawaalees", "চুয়াল্লিশ (৪৪)"),
        Triple("پینتالیس", "paintaalees", "পঁয়তাল্লিশ (৪৫)"),
        Triple("چھیالیس", "chhyaalees", "ছেচল্লিশ (৪৬)"),
        Triple("سینتالیس", "saintaalees", "সাতচল্লিশ (৪৭)"),
        Triple("اڑتالیس", "artaalees", "আটচল্লিশ (৪৮)"),
        Triple("انچاس", "unchaas", "উনপঞ্চাশ (৪৯)"),
        Triple("پچاس", "pachaas", "পঞ্চাশ (৫০)"),

        Triple("اکیاون", "ikyaawan", "একান্ন (৫১)"),
        Triple("باون", "baawan", "বায়ান্ন (৫২)"),
        Triple("ترپن", "tirpan", "তিপ্পান্ন (৫৩)"),
        Triple("چوّن", "chawwan", "চুয়ান্ন (৫৪)"),
        Triple("پچپن", "pachpan", "পঞ্চান্ন (৫৫)"),
        Triple("چھپن", "chhappan", "ছাপ্পান্ন (৫৬)"),
        Triple("ستاون", "sattawan", "সাতান্ন (৫৭)"),
        Triple("اٹھاون", "athaawan", "আটান্ন (৫৮)"),
        Triple("انسٹھ", "unsath", "উনষাট (৫৯)"),
        Triple("ساٹھ", "saath", "ষাট (৬০)"),

        Triple("اکسٹھ", "iksath", "একষট্টি (৬১)"),
        Triple("باسٹھ", "baasath", "বাষট্টি (৬২)"),
        Triple("تریسٹھ", "tirasath", "তেষট্টি (৬৩)"),
        Triple("چونسٹھ", "chaunsath", "চৌষট্টি (৬৪)"),
        Triple("پینسٹھ", "painsath", "পঁয়ষট্টি (৬৫)"),
        Triple("چھیاسٹھ", "chhyaasath", "ছেষট্টি (৬৬)"),
        Triple("سڑسٹھ", "sarsath", "সাতষট্টি (৬৭)"),
        Triple("اڑسٹھ", "arsath", "আটষট্টি (৬৮)"),
        Triple("انہتر", "unhattar", "উনসত্তর (৬৯)"),
        Triple("ستر", "sattar", "সত্তর (৭০)"),

        Triple("اکہتر", "ikhattar", "একাত্তর (৭১)"),
        Triple("بہتر", "bahattar", "বাহাত্তর (৭২)"),
        Triple("تہتر", "tihattar", "তিহাত্তর (৭৩)"),
        Triple("چوہتر", "chauhattar", "চৌহাত্তর (৭৪)"),
        Triple("پچہتر", "pachhattar", "পঁচাত্তর (৭৫)"),
        Triple("چھہتر", "chhihattar", "ছিয়াত্তর (৭৬)"),
        Triple("ستتر", "sat-hattar", "সতাত্তর (৭৭)"),
        Triple("اٹھہتر", "athhattar", "আটাত্তর (৭৮)"),
        Triple("اناسی", "unaasi", "উনাশি (৭৯)"),
        Triple("اسی", "assi", "আশি (৮০)"),

        Triple("اکیاسی", "ikyaasi", "একাশি (৮১)"),
        Triple("بیاسی", "byaasi", "বিরাশি (৮২)"),
        Triple("تراسی", "tiraasi", "তিরাশি (৮৩)"),
        Triple("چوراسی", "chauraasi", "চুরাশি (৮৪)"),
        Triple("پچاسی", "pachaasi", "পঁচাশি (৮৫)"),
        Triple("چھیاسی", "chhyaasi", "ছিয়াশি (৮৬)"),
        Triple("ستاسی", "sataasi", "সাতাশি (৮৭)"),
        Triple("اٹھاسی", "athaasi", "আটাশি (৮৮)"),
        Triple("نواسی", "nawaasi", "ঊননব্বই (৮৯)"),
        Triple("نوے", "nabbay", "নব্বই (৯০)"),

        Triple("اکیانوے", "ikyaanway", "একানব্বই (৯১)"),
        Triple("بانوے", "baanway", "বায়ানব্বই (৯২)"),
        Triple("ترانوے", "tiraanway", "তিরানব্বই (৯৩)"),
        Triple("چورانوے", "chauraanway", "চুরানব্বই (৯৪)"),
        Triple("پچانوے", "pachaanway", "পঁচানব্বই (৯৫)"),
        Triple("چھیانوے", "chhyaanway", "ছিয়ানব্বই (৯৬)"),
        Triple("ستانوے", "sataanway", "সাতানব্বই (৯৭)"),
        Triple("اٹھانوے", "athaanway", "আটানব্বই (৯৮)"),
        Triple("ننانوے", "ninanway", "নিরানব্বই (৯৯)"),
        Triple("سو", "sau", "সও / একশো (১০০)")
    )

    private fun buildUrduNumbers(): List<LanguageNumber> {
        return RAW_DATA.mapIndexed { idx, (word, translit, bn) ->
            val num = idx + 1
            val rangeGroup = when (num) {
                in 1..20 -> "1-20"
                in 21..40 -> "21-40"
                in 41..60 -> "41-60"
                in 61..80 -> "61-80"
                else -> "81-100"
            }
            LanguageNumber(
                number = num,
                nativeNumeral = toUrduDigits(num),
                wordTarget = word,
                secondaryDisplay = toUrduDigits(num),
                phoneticTranslit = translit,
                bnPron = bn,
                ttsText = word,
                rangeGroup = rangeGroup
            )
        }
    }

    val CONFIG = LanguageNumberConfig(
        langCode = "urdu",
        speechLang = SpeechLang.UR,
        titleBn = "উর্দু সংখ্যা ও গণনা (১ থেকে ১০০)",
        subtitleBn = "উর্দু হরফ, সংখ্যা ও বাংলা উচ্চারণে পূর্ণাঙ্গ ১-১০০ গিনতি",
        nativeTitle = "اردو گنتی (Ginti 1-100)",
        accentColorHex = 0xFF1B5E20,
        categories = listOf(
            NumberRangeCategory("all", "সব (১-১০০)", "১০০টি"),
            NumberRangeCategory("1-20", "১ - ২০ (মৌলিক)", "২০টি"),
            NumberRangeCategory("21-40", "২১ - ৪০", "২০টি"),
            NumberRangeCategory("41-60", "৪১ - ৬০", "২০টি"),
            NumberRangeCategory("61-80", "৬১ - ৮০", "২০টি"),
            NumberRangeCategory("81-100", "৮১ - ১০০", "২০টি")
        ),
        numbers = buildUrduNumbers()
    )
}

