package com.gigabyte.bookstore.learning.presentation.alphabet

import com.gigabyte.bookstore.learning.domain.model.SpeechLang

data class AlphabetLetter(
    val id: String,
    /** Primary visible character(s), e.g. "Aa", "ا", "अ", "Ä ä" */
    val primaryDisplay: String,
    /** Optional secondary script/transliteration, e.g. "Alif", "Ka", "A" */
    val secondaryDisplay: String? = null,
    /** Transliteration or phonic name, e.g. "ei", "Alif", "Ka", "ae" */
    val phoneticName: String,
    /** Bangla pronunciation guidance for Bengali native learners */
    val bnPron: String,
    /** Category identifier, e.g. "vowel", "consonant", "swar", "vyanjan" */
    val categoryId: String,
    /** Target text spoken by TTS, e.g. "A", "الف", "क", "Ä" */
    val ttsText: String = primaryDisplay,
    /** Real vocabulary example, e.g. "Apple", "انار", "आम", "Apfel" */
    val exampleWord: String? = null,
    /** Example word transcription/pronunciation */
    val examplePhonetic: String? = null,
    /** Meaning of example word in Bangla */
    val exampleTranslationBn: String? = null,
    /** Phonetic advice or articulatory tip in Bangla */
    val pronunciationTipBn: String? = null
)

data class AlphabetCategory(
    val id: String,
    val titleBn: String,
    val countLabel: String
)

data class AlphabetRow(
    val id: String,
    val titleBn: String,
    val subtitleTarget: String,
    val categoryId: String,
    val letters: List<AlphabetLetter>
)

data class LanguageAlphabetConfig(
    val langCode: String,
    val speechLang: SpeechLang,
    val titleBn: String,
    val subtitleBn: String,
    val accentColorHex: Long,
    val categories: List<AlphabetCategory>,
    val rows: List<AlphabetRow>
) {
    val allLetters: List<AlphabetLetter> get() = rows.flatMap { it.letters }
}

