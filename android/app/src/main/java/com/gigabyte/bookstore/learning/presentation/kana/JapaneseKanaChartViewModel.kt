package com.gigabyte.bookstore.learning.presentation.kana

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class JapaneseKanaChartViewModel(application: Application) : AndroidViewModel(application) {

    val audioPlayer = KanaAudioPlayer(application)

    private val _scriptMode = MutableStateFlow(ScriptMode.HIRAGANA)
    val scriptMode: StateFlow<ScriptMode> = _scriptMode.asStateFlow()

    private val _category = MutableStateFlow(KanaCategory.ALL)
    val category: StateFlow<KanaCategory> = _category.asStateFlow()

    private val _speechRate = MutableStateFlow(1.0f)
    val speechRate: StateFlow<Float> = _speechRate.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _selectedLetterForDetail = MutableStateFlow<KanaLetter?>(null)
    val selectedLetterForDetail: StateFlow<KanaLetter?> = _selectedLetterForDetail.asStateFlow()

    val filteredRows: StateFlow<List<KanaRow>> = combine(_category, _searchQuery) { cat, query ->
        val baseRows = when (cat) {
            KanaCategory.ALL -> KanaData.ALL_ROWS
            KanaCategory.GOJUON -> KanaData.GOJUON_ROWS
            KanaCategory.DAKUTEN -> KanaData.DAKUTEN_ROWS
            KanaCategory.YOON -> KanaData.YOON_ROWS
        }

        val trimmed = query.trim().lowercase()
        if (trimmed.isEmpty()) {
            baseRows
        } else {
            baseRows.mapNotNull { row ->
                val matchingLetters = row.letters.map { letter ->
                    if (letter != null && (
                        letter.romaji.lowercase().contains(trimmed) ||
                        letter.hiragana.contains(trimmed) ||
                        letter.katakana.contains(trimmed) ||
                        letter.bnPron.contains(trimmed) ||
                        letter.exampleWord?.contains(trimmed) == true ||
                        letter.exampleBn?.contains(trimmed) == true
                    )) {
                        letter
                    } else null
                }
                if (matchingLetters.any { it != null }) {
                    row.copy(letters = matchingLetters)
                } else null
            }
        }
    }.stateIn(viewModelScope, SharingStarted.Lazily, KanaData.ALL_ROWS)

    fun setScriptMode(mode: ScriptMode) {
        _scriptMode.value = mode
    }

    fun setCategory(category: KanaCategory) {
        _category.value = category
    }

    fun toggleSpeechRate() {
        _speechRate.value = if (_speechRate.value == 1.0f) 0.7f else 1.0f
    }

    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun openDetail(letter: KanaLetter) {
        _selectedLetterForDetail.value = letter
    }

    fun closeDetail() {
        _selectedLetterForDetail.value = null
    }

    fun playLetter(letter: KanaLetter) {
        audioPlayer.speakLetter(letter, _speechRate.value)
    }

    fun playExample(letter: KanaLetter) {
        val word = letter.exampleWord ?: letter.hiragana
        audioPlayer.speakText(word, letter.id, _speechRate.value)
    }

    fun playRow(row: KanaRow) {
        val nonNullLetters = row.letters.filterNotNull()
        if (nonNullLetters.isNotEmpty()) {
            audioPlayer.playRowSequence(nonNullLetters, _speechRate.value)
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

