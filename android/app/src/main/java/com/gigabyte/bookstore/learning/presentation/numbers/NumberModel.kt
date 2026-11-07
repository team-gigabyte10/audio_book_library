package com.gigabyte.bookstore.learning.presentation.numbers

import com.gigabyte.bookstore.learning.domain.model.SpeechLang

data class LanguageNumber(
    val number: Int,
    /** Western digit, e.g. "1", "25", "100" */
    val digitDisplay: String = number.toString(),
    /** Native script numeral, e.g. "১", "१", "۱", "一" */
    val nativeNumeral: String? = null,
    /** Target word in native script, e.g. "いち" / "一", "ایک", "एक", "eins" */
    val wordTarget: String,
    /** Secondary or kanji/alternative spelling if applicable */
    val secondaryDisplay: String? = null,
    /** Latin / Romanized transliteration, e.g. "ichi", "aik", "ek", "eins" */
    val phoneticTranslit: String,
    /** Pronunciation guide in Bangla for Bengali native learners */
    val bnPron: String,
    /** Text read aloud by TTS engine */
    val ttsText: String = wordTarget,
    /** Range bucket for filtering, e.g. "1-20", "21-40", "41-60", "61-80", "81-100" */
    val rangeGroup: String
)

data class NumberRangeCategory(
    val id: String,
    val titleBn: String,
    val countLabel: String
)

data class LanguageNumberConfig(
    val langCode: String,
    val speechLang: SpeechLang,
    val titleBn: String,
    val subtitleBn: String,
    val nativeTitle: String,
    val accentColorHex: Long,
    val categories: List<NumberRangeCategory>,
    val numbers: List<LanguageNumber>
)

