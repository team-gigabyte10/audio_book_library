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
import com.gigabyte.bookstore.learning.domain.translator.BanglaPronunciationEngine
import com.gigabyte.bookstore.learning.domain.translator.TranslatorLanguage
import com.gigabyte.bookstore.learning.presentation.alphabet.PinyinAlphabetData
import com.gigabyte.bookstore.learning.presentation.calendar.CalendarCategory
import com.gigabyte.bookstore.learning.presentation.calendar.ChineseCalendarData
import com.gigabyte.bookstore.learning.presentation.lesson.speechCheckLanguage
import com.gigabyte.bookstore.learning.presentation.numbers.ChineseNumberData
import com.gigabyte.bookstore.learning.presentation.vocab.ChineseVocabData
import com.gigabyte.bookstore.learning.presentation.vocab.VocabCategory
import com.gigabyte.bookstore.learning.presentation.vocab.VocabRepository
import kotlinx.coroutines.test.runTest
import okio.Buffer
import okio.buffer
import okio.source
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

class ChineseSupportTest {

    @Test
    fun `targetLangForId and speechCheckLanguage resolve zh prefix to Mandarin`() {
        assertEquals(SpeechLang.ZH, targetLangForId("zh-hsk1-01-l01-001"))
        assertEquals(SpeechLang.ZH, targetLangForId("zh-hsk2-05-l03-010"))
        assertEquals("zh-CN", speechCheckLanguage("zh-hsk1-01-l01-001"))
    }

    @Test
    fun `Chinese ladder steps encode and decode cleanly`() {
        val ladder = listOf(
            LadderStep(SpeechLang.ZH, 0.72f),
            LadderStep(SpeechLang.BN, 1.0f),
            LadderStep(SpeechLang.ZH, 0.90f),
            LadderStep(pauseMs = 1500L)
        )
        assertEquals(ladder, LadderStep.decode(LadderStep.encode(ladder)))
    }

    @Test
    fun `EscbJsonParser maps target_lang zh and explicit zh play step`() = runTest {
        val json = """
            {
              "schema_version": 1,
              "course": { "id": "zh", "target_lang": "zh" },
              "ladder_default": [
                { "play": "target", "speed": 0.75 },
                { "play": "bn", "speed": 1.0 },
                { "play": "zh", "speed": 0.95 }
              ],
              "parts": []
            }
        """.trimIndent()
        val sink = object : EscbContentSink {
            override suspend fun onPart(part: PartEntity) = Unit
            override suspend fun onLesson(lesson: LessonEntity, items: List<ItemEntity>) = Unit
        }
        val header = EscbJsonParser().parse(Buffer().writeUtf8(json), sink)
        assertEquals(listOf(SpeechLang.ZH, SpeechLang.BN, SpeechLang.ZH), header.ladder.map { it.play })
    }

    @Test
    fun `SpeechMatch strips Chinese punctuation and evaluates Mandarin correctly`() {
        val result = SpeechMatch.evaluate(
            spoken = listOf("你好，请问洗手间在哪里？"),
            expectedTargets = listOf("你好；请问洗手间在哪里！")
        )
        assertEquals(SpeechMatch.Result.MATCH, result)

        val mismatch = SpeechMatch.evaluate(
            spoken = listOf("谢谢你"),
            expectedTargets = listOf("对不起")
        )
        assertEquals(SpeechMatch.Result.MISS, mismatch)
    }

    @Test
    fun `TranslatorLanguage and BanglaPronunciationEngine support Mandarin Chinese`() {
        assertEquals(TranslatorLanguage.CHINESE, TranslatorLanguage.fromKey("zh"))
        assertEquals(TranslatorLanguage.CHINESE, TranslatorLanguage.fromKey("chinese"))
        assertEquals(TranslatorLanguage.CHINESE, TranslatorLanguage.fromKey("zh-hsk1-01"))
        assertEquals(TranslatorLanguage.CHINESE, TranslatorLanguage.fromKey("mandarin"))

        val niHao = BanglaPronunciationEngine.generate("你好", TranslatorLanguage.CHINESE)
        val xieXie = BanglaPronunciationEngine.generate("谢谢", TranslatorLanguage.CHINESE)
        val vocabWater = BanglaPronunciationEngine.generate("水", TranslatorLanguage.CHINESE)
        assertNotNull(niHao)
        assertNotNull(xieXie)
        assertEquals("শুয়েই", vocabWater)
        assertTrue(niHao!!.isNotBlank())
        assertTrue(xieXie!!.isNotBlank())
    }

    @Test
    fun `Pinyin alphabet, Chinese numbers, and Chinese calendar charts are complete`() {
        assertEquals(SpeechLang.ZH, PinyinAlphabetData.CONFIG.speechLang)
        assertTrue(PinyinAlphabetData.CONFIG.rows.any { it.categoryId == "tones" })
        assertTrue(PinyinAlphabetData.CONFIG.rows.any { it.categoryId == "initials" })
        assertTrue(PinyinAlphabetData.CONFIG.rows.any { it.categoryId == "finals" })

        assertEquals(SpeechLang.ZH, ChineseNumberData.CONFIG.speechLang)
        assertEquals(100, ChineseNumberData.CONFIG.numbers.size)
        assertEquals("1", ChineseNumberData.CONFIG.numbers.first().digit)
        assertEquals("一百", ChineseNumberData.CONFIG.numbers.last().wordTarget)

        assertEquals(SpeechLang.ZH, ChineseCalendarData.CONFIG.speechLang)
        assertEquals(7, ChineseCalendarData.CONFIG.items.count { it.category == CalendarCategory.DAYS })
        assertEquals(12, ChineseCalendarData.CONFIG.items.count { it.category == CalendarCategory.MONTHS })
        assertEquals(4, ChineseCalendarData.CONFIG.items.count { it.category == CalendarCategory.SEASONS })
        assertTrue(ChineseCalendarData.CONFIG.items.any { it.category == CalendarCategory.TIME })
    }

    @Test
    fun `ChineseVocabData covers all 20 categories with 1000 pure-script Bangla pronunciations`() {
        val repoConfigZh = VocabRepository.getConfigForLanguage("zh")
        val repoConfigName = VocabRepository.getConfigForLanguage("chinese")
        assertEquals(ChineseVocabData.config, repoConfigZh)
        assertEquals(ChineseVocabData.config, repoConfigName)
        assertEquals(SpeechLang.ZH, repoConfigZh.speechLang)
        assertEquals(1000, repoConfigZh.items.size)

        val expectedCategories = VocabCategory.entries.filter { it != VocabCategory.ALL }.toSet()
        val actualCategories = repoConfigZh.items.map { it.category }.toSet()
        assertEquals(expectedCategories, actualCategories)

        val uniqueIds = repoConfigZh.items.map { it.id }.toSet()
        assertEquals(1000, uniqueIds.size)

        // Ensure every singularBnPron conforms to BnPronScriptPurityTest character ranges
        repoConfigZh.items.forEach { item ->
            assertFalse("Missing pinyin for ${item.id}", item.singularSecondary.isNullOrBlank())
            assertTrue("Missing Bangla meaning for ${item.id}", item.bnMeaning.isNotBlank())
            for (ch in item.singularBnPron) {
                val cp = ch.code
                val ok = (cp in 0x0980..0x09FF) || (cp in 0x0020..0x007E) || cp == 0x09F7 || ch == '·'
                assertTrue("Disallowed char '$ch' (${cp.toString(16)}) in ${item.id}: ${item.singularBnPron}", ok)
            }
        }
    }

    @Test
    fun `bundled spoken_chinese_standard_hsk1 asset parses cleanly via EscbJsonParser`() = runTest {
        val assetFile = File("src/main/assets/spoken_chinese_standard_hsk1.json")
        assertTrue("Chinese HSK1 asset must exist at ${assetFile.path}", assetFile.exists())

        val seenParts = mutableMapOf<String, PartEntity>()
        val seenLessons = mutableListOf<LessonEntity>()
        val seenItems = mutableListOf<ItemEntity>()

        val sink = object : EscbContentSink {
            override suspend fun onPart(part: PartEntity) {
                seenParts[part.id] = part
            }

            override suspend fun onLesson(lesson: LessonEntity, items: List<ItemEntity>) {
                seenLessons += lesson
                seenItems += items
            }
        }

        val header = assetFile.source().buffer().use { src ->
            EscbJsonParser().parse(src, sink)
        }

        assertEquals(SpeechLang.ZH, header.targetLang)
        assertEquals(16, seenParts.size)
        assertEquals(64, seenLessons.size)
        assertEquals(512, seenItems.size)
        assertTrue(seenParts.keys.all { it.startsWith("zh-hsk1-") })
        assertEquals("A0", seenParts["zh-hsk1-01"]?.level)
        assertEquals("A0", seenParts["zh-hsk1-02"]?.level)
        assertEquals("A1", seenParts["zh-hsk1-03"]?.level)
        assertTrue(seenItems.all { it.target.isNotBlank() && !it.bn.isNullOrBlank() && !it.bnPron.isNullOrBlank() })
    }
}

