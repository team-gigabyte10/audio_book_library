package com.gigabyte.bookstore.learning.presentation.numbers

import com.gigabyte.bookstore.learning.domain.model.SpeechLang

object GermanNumberData {

    private val BASIC_1_TO_20 = listOf(
        Triple("eins", "aɪns", "আইনস্ (১)"),
        Triple("zwei", "tsvaɪ", "ৎসভাই (২)"),
        Triple("drei", "dʁaɪ", "দ্রাই (৩)"),
        Triple("vier", "fiːɐ̯", "ফিয়া (৪)"),
        Triple("fünf", "fʏnf", "ফুন্ফ (৫)"),
        Triple("sechs", "zɛks", "জেক্স (৬)"),
        Triple("sieben", "ˈziːbn̩", "জিবেন (৭)"),
        Triple("acht", "axt", "আখ্ট (৮)"),
        Triple("neun", "nɔɪn", "নয়ন (৯)"),
        Triple("zehn", "tseːn", "ৎসেন (১০)"),
        Triple("elf", "ɛlf", "এল্ফ (১১)"),
        Triple("zwölf", "tsvœlf", "ৎসভ্যোল্ফ (১২)"),
        Triple("dreizehn", "ˈdʁaɪ̯ˌtseːn", "দ্রাইৎসেন (১৩)"),
        Triple("vierzehn", "ˈfiːɐ̯ˌtseːn", "ফিয়াৎসেন (১৪)"),
        Triple("fünfzehn", "ˈfʏnfˌtseːn", "ফুন্ফৎসেন (১৫)"),
        Triple("sechzehn", "ˈzɛçˌtseːn", "জেখৎসেন (১৬)"),
        Triple("siebzehn", "ˈziːpˌtseːn", "জিবৎসেন (১৭)"),
        Triple("achtzehn", "ˈaxtˌtseːn", "আখ্টৎসেন (১৮)"),
        Triple("neunzehn", "ˈnɔɪ̯nˌtseːn", "নয়নৎসেন (১৯)"),
        Triple("zwanzig", "ˈtsvan.tsɪç", "ৎসভানৎসিশ (২০)")
    )

    private val TENS = mapOf(
        2 to Triple("zwanzig", "tsvan-tsikh", "ৎসভানৎসিশ"),
        3 to Triple("dreißig", "dry-sikh", "দ্রাইসিস্"),
        4 to Triple("vierzig", "feer-tsikh", "ফিয়ারৎসিশ"),
        5 to Triple("fünfzig", "fewnf-tsikh", "ফুন্ফৎসিশ"),
        6 to Triple("sechzig", "zekh-tsikh", "জেখৎসিশ"),
        7 to Triple("siebzig", "zeep-tsikh", "জিবৎসিশ"),
        8 to Triple("achtzig", "ahkh-tsikh", "আখ্টৎসিশ"),
        9 to Triple("neunzig", "noyn-tsikh", "নয়নৎসিশ")
    )

    private val UNIT_PARTS = listOf(
        Triple("ein", "ayn", "আইন"),
        Triple("zwei", "tsvay", "ৎসভাই"),
        Triple("drei", "dray", "দ্রাই"),
        Triple("vier", "feer", "ফিয়া"),
        Triple("fünf", "fewnf", "ফুন্ফ"),
        Triple("sechs", "zex", "জেক্স"),
        Triple("sieben", "zeeben", "জিবেন"),
        Triple("acht", "ahkht", "আখ্ট"),
        Triple("neun", "noyn", "নয়ন")
    )

    private fun buildGermanNumbers(): List<LanguageNumber> {
        val list = mutableListOf<LanguageNumber>()

        for (n in 1..100) {
            val rangeGroup = when (n) {
                in 1..20 -> "1-20"
                in 21..40 -> "21-40"
                in 41..60 -> "41-60"
                in 61..80 -> "61-80"
                else -> "81-100"
            }

            if (n in 1..20) {
                val (word, translit, bn) = BASIC_1_TO_20[n - 1]
                list.add(
                    LanguageNumber(
                        number = n,
                        wordTarget = word,
                        phoneticTranslit = translit,
                        bnPron = bn,
                        ttsText = word,
                        rangeGroup = rangeGroup
                    )
                )
            } else if (n in 21..99) {
                val tensDigit = n / 10
                val unitDigit = n % 10
                val tensInfo = TENS[tensDigit] ?: Triple("", "", "")

                if (unitDigit == 0) {
                    list.add(
                        LanguageNumber(
                            number = n,
                            wordTarget = tensInfo.first,
                            phoneticTranslit = tensInfo.second,
                            bnPron = "${tensInfo.third} ($n)",
                            ttsText = tensInfo.first,
                            rangeGroup = rangeGroup
                        )
                    )
                } else {
                    val unitInfo = UNIT_PARTS[unitDigit - 1]
                    val fullWord = "${unitInfo.first}und${tensInfo.first}"
                    val fullTranslit = "${unitInfo.second}-und-${tensInfo.second}"
                    val fullBn = "${unitInfo.third}-উন্ট-${tensInfo.third} ($n)"

                    list.add(
                        LanguageNumber(
                            number = n,
                            wordTarget = fullWord,
                            phoneticTranslit = fullTranslit,
                            bnPron = fullBn,
                            ttsText = fullWord,
                            rangeGroup = rangeGroup
                        )
                    )
                }
            } else if (n == 100) {
                list.add(
                    LanguageNumber(
                        number = 100,
                        wordTarget = "hundert",
                        phoneticTranslit = "ˈhʊndɐt",
                        bnPron = "হুন্ডার্ট / একশো (১০০)",
                        ttsText = "hundert",
                        rangeGroup = rangeGroup
                    )
                )
            }
        }
        return list
    }

    val CONFIG = LanguageNumberConfig(
        langCode = "german",
        speechLang = SpeechLang.DE,
        titleBn = "জার্মান সংখ্যা ও গণনা (১ থেকে ১০০)",
        subtitleBn = "Zahlen 1-100: জার্মান উচ্চারণ ও ব্যাকরণিক একুশে নিয়ম",
        nativeTitle = "Deutsche Zahlen (1-100)",
        accentColorHex = 0xFF4527A0,
        categories = listOf(
            NumberRangeCategory("all", "সব (১-১০০)", "১০০টি"),
            NumberRangeCategory("1-20", "১ - ২০ (মৌলিক)", "২০টি"),
            NumberRangeCategory("21-40", "২১ - ৪০", "২০টি"),
            NumberRangeCategory("41-60", "৪১ - ৬০", "২০টি"),
            NumberRangeCategory("61-80", "৬১ - ৮০", "২০টি"),
            NumberRangeCategory("81-100", "৮১ - ১০০", "২০টি")
        ),
        numbers = buildGermanNumbers()
    )
}

