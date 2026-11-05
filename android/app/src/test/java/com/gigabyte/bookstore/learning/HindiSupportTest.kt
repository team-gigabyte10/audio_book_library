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
import com.gigabyte.bookstore.learning.presentation.lesson.speechCheckLanguage
import kotlinx.coroutines.test.runTest
import okio.Buffer
import org.junit.Assert.assertEquals
import org.junit.Assert.assertSame
import org.junit.Test

class HindiSupportTest {

    @Test
    fun `target language resolves to HI for hi prefix`() {
        assertEquals(SpeechLang.HI, targetLangForId("hi-std-a1-07-l01"))
        assertEquals(SpeechLang.HI, targetLangForId("hi-std-s0-01-l01-001"))
        assertEquals("hi-IN", speechCheckLanguage("hi-std-a1-01-l01-001"))
    }

    @Test
    fun `Hindi ladder steps encode and decode`() {
        val ladder = listOf(LadderStep(SpeechLang.HI, 0.8f), LadderStep(SpeechLang.BN, 1.15f), LadderStep(pauseMs = 1200L))
        assertEquals(ladder, LadderStep.decode(LadderStep.encode(ladder)))
    }

    @Test
    fun `parser maps target to Hindi when the course target_lang is hi`() = runTest {
        val json = """
            { "schema_version": 1, "course": { "id": "hi", "target_lang": "hi" },
              "ladder_default": [ { "play": "target", "speed": 0.8 }, { "play": "bn", "speed": 1.15 } ],
              "parts": [] }
        """.trimIndent()
        val sink = object : EscbContentSink {
            override suspend fun onPart(part: PartEntity) = Unit
            override suspend fun onLesson(lesson: LessonEntity, items: List<ItemEntity>) = Unit
        }
        val header = EscbJsonParser().parse(Buffer().writeUtf8(json), sink)
        assertEquals(listOf(SpeechLang.HI, SpeechLang.BN), header.ladder.map { it.play })
    }

    private fun hindiItem(id: String = "hi-std-a1-07-l01-005") = LessonItem(
        id = id,
        conceptId = "c",
        type = "sentence",
        level = Level.A1,
        target = "मैं रोज़ उठता हूँ।",
        bn = "আমি প্রতিদিন উঠি।",
        bnPron = "ম্যাঁয় রোজ় উঠতা হুঁ",
        tokens = listOf(Token("मैं", "আমি"), Token("रोज़", "প্রতিদিন"), Token("उठता", "উঠি (পুং)"), Token("हूँ", "হুঁ")),
        exampleTarget = "मैं रोज़ उठती हूँ।",
        exampleBn = "ম্যাঁয় রোজ় উঠতী হুঁ"
    )

    @Test
    fun `female speaker swaps in the female Hindi version and keeps glosses`() {
        val female = hindiItem().forUrduSpeaker(female = true)
        assertEquals("मैं रोज़ उठती हूँ।", female.target)
        assertEquals("ম্যাঁয় রোজ় উঠতী হুঁ", female.bnPron)
        assertEquals(listOf("मैं", "रोज़", "उठती", "हूँ"), female.tokens.map { it.text })
        assertEquals("উঠি (স্ত্রী)", female.tokens[2].bn)
        assertEquals("मैं रोज़ उठता हूँ।", female.exampleTarget)
    }

    @Test
    fun `male speaker leaves Hindi item unchanged`() {
        val item = hindiItem()
        assertSame(item, item.forUrduSpeaker(female = false))
    }
}

