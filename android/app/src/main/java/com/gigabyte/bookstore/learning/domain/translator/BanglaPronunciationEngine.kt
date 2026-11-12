package com.gigabyte.bookstore.learning.domain.translator

import com.gigabyte.bookstore.learning.presentation.vocab.VocabRepository
import java.util.concurrent.ConcurrentHashMap

/**
 * Deterministic, zero-network Bangla phonetic pronunciation bridge (`বাংলা উচ্চারণ`).
 *
 * Guarantees that every translation across all 7 courses (English, Japanese, Urdu, Hindi, German,
 * Arabic, and Regional Bangla) can display accurate Bengali-script pronunciation even when
 * Tier-3 web fallback or offline partial/word matching is used.
 */
object BanglaPronunciationEngine {

    private val vocabCache = ConcurrentHashMap<String, Map<String, String>>()

    private val PUNCT_EDGE = Regex("^([^\\p{L}\\p{N}\\p{M}]*)(.*?)([^\\p{L}\\p{N}\\p{M}]*)$")
    private val LATIN_CHECK = Regex("[A-Za-zÀ-ÖØ-öø-ÿ]")
    private val BENGALI_CHAR = Regex("[\\u0980-\\u09FF]")
    private val DEVANAGARI_CHAR = Regex("[\\u0900-\\u097F]")
    private val KANA_CHAR = Regex("[\\u3040-\\u30FF]")
    private val KANJI_CHAR = Regex("[\\u4E00-\\u9FFF]")
    private val ARABIC_CHAR = Regex("[\\u0600-\\u06FF\\u0750-\\u077F]")
    private val DIGITS_ONLY = Regex("^\\d+$")

    fun generate(
        targetText: String,
        language: TranslatorLanguage,
        romanizationHint: String? = null,
        useVocabLookup: Boolean = true
    ): String? {
        val clean = targetText.trim()
        if (clean.isEmpty()) return null

        // Regional / already Bengali text
        if (language == TranslatorLanguage.REGIONAL_BANGLA) {
            return clean
        }

        // Exact phrase hit in bundled 1000-word VocabVault
        if (useVocabLookup) {
            lookupVocab(language.key, clean)?.let { return it }
        }

        val hint = romanizationHint?.trim()?.takeIf { it.isNotEmpty() }

        val generated = when (language) {
            TranslatorLanguage.REGIONAL_BANGLA -> clean
            TranslatorLanguage.HINDI -> {
                if (DEVANAGARI_CHAR.containsMatchIn(clean)) {
                    transliterateDevanagariSentence(clean, useVocabLookup)
                } else {
                    transliterateLatinSentence(hint ?: clean, TranslatorLanguage.HINDI, useVocabLookup)
                }
            }
            TranslatorLanguage.JAPANESE -> transliterateJapaneseSentence(clean, hint, useVocabLookup)
            TranslatorLanguage.GERMAN -> transliterateLatinSentence(clean, TranslatorLanguage.GERMAN, useVocabLookup)
            TranslatorLanguage.ENGLISH -> transliterateLatinSentence(clean, TranslatorLanguage.ENGLISH, useVocabLookup)
            TranslatorLanguage.ARABIC -> transliterateArabicOrUrdu(clean, hint, TranslatorLanguage.ARABIC, useVocabLookup)
            TranslatorLanguage.URDU -> transliterateArabicOrUrdu(clean, hint, TranslatorLanguage.URDU, useVocabLookup)
            TranslatorLanguage.CHINESE -> transliterateChineseSentence(clean, hint, useVocabLookup)
            TranslatorLanguage.KOREAN -> transliterateKoreanSentence(clean, hint, useVocabLookup)
        }

        val normalized = generated.replace(Regex("\\s+"), " ").trim()
        return normalized.takeIf { it.isNotEmpty() }
    }

    fun generateWord(
        word: String,
        language: TranslatorLanguage,
        romanizationHint: String? = null
    ): String? = generate(word, language, romanizationHint, useVocabLookup = true)

    private fun lookupVocab(langKey: String, text: String): String? {
        val norm = normalizeLookupKey(text)
        if (norm.isEmpty()) return null
        val map = getVocabMap(langKey)
        return map[norm]
    }

    private fun getVocabMap(langKey: String): Map<String, String> {
        if (langKey !in setOf("english", "japanese", "urdu", "hindi", "german", "chinese", "korean")) return emptyMap()
        return vocabCache.getOrPut(langKey) {
            runCatching {
                val items = VocabRepository.getConfigForLanguage(langKey).items
                val map = HashMap<String, String>(items.size * 2)
                for (item in items) {
                    val sKey = normalizeLookupKey(item.singularTarget)
                    if (sKey.isNotEmpty() && item.singularBnPron.isNotBlank()) {
                        map.putIfAbsent(sKey, item.singularBnPron.trim())
                    }
                    item.singularSecondary?.let { sec ->
                        val secKey = normalizeLookupKey(sec)
                        if (secKey.isNotEmpty() && item.singularBnPron.isNotBlank()) {
                            map.putIfAbsent(secKey, item.singularBnPron.trim())
                        }
                    }
                    val pTarget = item.pluralTarget
                    val pPron = item.pluralBnPron
                    if (!pTarget.isNullOrBlank() && !pPron.isNullOrBlank()) {
                        val pKey = normalizeLookupKey(pTarget)
                        if (pKey.isNotEmpty()) map.putIfAbsent(pKey, pPron.trim())
                    }
                }
                map
            }.getOrDefault(emptyMap())
        }
    }

    private fun normalizeLookupKey(text: String): String =
        text.trim().lowercase().replace(Regex("[।॥,?!.,:;'\'\"“”()\\[\\]]+"), "").trim()

    // =========================================================================
    // HINDI (Devanagari -> Bengali script)
    // =========================================================================

    private fun transliterateDevanagariSentence(text: String, useVocabLookup: Boolean): String {
        val parts = text.split(Regex("\\s+")).filter { it.isNotEmpty() }
        return parts.joinToString(" ") { raw ->
            val m = PUNCT_EDGE.matchEntire(raw)
            val pre = m?.groupValues?.getOrNull(1).orEmpty()
            val core = m?.groupValues?.getOrNull(2) ?: raw
            val post = m?.groupValues?.getOrNull(3).orEmpty()
            if (core.isEmpty()) return@joinToString raw

            val bnCore = (if (useVocabLookup) lookupVocab("hindi", core) else null)
                ?: transliterateDevanagariWord(core)
            "$pre$bnCore$post"
        }
    }

    internal fun transliterateDevanagariWord(word: String): String {
        if (DIGITS_ONLY.matches(word)) return word
        if (!DEVANAGARI_CHAR.containsMatchIn(word)) return word
        val sb = StringBuilder(word.length)
        var i = 0
        while (i < word.length) {
            val ch = word[i]
            val next = word.getOrNull(i + 1)
            // Nukta pairs (e.g., क + ़)
            if (next == '\u093C') {
                val mapped = when (ch) {
                    'क' -> "ক"
                    'ख' -> "খ"
                    'ग' -> "গ"
                    'ज' -> "জ"
                    'ड' -> "ড়"
                    'ढ' -> "ঢ়"
                    'फ' -> "ফ"
                    'य' -> "য়"
                    else -> mapDevanagariChar(ch)
                }
                sb.append(mapped)
                i += 2
                continue
            }
            // Precomposed Nukta characters
            when (ch) {
                '\u0958' -> { sb.append("ক"); i++; continue }
                '\u0959' -> { sb.append("খ"); i++; continue }
                '\u095A' -> { sb.append("গ"); i++; continue }
                '\u095B' -> { sb.append("জ"); i++; continue }
                '\u095C' -> { sb.append("ড়"); i++; continue }
                '\u095D' -> { sb.append("ঢ়"); i++; continue }
                '\u095E' -> { sb.append("ফ"); i++; continue }
                '\u095F' -> { sb.append("য়"); i++; continue }
            }
            // Devanagari 'य' -> 'য়' (more accurate in Hindi phonetics after vowels/medially)
            if (ch == 'य') {
                val prev = word.getOrNull(i - 1)
                if (prev == '\u094D') sb.append("য") else sb.append("য়")
                i++
                continue
            }
            // Devanagari 'व' -> 'ভ' word-initially or standalone, 'ব' in conjuncts
            if (ch == 'व') {
                val prev = word.getOrNull(i - 1)
                when {
                    prev == '\u094D' -> sb.append("ব")
                    i == 0 -> sb.append("ভ")
                    else -> sb.append("ওয়")
                }
                i++
                continue
            }
            sb.append(mapDevanagariChar(ch))
            i++
        }
        return sb.toString()
    }

    private fun mapDevanagariChar(ch: Char): String = when (ch) {
        'अ' -> "অ"; 'आ' -> "আ"; 'इ' -> "ই"; 'ई' -> "ঈ"; 'उ' -> "উ"; 'ऊ' -> "ঊ"
        'ऋ' -> "ঋ"; 'ए' -> "এ"; 'ऐ' -> "ঐ"; 'ओ' -> "ও"; 'औ' -> "ঔ"
        'ऑ' -> "অ"; 'ऍ' -> "অ্যা"
        'ा' -> "া"; 'ि' -> "ি"; 'ी' -> "ী"; 'ु' -> "ু"; 'ू' -> "ূ"
        'ृ' -> "ৃ"; 'े' -> "ে"; 'ै' -> "ৈ"; 'ो' -> "ো"; 'ौ' -> "ৌ"
        'ॉ' -> "া"; 'ॅ' -> "্যা"
        'क' -> "ক"; 'ख' -> "খ"; 'ग' -> "গ"; 'घ' -> "ঘ"; 'ङ' -> "ঙ"
        'च' -> "চ"; 'छ' -> "ছ"; 'ज' -> "জ"; 'झ' -> "ঝ"; 'ञ' -> "ঞ"
        'ट' -> "ট"; 'ठ' -> "ঠ"; 'ड' -> "ড"; 'ढ' -> "ঢ"; 'ण' -> "ণ"
        'त' -> "ত"; 'थ' -> "থ"; 'द' -> "দ"; 'ध' -> "ধ"; 'न' -> "ন"
        'प' -> "প"; 'फ' -> "ফ"; 'ब' -> "ব"; 'भ' -> "ভ"; 'म' -> "ম"
        'य' -> "য়"; 'र' -> "র"; 'ल' -> "ল"; 'व' -> "ভ"; 'श' -> "শ"; 'ष' -> "ষ"; 'स' -> "স"; 'ह' -> "হ"
        '्' -> "্"; 'ं' -> "ং"; 'ँ' -> "ঁ"; 'ः' -> "ঃ"; '।' -> "।"; '॥' -> "॥"
        else -> ch.toString()
    }

    // =========================================================================
    // JAPANESE (Kana & Romaji -> Bengali script)
    // =========================================================================

    private fun transliterateJapaneseSentence(
        targetText: String,
        romanizationHint: String?,
        useVocabLookup: Boolean
    ): String {
        val hasKanji = KANJI_CHAR.containsMatchIn(targetText)
        val hasKana = KANA_CHAR.containsMatchIn(targetText)
        // Prefer Google/AI Romaji when Kanji are present so Kanji readings are accurate!
        if (hasKanji && !romanizationHint.isNullOrBlank()) {
            return transliterateRomajiToBangla(romanizationHint)
        }
        if (hasKana && !hasKanji) {
            return transliterateKanaToBangla(targetText)
        }
        if (!romanizationHint.isNullOrBlank()) {
            return transliterateRomajiToBangla(romanizationHint)
        }
        if (useVocabLookup) {
            lookupVocab("japanese", targetText)?.let { return it }
        }
        return if (hasKana) transliterateKanaToBangla(targetText) else targetText
    }

    internal fun transliterateKanaToBangla(input: String): String {
        // Normalize Katakana -> Hiragana for uniform mora table lookup
        val hira = buildString(input.length) {
            for (c in input) {
                when {
                    c in '\u30A1'..'\u30F6' -> append((c.code - 0x60).toChar())
                    c == 'ー' -> append('ー')
                    else -> append(c)
                }
            }
        }

        val romaji = StringBuilder()
        var i = 0
        while (i < hira.length) {
            val c = hira[i]
            val next = hira.getOrNull(i + 1)
            // Small tsu (sokuon) doubles next consonant
            if (c == 'っ' && next != null) {
                val nextRoma = KANA_DIGRAPHS[hira.substring(i + 1, (i + 3).coerceAtMost(hira.length))]
                    ?: KANA_MONOGRAPHS[next.toString()]
                val firstCons = nextRoma?.firstOrNull()
                if (firstCons != null && firstCons !in "aeiou") {
                    romaji.append(firstCons)
                }
                i++
                continue
            }
            if (c == 'ー') {
                // Repeat last vowel sound for katakana elongation
                val last = romaji.lastOrNull()
                if (last != null && last in "aeiou") romaji.append(last)
                i++
                continue
            }
            if (i + 1 < hira.length) {
                val pair = hira.substring(i, i + 2)
                KANA_DIGRAPHS[pair]?.let {
                    romaji.append(it)
                    i += 2
                    return@let
                }?.also { continue }
            }
            KANA_MONOGRAPHS[c.toString()]?.let {
                romaji.append(it)
                i++
                continue
            }
            romaji.append(
                when (c) {
                    '。' -> "।"; '、' -> ","; '？' -> "?"; '！' -> "!"
                    else -> c
                }
            )
            i++
        }
        return transliterateRomajiToBangla(romaji.toString())
    }

    internal fun transliterateRomajiToBangla(romaji: String): String {
        val parts = romaji.trim().split(Regex("\\s+")).filter { it.isNotEmpty() }
        return parts.joinToString(" ") { raw ->
            val m = PUNCT_EDGE.matchEntire(raw)
            val pre = m?.groupValues?.getOrNull(1).orEmpty()
            val core = m?.groupValues?.getOrNull(2) ?: raw
            val post = m?.groupValues?.getOrNull(3).orEmpty()
            if (core.isEmpty()) return@joinToString raw
            "$pre${romajiWordToBangla(core)}$post"
        }
    }

    private fun romajiWordToBangla(word: String): String {
        val s = word.lowercase()
            .replace("ā", "aa").replace("ī", "ii").replace("ū", "uu")
            .replace("ē", "ee").replace("ō", "oo")
            .replace("-", "")
        if (!LATIN_CHECK.containsMatchIn(s)) return word

        val sb = StringBuilder()
        var i = 0
        while (i < s.length) {
            val c = s[i]
            if (c !in 'a'..'z') {
                sb.append(c)
                i++
                continue
            }
            // Check 3-char clusters
            if (i + 2 < s.length) {
                val tri = s.substring(i, i + 3)
                when (tri) {
                    "tsu" -> { sb.append("ৎসু"); i += 3; continue }
                    "chi" -> { sb.append("চি"); i += 3; continue }
                    "shi" -> { sb.append("শি"); i += 3; continue }
                    "sha" -> { sb.append("শা"); i += 3; continue }
                    "shu" -> { sb.append("শু"); i += 3; continue }
                    "sho" -> { sb.append("শো"); i += 3; continue }
                    "cha" -> { sb.append("চা"); i += 3; continue }
                    "chu" -> { sb.append("চু"); i += 3; continue }
                    "cho" -> { sb.append("চো"); i += 3; continue }
                }
            }
            // Check 2-char clusters
            if (i + 1 < s.length) {
                val di = s.substring(i, i + 2)
                when (di) {
                    "sh" -> { sb.append(attachBanglaConsonant("শ", s.getOrNull(i + 2))); i += advanceCluster(s, i, 2, isGerman = false); continue }
                    "ch" -> { sb.append(attachBanglaConsonant("চ", s.getOrNull(i + 2))); i += advanceCluster(s, i, 2, isGerman = false); continue }
                    "ts" -> { sb.append(attachBanglaConsonant("ৎস", s.getOrNull(i + 2))); i += advanceCluster(s, i, 2, isGerman = false); continue }
                    "ky", "gy", "ny", "hy", "my", "ry", "by", "py" -> {
                        val base = romajiConsonant(di[0])
                        val v = s.getOrNull(i + 2)
                        val matra = when (v) {
                            'a' -> "্যা"
                            'u' -> "্যু"
                            'o' -> "্যো"
                            else -> "্য"
                        }
                        sb.append(base).append(matra)
                        i += if (v in listOf('a', 'u', 'o')) 3 else 2
                        continue
                    }
                    "aa" -> { sb.append("আ"); i += 2; continue }
                    "ii", "ee" -> { sb.append("ই"); i += 2; continue }
                    "uu" -> { sb.append("উ"); i += 2; continue }
                    "oo" -> { sb.append("ও"); i += 2; continue }
                    "ei" -> { sb.append("এই"); i += 2; continue }
                    "ai" -> { sb.append("আই"); i += 2; continue }
                    "ou" -> { sb.append("ও"); i += 2; continue }
                    "n'" -> { sb.append("ন"); i += 2; continue }
                }
            }
            if (c in "aeiou") {
                sb.append(
                    when (c) {
                        'a' -> "আ"; 'i' -> "ই"; 'u' -> "উ"; 'e' -> "এ"; else -> "ও"
                    }
                )
                i++
                continue
            }
            // Standalone syllabic 'n' before consonant or end of word
            if (c == 'n') {
                val next = s.getOrNull(i + 1)
                if (next == null || next !in "aeiouy") {
                    if (next in listOf('k', 'g')) sb.append("ং")
                    else if (next in listOf('p', 'b', 'm')) sb.append("ম")
                    else sb.append("ন")
                    i++
                    continue
                }
            }
            val cons = romajiConsonant(c)
            if (i + 2 < s.length && s.substring(i + 1, i + 3) == "ou") {
                sb.append("${cons}ো")
                i += 3
            } else {
                val next = s.getOrNull(i + 1)
                sb.append(attachBanglaConsonant(cons, next))
                i += advanceCluster(s, i, 1, isGerman = false)
            }
        }
        return sb.toString()
    }

    private fun romajiConsonant(c: Char): String = when (c) {
        'k' -> "ক"; 'g' -> "গ"; 's' -> "স"; 'z', 'j' -> "জ"
        't' -> "ত"; 'd' -> "দ"; 'n' -> "ন"; 'h' -> "হ"
        'f' -> "ফ"; 'b' -> "ব"; 'p' -> "প"; 'm' -> "ম"
        'y' -> "য়"; 'r' -> "র"; 'w' -> "ওয়"; 'c' -> "ক"
        'l' -> "ল"; 'v' -> "ভ"
        else -> c.toString()
    }

    // =========================================================================
    // ARABIC & URDU (Common Phrases + Script + Google `dt=rm` Romanization)
    // =========================================================================

    private fun transliterateArabicOrUrdu(
        targetText: String,
        romanizationHint: String?,
        language: TranslatorLanguage,
        useVocabLookup: Boolean
    ): String {
        val clean = targetText.trim()
        if (language == TranslatorLanguage.ARABIC) {
            ARABIC_COMMON_PHRASES[normalizeLookupKey(clean)]?.let { return it }
        } else {
            URDU_COMMON_PHRASES[normalizeLookupKey(clean)]?.let { return it }
        }

        // If romanization hint exists (from Google `dt=rm` or AI), prefer transliterating it accurately
        if (!romanizationHint.isNullOrBlank() && LATIN_CHECK.containsMatchIn(romanizationHint)) {
            return transliterateArabicUrduRomanization(romanizationHint)
        }

        // Otherwise fallback to direct Arabic/Urdu script word-by-word transliteration
        val parts = clean.split(Regex("\\s+")).filter { it.isNotEmpty() }
        return parts.joinToString(" ") { raw ->
            val m = PUNCT_EDGE.matchEntire(raw)
            val pre = m?.groupValues?.getOrNull(1).orEmpty()
            val core = m?.groupValues?.getOrNull(2) ?: raw
            val post = m?.groupValues?.getOrNull(3).orEmpty()
            if (core.isEmpty()) return@joinToString raw

            val bnCore = (if (useVocabLookup) lookupVocab(language.key, core) else null)
                ?: ARABIC_WORD_LEXICON[core]
                ?: URDU_WORD_LEXICON[core]
                ?: transliterateArabicScriptWord(core)
            "$pre$bnCore$post"
        }
    }

    internal fun transliterateArabicUrduRomanization(roman: String): String {
        val parts = roman.trim().split(Regex("\\s+")).filter { it.isNotEmpty() }
        return parts.joinToString(" ") { raw ->
            val m = PUNCT_EDGE.matchEntire(raw)
            val pre = m?.groupValues?.getOrNull(1).orEmpty()
            val core = m?.groupValues?.getOrNull(2) ?: raw
            val post = m?.groupValues?.getOrNull(3).orEmpty()
            if (core.isEmpty()) return@joinToString raw
            val norm = core.lowercase().replace("'", "").replace("’", "").replace("ʻ", "")
            val lexiconHit = ARABIC_URDU_ROMA_WORDS[norm]
            val bnCore = lexiconHit ?: transliterateLatinPhoneticWord(norm, isGerman = false)
            "$pre$bnCore$post"
        }
    }

    private fun transliterateArabicScriptWord(word: String): String {
        if (!ARABIC_CHAR.containsMatchIn(word)) return word
        val sb = StringBuilder()
        var i = 0
        while (i < word.length) {
            val ch = word[i]
            val next = word.getOrNull(i + 1)
            // Harakat check
            val banglaBase = when (ch) {
                'ا', 'أ', 'إ', 'آ' -> if (i == 0) "আ" else "া"
                'ب', 'پ' -> if (ch == 'پ') "প" else "ব"
                'ت', 'ٹ', 'ة' -> when (ch) { 'ٹ' -> "ট"; 'ة' -> "হ"; else -> "ত" }
                'ث' -> "ছ"
                'ج' -> "জ"
                'چ' -> "চ"
                'ح' -> "হ"
                'خ' -> "খ"
                'د', 'ڈ' -> if (ch == 'ڈ') "ড" else "দ"
                'ذ' -> "জ"
                'ر', 'ڑ' -> if (ch == 'ڑ') "ড়" else "র"
                'ز', 'ژ' -> "জ"
                'س' -> "স"
                'ش' -> "শ"
                'ص' -> "স"
                'ض' -> "দ"
                'ط' -> "ত"
                'ظ' -> "জ"
                'ع' -> if (i == 0) "আ" else ""
                'غ' -> "গ"
                'ف' -> "ফ"
                'ق' -> "ক"
                'ك', 'ک' -> "ক"
                'گ' -> "গ"
                'ل' -> "ল"
                'م' -> "ম"
                'ن', 'ں' -> if (ch == 'ں') "ঁ" else "ন"
                'ه', 'ہ', 'ھ' -> "হ"
                'و' -> if (i == 0) "ওয়" else "ও"
                'ي', 'ی', 'ے' -> if (i == 0) "ইয়" else "ই"
                'ء', 'ئ', 'ؤ' -> ""
                '\u064E' -> "া"  // fatha
                '\u0650' -> "ি"  // kasra
                '\u064F' -> "ু"  // damma
                '\u064B' -> "ান" // fathatan
                '\u0652' -> "্"  // sukun
                '\u0651' -> ""   // shadda
                '؟' -> "?"
                '،' -> ","
                else -> if (ch in '\u064B'..'\u065F') "" else ch.toString()
            }
            if (next in listOf('\u064E', '\u0650', '\u064F') && banglaBase.isNotEmpty() && ch !in listOf('ا', 'و', 'ي')) {
                sb.append(banglaBase).append(
                    when (next) {
                        '\u064E' -> "া"
                        '\u0650' -> "ি"
                        else -> "ু"
                    }
                )
                i += 2
                continue
            }
            sb.append(banglaBase)
            i++
        }
        return sb.toString()
    }

    // =========================================================================
    // ENGLISH & GERMAN (Vocab + Lexicon + Grapheme-to-Phoneme Rules -> বাংলা)
    // =========================================================================

    private fun transliterateLatinSentence(
        text: String,
        language: TranslatorLanguage,
        useVocabLookup: Boolean
    ): String {
        val parts = text.trim().split(Regex("\\s+")).filter { it.isNotEmpty() }
        return parts.joinToString(" ") { raw ->
            val m = PUNCT_EDGE.matchEntire(raw)
            val pre = m?.groupValues?.getOrNull(1).orEmpty()
            val core = m?.groupValues?.getOrNull(2) ?: raw
            val post = m?.groupValues?.getOrNull(3).orEmpty()
            if (core.isEmpty()) return@joinToString raw

            val bnCore = transliterateSingleLatinWord(core, language, useVocabLookup)
            "$pre$bnCore$post"
        }
    }

    private fun transliterateSingleLatinWord(
        core: String,
        language: TranslatorLanguage,
        useVocabLookup: Boolean
    ): String {
        if (DIGITS_ONLY.matches(core)) return core
        if (BENGALI_CHAR.containsMatchIn(core)) return core
        val lower = core.lowercase()

        // 1. Curated 1000-word VocabVault lookup
        if (useVocabLookup) {
            lookupVocab(language.key, lower)?.let { return it }
        }

        // 2. High-frequency daily word dictionary
        val dict = if (language == TranslatorLanguage.GERMAN) GERMAN_WORD_LEXICON else ENGLISH_WORD_LEXICON
        dict[lower]?.let { return it }

        // Handle contractions cleanly (e.g. "don't", "i'm", "it's")
        if (language == TranslatorLanguage.ENGLISH && '\'' in lower) {
            ENGLISH_CONTRACTIONS[lower]?.let { return it }
        }

        // 3. Rule-based grapheme-to-phoneme engine
        return transliterateLatinPhoneticWord(lower, isGerman = language == TranslatorLanguage.GERMAN)
    }

    internal fun transliterateLatinPhoneticWord(word: String, isGerman: Boolean): String {
        if (word.isEmpty() || !LATIN_CHECK.containsMatchIn(word)) return word
        val s = word.lowercase()
            .replace("äu", "eu")
            .replace("ß", "ss")
        val sb = StringBuilder()
        var i = 0
        while (i < s.length) {
            val rem = s.substring(i)

            // German specific rules
            if (isGerman) {
                when {
                    rem.startsWith("tsch") -> { sb.append(attachNextVowel("চ", s, i + 4)); i += advanceCluster(s, i, 4, true); continue }
                    rem.startsWith("sch") -> { sb.append(attachNextVowel("শ", s, i + 3)); i += advanceCluster(s, i, 3, true); continue }
                    i == 0 && rem.startsWith("st") -> { sb.append(attachNextVowel("শ্ট", s, i + 2)); i += advanceCluster(s, i, 2, true); continue }
                    i == 0 && rem.startsWith("sp") -> { sb.append(attachNextVowel("শ্প", s, i + 2)); i += advanceCluster(s, i, 2, true); continue }
                    rem.startsWith("chs") -> { sb.append("ক্স"); i += 3; continue }
                    rem.startsWith("ch") -> { sb.append(if (s.getOrNull(i - 1) in listOf('a', 'o', 'u')) "খ" else "শ"); i += 2; continue }
                    rem.startsWith("ei") || rem.startsWith("ai") -> { sb.append("আই"); i += 2; continue }
                    rem.startsWith("eu") -> { sb.append("অয়"); i += 2; continue }
                    rem.startsWith("au") -> { sb.append("আউ"); i += 2; continue }
                    rem.startsWith("ie") -> { sb.append("ই"); i += 2; continue }
                    rem.startsWith("qu") -> { sb.append(attachNextVowel("কভ", s, i + 2)); i += advanceCluster(s, i, 2, true); continue }
                }
            } else {
                // English suffixes & multi-letter grapheme clusters
                when {
                    rem == "tion" || rem == "tions" -> { sb.append(if (rem.endsWith("s")) "শন্স" else "শন"); i += rem.length; continue }
                    rem == "sion" || rem == "sions" -> { sb.append(if (rem.endsWith("s")) "শন্স" else "শন"); i += rem.length; continue }
                    rem == "ture" -> { sb.append("চার"); i += 4; continue }
                    rem == "ight" -> { sb.append("াইট"); i += 4; continue }
                    rem == "ough" -> { sb.append("ও"); i += 4; continue }
                    rem.startsWith("sh") -> { sb.append(attachNextVowel("শ", s, i + 2)); i += advanceCluster(s, i, 2, false); continue }
                    rem.startsWith("ch") -> { sb.append(attachNextVowel("চ", s, i + 2)); i += advanceCluster(s, i, 2, false); continue }
                    rem.startsWith("th") -> { sb.append(attachNextVowel("থ", s, i + 2)); i += advanceCluster(s, i, 2, false); continue }
                    rem.startsWith("ph") -> { sb.append(attachNextVowel("ফ", s, i + 2)); i += advanceCluster(s, i, 2, false); continue }
                    rem.startsWith("wh") -> { sb.append(attachNextVowel("হোয়", s, i + 2)); i += advanceCluster(s, i, 2, false); continue }
                    rem.startsWith("ng") -> { sb.append("ং"); i += 2; continue }
                    rem.startsWith("ck") -> { sb.append("ক"); i += 2; continue }
                    rem.startsWith("oo") -> { sb.append("উ"); i += 2; continue }
                    rem.startsWith("ee") || rem.startsWith("ea") -> { sb.append("ই"); i += 2; continue }
                    rem.startsWith("ai") || rem.startsWith("ay") -> { sb.append("এই"); i += 2; continue }
                    rem.startsWith("oa") -> { sb.append("ও"); i += 2; continue }
                    rem.startsWith("ou") || rem.startsWith("ow") -> { sb.append("আউ"); i += 2; continue }
                    rem.startsWith("oi") || rem.startsWith("oy") -> { sb.append("অয়"); i += 2; continue }
                }
            }

            val ch = s[i]
            // Silent trailing 'e' in English multi-letter words
            if (!isGerman && ch == 'e' && i == s.lastIndex && s.length > 3) {
                i++
                continue
            }

            if (ch in "aeiouäöü") {
                sb.append(
                    when (ch) {
                        'a' -> "অ্যা"
                        'e' -> "এ"
                        'i' -> "ই"
                        'o' -> "ও"
                        'u' -> "উ"
                        'ä' -> "এ"
                        'ö' -> "ও"
                        'ü' -> "উ"
                        else -> ""
                    }
                )
                i++
                continue
            }

            // Skip immediate duplicate consonant
            if (i + 1 < s.length && s[i + 1] == ch && ch in 'a'..'z') {
                i++
                continue
            }

            val bnCons = when {
                isGerman && ch == 'w' -> "ভ"
                isGerman && ch == 'v' -> "ফ"
                isGerman && ch == 'z' -> "ৎস"
                isGerman && ch == 'j' -> "য়"
                isGerman && ch == 's' && isVowel(s.getOrNull(i + 1)) -> "জ"
                !isGerman && ch == 'c' && s.getOrNull(i + 1) in listOf('e', 'i', 'y') -> "স"
                !isGerman && ch == 'j' -> "জ"
                ch == 'b' -> "ব"; ch == 'c' -> "ক"; ch == 'd' -> "ড"
                ch == 'f' -> "ফ"; ch == 'g' -> "গ"; ch == 'h' -> "হ"
                ch == 'k' -> "ক"; ch == 'l' -> "ল"; ch == 'm' -> "ম"
                ch == 'n' -> "ন"; ch == 'p' -> "প"; ch == 'q' -> "ক"
                ch == 'r' -> "র"; ch == 's' -> "স"; ch == 't' -> "ট"
                ch == 'v' -> "ভ"; ch == 'w' -> "ওয়"; ch == 'x' -> "ক্স"
                ch == 'y' -> "য়"; ch == 'z' -> "জ"
                else -> ch.toString()
            }
            val afterCons = s.substring(i + 1)
            val digraphMatra = when {
                !isGerman && afterCons.startsWith("igh") -> "াই" to 3
                afterCons.startsWith("oo") -> "ু" to 2
                afterCons.startsWith("ee") || (!isGerman && afterCons.startsWith("ea")) -> "ি" to 2
                isGerman && afterCons.startsWith("ie") -> "ি" to 2
                isGerman && (afterCons.startsWith("ei") || afterCons.startsWith("ai")) -> "াই" to 2
                isGerman && afterCons.startsWith("eu") -> "য়" to 2
                isGerman && afterCons.startsWith("au") -> "াউ" to 2
                !isGerman && (afterCons.startsWith("ai") || afterCons.startsWith("ay")) -> "েই" to 2
                !isGerman && afterCons.startsWith("oa") -> "ো" to 2
                !isGerman && (afterCons.startsWith("ou") || afterCons.startsWith("ow")) -> "াউ" to 2
                !isGerman && (afterCons.startsWith("oi") || afterCons.startsWith("oy")) -> "য়" to 2
                else -> null
            }
            if (digraphMatra != null) {
                sb.append(bnCons).append(digraphMatra.first)
                i += 1 + digraphMatra.second
                continue
            }

            val next = s.getOrNull(i + 1)
            val isTrailingSilentE = !isGerman && next == 'e' && i + 1 == s.lastIndex && s.length > 3
            if (isVowel(next) && !isTrailingSilentE) {
                sb.append(attachBanglaConsonant(bnCons, next))
                i += 2
            } else {
                sb.append(bnCons)
                i++
            }
        }
        return sb.toString()
    }

    private fun isVowel(ch: Char?): Boolean = ch != null && ch in "aeiouäöü"

    private fun attachNextVowel(cons: String, s: String, vowelIdx: Int): String =
        attachBanglaConsonant(cons, s.getOrNull(vowelIdx))

    private fun advanceCluster(s: String, startIdx: Int, clusterLen: Int, isGerman: Boolean): Int {
        val vowelIdx = startIdx + clusterLen
        val v = s.getOrNull(vowelIdx)
        val isTrailingSilentE = !isGerman && v == 'e' && vowelIdx == s.lastIndex && s.length > 3
        return if (isVowel(v) && !isTrailingSilentE) clusterLen + 1 else clusterLen
    }

    private fun attachBanglaConsonant(cons: String, vowel: Char?): String = when (vowel) {
        'a' -> "${cons}া"
        'i' -> "${cons}ি"
        'u' -> "${cons}ু"
        'e', 'ä' -> "${cons}ে"
        'o', 'ö' -> "${cons}ো"
        'ü' -> "${cons}ু"
        else -> cons
    }

    private val KANA_DIGRAPHS = mapOf(
        "きゃ" to "kya", "きゅ" to "kyu", "きょ" to "kyo",
        "しゃ" to "sha", "しゅ" to "shu", "しょ" to "sho",
        "ちゃ" to "cha", "ちゅ" to "chu", "ちょ" to "cho",
        "にゃ" to "nya", "にゅ" to "nyu", "にょ" to "nyo",
        "ひゃ" to "hya", "ひゅ" to "hyu", "ひょ" to "hyo",
        "みゃ" to "mya", "みゅ" to "myu", "みょ" to "myo",
        "りゃ" to "rya", "りゅ" to "ryu", "りょ" to "ryo",
        "ぎゃ" to "gya", "ぎゅ" to "gyu", "ぎょ" to "gyo",
        "じゃ" to "ja", "じゅ" to "ju", "じょ" to "jo",
        "びゃ" to "bya", "びゅ" to "byu", "びょ" to "byo",
        "ぴゃ" to "pya", "ぴゅ" to "pyu", "ぴょ" to "pyo"
    )

    private val KANA_MONOGRAPHS = mapOf(
        "あ" to "a", "い" to "i", "う" to "u", "え" to "e", "お" to "o",
        "か" to "ka", "き" to "ki", "く" to "ku", "け" to "ke", "こ" to "ko",
        "さ" to "sa", "し" to "shi", "す" to "su", "せ" to "se", "そ" to "so",
        "た" to "ta", "ち" to "chi", "つ" to "tsu", "て" to "te", "と" to "to",
        "な" to "na", "に" to "ni", "ぬ" to "nu", "ね" to "ne", "の" to "no",
        "は" to "ha", "ひ" to "hi", "ふ" to "fu", "へ" to "he", "ほ" to "ho",
        "ま" to "ma", "み" to "mi", "む" to "mu", "め" to "me", "も" to "mo",
        "や" to "ya", "ゆ" to "yu", "よ" to "yo",
        "ら" to "ra", "り" to "ri", "る" to "ru", "れ" to "re", "ろ" to "ro",
        "わ" to "wa", "を" to "o", "ん" to "n",
        "が" to "ga", "ぎ" to "gi", "ぐ" to "gu", "げ" to "ge", "ご" to "go",
        "ざ" to "za", "じ" to "ji", "ず" to "zu", "ぜ" to "ze", "ぞ" to "zo",
        "だ" to "da", "ぢ" to "ji", "づ" to "zu", "で" to "de", "ど" to "do",
        "ば" to "ba", "び" to "bi", "ぶ" to "bu", "べ" to "be", "ぼ" to "bo",
        "ぱ" to "pa", "ぴ" to "pi", "ぷ" to "pu", "ぺ" to "pe", "ぽ" to "po",
        "ぁ" to "a", "ぃ" to "i", "ぅ" to "u", "ぇ" to "e", "ぉ" to "o"
    )

    private val ENGLISH_CONTRACTIONS = mapOf(
        "i'm" to "আইম", "you're" to "ইউ আর", "he's" to "হিজ", "she's" to "শিজ",
        "it's" to "ইটস", "we're" to "উই আর", "they're" to "দে আর",
        "don't" to "ডোন্ট", "doesn't" to "ডাজন্ট", "didn't" to "ডিডন্ট",
        "can't" to "কান্ট", "couldn't" to "কুডন্ট", "won't" to "ওন্ট",
        "wouldn't" to "উডন্ট", "shouldn't" to "শুডন্ট", "isn't" to "ইজন্ট",
        "aren't" to "আরন্ট", "what's" to "হোয়াটস", "where's" to "হোয়্যার্স",
        "how's" to "হাউস", "that's" to "দ্যাটস", "there's" to "দেয়ার্স",
        "i'll" to "আইল", "i've" to "আইভ", "let's" to "লেটস"
    )

    private val ENGLISH_WORD_LEXICON = mapOf(
        "hello" to "হ্যালো", "hi" to "হাই", "hey" to "হেই",
        "how" to "হাউ", "are" to "আর", "you" to "ইউ", "i" to "আই", "am" to "অ্যাম",
        "fine" to "ফাইন", "good" to "গুড", "well" to "ওয়েল", "great" to "গ্রেট",
        "morning" to "মর্নিং", "afternoon" to "আফটারনুন", "evening" to "ইভনিং", "night" to "নাইট",
        "thank" to "থ্যাংক", "thanks" to "থ্যাংকস", "welcome" to "ওয়েলকাম",
        "please" to "প্লিজ", "sorry" to "সরি", "excuse" to "এক্সকিউজ", "me" to "মি",
        "what" to "হোয়াট", "is" to "ইজ", "your" to "ইয়োর", "name" to "নেম", "my" to "মাই",
        "where" to "হোয়্যার", "when" to "হোয়েন", "why" to "হোয়াই", "who" to "হু", "which" to "হুইচ",
        "much" to "মাচ", "many" to "মেনি", "price" to "প্রাইস", "cost" to "কস্ট",
        "this" to "দিস", "that" to "দ্যাট", "these" to "দিজ", "those" to "দোজ",
        "the" to "দ্য", "a" to "আ", "an" to "অ্যান", "and" to "অ্যান্ড", "or" to "অর", "but" to "বাট",
        "in" to "ইন", "on" to "অন", "at" to "অ্যাট", "to" to "টু", "for" to "ফর", "from" to "ফ্রম",
        "with" to "উইথ", "of" to "অফ", "by" to "বাই", "about" to "অ্যাবাউট",
        "not" to "নট", "no" to "নো", "yes" to "ইয়েস", "ok" to "ওকে", "okay" to "ওকে",
        "he" to "হি", "she" to "শি", "it" to "ইট", "we" to "উই", "they" to "দে", "them" to "দেম",
        "his" to "হিজ", "her" to "হার", "our" to "আওয়ার", "their" to "দেয়ার", "us" to "আস",
        "help" to "হেল্প", "need" to "নিড", "want" to "ওয়ান্ট", "like" to "লাইক", "love" to "লাভ",
        "have" to "হ্যাভ", "has" to "হ্যাজ", "had" to "হ্যাড",
        "do" to "ডু", "does" to "ডাজ", "did" to "ডিড", "done" to "ডান",
        "can" to "ক্যান", "could" to "কুড", "would" to "উড", "should" to "শুড",
        "will" to "উইল", "shall" to "শ্যাল", "may" to "মে", "might" to "মাইট", "must" to "মাস্ট",
        "go" to "গো", "going" to "গোয়িং", "went" to "ওয়েন্ট", "come" to "কাম", "coming" to "কামিং",
        "here" to "হেয়ার", "there" to "দেয়ার", "near" to "নিয়ার", "far" to "ফার",
        "cold" to "কোল্ড", "hot" to "হট", "warm" to "ওয়ার্ম", "water" to "ওয়াটার",
        "give" to "গিভ", "take" to "টেক", "care" to "কেয়ার", "stay" to "স্টে", "safe" to "সেফ",
        "eat" to "ইট", "drink" to "ড্রিংক", "food" to "ফুড", "sleep" to "স্লিপ",
        "work" to "ওয়ার্ক", "job" to "জব", "home" to "হোম", "house" to "হাউস", "room" to "রুম",
        "road" to "রোড", "way" to "ওয়ে", "street" to "স্ট্রিট", "city" to "সিটি",
        "time" to "টাইম", "today" to "টুডে", "tomorrow" to "টুমরো", "yesterday" to "ইয়েস্টারডে",
        "now" to "নাউ", "later" to "লেটার", "soon" to "সুন", "always" to "অলওয়েজ",
        "very" to "ভেরি", "really" to "রিয়্যালি", "nice" to "নাইস", "meet" to "মিট",
        "brother" to "ব্রাদার", "sister" to "সিস্টার", "friend" to "ফ্রেন্ড", "sir" to "স্যার",
        "doctor" to "ডক্টর", "hospital" to "হসপিটাল", "medicine" to "মেডিসিন",
        "money" to "মানি", "taka" to "টাকা", "dollar" to "ডলার", "buy" to "বাই", "sell" to "সেল",
        "open" to "ওপেন", "close" to "ক্লোজ", "know" to "নো", "understand" to "আন্ডারস্ট্যান্ড",
        "speak" to "স্পিক", "talk" to "টক", "say" to "সে", "tell" to "টেল", "ask" to "আস্ক",
        "english" to "ইংলিশ", "bangla" to "বাংলা", "bengali" to "বেঙ্গলি",
        "one" to "ওয়ান", "two" to "টু", "three" to "থ্রি", "four" to "ফোর", "five" to "ফাইভ",
        "six" to "সিক্স", "seven" to "সেভেন", "eight" to "এইট", "nine" to "নাইন", "ten" to "টেন",
        "little" to "লিটল", "some" to "সাম", "more" to "মোর", "all" to "অল", "every" to "এভরি",
        "right" to "রাইট", "left" to "লেফট", "straight" to "স্ট্রেট",
        "phone" to "ফোন", "call" to "কল", "message" to "ম্যাসেজ", "wait" to "ওয়েট",
        "read" to "রিড", "write" to "রাইট", "stop" to "স্টপ", "start" to "স্টার্ট",
        "see" to "সি", "look" to "লুক", "watch" to "ওয়াচ", "hear" to "হেয়ার", "listen" to "লিসেন",
        "happy" to "হ্যাপি", "sad" to "স্যাড", "tired" to "টায়ার্ড", "hungry" to "হাংরি", "thirsty" to "থার্স্টি"
    )

    private val GERMAN_WORD_LEXICON = mapOf(
        "hallo" to "হ্যালো", "guten" to "গুটেন", "morgen" to "মর্গেন", "tag" to "টাগ",
        "abend" to "আবেন্ড", "nacht" to "নাখট", "wie" to "ভি", "geht" to "গেট", "es" to "এস",
        "ihnen" to "ইনেন", "dir" to "ডিয়ার", "mir" to "মিয়ার", "gut" to "গুট", "sehr" to "জেয়ার",
        "danke" to "ডাংকে", "vielen" to "ফিলেন", "dank" to "ডাংক", "bitte" to "বিটে",
        "entschuldigung" to "এন্টশুলডিগুং", "ja" to "ইয়া", "nein" to "নাইন",
        "ich" to "ইশ", "du" to "দু", "sie" to "জি", "wir" to "ভিয়ার", "ihr" to "ইয়ার",
        "bin" to "বিন", "bist" to "বিস্ট", "ist" to "ইস্ট", "sind" to "জিন্ড", "habe" to "হাবে",
        "und" to "উন্ড", "oder" to "ওডার", "aber" to "আবার", "nicht" to "নিশ্ট",
        "was" to "ভাস", "wo" to "ভো", "wann" to "ভান", "warum" to "ভারুম", "wer" to "ভেয়ার",
        "viel" to "ফিল", "kostet" to "কস্টেট", "das" to "ডাস", "der" to "ডেয়ার", "die" to "ডি",
        "ein" to "আইন", "eine" to "আইনে", "etwas" to "এটভাস", "wasser" to "ভাসার", "kaltes" to "কাল্টেস",
        "hilfe" to "হিলফে", "brauche" to "ব্রাউখে", "straße" to "শ্ট্রাসে", "wohin" to "ভোহিন",
        "sprechen" to "শ্প্রেখেন", "verstehe" to "ফেয়ারশ্টেহে", "deutsch" to "ডয়চ"
    )

    private val ARABIC_COMMON_PHRASES = mapOf(
        "مرحبا" to "মারহাবান", "أهلا" to "আহলান", "شكرا" to "শুকরান", "عفوا" to "আফওয়ান",
        "نعم" to "নাআম", "لا" to "লা", "السلام عليكم" to "আসসালামু আলাইকুম",
        "وعليكم السلام" to "ওয়া আলাইকুমুস সালাম", "كيف حالك" to "কাইফা হালুক",
        "أنا بخير" to "আনা বিখাইর", "من فضلك" to "মিন ফাদলিক"
    )

    private val URDU_COMMON_PHRASES = mapOf(
        "السلام علیکم" to "আসসালামু আলাইকুম", "شکریہ" to "শুকরিয়া",
        "جی ہاں" to "জি হাঁ", "نہیں" to "নেহি", "آپ کیسے ہیں" to "আপ কাইসে হ্যায়ঁ",
        "میں ٹھیک ہوں" to "ম্যায়ঁ ঠিক হুঁ", "اس کی قیمت کیا ہے" to "ইস কি কিমত কিয়া হ্যায়"
    )

    private val ARABIC_WORD_LEXICON = mapOf(
        "مرحبا" to "মারহাবান", "كيف" to "কাইফা", "حالك" to "হালুক", "أنا" to "আনা",
        "بخير" to "বিখাইর", "شكرا" to "শুকরান", "كم" to "কাম", "ثمن" to "ছামান",
        "هذا" to "হাযা", "ماء" to "মা'", "بارد" to "বারিদ", "أين" to "আইনা",
        "الطريق" to "আত-তারীক", "أريد" to "উরীদু", "مساعدة" to "মুসাআদাহ", "من" to "মিন", "فضلك" to "فাদলিক"
    )

    private val URDU_WORD_LEXICON = mapOf(
        "آپ" to "আপ", "کیسے" to "কাইসে", "ہیں" to "হ্যায়ঁ", "میں" to "ম্যায়ঁ",
        "ٹھیک" to "ঠিক", "ہوں" to "হুঁ", "شکریہ" to "শুকরিয়া", "بھائی" to "ভাই",
        "اس" to "ইস", "کی" to "কি", "قیمت" to "কিমত", "کتنی" to "কিতনি", "ہے" to "হ্যায়",
        "پانی" to "পানি", "ٹھنڈا" to "ঠান্ডা", "راستہ" to "রাস্তা", "کہاں" to "কাহাঁ", "مدد" to "মদদ"
    )

    private val ARABIC_URDU_ROMA_WORDS = mapOf(
        "marhaban" to "মারহাবান", "ahlan" to "আহলান", "shukran" to "শুকরান", "shukriya" to "শুকরিয়া",
        "kayfa" to "কাইফা", "haluk" to "হালুক", "haluka" to "হালুকা", "halak" to "হালাক",
        "ana" to "আনা", "bikheir" to "বিখাইর", "bikhair" to "বিখাইর",
        "kam" to "কাম", "thaman" to "ছামান", "hatha" to "হাযা", "hadha" to "হাযা",
        "maa" to "মা'", "barid" to "বারিদ", "ayna" to "আইনা", "tariq" to "তারীক",
        "aap" to "আপ", "kaise" to "কাইসে", "hain" to "হ্যায়ঁ", "main" to "ম্যায়ঁ",
        "theek" to "ঠিক", "hoon" to "হুঁ", "hun" to "হুঁ", "hai" to "হ্যায়",
        "kitna" to "কিতনা", "kitni" to "কিতনি", "kahan" to "কাহাঁ", "pani" to "পানি",
        "thanda" to "ঠান্ডা", "madad" to "মদদ", "chahiye" to "চাহিয়ে", "shukriya" to "শুকরিয়া"
    )

    private fun transliterateChineseSentence(
        text: String,
        pinyinHint: String?,
        useVocabLookup: Boolean
    ): String {
        val normKey = normalizeLookupKey(text)
        CHINESE_COMMON_PHRASES[normKey]?.let { return it }

        if (!pinyinHint.isNullOrBlank()) {
            val cleanedPinyin = pinyinHint
                .replace(Regex("[āáǎà]"), "a")
                .replace(Regex("[ēéěè]"), "e")
                .replace(Regex("[īíǐì]"), "i")
                .replace(Regex("[ōóǒò]"), "o")
                .replace(Regex("[ūúǔù]"), "u")
                .replace(Regex("[ǖǘǚǜü]"), "yu")
                .replace(Regex("[1-5]"), "")
            val fromHint = transliterateLatinSentence(cleanedPinyin, TranslatorLanguage.ENGLISH, useVocabLookup = false)
            if (BENGALI_CHAR.containsMatchIn(fromHint)) return fromHint
        }

        val sb = StringBuilder()
        var i = 0
        while (i < text.length) {
            if (i + 2 <= text.length) {
                val two = text.substring(i, i + 2)
                val twoPron = CHINESE_WORD_READINGS[two] ?: if (useVocabLookup) lookupVocab("chinese", two) else null
                if (twoPron != null) {
                    if (sb.isNotEmpty() && sb.last() != ' ') sb.append(' ')
                    sb.append(twoPron)
                    i += 2
                    continue
                }
            }
            val one = text[i].toString()
            val onePron = CHINESE_WORD_READINGS[one] ?: if (useVocabLookup) lookupVocab("chinese", one) else null
            when {
                onePron != null -> {
                    if (sb.isNotEmpty() && sb.last() != ' ') sb.append(' ')
                    sb.append(onePron)
                }
                text[i].isWhitespace() -> if (sb.isNotEmpty() && sb.last() != ' ') sb.append(' ')
                text[i] in "，。？！、,.?!" -> sb.append(' ')
            }
            i++
        }
        return sb.toString().trim().ifEmpty { text }
    }

    private val CHINESE_COMMON_PHRASES = mapOf(
        "你好" to "নি হাও",
        "您好" to "নিন্ হাও",
        "你好吗" to "নি হাও মা",
        "我很好" to "ওও হেন্ হাও",
        "谢谢" to "সিয়েসিয়ে",
        "不客气" to "পু খ্যোছি",
        "对不起" to "তুইবুছি",
        "没关系" to "মেই কুয়ানসি",
        "再见" to "দ্জাই চিয়ান্",
        "多少钱" to "তুওশাও ছিয়ান্",
        "太贵了" to "থাই কুই ল্য",
        "请给我水" to "ছিং কেই ওও শুই"
    )

    private val CHINESE_WORD_READINGS = mapOf(
        "你好" to "নি হাও", "谢谢" to "সিয়েসিয়ে", "再见" to "দ্জাই চিয়ান্", "请问" to "ছিং ওয়েন্",
        "对不起" to "তুইবুছি", "没关系" to "মেই কুয়ানসি", "中国" to "চোংকুও", "孟加拉" to "মংচিয়ালা",
        "多少" to "তুওশাও", "什么" to "শেন্ম্য", "哪里" to "নালি", "怎么" to "জেন্ম্য",
        "今天" to "চিন্থিয়ান্", "明天" to "মিংথিয়ান্", "昨天" to "জুওথিয়ান্", "现在" to "সিয়ান্দজাই",
        "我" to "ওও", "你" to "নি", "您" to "নিন্", "他" to "থা", "她" to "থা", "们" to "মেন্",
        "好" to "হাও", "很" to "হেন্", "是" to "শি", "不" to "পু", "没" to "মেই", "有" to "ইয়ৌ",
        "在" to "দ্জাই", "去" to "ছ্যু", "来" to "লাই", "吃" to "ছি", "喝" to "হ্য", "水" to "শুই",
        "茶" to "ছা", "饭" to "ফান্", "钱" to "ছিয়ান্", "人" to "রেন্", "大" to "তা", "小" to "সিয়াও",
        "吗" to "মা", "呢" to "ন্য", "了" to "ল্য", "的" to "দ্য", "请" to "ছিং", "看" to "খান্",
        "一" to "ই", "二" to "আর", "两" to "লিয়াং", "三" to "সান্", "四" to "স্যু", "五" to "উ",
        "六" to "লিউ", "七" to "ছি", "八" to "পা", "九" to "চিউ", "十" to "শি", "百" to "পাই"
    )

    private fun transliterateKoreanSentence(
        text: String,
        romanizationHint: String?,
        useVocabLookup: Boolean
    ): String {
        val clean = text.trim()
        if (useVocabLookup) {
            lookupVocab("korean", clean)?.let { return it }
        }
        KOREAN_COMMON_PHRASES[clean.trimEnd('.', '?', '!', '。')]?.let { return it }
        val hasHangul = clean.any { it in '\uAC00'..'\uD7A3' }
        if (!hasHangul) {
            return if (!romanizationHint.isNullOrBlank()) {
                transliterateLatinSentence(romanizationHint, TranslatorLanguage.ENGLISH, false)
            } else {
                clean
            }
        }
        val sb = StringBuilder()
        for (ch in clean) {
            when {
                ch in '\uAC00'..'\uD7A3' -> {
                    val code = ch.code - 0xAC00
                    val jong = code % 28
                    val jung = (code / 28) % 21
                    val cho = code / (28 * 21)
                    sb.append(HANGUL_CHO[cho])
                    sb.append(HANGUL_JUNG[jung])
                    sb.append(HANGUL_JONG[jong])
                }
                ch.isWhitespace() -> if (sb.isNotEmpty() && sb.last() != ' ') sb.append(' ')
                ch in ",.?!" -> Unit
                else -> sb.append(ch)
            }
        }
        return sb.toString().trim().ifEmpty { clean }
    }

    private val HANGUL_CHO = arrayOf(
        "গ", "ক্ক", "ন", "দ", "ত্ত", "র", "ম", "ব", "প্প", "স", "স্স", "", "জ", "চ্চ", "ছ", "খ", "থ", "ফ", "হ"
    )
    private val HANGUL_JUNG = arrayOf(
        "া", "্যা", "অ", "্য", "ো", "য়ো", "ু", "্যু", "উ", "ওয়া", "ওয়ে", "ওয়ে", "য়ো", "ু", "উও", "উএ", "উই", "্যু", "উ", "উই", "ি"
    )
    private val HANGUL_JONG = arrayOf(
        "", "ক", "ক্ক", "ক", "ন", "ন", "ন", "ত", "ল", "ল", "ম", "ব", "ল", "ল", "ল", "ল", "ম", "প", "প", "ত", "স্স", "ং", "ত", "ত", "ক", "ত", "প", "হ"
    )
    private val KOREAN_COMMON_PHRASES = mapOf(
        "안녕하세요" to "আন্নিয়ংহাসেয়ো",
        "감사합니다" to "কামসাহামনিদা",
        "고맙습니다" to "কোমাপসুমনিদা",
        "죄송합니다" to "চোয়েসোংহামনিদা",
        "괜찮아요" to "কোয়েনছানায়ো",
        "얼마예요" to "অলমায়েয়ো",
        "물 주세요" to "মুল জুসেয়ো",
        "안녕히 가세요" to "আন্নিয়ংহি গাসেয়ো"
    )
}
