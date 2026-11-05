package com.gigabyte.bookstore.learning

import com.gigabyte.bookstore.learning.data.content.EscbContentSink
import com.gigabyte.bookstore.learning.data.content.EscbJsonParser
import com.gigabyte.bookstore.learning.data.db.ItemEntity
import com.gigabyte.bookstore.learning.data.db.LessonEntity
import com.gigabyte.bookstore.learning.data.db.PartEntity
import com.gigabyte.bookstore.learning.domain.model.LadderStep
import com.gigabyte.bookstore.learning.domain.model.SpeechLang
import com.gigabyte.bookstore.learning.domain.model.targetLangForId
import com.gigabyte.bookstore.learning.domain.speech.SpeechMatch
import com.gigabyte.bookstore.learning.presentation.lesson.speechCheckLanguage
import kotlinx.coroutines.test.runTest
import okio.Buffer
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class GermanSupportTest {

    @Test
    fun `target language resolves to DE for de prefix`() {
        assertEquals(SpeechLang.DE, targetLangForId("de-std-a1-07-l01"))
        assertEquals(SpeechLang.DE, targetLangForId("de-std-s0-01-l01-001"))
        assertEquals("de-DE", speechCheckLanguage("de-std-a1-01-l01-001"))
    }

    @Test
    fun `German ladder steps encode and decode`() {
        val ladder = listOf(
            LadderStep(SpeechLang.DE, 0.85f),
            LadderStep(SpeechLang.BN, 1.15f),
            LadderStep(SpeechLang.DE, 0.95f),
            LadderStep(pauseMs = 1200L)
        )
        assertEquals(ladder, LadderStep.decode(LadderStep.encode(ladder)))
    }

    @Test
    fun `parser maps target to German when the course target_lang is de`() = runTest {
        val json = """
            { "schema_version": 1, "course": { "id": "de", "target_lang": "de" },
              "ladder_default": [ { "play": "target", "speed": 0.85 }, { "play": "bn", "speed": 1.15 } ],
              "parts": [] }
        """.trimIndent()
        val sink = object : EscbContentSink {
            override suspend fun onPart(part: PartEntity) = Unit
            override suspend fun onLesson(lesson: LessonEntity, items: List<ItemEntity>) = Unit
        }
        val header = EscbJsonParser().parse(Buffer().writeUtf8(json), sink)
        assertEquals(listOf(SpeechLang.DE, SpeechLang.BN), header.ladder.map { it.play })
    }

    @Test
    fun `German speech match normalizes umlauts and eszett`() {
        val spoken = "Ich moechte schoene Gruesse schliessen"
        val expected = "Ich möchte schöne Grüße schließen."
        val result = SpeechMatch.evaluate(spoken = spoken, expected = expected, language = "de-DE")
        assertTrue("Expected score >= 80 but got ${result.score}", result.score >= 80)
    }
}
