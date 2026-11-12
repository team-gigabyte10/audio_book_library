package com.gigabyte.bookstore.learning.presentation.numbers

import com.gigabyte.bookstore.learning.domain.model.SpeechLang

object ChineseNumberData {

    private val UNITS = listOf(
        Triple("一", "yī", "ই"),
        Triple("二", "èr", "আর"),
        Triple("三", "sān", "সান্"),
        Triple("四", "sì", "স্যু"),
        Triple("五", "wǔ", "উ"),
        Triple("六", "liù", "লিউ"),
        Triple("七", "qī", "ছি"),
        Triple("八", "bā", "পা"),
        Triple("九", "jiǔ", "চিউ")
    )

    private fun buildChineseNumbers(): List<LanguageNumber> {
        val list = mutableListOf<LanguageNumber>()

        for (n in 1..100) {
            val rangeGroup = when (n) {
                in 1..20 -> "1-20"
                in 21..40 -> "21-40"
                in 41..60 -> "41-60"
                in 61..80 -> "61-80"
                else -> "81-100"
            }

            when {
                n in 1..9 -> {
                    val (hanzi, pinyin, bn) = UNITS[n - 1]
                    list.add(
                        LanguageNumber(
                            number = n,
                            nativeNumeral = hanzi,
                            wordTarget = hanzi,
                            secondaryDisplay = pinyin,
                            phoneticTranslit = pinyin,
                            bnPron = bn,
                            ttsText = hanzi,
                            rangeGroup = rangeGroup
                        )
                    )
                }
                n == 10 -> {
                    list.add(
                        LanguageNumber(
                            number = 10,
                            nativeNumeral = "十",
                            wordTarget = "十",
                            secondaryDisplay = "shí",
                            phoneticTranslit = "shí",
                            bnPron = "শি",
                            ttsText = "十",
                            rangeGroup = rangeGroup
                        )
                    )
                }
                n in 11..99 -> {
                    val tensDigit = n / 10
                    val unitDigit = n % 10
                    val hanziTen = if (tensDigit == 1) "十" else "${UNITS[tensDigit - 1].first}十"
                    val pinyinTen = if (tensDigit == 1) "shí" else "${UNITS[tensDigit - 1].second}shí"
                    val bnTen = if (tensDigit == 1) "শি" else "${UNITS[tensDigit - 1].third}-শি"

                    if (unitDigit == 0) {
                        list.add(
                            LanguageNumber(
                                number = n,
                                nativeNumeral = hanziTen,
                                wordTarget = hanziTen,
                                secondaryDisplay = pinyinTen,
                                phoneticTranslit = pinyinTen,
                                bnPron = bnTen,
                                ttsText = hanziTen,
                                rangeGroup = rangeGroup
                            )
                        )
                    } else {
                        val (hanziU, pinyinU, bnU) = UNITS[unitDigit - 1]
                        val fullHanzi = hanziTen + hanziU
                        val fullPinyin = "$pinyinTen $pinyinU"
                        val fullBn = "$bnTen-$bnU"
                        list.add(
                            LanguageNumber(
                                number = n,
                                nativeNumeral = fullHanzi,
                                wordTarget = fullHanzi,
                                secondaryDisplay = fullPinyin,
                                phoneticTranslit = fullPinyin,
                                bnPron = fullBn,
                                ttsText = fullHanzi,
                                rangeGroup = rangeGroup
                            )
                        )
                    }
                }
                n == 100 -> {
                    list.add(
                        LanguageNumber(
                            number = 100,
                            nativeNumeral = "一百",
                            wordTarget = "一百",
                            secondaryDisplay = "yībǎi",
                            phoneticTranslit = "yībǎi",
                            bnPron = "ই-পাই",
                            ttsText = "一百",
                            rangeGroup = rangeGroup
                        )
                    )
                }
            }
        }
        return list
    }

    val CONFIG = LanguageNumberConfig(
        langCode = "chinese",
        speechLang = SpeechLang.ZH,
        titleBn = "চাইনিজ সংখ্যা ও গণনা (১ থেকে ১০০)",
        subtitleBn = "হানজি, পিনইন এবং বাংলা উচ্চারণসহ ম্যান্ডারিন সংখ্যা ১-১০০",
        nativeTitle = "数字 (Shùzì 1-100)",
        accentColorHex = 0xFFD32F2F,
        categories = listOf(
            NumberRangeCategory("all", "সব (১-১০০)", "১০০টি"),
            NumberRangeCategory("1-20", "১ - ২০ (মৌলিক)", "২০টি"),
            NumberRangeCategory("21-40", "২১ - ৪০", "২০টি"),
            NumberRangeCategory("41-60", "৪১ - ৬০", "২০টি"),
            NumberRangeCategory("61-80", "৬১ - ৮০", "২০টি"),
            NumberRangeCategory("81-100", "৮১ - ১০০", "২০টি")
        ),
        numbers = buildChineseNumbers()
    )
}

