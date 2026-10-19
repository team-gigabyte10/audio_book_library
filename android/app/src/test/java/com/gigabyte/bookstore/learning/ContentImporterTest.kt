package com.gigabyte.bookstore.learning

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.gigabyte.bookstore.learning.data.LearningRepository
import com.gigabyte.bookstore.learning.data.QuizAnswer
import com.gigabyte.bookstore.learning.data.content.ContentImporter
import com.gigabyte.bookstore.learning.data.db.LearningDatabase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

// Plain Application: the real one starts TTS, Firebase-backed repositories and the audiobook DB.
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36], application = Application::class)
class ContentImporterTest {

    private lateinit var context: Context
    private lateinit var db: LearningDatabase

    private fun json(extraTitle: String = "") = """
        {
          "schema_version": 1,
          "course": { "title_bn": "কোর্স$extraTitle" },
          "ladder_default": [ { "play": "target", "speed": 0.6 }, { "pause_ms": 1500 } ],
          "stats": { "lessons": 1 },
          "parts": [
            { "id": "en-p1", "order": 1, "level": "A0", "title_bn": "প্রথম শব্দ", "lessons": [
              { "id": "en-p1-l001", "order": 1, "title_bn": "লেসন ১", "structure": [], "items": [
                { "id": "a", "concept_id": "ca", "type": "word", "level": "A0", "target": "Best", "bn": "সেরা", "status": "needs_review" },
                { "id": "b", "concept_id": "cb", "type": "word", "level": "A0", "target": "Good", "bn": "ভালো", "status": "needs_review" },
                { "id": "c", "concept_id": "cc", "type": "word", "level": "A0", "target": "Nice", "bn": "সুন্দর", "status": "needs_review" },
                { "id": "d", "concept_id": "cd", "type": "word", "level": "A0", "target": "Bad", "bn": null, "status": "needs_review" },
                { "id": "e", "concept_id": "ce", "type": "word", "level": "A0", "target": "Ugly", "bn": "কুৎসিত",
                  "status": "needs_review", "review_flags": ["check_bn_ocr"] }
              ] }
            ] }
          ]
        }
    """.trimIndent()

    private fun importer(versionCode: Int, content: String) =
        ContentImporter(context, db, versionCode) { content.byteInputStream() }

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
        db = Room.inMemoryDatabaseBuilder(context, LearningDatabase::class.java).allowMainThreadQueries().build()
    }

    @After
    fun tearDown() = db.close()

    @Test
    fun `imports once, skips unchanged content, re-imports changed content and keeps progress`() = runBlocking {
        assertTrue(importer(1, json()).ensureImported())
        assertFalse(importer(1, json()).ensureImported())

        val repo = LearningRepository(db.learningDao())
        repo.recordQuiz("en-p1-l001", listOf(QuizAnswer("ca", true, 500)))

        // App update with identical bytes: no re-import.
        assertFalse(importer(2, json()).ensureImported())
        // App update with new content: re-import, progress survives.
        assertTrue(importer(3, json(" v2")).ensureImported())
        assertEquals("কোর্স v2", db.learningDao().getMeta()?.titleBn)
        assertEquals("DONE", db.learningDao().getProgress("en-p1-l001")?.state)
    }

    @Test
    fun `quality gate hides items without Bangla or with review flags`() = runBlocking {
        importer(1, json()).ensureImported()
        val visible = db.learningDao().getVisibleItems("en-p1-l001").map { it.id }
        assertEquals(listOf("a", "b", "c"), visible)
        val lessons = db.learningDao().getLessonsWithCount("en-p1")
        assertEquals(3, lessons.single().visibleCount)
    }
}
