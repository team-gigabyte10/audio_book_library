package com.gigabyte.bookstore.learning.domain.util

import java.util.regex.Pattern

/**
 * Utility to convert raw numbered Pinyin (e.g. "zi4 xing2 che1", "nin2 hao3")
 * into standard typographical Pinyin with tone accent diacritics (e.g. "zì xíng chē", "nín hǎo").
 *
 * Implements official Hanyu Pinyin tone placement rules:
 * 1. 'a' or 'e' always receives the tone mark if present.
 * 2. If 'ou' is present, 'o' receives the tone mark.
 * 3. Otherwise, the last vowel in the syllable receives the tone mark (e.g. 'ui' -> 'í', 'iu' -> 'ū').
 */
object PinyinToneConverter {

    private val SYLLABLE_PATTERN = Pattern.compile(
        "^([^a-zA-ZüÜvV:]*)([a-zA-ZüÜvV:]+?)([1-5])([^a-zA-ZüÜvV:]*)$"
    )

    private val TONE_MAP: Map<Char, List<Char>> = mapOf(
        'a' to listOf('ā', 'á', 'ǎ', 'à', 'a'),
        'e' to listOf('ē', 'é', 'ě', 'è', 'e'),
        'i' to listOf('ī', 'í', 'ǐ', 'ì', 'i'),
        'o' to listOf('ō', 'ó', 'ǒ', 'ò', 'o'),
        'u' to listOf('ū', 'ú', 'ǔ', 'ù', 'u'),
        'v' to listOf('ǖ', 'ǘ', 'ǚ', 'ǜ', 'ü'),
        'ü' to listOf('ǖ', 'ǘ', 'ǚ', 'ǜ', 'ü'),
        'A' to listOf('Ā', 'Á', 'Ǎ', 'À', 'A'),
        'E' to listOf('Ē', 'É', 'Ě', 'È', 'E'),
        'I' to listOf('Ī', 'Í', 'Ǐ', 'Ì', 'I'),
        'O' to listOf('Ō', 'Ó', 'Ǒ', 'Ò', 'O'),
        'U' to listOf('Ū', 'Ú', 'Ǔ', 'Ù', 'U'),
        'V' to listOf('Ǖ', 'Ǘ', 'Ǚ', 'Ǜ', 'Ü'),
        'Ü' to listOf('Ǖ', 'Ǘ', 'Ǚ', 'Ǜ', 'Ü')
    )

    private const val VOWELS = "aeiouvüAEIOUVÜ"

    /**
     * Converts a single syllable with a tone number (e.g. "zi4", "xing2", "Meng4") to standard pinyin.
     */
    fun convertSyllable(token: String): String {
        val matcher = SYLLABLE_PATTERN.matcher(token)
        if (!matcher.matches()) {
            return token.replace("v", "ü").replace("V", "Ü")
        }

        val prefix = matcher.group(1) ?: ""
        var word = matcher.group(2) ?: ""
        val toneNum = (matcher.group(3) ?: "5").toIntOrNull() ?: 5
        val suffix = matcher.group(4) ?: ""

        val toneIndex = (toneNum - 1).coerceIn(0, 4)
        if (toneIndex == 4) { // Neutral tone (5)
            return prefix + word.replace("v", "ü").replace("V", "Ü") + suffix
        }

        // Rule 1: Look for 'a' or 'e'
        var replaced = false
        val charArray = word.toCharArray()
        for (i in charArray.indices) {
            val c = charArray[i]
            if (c == 'a' || c == 'A' || c == 'e' || c == 'E') {
                TONE_MAP[c]?.let { tones ->
                    charArray[i] = tones[toneIndex]
                    replaced = true
                }
                break
            }
        }

        // Rule 2: If 'ou' is present, 'o' gets the tone mark
        if (!replaced) {
            for (i in 0 until charArray.size - 1) {
                val c = charArray[i]
                val next = charArray[i + 1]
                if ((c == 'o' || c == 'O') && (next == 'u' || next == 'U')) {
                    TONE_MAP[c]?.let { tones ->
                        charArray[i] = tones[toneIndex]
                        replaced = true
                    }
                    break
                }
            }
        }

        // Rule 3: Last vowel gets the tone mark
        if (!replaced) {
            var lastVowelIdx = -1
            for (i in charArray.indices) {
                if (charArray[i] in VOWELS) {
                    lastVowelIdx = i
                }
            }
            if (lastVowelIdx != -1) {
                val c = charArray[lastVowelIdx]
                TONE_MAP[c]?.let { tones ->
                    charArray[lastVowelIdx] = tones[toneIndex]
                    replaced = true
                }
            }
        }

        val finalWord = String(charArray).replace("v", "ü").replace("V", "Ü")
        return prefix + finalWord + suffix
    }

    /**
     * Converts a full pinyin string (e.g. "zi4 xing2 che1") to tone-marked pinyin ("zì xíng chē").
     * Leaves already converted pinyin or plain words untouched.
     */
    fun toToneMarks(pinyin: String?): String {
        if (pinyin.isNullOrBlank()) return ""
        if (!pinyin.any { it in '1'..'5' }) return pinyin.replace("v", "ü").replace("V", "Ü")

        return pinyin.split(" ").joinToString(" ") { token ->
            if (token.any { it in '1'..'5' }) convertSyllable(token) else token.replace("v", "ü").replace("V", "Ü")
        }
    }
}
