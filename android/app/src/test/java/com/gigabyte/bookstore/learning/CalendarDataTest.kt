package com.gigabyte.bookstore.learning

import com.gigabyte.bookstore.learning.domain.model.SpeechLang
import com.gigabyte.bookstore.learning.presentation.calendar.CalendarCategory
import com.gigabyte.bookstore.learning.presentation.calendar.CalendarLanguageConfig
import com.gigabyte.bookstore.learning.presentation.calendar.EnglishCalendarData
import com.gigabyte.bookstore.learning.presentation.calendar.GermanCalendarData
import com.gigabyte.bookstore.learning.presentation.calendar.HindiCalendarData
import com.gigabyte.bookstore.learning.presentation.calendar.JapaneseCalendarData
import com.gigabyte.bookstore.learning.presentation.calendar.UrduCalendarData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class CalendarDataTest {

    @Test
    fun `Japanese calendar dataset has 7 days, 12 months, 4 seasons and valid time words`() {
        val config = JapaneseCalendarData.CONFIG
        assertEquals(SpeechLang.JA, config.speechLang)
        verifyConfig(config, expectedDays = 7, expectedMonths = 12, expectedSeasons = 4)

        val mon = config.items.first { it.id == "jp-day-1" }
        assertEquals("月曜日", mon.targetWord)
        assertEquals("げつようび", mon.secondaryDisplay)
        assertEquals("সোমবার", mon.bnMeaning)
        assertEquals("গেৎসুয়োওবি", mon.bnPron)

        val april = config.items.first { it.id == "jp-mon-4" }
        assertEquals("4月", april.targetWord)
        assertEquals("しがつ", april.secondaryDisplay)
        assertEquals("しがつ", april.ttsText)
    }

    @Test
    fun `Urdu calendar dataset has 7 days, 12 months, 5 seasons and valid time words`() {
        val config = UrduCalendarData.CONFIG
        assertEquals(SpeechLang.UR, config.speechLang)
        verifyConfig(config, expectedDays = 7, expectedMonths = 12, expectedSeasons = 5)

        val monday = config.items.first { it.id == "ur-day-1" }
        assertEquals("پیر", monday.targetWord)
        assertEquals("সোমবার", monday.bnMeaning)
        assertEquals("পীর", monday.bnPron)

        val friday = config.items.first { it.id == "ur-day-5" }
        assertEquals("جمعہ", friday.targetWord)
        assertEquals("শুক্রবার", friday.bnMeaning)
    }

    @Test
    fun `Hindi calendar dataset has 7 days, 12 months, 6 seasons and valid time words`() {
        val config = HindiCalendarData.CONFIG
        assertEquals(SpeechLang.HI, config.speechLang)
        verifyConfig(config, expectedDays = 7, expectedMonths = 12, expectedSeasons = 6)

        val monday = config.items.first { it.id == "hi-day-1" }
        assertEquals("सोमवार", monday.targetWord)
        assertEquals("সোমবার", monday.bnMeaning)

        val spring = config.items.first { it.id == "hi-sea-1" }
        assertEquals("वसंत ऋतु", spring.targetWord)
        assertEquals("বসন্তকাল", spring.bnMeaning)
    }

    @Test
    fun `German calendar dataset has 7 days, 12 months, 4 seasons and valid time words`() {
        val config = GermanCalendarData.CONFIG
        assertEquals(SpeechLang.DE, config.speechLang)
        verifyConfig(config, expectedDays = 7, expectedMonths = 12, expectedSeasons = 4)

        val monday = config.items.first { it.id == "de-day-1" }
        assertEquals("Montag", monday.targetWord)
        assertEquals("সোমবার", monday.bnMeaning)
        assertEquals("মোন্টাগ", monday.bnPron)

        val spring = config.items.first { it.id == "de-sea-1" }
        assertEquals("der Frühling", spring.targetWord)
        assertEquals("বসন্তকাল", spring.bnMeaning)
    }

    @Test
    fun `English calendar dataset has 7 days, 12 months, 6 seasons and valid time words`() {
        val config = EnglishCalendarData.CONFIG
        assertEquals(SpeechLang.EN, config.speechLang)
        verifyConfig(config, expectedDays = 7, expectedMonths = 12, expectedSeasons = 6)

        val monday = config.items.first { it.id == "en-day-1" }
        assertEquals("Monday", monday.targetWord)
        assertEquals("সোমবার", monday.bnMeaning)
        assertEquals("মানডে", monday.bnPron)
    }

    private fun verifyConfig(
        config: CalendarLanguageConfig,
        expectedDays: Int,
        expectedMonths: Int,
        expectedSeasons: Int
    ) {
        val items = config.items
        assertTrue("Total items should be >= 35", items.size >= 35)

        val days = items.filter { it.category == CalendarCategory.DAYS }
        assertEquals("Days count for ${config.langCode}", expectedDays, days.size)

        val months = items.filter { it.category == CalendarCategory.MONTHS }
        assertEquals("Months count for ${config.langCode}", expectedMonths, months.size)

        val seasons = items.filter { it.category == CalendarCategory.SEASONS }
        assertEquals("Seasons count for ${config.langCode}", expectedSeasons, seasons.size)

        val time = items.filter { it.category == CalendarCategory.TIME }
        assertTrue("Time words should be >= 10", time.size >= 10)

        for (item in items) {
            assertTrue("ID non-blank for ${item.id}", item.id.isNotBlank())
            assertTrue("Target word non-blank for ${item.id}", item.targetWord.isNotBlank())
            assertTrue("Bn meaning non-blank for ${item.id}", item.bnMeaning.isNotBlank())
            assertTrue("Bn pron non-blank for ${item.id}", item.bnPron.isNotBlank())
            assertTrue("TTS text non-blank for ${item.id}", item.ttsText.isNotBlank())
            assertTrue("Icon emoji non-blank for ${item.id}", item.iconEmoji.isNotBlank())
        }
    }
}

