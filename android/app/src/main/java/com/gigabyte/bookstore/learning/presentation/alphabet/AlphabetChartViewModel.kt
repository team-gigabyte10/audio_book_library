package com.gigabyte.bookstore.learning.presentation.alphabet

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class AlphabetChartViewModel(
    application: Application,
    val langCode: String
) : AndroidViewModel(application) {

    val audioPlayer = MultiLangAudioPlayer(application)

    val config: LanguageAlphabetConfig = when (langCode.lowercase()) {
        "urdu" -> UrduAlphabetData.CONFIG
        "hindi" -> HindiVarnamalaData.CONFIG
        "german" -> GermanAlphabetData.CONFIG
        "chinese", "zh" -> PinyinAlphabetData.CONFIG
        else -> EnglishAlphabetData.CONFIG
    }

    private val _selectedCategoryId = MutableStateFlow("all")
    val selectedCategoryId: StateFlow<String> = _selectedCategoryId.asStateFlow()

    private val _speechRate = MutableStateFlow(1.0f)
    val speechRate: StateFlow<Float> = _speechRate.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _selectedLetterForDetail = MutableStateFlow<AlphabetLetter?>(null)
    val selectedLetterForDetail: StateFlow<AlphabetLetter?> = _selectedLetterForDetail.asStateFlow()

    val filteredRows: StateFlow<List<AlphabetRow>> = combine(
        _selectedCategoryId,
        _searchQuery
    ) { catId, query ->
        val baseRows = if (catId == "all") {
            config.rows
        } else {
            config.rows.filter { it.categoryId == catId }
        }

        val trimmed = query.trim().lowercase()
        if (trimmed.isEmpty()) {
            baseRows
        } else {
            baseRows.mapNotNull { row ->
                val matching = row.letters.filter { letter ->
                    letter.primaryDisplay.lowercase().contains(trimmed) ||
                        letter.phoneticName.lowercase().contains(trimmed) ||
                        letter.bnPron.contains(trimmed) ||
                        letter.exampleWord?.lowercase()?.contains(trimmed) == true ||
                        letter.exampleTranslationBn?.contains(trimmed) == true
                }
                if (matching.isNotEmpty()) {
                    row.copy(letters = matching)
                } else null
            }
        }
    }.stateIn(viewModelScope, SharingStarted.Lazily, config.rows)

    fun setCategory(categoryId: String) {
        _selectedCategoryId.value = categoryId
    }

    fun toggleSpeechRate() {
        _speechRate.value = if (_speechRate.value == 1.0f) 0.7f else 1.0f
    }

    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun openDetail(letter: AlphabetLetter) {
        _selectedLetterForDetail.value = letter
    }

    fun closeDetail() {
        _selectedLetterForDetail.value = null
    }

    fun playLetter(letter: AlphabetLetter) {
        audioPlayer.speakLetter(letter, config.speechLang, _speechRate.value)
    }

    fun playExampleWord(letter: AlphabetLetter) {
        val word = letter.exampleWord ?: letter.ttsText
        audioPlayer.speakText(word, letter.id, config.speechLang, _speechRate.value)
    }

    fun playRow(row: AlphabetRow) {
        if (row.letters.isNotEmpty()) {
            audioPlayer.playRowSequence(row.letters, config.speechLang, _speechRate.value)
        }
    }

    fun stopAudio() {
        audioPlayer.stop()
    }

    override fun onCleared() {
        super.onCleared()
        audioPlayer.shutdown()
    }
}

