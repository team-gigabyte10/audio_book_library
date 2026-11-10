package com.gigabyte.bookstore.learning

import com.gigabyte.bookstore.learning.data.content.EscbContentSink
import com.gigabyte.bookstore.learning.data.content.EscbJsonParser
import com.gigabyte.bookstore.learning.data.db.ItemEntity
import com.gigabyte.bookstore.learning.data.db.LessonEntity
import com.gigabyte.bookstore.learning.data.db.PartEntity
import com.gigabyte.bookstore.learning.domain.model.LadderStep
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
        assertEquals(SpeechLang.BD, targetLangForId("bd-ctg-01-l01-001"))
        assertEquals(SpeechLang.BD, targetLangForId("bd-syl-01-l02"))
        assertEquals(SpeechLang.BD, targetLangForId("bd-dhk-01-l03"))
        assertEquals("bn-BD", speechCheckLanguage("bd-ctg-01-l01-001"))
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

    @Suppress("UNCHECKED_CAST")
    @Test
    fun `bundled spoken_bangla_regional_divisions asset contains all 8 divisions`() {
        val assetFile = File("src/main/assets/spoken_bangla_regional_divisions.json")
        assertTrue("Asset json must exist", assetFile.exists())

        val moshi = Moshi.Builder().build()
        val adapter = moshi.adapter(Map::class.java)
        val data = adapter.fromJson(assetFile.readText(Charsets.UTF_8)) as? Map<String, Any>
        assertTrue("Root must not be null", data != null)

        val parts = data!!["parts"] as? List<Map<String, Any>> ?: emptyList()
        assertTrue("Must contain at least 8 division units", parts.size >= 8)

        val partIds = parts.map { it["id"] as String }
        assertTrue("Must contain Chattogram", partIds.any { it.startsWith("bd-ctg-") })
        assertTrue("Must contain Sylhet", partIds.any { it.startsWith("bd-syl-") })
        assertTrue("Must contain Dhaka", partIds.any { it.startsWith("bd-dhk-") })
        assertTrue("Must contain Barishal", partIds.any { it.startsWith("bd-bar-") })
        assertTrue("Must contain Rajshahi", partIds.any { it.startsWith("bd-raj-") })
        assertTrue("Must contain Rangpur", partIds.any { it.startsWith("bd-rng-") })
        assertTrue("Must contain Khulna", partIds.any { it.startsWith("bd-khl-") })
        assertTrue("Must contain Mymensingh", partIds.any { it.startsWith("bd-mym-") })
    }
}

