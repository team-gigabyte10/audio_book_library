package com.gigabyte.bookstore.learning

import com.gigabyte.bookstore.learning.data.content.EscbContentSink
import com.gigabyte.bookstore.learning.data.content.EscbJsonParser
import com.gigabyte.bookstore.learning.data.db.ItemEntity
import com.gigabyte.bookstore.learning.data.db.LessonEntity
import com.gigabyte.bookstore.learning.data.db.PartEntity
import com.gigabyte.bookstore.learning.domain.model.LadderStep
import com.gigabyte.bookstore.learning.domain.model.SpeechLang
import com.gigabyte.bookstore.learning.domain.model.targetLangForId
import com.gigabyte.bookstore.learning.presentation.lesson.isQuranItem
import com.gigabyte.bookstore.learning.presentation.lesson.speechCheckLanguage
import com.squareup.moshi.Moshi
import kotlinx.coroutines.test.runTest
import okio.Buffer
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

class QuranSupportTest {

    @Test
    fun `target language resolves to AR for qr prefix`() {
        assertEquals(SpeechLang.AR, targetLangForId("qr-p1-u01-l01-001"))
        assertEquals(SpeechLang.AR, targetLangForId("qr-p2-u03-l02"))
        assertEquals(SpeechLang.AR, targetLangForId("qr-p4-u08-l04"))
        assertEquals("ar-SA", speechCheckLanguage("qr-p1-u01-l01-001"))
        assertTrue(isQuranItem("qr-p1-u01-l01-001"))
    }

    @Test
    fun `Quran Arabic ladder steps encode and decode`() {
        val ladder = listOf(
            LadderStep(SpeechLang.AR, 0.75f),
            LadderStep(SpeechLang.BN, 1.0f),
            LadderStep(SpeechLang.AR, 0.90f),
            LadderStep(pauseMs = 1800L)
        )
        assertEquals(ladder, LadderStep.decode(LadderStep.encode(ladder)))
    }

    @Test
    fun `parser maps target to AR when the course target_lang is ar`() = runTest {
        val json = """
            { "schema_version": 1, "course": { "id": "qr", "target_lang": "ar" },
              "ladder_default": [ { "play": "target", "speed": 0.75 }, { "play": "bn", "speed": 1.0 } ],
              "parts": [] }
        """.trimIndent()
        val sink = object : EscbContentSink {
            override suspend fun onPart(part: PartEntity) = Unit
            override suspend fun onLesson(lesson: LessonEntity, items: List<ItemEntity>) = Unit
        }
        val header = EscbJsonParser().parse(Buffer().writeUtf8(json), sink)
        assertEquals(listOf(SpeechLang.AR, SpeechLang.BN), header.ladder.map { it.play })
    }

    @Suppress("UNCHECKED_CAST")
    @Test
    fun `bundled quran_learning_noorani_complete asset contains all 8 parts`() {
        val assetFile = File("src/main/assets/quran_learning_noorani_complete.json")
        assertTrue("Asset json must exist", assetFile.exists())

        val moshi = Moshi.Builder().build()
        val adapter = moshi.adapter(Map::class.java)
        val data = adapter.fromJson(assetFile.readText(Charsets.UTF_8)) as? Map<String, Any>
        assertTrue("Root must not be null", data != null)

        val parts = data!!["parts"] as? List<Map<String, Any>> ?: emptyList()
        assertEquals("Must contain 8 parts", 8, parts.size)

        val partIds = parts.map { it["id"] as String }
        assertTrue("Part 1 must exist", partIds.contains("qr-p1-u01"))
        assertTrue("Part 2 must exist", partIds.contains("qr-p1-u02"))
        assertTrue("Part 3 must exist", partIds.contains("qr-p2-u03"))
        assertTrue("Part 4 must exist", partIds.contains("qr-p2-u04"))
        assertTrue("Part 5 must exist", partIds.contains("qr-p3-u05"))
        assertTrue("Part 6 must exist", partIds.contains("qr-p3-u06"))
        assertTrue("Part 7 must exist", partIds.contains("qr-p4-u07"))
        assertTrue("Part 8 must exist", partIds.contains("qr-p4-u08"))
    }
}
