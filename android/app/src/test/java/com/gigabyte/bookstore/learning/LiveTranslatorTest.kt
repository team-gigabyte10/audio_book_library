package com.gigabyte.bookstore.learning

import com.gigabyte.bookstore.learning.data.translator.LiveTranslatorRepository
import com.gigabyte.bookstore.learning.domain.model.Token
import com.gigabyte.bookstore.learning.domain.translator.RegionalDialectChoice
import com.gigabyte.bookstore.learning.domain.translator.TranslationResult
import com.gigabyte.bookstore.learning.domain.translator.TranslationSourceTier
import com.gigabyte.bookstore.learning.domain.translator.TranslatorDirection
import com.gigabyte.bookstore.learning.domain.translator.TranslatorLanguage
import com.gigabyte.bookstore.learning.presentation.translator.LiveTranslatorViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class LiveTranslatorTest {

    @Test
    fun `TranslatorLanguage resolves all 7 course prefixes and names accurately`() {
        assertEquals(TranslatorLanguage.ENGLISH, TranslatorLanguage.fromKey("english"))
        assertEquals(TranslatorLanguage.ENGLISH, TranslatorLanguage.fromKey("en-a1-01-l01"))
        assertEquals(TranslatorLanguage.JAPANESE, TranslatorLanguage.fromKey("jp-n5-01-l02"))
        assertEquals(TranslatorLanguage.URDU, TranslatorLanguage.fromKey("ur-std-a1-01"))
        assertEquals(TranslatorLanguage.HINDI, TranslatorLanguage.fromKey("hi_standard"))
        assertEquals(TranslatorLanguage.GERMAN, TranslatorLanguage.fromKey("de-b1-02"))
        assertEquals(TranslatorLanguage.ARABIC, TranslatorLanguage.fromKey("qr-p4-u07-l01"))
        assertEquals(TranslatorLanguage.ARABIC, TranslatorLanguage.fromKey("quran"))
        assertEquals(TranslatorLanguage.REGIONAL_BANGLA, TranslatorLanguage.fromKey("bd-thm-01-l01"))
        assertEquals(TranslatorLanguage.REGIONAL_BANGLA, TranslatorLanguage.fromKey("regional_bangla"))

        assertEquals(RegionalDialectChoice.SYL, RegionalDialectChoice.fromKey("syl"))
        assertEquals(RegionalDialectChoice.CTG, RegionalDialectChoice.fromKey(null))
    }

    @Test
    fun `parseAiTranslationJson extracts structured JSON even inside markdown fences`() {
        val raw = """
            ```json
            {
              "translated_text": "お元気ですか？",
              "bangla_pronunciation": "ওগেংকি দেস্ কা?",
              "romanization": "Ogenki desu ka?",
              "word_breakdown": [
                {"t": "お元気", "bn": "ভালো/সুস্থ"},
                {"t": "ですか", "bn": "কি"}
              ],
              "grammar_tip_bn": "ভদ্রভাবে কারো কুশল জানতে এই বাক্যটি ব্যবহার করা হয়।"
            }
            ```
        """.trimIndent()

        val result = LiveTranslatorRepository.parseAiTranslationJson(
            rawResponse = raw,
            sourceText = "আপনি কেমন আছেন?",
            language = TranslatorLanguage.JAPANESE,
            direction = TranslatorDirection.BN_TO_TARGET,
            dialect = RegionalDialectChoice.CTG
        )!!

        assertEquals("お元気ですか？", result.targetText)
        assertEquals("ওগেংকি দেস্ কা?", result.banglaPronunciation)
        assertEquals("Ogenki desu ka?", result.romanization)
        assertEquals(2, result.wordBreakdown.size)
        assertEquals("ভদ্রভাবে কারো কুশল জানতে এই বাক্যটি ব্যবহার করা হয়।", result.grammarTipBn)
        assertEquals(TranslationSourceTier.AI_TUTOR, result.sourceTier)
    }

    @Test
    fun `parseAiTranslationJson returns null on empty or malformed payloads`() {
        assertNull(
            LiveTranslatorRepository.parseAiTranslationJson(
                rawResponse = "not valid json",
                sourceText = "হ্যালো",
                language = TranslatorLanguage.ENGLISH,
                direction = TranslatorDirection.BN_TO_TARGET,
                dialect = RegionalDialectChoice.CTG
            )
        )
        assertNull(
            LiveTranslatorRepository.parseAiTranslationJson(
                rawResponse = """{"translated_text": ""}""",
                sourceText = "হ্যালো",
                language = TranslatorLanguage.ENGLISH,
                direction = TranslatorDirection.BN_TO_TARGET,
                dialect = RegionalDialectChoice.CTG
            )
        )
    }

    @Test
    fun `parseGoogleTranslateArrayJson joins multi-segment web translations`() {
        val raw = """[[["How are you? ","আপনি কেমন আছেন? ",null,null,1],["I am fine.","আমি ভালো আছি।",null,null,1]],null,"bn"]"""
        assertEquals("How are you? I am fine.", LiveTranslatorRepository.parseGoogleTranslateArrayJson(raw))
    }

    @Test
    fun `normalizeForMatch strips Bangla danda and punctuation uniformly`() {
        assertEquals(
            LiveTranslatorRepository.normalizeForMatch("আমি ভালো আছি।"),
            LiveTranslatorRepository.normalizeForMatch("  আমি ভালো আছি ")
        )
    }

    @Test
    fun `history encode and decode preserves complete TranslationResult list`() {
        val sample = TranslationResult(
            sourceText = "দাম কত?",
            targetText = "How much?",
            banglaPronunciation = "হাউ মাচ?",
            romanization = "haʊ mʌtʃ",
            wordBreakdown = listOf(Token("How", "কত"), Token("much?", "বেশি")),
            grammarTipBn = "কেনাকাটার সময় দাম জানতে বলুন।",
            languageKey = TranslatorLanguage.ENGLISH.key,
            direction = TranslatorDirection.BN_TO_TARGET,
            sourceTier = TranslationSourceTier.OFFLINE_CURRICULUM,
            timestampMs = 123456L
        )
        val encoded = LiveTranslatorViewModel.encodeHistory(listOf(sample))
        val decoded = LiveTranslatorViewModel.decodeHistory(encoded)
        assertEquals(listOf(sample), decoded)
    }
}
