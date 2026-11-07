package com.gigabyte.bookstore.learning.presentation.numbers

import com.gigabyte.bookstore.learning.domain.model.SpeechLang

object HindiNumberData {

    private fun toDevanagariDigits(n: Int): String {
        val devDigits = charArrayOf('०', '१', '२', '३', '४', '५', '६', '७', '८', '९')
        return n.toString().map { devDigits[it - '0'] }.joinToString("")
    }

    private val RAW_DATA = listOf(
        Triple("एक", "ek", "এক (১)"),
        Triple("दो", "do", "দো / দুই (২)"),
        Triple("तीन", "teen", "তিন (৩)"),
        Triple("चार", "chaar", "চার (৪)"),
        Triple("पाँच", "paanch", "পাঁচ (৫)"),
        Triple("छह", "chhah", "ছহ্ / ছয় (৬)"),
        Triple("सात", "saat", "সাত (৭)"),
        Triple("आठ", "aath", "আট (৮)"),
        Triple("नौ", "nau", "নও / নয় (৯)"),
        Triple("दस", "das", "দশ (১০)"),

        Triple("ग्यारह", "gyaarah", "গিয়ারহ (১১)"),
        Triple("बारह", "baarah", "বারহ (১২)"),
        Triple("तेरह", "terah", "তেরহ (১৩)"),
        Triple("चौदह", "chaudah", "চৌদহ (১৪)"),
        Triple("पंद्रह", "pandrah", "পন্দ্রহ (১৫)"),
        Triple("सोलह", "solah", "সোলহ (১৬)"),
        Triple("सत्रह", "satrah", "সত্রহ (১৭)"),
        Triple("अठारह", "athaarah", "আঠারহ (১৮)"),
        Triple("उन्नीस", "unnees", "উন্নিস (১৯)"),
        Triple("बीस", "bees", "বিস / বিশ (২০)"),

        Triple("इक्कीस", "ikkees", "ইক্কিস (২১)"),
        Triple("बाईस", "baees", "বাইস (২২)"),
        Triple("तेईस", "teees", "তেইস (২৩)"),
        Triple("चौबीस", "chaubees", "চৌব্বিস (২৪)"),
        Triple("पच्चीस", "pachchees", "পঁচিশ (২৫)"),
        Triple("छब्बीस", "chhabbees", "ছাব্বিশ (২৬)"),
        Triple("सत्ताईस", "sattaees", "সাতাইস (২৭)"),
        Triple("अट्ठाईस", "atthaees", "আঠাইস (২৮)"),
        Triple("उनतीस", "untees", "উনত্রিশ (২৯)"),
        Triple("तीस", "tees", "তিস / ত্রিশ (৩০)"),

        Triple("इकत्तीस", "ikattees", "একত্রিশ (৩১)"),
        Triple("बत्तीस", "battees", "বত্রিশ (৩২)"),
        Triple("तैंतीस", "taintees", "তেত্রিশ (৩৩)"),
        Triple("चौंतीस", "chauntees", "চৌত্রিশ (৩৪)"),
        Triple("पैंतीस", "paintees", "পঁয়ত্রিশ (৩৫)"),
        Triple("छत्तीस", "chhattees", "ছত্রিশ (৩৬)"),
        Triple("सैंतीस", "saintees", "সাঁইত্রিশ (৩৭)"),
        Triple("अड़तीस", "adtees", "আটত্রিশ (৩৮)"),
        Triple("उनतालीस", "untaalees", "উনচল্লিশ (৩৯)"),
        Triple("चालीस", "chaalees", "চল্লিশ (৪০)"),

        Triple("इकतालीस", "iktaalees", "একচল্লিশ (৪১)"),
        Triple("बयालीस", "bayaalees", "বিয়াল্লিশ (৪২)"),
        Triple("तैंतालीस", "taintaalees", "তেতাল্লিশ (৪৩)"),
        Triple("चवालीस", "chawaalees", "চুয়াল্লিশ (৪৪)"),
        Triple("पैंतालीस", "paintaalees", "পঁয়তাল্লিশ (৪৫)"),
        Triple("छियालीस", "chhiyaalees", "ছেচল্লিশ (৪৬)"),
        Triple("सैंतालीस", "saintaalees", "সাতচল্লিশ (৪৭)"),
        Triple("अड़तालीस", "adtaalees", "আটচল্লিশ (৪৮)"),
        Triple("उनचास", "unchaas", "উনপঞ্চাশ (৪৯)"),
        Triple("पचास", "pachaas", "পঞ্চাশ (৫০)"),

        Triple("इक्यावन", "ikyaawan", "একান্ন (৫১)"),
        Triple("बावन", "baawan", "বায়ান্ন (৫২)"),
        Triple("तिरपन", "tirpan", "তিপ্পান্ন (৫৩)"),
        Triple("चौवन", "chauwan", "চুয়ান্ন (৫৪)"),
        Triple("पचपन", "pachpan", "পঞ্চান্ন (৫৫)"),
        Triple("छप्पन", "chhappan", "ছাপ্পান্ন (৫৬)"),
        Triple("सत्तावन", "sattawan", "সাতান্ন (৫৭)"),
        Triple("अट्ठावन", "atthaawan", "আটান্ন (৫৮)"),
        Triple("उनसठ", "unsath", "উনষাট (৫৯)"),
        Triple("साठ", "saath", "ষাট (৬০)"),

        Triple("इकसठ", "iksath", "একষট্টি (৬১)"),
        Triple("बासठ", "baasath", "বাষট্টি (৬২)"),
        Triple("तिरसठ", "tirasath", "তেষট্টি (৬৩)"),
        Triple("चौंसठ", "chaunsath", "চৌষট্টি (৬৪)"),
        Triple("पैंसठ", "painsath", "পঁয়ষট্টি (৬৫)"),
        Triple("छियासठ", "chhiyaasath", "ছেষট্টি (৬৬)"),
        Triple("सड़सठ", "sadsath", "সাতষট্টি (৬৭)"),
        Triple("अड़सठ", "adsath", "আটষট্টি (৬৮)"),
        Triple("उनहत्तर", "unhattar", "উনসত্তর (৬৯)"),
        Triple("सत्तर", "sattar", "সত্তর (৭০)"),

        Triple("इकहत्तर", "ikhattar", "একাত্তর (৭১)"),
        Triple("बहत्तर", "bahattar", "বাহাত্তর (৭২)"),
        Triple("तिहत्तर", "tihattar", "তিহাত্তর (৭৩)"),
        Triple("चौहत्तर", "chauhattar", "চৌহাত্তর (৭৪)"),
        Triple("पचहत्तर", "pachhattar", "পঁচাত্তর (৭৫)"),
        Triple("छिहत्तर", "chhihattar", "ছিয়াত্তর (৭৬)"),
        Triple("सतहत्तर", "sathattar", "সতাত্তর (৭৭)"),
        Triple("अठहत्तर", "athhattar", "আটাত্তর (৭৮)"),
        Triple("उन्यासी", "unyaasi", "উনাশি (৭৯)"),
        Triple("अस्सी", "assi", "আশি (৮০)"),

        Triple("इक्यासी", "ikyaasi", "একাশি (৮১)"),
        Triple("बयासी", "bayaasi", "বিরাশি (৮২)"),
        Triple("तिरासी", "tiraasi", "তিরাশি (৮৩)"),
        Triple("चौरासी", "chauraasi", "চুরাশি (৮৪)"),
        Triple("पचासी", "pachaasi", "পঁচাশি (৮৫)"),
        Triple("छियासी", "chhiyaasi", "ছিয়াশি (৮৬)"),
        Triple("सत्तासी", "sattaasi", "সাতাশি (৮৭)"),
        Triple("अट्ठासी", "atthaasi", "আটাশি (৮৮)"),
        Triple("नवासी", "nawaasi", "ঊননব্বই (৮৯)"),
        Triple("नब्बे", "nabbe", "নব্বই (৯০)"),

        Triple("इक्यानवे", "ikyaanwe", "একানব্বই (৯১)"),
        Triple("बानवे", "baanwe", "বায়ানব্বই (৯২)"),
        Triple("तिरानवे", "tiraanwe", "তিরানব্বই (৯৩)"),
        Triple("चौरानवे", "chauraanwe", "চুরানব্বই (৯৪)"),
        Triple("पचानवे", "pachaanwe", "পঁচানব্বই (৯৫)"),
        Triple("छियानवे", "chhiyaanwe", "ছিয়ানব্বই (৯৬)"),
        Triple("सत्तानवे", "sattaanwe", "সাতানব্বই (৯৭)"),
        Triple("अट्ठानवे", "atthaanwe", "আটানব্বই (৯৮)"),
        Triple("निन्यानवे", "ninyaanwe", "নিন্যানবে (৯৯)"),
        Triple("सौ", "sau", "সৌ / একশো (১০০)")
    )

    private fun buildHindiNumbers(): List<LanguageNumber> {
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
                nativeNumeral = toDevanagariDigits(num),
                wordTarget = word,
                secondaryDisplay = toDevanagariDigits(num),
                phoneticTranslit = translit,
                bnPron = bn,
                ttsText = word,
                rangeGroup = rangeGroup
            )
        }
    }

    val CONFIG = LanguageNumberConfig(
        langCode = "hindi",
        speechLang = SpeechLang.HI,
        titleBn = "হিন্দি সংখ্যা ও গণনা (১ থেকে ১০০)",
        subtitleBn = "দেবনাগরী লিপি, সংখ্যা ও বাংলা উচ্চারণে পূর্ণাঙ্গ ১-১০০ গিনতি",
        nativeTitle = "हिंदी गिनती (Ginti 1-100)",
        accentColorHex = 0xFFE65100,
        categories = listOf(
            NumberRangeCategory("all", "সব (১-১০০)", "১০০টি"),
            NumberRangeCategory("1-20", "১ - ২০ (মৌলিক)", "২০টি"),
            NumberRangeCategory("21-40", "২১ - ৪০", "২০টি"),
            NumberRangeCategory("41-60", "৪১ - ৬০", "২০টি"),
            NumberRangeCategory("61-80", "৬১ - ৮০", "২০টি"),
            NumberRangeCategory("81-100", "৮১ - ১০০", "২০টি")
        ),
        numbers = buildHindiNumbers()
    )
}

