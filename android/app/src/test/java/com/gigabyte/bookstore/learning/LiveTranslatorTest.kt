package com.gigabyte.bookstore.learning

import com.gigabyte.bookstore.learning.data.translator.LiveTranslatorRepository
import com.gigabyte.bookstore.learning.domain.model.Token
import com.gigabyte.bookstore.learning.domain.translator.BanglaPronunciationEngine
import com.gigabyte.bookstore.learning.domain.translator.RegionalDialectChoice
import com.gigabyte.bookstore.learning.domain.translator.TranslationResult
import com.gigabyte.bookstore.learning.domain.translator.TranslationSourceTier
import com.gigabyte.bookstore.learning.domain.translator.TranslatorDirection
import com.gigabyte.bookstore.learning.domain.translator.TranslatorLanguage
import com.gigabyte.bookstore.learning.presentation.translator.LiveTranslatorViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34], manifest = Config.NONE)
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

    @Test
    fun `parseGoogleTranslatePayload extracts translation and dt=rm romanization safely`() {
        val raw = """[[["お元気ですか？","আপনি কেমন আছেন?",null,null,1],[null,null,"Ogenki desu ka?","Apni kemon achen?"]],null,"bn"]"""
        val payload = LiveTranslatorRepository.parseGoogleTranslatePayload(raw)!!
        assertEquals("お元気ですか？", payload.translatedText)
        assertEquals("Ogenki desu ka?", payload.targetRomanization)
        assertEquals("Apni kemon achen?", payload.sourceRomanization)
    }

    @Test
    fun `BanglaPronunciationEngine generates Bengali script pronunciation across all 7 languages`() {
        val enPron = BanglaPronunciationEngine.generate("How are you?", TranslatorLanguage.ENGLISH)!!
        assertTrue("Expected Bengali script for English, got: $enPron", enPron.contains("হাউ"))

        val hiPron = BanglaPronunciationEngine.generate("नमस्ते", TranslatorLanguage.HINDI)!!
        assertEquals("নমস্তে", hiPron)

        val jaKanaPron = BanglaPronunciationEngine.generate("ありがとう", TranslatorLanguage.JAPANESE)!!
        assertTrue("Expected Bengali script for Japanese kana, got: $jaKanaPron", jaKanaPron.any { it in '\u0980'..'\u09FF' })

        val jaKanjiPron = BanglaPronunciationEngine.generate(
            targetText = "お元気ですか？",
            language = TranslatorLanguage.JAPANESE,
            romanizationHint = "Ogenki desu ka?"
        )!!
        assertTrue("Expected Bengali script for Japanese kanji+romaji, got: $jaKanjiPron", jaKanjiPron.any { it in '\u0980'..'\u09FF' })

        val dePron = BanglaPronunciationEngine.generate("Guten Morgen", TranslatorLanguage.GERMAN)!!
        assertEquals("গুটেন মর্গেন", dePron)

        val arPron = BanglaPronunciationEngine.generate(
            targetText = "مرحبا",
            language = TranslatorLanguage.ARABIC,
            romanizationHint = "Marhaban"
        )!!
        assertEquals("মারহাবান", arPron)

        val urPron = BanglaPronunciationEngine.generate(
            targetText = "آپ کیسے ہیں",
            language = TranslatorLanguage.URDU,
            romanizationHint = "Aap kaise hain"
        )!!
        assertTrue("Expected Bengali script for Urdu, got: $urPron", urPron.any { it in '\u0980'..'\u09FF' })

        val bdPron = BanglaPronunciationEngine.generate("কেমন আছ?", TranslatorLanguage.REGIONAL_BANGLA)!!
        assertEquals("কেমন আছ?", bdPron)
    }

    @Test
    fun `ensureBanglaPronunciation guarantees pronunciation and token readings when missing`() {
        val webResult = TranslationResult(
            sourceText = "দাম কত?",
            targetText = "How much is this?",
            banglaPronunciation = null,
            wordBreakdown = emptyList(),
            languageKey = TranslatorLanguage.ENGLISH.key,
            direction = TranslatorDirection.BN_TO_TARGET,
            sourceTier = TranslationSourceTier.WEB_FALLBACK
        )
        val enriched = LiveTranslatorRepository.ensureBanglaPronunciation(webResult)
        assertNotNull(enriched.banglaPronunciation)
        assertFalse(enriched.banglaPronunciation.isNullOrBlank())
        assertTrue(enriched.wordBreakdown.isNotEmpty())
        assertTrue(enriched.wordBreakdown.all { !it.bnPron.isNullOrBlank() })

        val reverseResult = TranslationResult(
            sourceText = "Guten Morgen",
            targetText = "শুভ সকাল",
            banglaPronunciation = null,
            languageKey = TranslatorLanguage.GERMAN.key,
            direction = TranslatorDirection.TARGET_TO_BN,
            sourceTier = TranslationSourceTier.WEB_FALLBACK
        )
        val enrichedReverse = LiveTranslatorRepository.ensureBanglaPronunciation(reverseResult)
        assertEquals("গুটেন মর্গেন", enrichedReverse.banglaPronunciation)
    }
}

