package com.gigabyte.bookstore.learning

import com.gigabyte.bookstore.learning.data.content.EscbContentSink
import com.gigabyte.bookstore.learning.data.content.EscbJsonParser
import com.gigabyte.bookstore.learning.data.db.ItemEntity
import com.gigabyte.bookstore.learning.data.db.LessonEntity
import com.gigabyte.bookstore.learning.data.db.PartEntity
import com.gigabyte.bookstore.learning.domain.model.LadderStep
import com.gigabyte.bookstore.learning.domain.model.LessonItem
import com.gigabyte.bookstore.learning.domain.model.Level
import com.gigabyte.bookstore.learning.domain.model.SpeechLang
import com.gigabyte.bookstore.learning.domain.model.Token
import com.gigabyte.bookstore.learning.domain.model.forUrduSpeaker
import com.gigabyte.bookstore.learning.domain.model.targetLangForId
import kotlinx.coroutines.test.runTest
import okio.Buffer
import org.junit.Assert.assertEquals
import org.junit.Assert.assertSame
import org.junit.Test

class UrduSupportTest {

    @Test
    fun `target language comes from the ID prefix`() {
        assertEquals(SpeechLang.UR, targetLangForId("ur-std-a1-07-l01"))
        assertEquals(SpeechLang.JA, targetLangForId("jp-std-n5-01-l01"))
        assertEquals(SpeechLang.EN, targetLangForId("en-p1-l001"))
        assertEquals(SpeechLang.EN, targetLangForId("past-p1-l001"))
    }

    @Test
    fun `Urdu ladder steps encode and decode`() {
        val ladder = listOf(LadderStep(SpeechLang.UR, 0.8f), LadderStep(SpeechLang.BN, 1.15f), LadderStep(pauseMs = 1200L))
        assertEquals(ladder, LadderStep.decode(LadderStep.encode(ladder)))
    }

    @Test
    fun `parser maps target to Urdu when the course target_lang is ur`() = runTest {
        val json = """
            { "schema_version": 1, "course": { "id": "ur", "target_lang": "ur" },
              "ladder_default": [ { "play": "target", "speed": 0.8 }, { "play": "bn", "speed": 1.15 } ],
              "parts": [] }
        """.trimIndent()
        val sink = object : EscbContentSink {
            override suspend fun onPart(part: PartEntity) = Unit
            override suspend fun onLesson(lesson: LessonEntity, items: List<ItemEntity>) = Unit
        }
        val header = EscbJsonParser().parse(Buffer().writeUtf8(json), sink)
        assertEquals(listOf(SpeechLang.UR, SpeechLang.BN), header.ladder.map { it.play })
    }

    private fun urduItem(id: String = "ur-std-a1-07-l01-005") = LessonItem(
        id = id,
        conceptId = "c",
        type = "sentence",
        level = Level.A1,
        target = "میں روز اٹھتا ہوں۔",
        bn = "আমি প্রতিদিন উঠি।",
        bnPron = "ম্যাঁয় রোজ় উঠতা হুঁ",
        tokens = listOf(Token("میں", "আমি"), Token("روز", "রোজ"), Token("اٹھتا", "উঠি (পুং)"), Token("ہوں", "হুঁ")),
        exampleTarget = "میں روز اٹھتی ہوں۔",
        exampleBn = "ম্যাঁয় রোজ় উঠতি হুঁ"
    )

    @Test
    fun `female speaker swaps in the female version and keeps glosses`() {
        val female = urduItem().forUrduSpeaker(female = true)
        assertEquals("میں روز اٹھتی ہوں۔", female.target)
        assertEquals("ম্যাঁয় রোজ় উঠতি হুঁ", female.bnPron)
        assertEquals(listOf("میں", "روز", "اٹھتی", "ہوں"), female.tokens.map { it.text })
        assertEquals("উঠি (স্ত্রী)", female.tokens[2].bn)
        // The male version stays available as the other form.
        assertEquals("میں روز اٹھتا ہوں۔", female.exampleTarget)
    }

    @Test
    fun `male speaker and non-Urdu items are unchanged`() {
        val item = urduItem()
        assertSame(item, item.forUrduSpeaker(female = false))
        val english = urduItem(id = "en-p1-l001-001")
        assertSame(english, english.forUrduSpeaker(female = true))
    }
}
