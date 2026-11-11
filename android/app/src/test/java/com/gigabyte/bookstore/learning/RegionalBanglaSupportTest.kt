package com.gigabyte.bookstore.learning

import com.gigabyte.bookstore.learning.data.content.EscbContentSink
import com.gigabyte.bookstore.learning.data.content.EscbJsonParser
import com.gigabyte.bookstore.learning.data.db.ItemEntity
import com.gigabyte.bookstore.learning.data.db.LessonEntity
import com.gigabyte.bookstore.learning.data.db.PartEntity
import com.gigabyte.bookstore.learning.domain.ladder.LessonQueueBuilder
import com.gigabyte.bookstore.learning.domain.model.LadderStep
import com.gigabyte.bookstore.learning.domain.model.LearnSettings
import com.gigabyte.bookstore.learning.domain.model.LessonItem
import com.gigabyte.bookstore.learning.domain.model.Level
import com.gigabyte.bookstore.learning.domain.model.PlaybackStep
import com.gigabyte.bookstore.learning.domain.model.SpeechLang
import com.gigabyte.bookstore.learning.domain.model.targetLangForId
import com.gigabyte.bookstore.learning.presentation.lesson.speechCheckLanguage
import com.squareup.moshi.Moshi
import kotlinx.coroutines.test.runTest
import okio.Buffer
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

class RegionalBanglaSupportTest {

    @Test
    fun `target language resolves to BD for bd prefix`() {
        assertEquals(SpeechLang.BD, targetLangForId("bd-thm-01-l01-001"))
        assertEquals(SpeechLang.BD, targetLangForId("bd-thm-05-l02"))
        assertEquals(SpeechLang.BD, targetLangForId("bd-thm-08-l04"))
        assertEquals("bn-BD", speechCheckLanguage("bd-thm-01-l01-001"))
    }

    @Test
    fun `Regional Bangla ladder steps encode and decode`() {
        val ladder = listOf(
            LadderStep(SpeechLang.BD, 0.85f),
            LadderStep(SpeechLang.BN, 1.0f),
            LadderStep(SpeechLang.BD, 0.95f),
            LadderStep(pauseMs = 1500L)
        )
        assertEquals(ladder, LadderStep.decode(LadderStep.encode(ladder)))
    }

    @Test
    fun `parser maps target to BD when the course target_lang is bd`() = runTest {
        val json = """
            { "schema_version": 1, "course": { "id": "bd", "target_lang": "bd" },
              "ladder_default": [ { "play": "target", "speed": 0.85 }, { "play": "bn", "speed": 1.0 } ],
              "parts": [] }
        """.trimIndent()
        val sink = object : EscbContentSink {
            override suspend fun onPart(part: PartEntity) = Unit
            override suspend fun onLesson(lesson: LessonEntity, items: List<ItemEntity>) = Unit
        }
        val header = EscbJsonParser().parse(Buffer().writeUtf8(json), sink)
        assertEquals(listOf(SpeechLang.BD, SpeechLang.BN), header.ladder.map { it.play })
    }

    @Test
    fun `comparative regional group speaks Standard Bangla meaning once and announces each region`() {
        val item1 = LessonItem(
            id = "bd-thm-01-l01-001",
            conceptId = "c-bd-greeting-how-are-you",
            type = "sentence",
            level = Level.A1,
            target = "অন কেমন আছন?",
            bn = "আপনি কেমন আছেন?",
            speaker = "🏔️ চট্টগ্রাম (চাটগাঁইয়া)",
            tokens = emptyList()
        )
        val item2 = LessonItem(
            id = "bd-thm-01-l01-002",
            conceptId = "c-bd-greeting-how-are-you",
            type = "sentence",
            level = Level.A1,
            target = "আন্নে কেমন আছেন?",
            bn = "আপনি কেমন আছেন?",
            speaker = "🌾 নোয়াখালী (নোয়াখাইল্লা)",
            tokens = emptyList()
        )
        val ladder = listOf(
            LadderStep(SpeechLang.BD, 0.85f),
            LadderStep(SpeechLang.BN, 1.0f),
            LadderStep(SpeechLang.BD, 0.95f),
            LadderStep(pauseMs = 1500L)
        )

        val steps = LessonQueueBuilder.buildLesson(listOf(item1, item2), ladder, LearnSettings(repeatCount = 2))
        val speaks = steps.filterIsInstance<PlaybackStep.Speak>()

        // Standard Bangla spoken once at the beginning of the shared concept group
        assertEquals(1, speaks.count { it.lang == SpeechLang.BN })
        assertEquals("আপনি কেমন আছেন?", speaks.first { it.lang == SpeechLang.BN }.text)
        // Both regional sentences spoken cleanly
        assertTrue(speaks.any { it.lang == SpeechLang.BD && it.text == "অন কেমন আছন?" })
        assertTrue(speaks.any { it.lang == SpeechLang.BD && it.text == "আন্নে কেমন আছেন?" })
    }

    @Suppress("UNCHECKED_CAST")
    @Test
    fun `bundled spoken_bangla_regional_divisions asset groups all 9 regions per sentence across 8 themes`() {
        val assetFile = File("src/main/assets/spoken_bangla_regional_divisions.json")
        assertTrue("Asset json must exist", assetFile.exists())

        val moshi = Moshi.Builder().build()
        val adapter = moshi.adapter(Map::class.java)
        val data = adapter.fromJson(assetFile.readText(Charsets.UTF_8)) as? Map<String, Any>
        assertTrue("Root must not be null", data != null)

        val parts = data!!["parts"] as? List<Map<String, Any>> ?: emptyList()
        assertEquals("Must contain 8 thematic parts", 8, parts.size)

        val conceptCounts = mutableMapOf<String, Int>()
        for (part in parts) {
            val partId = part["id"] as String
            assertTrue("Expected thematic prefix bd-thm-", partId.startsWith("bd-thm-"))
            val lessons = part["lessons"] as? List<Map<String, Any>> ?: emptyList()
            for (lesson in lessons) {
                val items = lesson["items"] as? List<Map<String, Any>> ?: emptyList()
                for (item in items) {
                    val cid = item["concept_id"] as String
                    conceptCounts[cid] = (conceptCounts[cid] ?: 0) + 1
                }
            }
        }

        assertEquals("Must contain 64 shared concept sentences", 64, conceptCounts.size)
        assertTrue("Every concept sentence must cover all 9 regions", conceptCounts.values.all { it == 9 })
    }
}
