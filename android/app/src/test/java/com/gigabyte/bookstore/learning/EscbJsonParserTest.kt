package com.gigabyte.bookstore.learning

import com.gigabyte.bookstore.learning.data.content.EscbContentSink
import com.gigabyte.bookstore.learning.data.content.EscbJsonParser
import com.gigabyte.bookstore.learning.data.db.ItemEntity
import com.gigabyte.bookstore.learning.data.db.LessonEntity
import com.gigabyte.bookstore.learning.data.db.PartEntity
import com.gigabyte.bookstore.learning.data.toLessonItem
import com.gigabyte.bookstore.learning.domain.model.Level
import com.gigabyte.bookstore.learning.domain.model.SpeechLang
import kotlinx.coroutines.test.runTest
import okio.Buffer
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class EscbJsonParserTest {

    // Same shape as ESCB-Latest-Version.json, trimmed to the cases that matter.
    private val json = """
        {
          "schema_version": 1,
          "course": { "id": "en", "title_bn": "বাংলা থেকে ইংরেজি", "title_target": "English", "note": "x" },
          "ladder_default": [
            { "play": "target", "speed": 0.6 }, { "play": "bn", "speed": 1.0 },
            { "play": "target", "speed": 1.2, "min_level": "B1" }, { "pause_ms": 1500 }
          ],
          "stats": { "lessons": 2, "items": 3 },
          "parts": [
            { "id": "en-p0", "order": 0, "level": "A0", "title_bn": "অক্ষর", "title_target": "Script", "lessons": [],
              "content_needed": "author new content" },
            { "id": "en-p1", "order": 1, "level": "A0", "title_bn": "প্রথম শব্দ", "title_target": "First Words",
              "lessons": [
                { "id": "en-p1-l001", "order": 1, "title_target": "Common Words 1", "title_bn": "প্রচলিত শব্দ 1",
                  "intro_bn": null, "structure": ["S + V + O"], "source_section": "derived:vocabulary",
                  "items": [
                    { "id": "en-p1-l001-001", "concept_id": "c-best", "type": "word", "level": "A0", "target": "Best",
                      "romanization": null, "bn": "সেরা", "bn_pron": null, "tokens": [{ "t": "Best", "bn": "সেরা" }],
                      "tags": { "pos": null }, "pattern_id": null,
                      "audio": { "slow": "en/p1/l001/001_s.opus", "normal": "n.opus", "bn": "b.opus" },
                      "source": "ESCB p.106", "status": "needs_review",
                      "example": { "target": "This is the best.", "bn": null } }
                  ] },
                { "id": "en-p1-l002", "order": 2, "title_target": "Lesson 2", "title_bn": null, "structure": [],
                  "items": [
                    { "id": "en-p1-l002-001", "concept_id": "c-why", "type": "dialogue_line", "level": "B2",
                      "target": "Why should I hire you?", "bn": null,
                      "tokens": [{ "t": "Why", "bn": null }, { "t": "should", "bn": null }, { "t": "I", "bn": null }, { "t": "hire", "bn": null }, { "t": "you?", "bn": null }],
                      "tags": { "sentence_type": "interrogative", "question": "wh", "wh": "why" },
                      "audio": { "slow": "a", "normal": "b", "bn": null }, "status": "needs_review",
                      "review_flags": ["no_bn_in_source"], "speaker": "Interviewer", "future_field": { "a": [1, 2] } },
                    { "id": "en-p1-l002-002", "concept_id": "c-ok", "type": "sentence", "level": "A1",
                      "target": "I am fine.", "bn": "আমি ভালো আছি।", "tokens": [],
                      "tags": { "sentence_type": "assertive", "polarity": "affirmative", "tense": "present_simple" },
                      "status": "reviewed" }
                  ] }
              ] }
          ]
        }
    """.trimIndent()

    private class RecordingSink : EscbContentSink {
        var total = -1
        val parts = mutableListOf<PartEntity>()
        val lessons = mutableListOf<LessonEntity>()
        val items = mutableListOf<ItemEntity>()
        override suspend fun onTotalLessons(total: Int) { this.total = total }
        override suspend fun onPart(part: PartEntity) { parts += part }
        override suspend fun onLesson(lesson: LessonEntity, items: List<ItemEntity>) {
            lessons += lesson
            this.items += items
        }
    }

    @Test
    fun `parses header, parts, lessons and items`() = runTest {
        val sink = RecordingSink()
        val header = EscbJsonParser().parse(Buffer().writeUtf8(json), sink)

        assertEquals(1, header.schemaVersion)
        assertEquals(listOf(SpeechLang.EN, SpeechLang.BN, SpeechLang.EN, null), header.ladder.map { it.play })
        assertEquals(Level.B1, header.ladder[2].minLevel)
        assertEquals(1500L, header.ladder[3].pauseMs)
        assertEquals(2, sink.total)

        // Each part is emitted before its lessons and again at the end (to pick up later fields).
        val p0 = sink.parts.last { it.id == "en-p0" }
        assertEquals("author new content", p0.contentNeeded)
        assertEquals(listOf("en-p1-l001", "en-p1-l002"), sink.lessons.map { it.id })
        assertEquals("S + V + O", sink.lessons[0].structure)
        assertEquals("en-p1", sink.lessons[0].partId)

        assertEquals(3, sink.items.size)
        val best = sink.items[0]
        assertEquals("en-p1-l001", best.lessonId)
        assertEquals("This is the best.", best.exampleTarget)
        assertEquals("সেরা", best.toLessonItem().tokens.single().bn)

        val why = sink.items[1]
        assertNull(why.bn)
        assertEquals("no_bn_in_source", why.reviewFlags)
        assertEquals("Interviewer", why.speaker)
        assertEquals("why", why.wh)
        assertEquals(5, why.toLessonItem().tokens.size)

        // Empty tokens fall back to splitting the target on spaces.
        val fine = sink.items[2]
        assertEquals(listOf("I", "am", "fine."), fine.toLessonItem().tokens.map { it.text })
        assertEquals(1, fine.order)
        assertEquals("reviewed", fine.status)
    }
}
