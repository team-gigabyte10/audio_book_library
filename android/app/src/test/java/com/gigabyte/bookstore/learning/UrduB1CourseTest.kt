package com.gigabyte.bookstore.learning

import com.gigabyte.bookstore.learning.data.content.EscbContentSink
import com.gigabyte.bookstore.learning.data.content.EscbJsonParser
import com.gigabyte.bookstore.learning.data.db.ItemEntity
import com.gigabyte.bookstore.learning.data.db.LessonEntity
import com.gigabyte.bookstore.learning.data.db.PartEntity
import com.squareup.moshi.Moshi
import kotlinx.coroutines.runBlocking
import okio.buffer
import okio.source
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

class UrduB1CourseTest {

    @Suppress("UNCHECKED_CAST")
    @Test
    fun `Urdu B1 course asset exists and contains all 16 parts with valid items`() {
        val assetFile = File("src/main/assets/spoken_urdu_standard_b1.json")
        assertTrue("spoken_urdu_standard_b1.json must exist in assets", assetFile.exists())

        val jsonStr = assetFile.readText(Charsets.UTF_8)
        val moshi = Moshi.Builder().build()
        val adapter = moshi.adapter(Map::class.java)
        val root = adapter.fromJson(jsonStr) as Map<String, Any>

        assertEquals("Schema version must be 1", 1.0, (root["schema_version"] as Number).toDouble(), 0.001)
        val course = root["course"] as Map<String, Any>
        assertEquals("ur-standard-b1", course["id"])
        assertEquals("ur", course["target_lang"])
        assertEquals("bn", course["base_lang"])

        val parts = root["parts"] as List<Map<String, Any>>
        assertEquals("Urdu B1 course must contain exactly 16 parts", 16, parts.size)

        for ((i, part) in parts.withIndex()) {
            val expectedPartId = "ur-b1-%02d".format(i + 1)
            assertEquals("Part ID match", expectedPartId, part["id"])
            assertEquals("Level must be B1", "B1", part["level"])
            assertTrue("Part title_bn non-empty", (part["title_bn"] as String).isNotBlank())
            assertTrue("Part title_target non-empty", (part["title_target"] as String).isNotBlank())

            val lessons = part["lessons"] as List<Map<String, Any>>
            assertTrue("Lessons in part must not be empty", lessons.isNotEmpty())

            for (lesson in lessons) {
                assertTrue("Lesson title_bn non-empty", (lesson["title_bn"] as String).isNotBlank())
                assertTrue("Lesson title_target non-empty", (lesson["title_target"] as String).isNotBlank())

                val items = lesson["items"] as List<Map<String, Any>>
                assertTrue("Items in lesson must not be empty", items.isNotEmpty())

                for (item in items) {
                    assertTrue("item target non-empty", (item["target"] as String).isNotBlank())
                    assertTrue("item bn non-empty", (item["bn"] as String).isNotBlank())
                    assertTrue("item bn_pron non-empty", (item["bn_pron"] as String).isNotBlank())
                    val tokens = item["tokens"] as List<Any>
                    assertTrue("tokens non-empty", tokens.isNotEmpty())
                }
            }
        }
    }

    @Test
    fun `EscbJsonParser successfully streams Urdu B1 course without exceptions`() = runBlocking {
        val assetFile = File("src/main/assets/spoken_urdu_standard_b1.json")
        assertTrue(assetFile.exists())

        var partsCount = 0
        var lessonsCount = 0
        var itemsCount = 0

        val sink = object : EscbContentSink {
            override suspend fun onPart(part: PartEntity) {
                partsCount++
            }
            override suspend fun onLesson(lesson: LessonEntity, items: List<ItemEntity>) {
                lessonsCount++
                itemsCount += items.size
            }
        }

        val parser = EscbJsonParser()
        assetFile.source().buffer().use {
            parser.parse(it, sink)
        }

        assertEquals("Parsed parts count must be 16", 16, partsCount)
        assertEquals("Parsed lessons count must be 64", 64, lessonsCount)
        assertEquals("Parsed items count must be 512", 512, itemsCount)
    }
}

