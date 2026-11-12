package com.gigabyte.bookstore.learning

import com.gigabyte.bookstore.learning.data.content.EscbJsonParser
import com.gigabyte.bookstore.learning.domain.model.LadderStep
import com.gigabyte.bookstore.learning.domain.model.SpeechLang
import com.gigabyte.bookstore.learning.domain.model.targetLangForId
import com.gigabyte.bookstore.learning.domain.translator.BanglaPronunciationEngine
import com.gigabyte.bookstore.learning.domain.translator.TranslatorLanguage
import com.gigabyte.bookstore.learning.presentation.alphabet.KoreanAlphabetData
import com.gigabyte.bookstore.learning.presentation.calendar.KoreanCalendarData
import com.gigabyte.bookstore.learning.presentation.lesson.speechCheckLanguage
import com.gigabyte.bookstore.learning.presentation.numbers.KoreanNumberData
import com.gigabyte.bookstore.learning.presentation.vocab.KoreanVocabData
import com.gigabyte.bookstore.learning.presentation.vocab.VocabCategory
import com.gigabyte.bookstore.learning.presentation.vocab.VocabRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class KoreanSupportTest {

    @Test
    fun `ko prefix maps to SpeechLang KO and ko-KR speech check`() {
        assertEquals(SpeechLang.KO, targetLangForId("ko-std-01-l01-001"))
        assertEquals(SpeechLang.KO, targetLangForId("ko-a2-05-l02-004"))
        assertEquals(SpeechLang.KO, targetLangForId("ko-b1-10-l01-008"))
        assertEquals(SpeechLang.KO, targetLangForId("ko-b2-12-l03-002"))
        assertEquals(SpeechLang.KO, targetLangForId("ko-sp-16-l04-008"))
        assertEquals("ko-KR", speechCheckLanguage("ko-std-01-l01-001"))
    }

    @Test
    fun `ladder step encode decode supports KO`() {
        val steps = listOf(
            LadderStep(SpeechLang.KO, 0.80f),
            LadderStep(SpeechLang.BN, 1.1f),
            LadderStep(SpeechLang.KO, 1.0f),
            LadderStep(pauseMs = 1200L)
        )
        val encoded = LadderStep.encode(steps)
        assertEquals("ko:0.8;bn:1.1;ko:1.0;pause:1200", encoded)
        assertEquals(steps, LadderStep.decode(encoded))
    }

    @Test
    fun `korean study tools and 1000 word vocab vault are complete`() {
        val alpha = KoreanAlphabetData.CONFIG
        assertEquals(SpeechLang.KO, alpha.speechLang)
        assertEquals(47, alpha.rows.sumOf { it.letters.size })

        val numbers = KoreanNumberData.CONFIG
        assertEquals(SpeechLang.KO, numbers.speechLang)
        assertEquals(100, numbers.numbers.size)

        val cal = KoreanCalendarData.CONFIG
        assertEquals(SpeechLang.KO, cal.speechLang)
        assertEquals(31, cal.items.size)

        val vocab = VocabRepository.getConfigForLanguage("ko")
        assertEquals(KoreanVocabData.config, vocab)
        assertEquals(SpeechLang.KO, vocab.speechLang)
        assertEquals(1000, vocab.items.size)
        val nonAllCategories = VocabCategory.entries.filter { it != VocabCategory.ALL }
        nonAllCategories.forEach { cat ->
            assertTrue("Category $cat has items", vocab.items.any { it.category == cat })
        }
        vocab.items.forEach { item ->
            assertFalse("Blank bnPron in ${item.id}", item.singularBnPron.isBlank())
            assertFalse("Blank target in ${item.id}", item.singularTarget.isBlank())
        }
    }

    @Test
    fun `translator language and hangul pronunciation bridge work for korean`() {
        assertEquals(TranslatorLanguage.KOREAN, TranslatorLanguage.fromKey("korean"))
        assertEquals(TranslatorLanguage.KOREAN, TranslatorLanguage.fromKey("ko"))
        assertEquals("ko-KR", TranslatorLanguage.KOREAN.sttLocaleTag)

        val helloPron = BanglaPronunciationEngine.generate("안녕하세요", TranslatorLanguage.KOREAN)
        assertNotNull(helloPron)
        assertTrue(helloPron!!.contains("আন্নিয়ং"))

        val dynamicPron = BanglaPronunciationEngine.generate("한국어", TranslatorLanguage.KOREAN, useVocabLookup = false)
        assertNotNull(dynamicPron)
        assertTrue(dynamicPron!!.isNotBlank())
    }

    @Test
    fun `escb json parser parses ko target_lang`() {
        val json = """
            {
              "schema_version": 1,
              "course": {
                "id": "ko-standard-a1",
                "target_lang": "ko",
                "base_lang": "bn",
                "title_bn": "কোরিয়ান স্পোকেন: লেভেল A1",
                "title_target": "표준 한국어 A1"
              },
              "ladder_default": [
                { "play": "ko", "speed": 0.80 },
                { "play": "bn", "speed": 1.1 },
                { "play": "ko", "speed": 1.0 }
              ],
              "parts": []
            }
        """.trimIndent()
        val header = EscbJsonParser().parseHeader(json)
        assertEquals("ko-standard-a1", header.courseId)
        assertEquals(SpeechLang.KO, header.targetLang)
        assertEquals(listOf(SpeechLang.KO, SpeechLang.BN, SpeechLang.KO), header.ladder.map { it.play })
    }
}

