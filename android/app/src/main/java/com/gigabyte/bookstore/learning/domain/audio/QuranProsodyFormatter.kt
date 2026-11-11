package com.gigabyte.bookstore.learning.domain.audio

/**
 * Formats Arabic & Quranic text before sending to Text-to-Speech so TTS:
 * 1. Articulates isolated Noorani alphabet letters & joined shapes (`ب`, `بـ`) by their proper names
 *    instead of clipping or staying silent.
 * 2. Translates Uthmani script markers (`ٰ` Dagger Alif, `ٱ` Alif Wasla, `ۢ` High Meem) into
 *    phonetic standard Arabic with full Harakat so TTS voices preserve Madd elongation & vowels.
 * 3. Injects gentle *Tartil* Waqf breath pauses (`، `) and guards short syllables against truncation.
 *
 * Note: Display text on cards (`item.target`) is never modified.
 */
object QuranProsodyFormatter {

    private val LETTER_NAMES = mapOf(
        "أ" to "أَلِفْ",
        "ا" to "أَلِفْ",
        "ب" to "بَاءْ",
        "ت" to "تَاءْ",
        "ث" to "ثَاءْ",
        "ج" to "جِيمْ",
        "ح" to "حَاءْ",
        "خ" to "خَاءْ",
        "د" to "دَالْ",
        "ذ" to "ذَالْ",
        "ر" to "رَاءْ",
        "ز" to "زَايْ",
        "س" to "سِينْ",
        "ش" to "شِينْ",
        "ص" to "صَادْ",
        "ض" to "ضَادْ",
        "ط" to "طَاءْ",
        "ظ" to "ظَاءْ",
        "ع" to "عَيْنْ",
        "غ" to "غَيْنْ",
        "ف" to "فَاءْ",
        "ق" to "قَافْ",
        "ك" to "كَافْ",
        "ل" to "لَامْ",
        "م" to "مِيمْ",
        "ن" to "نُونْ",
        "و" to "وَاوْ",
        "ه" to "هَاءْ",
        "هـ" to "هَاءْ",
        "لا" to "لَامْ أَلِفْ",
        "ي" to "يَاءْ",
        "ء" to "هَمْزَةْ",
        "ة" to "تَاءْ مَرْبُوطَةْ"
    )

    private val WAQF_MARKS_REGEX = Regex("[\u06D6-\u06DC\u06DF-\u06E1\u06E3-\u06E8\u06EA-\u06ED]")
    private val HARAKAT_REGEX = Regex("[\u064B-\u065F\u0670]")

    fun formatForTilawat(rawArabic: String): String {
        val trimmed = rawArabic.trim()
        if (trimmed.isEmpty()) return trimmed

        // 1. Single letter or Tatweel positional shape (`بـ`, `ـبـ`, `ـب`, `هـ`, `لا`)
        val withoutTatweel = if (trimmed == "هـ") "هـ" else trimmed.replace("\u0640", "")
        LETTER_NAMES[withoutTatweel]?.let { return it }

        // 2. Sequence of isolated alphabet letters (e.g. `أ ب ت ث ج ح خ`)
        val tokens = trimmed.split(Regex("\\s+")).filter { it.isNotEmpty() }
        if (tokens.size >= 2 && tokens.all { token ->
                val clean = if (token == "هـ") "هـ" else token.replace("\u0640", "")
                LETTER_NAMES.containsKey(clean) && !HARAKAT_REGEX.containsMatchIn(clean)
            }
        ) {
            return tokens.joinToString("، ") { token ->
                val clean = if (token == "هـ") "هـ" else token.replace("\u0640", "")
                LETTER_NAMES[clean] ?: clean
            }
        }

        // 3. Phonetic Uthmani normalization for TTS clarity while retaining full Tashkeel
        var normalized = trimmed
            .replace("\u0640", "") // Strip visual stretchers that confuse TTS
            .replace("\u0671", "ا") // Alif Wasla -> standard Alif
            .replace("\u0649\u0670", "\u064Eا") // Alif Maksura + Dagger Alif -> Fatha + Alif
            .replace("\u064E\u0670", "\u064Eا") // Fatha + Dagger Alif -> Fatha + Alif
            .replace("\u0670", "ا") // Remaining Dagger Alif -> Alif
            .replace("ن\u06E2", "م") // Iqlab: Nun + small high meem -> nasal meem approximation
            .replace("\u06E2", "") // Remaining high meem
            .replace(WAQF_MARKS_REGEX, "، ")
            .replace(Regex("\\s+"), " ")
            .trim()

        // 4. Short Qaida syllables (1-3 base characters, e.g. `بَ`, `أَبْ`, `إِنَّ`) get a soft trailing
        // Arabic comma so TTS finishes vowel decay cleanly without cutting off.
        val baseCharsCount = normalized.replace(HARAKAT_REGEX, "").length
        if (baseCharsCount <= 3 && !normalized.endsWith("،") && !normalized.endsWith(".")) {
            normalized = "$normalized،"
        }

        return normalized
    }
}
