package com.gigabyte.bookstore.learning.presentation.vocab

object VocabRepository {
    fun getConfigForLanguage(langCode: String): VocabLanguageConfig {
        return when (langCode.lowercase()) {
            "en", "english" -> EnglishVocabData.config
            "de", "german" -> GermanVocabData.config
            "hi", "hindi" -> HindiVocabData.config
            "ur", "urdu" -> UrduVocabData.config
            "ja", "japanese" -> JapaneseVocabData.config
            "zh", "chinese" -> ChineseVocabData.config
            "ar", "arabic" -> ArabicVocabData.config
            else -> EnglishVocabData.config
        }
    }
}
