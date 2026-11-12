package com.gigabyte.bookstore.learning.presentation.numbers

import com.gigabyte.bookstore.learning.domain.model.SpeechLang

object ArabicNumberData {

    private val ONES = listOf(
        Triple("١", "وَاحِد" to "wāḥid", "ওয়াহিদ"),
        Triple("٢", "اِثْنَان" to "ithnān", "ইসনান"),
        Triple("٣", "ثَلَاثَة" to "thalātha", "সালাসা"),
        Triple("٤", "أَرْبَعَة" to "arba'a", "আরবাআ"),
        Triple("٥", "خَمْسَة" to "khamsa", "খামসা"),
        Triple("٦", "سِتَّة" to "sitta", "সিত্তা"),
        Triple("٧", "سَبْعَة" to "sab'a", "সাবআ"),
        Triple("٨", "ثَمَانِيَة" to "thamāniya", "সামানিয়া"),
        Triple("٩", "تِسْعَة" to "tis'a", "তিসআ")
    )

    private val TENS = listOf(
        Triple("٢٠", "عِشْرُون" to "'ishrūn", "ইশরূন"),
        Triple("٣٠", "ثَلَاثُون" to "thalāthūn", "সালাসূন"),
        Triple("٤٠", "أَرْبَعُون" to "arba'ūn", "আরবাঊন"),
        Triple("٥٠", "خَمْسُون" to "khamsūn", "খামসূন"),
        Triple("٦٠", "سِتُّون" to "sittūn", "সিত্তূন"),
        Triple("٧٠", "سَبْعُون" to "sab'ūn", "সাবঊন"),
        Triple("٨٠", "ثَمَانُون" to "thamānūn", "সামানূন"),
        Triple("٩٠", "تِسْعُون" to "tis'ūn", "তিসঊন")
    )

    private val TEENS = listOf(
        Triple("١١", "أَحَدَ عَشَرَ" to "aḥada 'ashar", "আহাদা আশার"),
        Triple("١٢", "اِثْنَا عَشَرَ" to "ithnā 'ashar", "ইসনা আশার"),
        Triple("١٣", "ثَلَاثَةَ عَشَرَ" to "thalāthata 'ashar", "সালাসাতা আশার"),
        Triple("١٤", "أَرْبَعَةَ عَشَرَ" to "arba'ata 'ashar", "আরবাআতা আশার"),
        Triple("١٥", "خَمْسَةَ عَشَرَ" to "khamsata 'ashar", "খামসাতা আশার"),
        Triple("١٦", "سِتَّةَ عَشَرَ" to "sittata 'ashar", "সিত্তাতা আশার"),
        Triple("١٧", "سَبْعَةَ عَشَرَ" to "sab'ata 'ashar", "সাবআতা আশার"),
        Triple("١٨", "ثَمَانِيَةَ عَشَرَ" to "thamāniyata 'ashar", "সামানিয়াতা আশার"),
        Triple("١٩", "تِسْعَةَ عَشَرَ" to "tis'ata 'ashar", "তিসআতা আশার")
    )

    private val EASTERN_DIGITS = charArrayOf('٠', '١', '٢', '٣', '٤', '٥', '٦', '٧', '٨', '٩')

    private fun toEasternDigits(n: Int): String =
        n.toString().map { EASTERN_DIGITS[it - '0'] }.joinToString("")

    private fun buildArabicNumbers(): List<LanguageNumber> {
        val list = mutableListOf<LanguageNumber>()

        for (n in 1..100) {
            val rangeGroup = when (n) {
                in 1..20 -> "1-20"
                in 21..40 -> "21-40"
                in 41..60 -> "41-60"
                in 61..80 -> "61-80"
                else -> "81-100"
            }

            val eastern = toEasternDigits(n)
            val (word, translit, bn) = when {
                n in 1..9 -> {
                    val (_, pair, bnPron) = ONES[n - 1]
                    Triple(pair.first, pair.second, bnPron)
                }
                n == 10 -> Triple("عَشَرَة", "'ashara", "আশারা")
                n in 11..19 -> {
                    val (_, pair, bnPron) = TEENS[n - 11]
                    Triple(pair.first, pair.second, bnPron)
                }
                n == 100 -> Triple("مِائَة", "mi'ah", "মিআহ")
                n % 10 == 0 -> {
                    val (_, pair, bnPron) = TENS[(n / 10) - 2]
                    Triple(pair.first, pair.second, bnPron)
                }
                else -> {
                    // Arabic puts units BEFORE tens: 21 = واحد وعشرون (one and twenty)
                    val unit = ONES[(n % 10) - 1]
                    val ten = TENS[(n / 10) - 2]
                    Triple(
                        "${unit.second.first} وَ${ten.second.first}",
                        "${unit.second.second} wa-${ten.second.second}",
                        "${unit.third} ওয়া-${ten.third}"
                    )
                }
            }

            list.add(
                LanguageNumber(
                    number = n,
                    nativeNumeral = eastern,
                    wordTarget = word,
                    secondaryDisplay = translit,
                    phoneticTranslit = translit,
                    bnPron = bn,
                    ttsText = word,
                    rangeGroup = rangeGroup
                )
            )
        }
        return list
    }

    val CONFIG = LanguageNumberConfig(
        langCode = "arabic",
        speechLang = SpeechLang.AR,
        titleBn = "আরবি সংখ্যা ও গণনা (১ থেকে ১০০)",
        subtitleBn = "আরবি অঙ্ক (١–١٠٠), উচ্চারণ ও বাংলা অর্থসহ রিয়াল-দিরহাম গণনা",
        nativeTitle = "الأرقام العربية (١ - ١٠٠)",
        accentColorHex = 0xFF00695C,
        categories = listOf(
            NumberRangeCategory("all", "সব (১-১০০)", "১০০টি"),
            NumberRangeCategory("1-20", "১ - ২০ (মৌলিক)", "২০টি"),
            NumberRangeCategory("21-40", "২১ - ৪০", "২০টি"),
            NumberRangeCategory("41-60", "৪১ - ৬০", "২০টি"),
            NumberRangeCategory("61-80", "৬১ - ৮০", "২০টি"),
            NumberRangeCategory("81-100", "৮১ - ১০০", "২০টি")
        ),
        numbers = buildArabicNumbers()
    )
}

