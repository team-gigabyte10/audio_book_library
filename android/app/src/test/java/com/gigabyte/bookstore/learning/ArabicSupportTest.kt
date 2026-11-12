package com.gigabyte.bookstore.learning

import com.gigabyte.bookstore.learning.domain.model.LadderStep
import com.gigabyte.bookstore.learning.domain.model.SpeechLang
import com.gigabyte.bookstore.learning.domain.model.targetLangForId
import com.gigabyte.bookstore.learning.domain.speech.SpeechMatch
import com.gigabyte.bookstore.learning.domain.translator.TranslatorLanguage
import com.gigabyte.bookstore.learning.presentation.alphabet.ArabicAlphabetData
import com.gigabyte.bookstore.learning.presentation.calendar.ArabicCalendarData
import com.gigabyte.bookstore.learning.presentation.calendar.CalendarCategory
import com.gigabyte.bookstore.learning.presentation.lesson.speechCheckLanguage
import com.gigabyte.bookstore.learning.presentation.numbers.ArabicNumberData
import com.gigabyte.bookstore.learning.presentation.vocab.ArabicVocabData
import com.gigabyte.bookstore.learning.presentation.vocab.VocabCategory
import com.gigabyte.bookstore.learning.presentation.vocab.VocabRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ArabicSupportTest {

    @Test
    fun `spoken arabic id prefixes resolve to SpeechLang AR and ar-SA`() {
        assertEquals(SpeechLang.AR, targetLangForId("ar-std-01-l01-001"))
        assertEquals(SpeechLang.AR, targetLangForId("ar-a2-05-l02-003"))
        assertEquals(SpeechLang.AR, targetLangForId("ar-b1-10-l01-004"))
        assertEquals(SpeechLang.AR, targetLangForId("ar-b2-12-l03-002"))
        assertEquals(SpeechLang.AR, targetLangForId("ar-sp-03-l04-008"))

        assertEquals("ar-SA", speechCheckLanguage("ar-std-01-l01-001"))
        assertEquals("ar-SA", speechCheckLanguage("qr-p1-u01-l01-001"))
        assertEquals(TranslatorLanguage.ARABIC, TranslatorLanguage.fromKey("ar_standard"))
        assertEquals(TranslatorLanguage.ARABIC, TranslatorLanguage.fromKey("ar_specialist"))
    }

    @Test
    fun `ladder step encodes and decodes ar cleanly`() {
        val step = LadderStep(play = SpeechLang.AR, speed = 0.85f)
        val decoded = LadderStep.decode(listOf(step.encode()))
        assertEquals(1, decoded.size)
        assertEquals(SpeechLang.AR, decoded.first().play)
        assertEquals(0.85f, decoded.first().speed, 0.001f)
    }

    @Test
    fun `speech match normalizes arabic harakat and alif hamza variants`() {
        val result = SpeechMatch.evaluate(
            heard = listOf("اهلا وسهلا"),
            expected = listOf("أَهْلاً وَسَهْلاً!")
        )
        assertEquals(SpeechMatch.Result.MATCH, result)
    }

    @Test
    fun `arabic alphabet, numbers, calendar and 1000-word vocab data are complete`() {
        val alpha = ArabicAlphabetData.CONFIG
        assertEquals(SpeechLang.AR, alpha.speechLang)
        assertEquals("arabic", alpha.langCode)
        val totalLetters = alpha.rows.sumOf { it.letters.size }
        assertTrue("Expected >= 35 Arabic letters/harakat, got $totalLetters", totalLetters >= 35)
        assertTrue(alpha.rows.all { it.letters.all { l -> l.ttsText.isNotBlank() && l.bnPron.isNotBlank() } })

        val numbers = ArabicNumberData.CONFIG
        assertEquals(SpeechLang.AR, numbers.speechLang)
        assertEquals(100, numbers.numbers.size)
        assertEquals("١", numbers.numbers.first().nativeNumeral)
        assertEquals("١٠٠", numbers.numbers.last().nativeNumeral)

        val cal = ArabicCalendarData.CONFIG
        assertEquals(SpeechLang.AR, cal.speechLang)
        assertEquals(7, cal.items.count { it.category == CalendarCategory.DAYS })
        assertEquals(24, cal.items.count { it.category == CalendarCategory.MONTHS })
        assertEquals(4, cal.items.count { it.category == CalendarCategory.SEASONS })

        val vocab = VocabRepository.getConfigForLanguage("arabic")
        assertEquals(ArabicVocabData.config, vocab)
        assertEquals(1000, vocab.items.size)
        assertEquals(1000, vocab.items.map { it.id }.toSet().size)
        for (cat in VocabCategory.entries.filter { it != VocabCategory.ALL }) {
            assertTrue("Missing items for $cat", vocab.items.any { it.category == cat })
        }
        assertFalse(vocab.items.any { it.singularTarget.isBlank() || it.singularBnPron.isBlank() || it.bnMeaning.isBlank() })
    }
}
