package com.gigabyte.bookstore.learning.presentation.numbers

import com.gigabyte.bookstore.learning.domain.model.SpeechLang

object KoreanNumberData {

    private val SINO_ONES = listOf(
        Triple("일", "il", "ইল"),
        Triple("이", "i", "ই"),
        Triple("삼", "sam", "সাম"),
        Triple("사", "sa", "সা"),
        Triple("오", "o", "ও"),
        Triple("육", "yuk", "ইয়ুক"),
        Triple("칠", "chil", "ছিল"),
        Triple("팔", "pal", "ফাল"),
        Triple("구", "gu", "গু")
    )

    private val NATIVE_ONES = listOf(
        Triple("하나", "hana", "হানা"),
        Triple("둘", "dul", "দুল"),
        Triple("셋", "set", "সেত"),
        Triple("넷", "net", "নেত"),
        Triple("다섯", "daseot", "দাসত"),
        Triple("여섯", "yeoseot", "ইয়সত"),
        Triple("일곱", "ilgop", "ইলগোপ"),
        Triple("여덟", "yeodeol", "ইয়দল"),
        Triple("아홉", "ahop", "আহোপ"),
        Triple("열", "yeol", "ইয়ল")
    )

    private fun sinoKorean(n: Int): Triple<String, String, String> {
        if (n == 100) return Triple("백", "baek", "ব্যাক")
        val tens = n / 10
        val ones = n % 10
        val ko = buildString {
            if (tens > 1) append(SINO_ONES[tens - 1].first)
            if (tens >= 1) append("십")
            if (ones > 0) append(SINO_ONES[ones - 1].first)
        }
        val rom = buildString {
            if (tens > 1) append(SINO_ONES[tens - 1].second)
            if (tens >= 1) append("sip")
            if (ones > 0) append(SINO_ONES[ones - 1].second)
        }
        val bn = buildString {
            if (tens > 1) append(SINO_ONES[tens - 1].third)
            if (tens >= 1) append("শিপ")
            if (ones > 0) append(SINO_ONES[ones - 1].third)
        }
        return Triple(ko, rom, bn)
    }

    private fun buildKoreanNumbers(): List<LanguageNumber> {
        val list = mutableListOf<LanguageNumber>()
        for (n in 1..100) {
            val rangeGroup = when (n) {
                in 1..20 -> "1-20"
                in 21..40 -> "21-40"
                in 41..60 -> "41-60"
                in 61..80 -> "61-80"
                else -> "81-100"
            }
            val (ko, rom, bn) = sinoKorean(n)
            val nativeHint = if (n in 1..10) {
                val nv = NATIVE_ONES[n - 1]
                " (${nv.first} / ${nv.third})"
            } else ""
            list.add(
                LanguageNumber(
                    number = n,
                    nativeNumeral = n.toString(),
                    wordTarget = ko,
                    secondaryDisplay = "$rom$nativeHint",
                    phoneticTranslit = rom,
                    bnPron = "$bn$nativeHint",
                    ttsText = ko,
                    rangeGroup = rangeGroup
                )
            )
        }
        return list
    }

    val CONFIG = LanguageNumberConfig(
        langCode = "korean",
        speechLang = SpeechLang.KO,
        titleBn = "কোরিয়ান সংখ্যা ও গণনা (১ থেকে ১০০)",
        subtitleBn = "সিনো-কোরিয়ান (일, 이, 삼) + মৌলিক নেটিভ (하나, 둘, 셋) ও ওন (원) গণনা",
        nativeTitle = "한국어 숫자 (1 - 100)",
        accentColorHex = 0xFF0047A0,
        categories = listOf(
            NumberRangeCategory("all", "সব (১-১০০)", "১০০টি"),
            NumberRangeCategory("1-20", "১ - ২০ (মৌলিক)", "২০টি"),
            NumberRangeCategory("21-40", "২১ - ৪০", "২০টি"),
            NumberRangeCategory("41-60", "৪১ - ৬০", "২০টি"),
            NumberRangeCategory("61-80", "৬১ - ৮০", "২০টি"),
            NumberRangeCategory("81-100", "৮১ - ১০০", "২০টি")
        ),
        numbers = buildKoreanNumbers()
    )
}
