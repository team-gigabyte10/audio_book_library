package com.gigabyte.bookstore.learning.presentation.numbers

import com.gigabyte.bookstore.learning.domain.model.SpeechLang

object JapaneseNumberData {

    private val UNITS = listOf(
        Triple("一", "いち", "ichi" to "ইচি"),
        Triple("二", "に", "ni" to "নি"),
        Triple("三", "さん", "san" to "সান"),
        Triple("四", "よん", "yon" to "ইয়োন"),
        Triple("五", "ご", "go" to "গো"),
        Triple("六", "ろく", "roku" to "রোকু"),
        Triple("七", "なな", "nana" to "নানা"),
        Triple("八", "はち", "hachi" to "হাচি"),
        Triple("九", "きゅう", "kyuu" to "কিউ")
    )

    private val TENS_PREFIX = listOf(
        Triple("", "じゅう", "juu" to "জিউ"),
        Triple("二", "にじゅう", "nijuu" to "নিজিউ"),
        Triple("三", "さんじゅう", "sanjuu" to "সানজিউ"),
        Triple("四", "よんじゅう", "yonjuu" to "ইয়োন্জিউ"),
        Triple("五", "ごじゅう", "gojuu" to "গোজিউ"),
        Triple("六", "ろくじゅう", "rokujuu" to "রোকুজিউ"),
        Triple("七", "ななじゅう", "nanajuu" to "নানাজিউ"),
        Triple("八", "はちじゅう", "hachijuu" to "হাচিজু"),
        Triple("九", "きゅうじゅう", "kyuujuu" to "কিউজিউ")
    )

    private fun buildJapaneseNumbers(): List<LanguageNumber> {
        val list = mutableListOf<LanguageNumber>()

        for (n in 1..100) {
            val rangeGroup = when (n) {
                in 1..20 -> "1-20"
                in 21..40 -> "21-40"
                in 41..60 -> "41-60"
                in 61..80 -> "61-80"
                else -> "81-100"
            }

            if (n in 1..9) {
                val (kanji, hira, pair) = UNITS[n - 1]
                list.add(
                    LanguageNumber(
                        number = n,
                        nativeNumeral = kanji,
                        wordTarget = hira,
                        secondaryDisplay = kanji,
                        phoneticTranslit = pair.first,
                        bnPron = pair.second,
                        ttsText = kanji,
                        rangeGroup = rangeGroup
                    )
                )
            } else if (n == 10) {
                list.add(
                    LanguageNumber(
                        number = 10,
                        nativeNumeral = "十",
                        wordTarget = "じゅう",
                        secondaryDisplay = "十",
                        phoneticTranslit = "juu",
                        bnPron = "জিউ",
                        ttsText = "十",
                        rangeGroup = rangeGroup
                    )
                )
            } else if (n in 11..99) {
                val tensDigit = n / 10
                val unitDigit = n % 10

                val tensInfo = TENS_PREFIX[tensDigit - 1]
                val kanjiTen = if (tensDigit == 1) "十" else "${UNITS[tensDigit - 1].first}十"

                if (unitDigit == 0) {
                    list.add(
                        LanguageNumber(
                            number = n,
                            nativeNumeral = kanjiTen,
                            wordTarget = tensInfo.second,
                            secondaryDisplay = kanjiTen,
                            phoneticTranslit = tensInfo.third.first,
                            bnPron = tensInfo.third.second,
                            ttsText = kanjiTen,
                            rangeGroup = rangeGroup
                        )
                    )
                } else {
                    val unitInfo = UNITS[unitDigit - 1]
                    val fullKanji = kanjiTen + unitInfo.first
                    val fullHira = tensInfo.second + unitInfo.second
                    val fullRomaji = tensInfo.third.first + unitInfo.third.first
                    val fullBn = tensInfo.third.second + "-" + unitInfo.third.second

                    list.add(
                        LanguageNumber(
                            number = n,
                            nativeNumeral = fullKanji,
                            wordTarget = fullHira,
                            secondaryDisplay = fullKanji,
                            phoneticTranslit = fullRomaji,
                            bnPron = fullBn,
                            ttsText = fullKanji,
                            rangeGroup = rangeGroup
                        )
                    )
                }
            } else if (n == 100) {
                list.add(
                    LanguageNumber(
                        number = 100,
                        nativeNumeral = "百",
                        wordTarget = "ひゃく",
                        secondaryDisplay = "百",
                        phoneticTranslit = "hyaku",
                        bnPron = "হিয়াকু",
                        ttsText = "百",
                        rangeGroup = rangeGroup
                    )
                )
            }
        }
        return list
    }

    val CONFIG = LanguageNumberConfig(
        langCode = "japanese",
        speechLang = SpeechLang.JA,
        titleBn = "জাপানি সংখ্যা ও গণনা (১ থেকে ১০০)",
        subtitleBn = "কানজি, হিরাগানা ও রোমাজিসহ প্রতিটি সংখ্যার সঠিক উচ্চারণ",
        nativeTitle = "数字 (Suuji 1-100)",
        accentColorHex = 0xFFC62828,
        categories = listOf(
            NumberRangeCategory("all", "সব (১-১০০)", "১০০টি"),
            NumberRangeCategory("1-20", "১ - ২০ (মৌলিক)", "২০টি"),
            NumberRangeCategory("21-40", "২১ - ৪০", "২০টি"),
            NumberRangeCategory("41-60", "৪১ - ৬০", "২০টি"),
            NumberRangeCategory("61-80", "৬১ - ৮০", "২০টি"),
            NumberRangeCategory("81-100", "৮১ - ১০০", "২০টি")
        ),
        numbers = buildJapaneseNumbers()
    )
}

