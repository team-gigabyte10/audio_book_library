package com.gigabyte.bookstore.learning.presentation.calendar

import com.gigabyte.bookstore.learning.domain.model.SpeechLang

enum class CalendarCategory(val id: String, val titleBn: String) {
    ALL("all", "সব একসাথে"),
    DAYS("days", "সপ্তাহের ৭ দিন"),
    MONTHS("months", "১২ মাস"),
    SEASONS("seasons", "ঋতুসমূহ"),
    TIME("time", "সময় ও দিনকাল")
}

data class CalendarItem(
    val id: String,
    val category: CalendarCategory,
    /** Primary display in target script (e.g. "月曜日", "پیر", "सोमवार", "Montag", "Monday") */
    val targetWord: String,
    /** Secondary display, e.g. Kana for Kanji ("げつようび"), or native symbol */
    val secondaryDisplay: String? = null,
    /** Meaning in Bengali (e.g. "সোমবার") */
    val bnMeaning: String,
    /** Pronunciation guide in Bengali (e.g. "গেৎসুয়োওবি", "পীর", "মোন্টাগ") */
    val bnPron: String,
    /** Text for Android TTS engine */
    val ttsText: String = secondaryDisplay ?: targetWord,
    /** Contextual emoji or badge (e.g. "🗓️", "🌙", "🌸", "☀️") */
    val iconEmoji: String = "📅",
    /** Optional notes */
    val noteBn: String? = null
)

data class CalendarCategoryInfo(
    val category: CalendarCategory,
    val countLabel: String
)

data class CalendarLanguageConfig(
    val langCode: String,
    val speechLang: SpeechLang,
    val titleBn: String,
    val subtitleBn: String,
    val nativeTitle: String,
    val accentColorHex: Long,
    val categories: List<CalendarCategoryInfo>,
    val items: List<CalendarItem>
)

