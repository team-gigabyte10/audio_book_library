package com.gigabyte.bookstore.learning.presentation.numbers

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.gigabyte.bookstore.learning.presentation.alphabet.MultiLangAudioPlayer
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class NumbersChartViewModel(
    application: Application,
    val langCode: String
) : AndroidViewModel(application) {

    val audioPlayer = MultiLangAudioPlayer(application)

    val config: LanguageNumberConfig = when (langCode.lowercase()) {
        "urdu" -> UrduNumberData.CONFIG
        "hindi" -> HindiNumberData.CONFIG
        "german" -> GermanNumberData.CONFIG
        else -> JapaneseNumberData.CONFIG
    }

    private val _selectedRangeId = MutableStateFlow("all")
    val selectedRangeId: StateFlow<String> = _selectedRangeId.asStateFlow()

    private val _speechRate = MutableStateFlow(1.0f)
    val speechRate: StateFlow<Float> = _speechRate.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _selectedNumberForDetail = MutableStateFlow<LanguageNumber?>(null)
    val selectedNumberForDetail: StateFlow<LanguageNumber?> = _selectedNumberForDetail.asStateFlow()

    private val _isAutoPlaying = MutableStateFlow(false)
    val isAutoPlaying: StateFlow<Boolean> = _isAutoPlaying.asStateFlow()

    private var autoPlayJob: Job? = null

    val filteredNumbers: StateFlow<List<LanguageNumber>> = combine(
        _selectedRangeId,
        _searchQuery
    ) { rangeId, query ->
        val baseNumbers = if (rangeId == "all") {
            config.numbers
        } else {
            config.numbers.filter { it.rangeGroup == rangeId }
        }

        val trimmed = query.trim().lowercase()
        if (trimmed.isEmpty()) {
            baseNumbers
        } else {
            baseNumbers.filter { item ->
                item.number.toString().contains(trimmed) ||
                    item.wordTarget.lowercase().contains(trimmed) ||
                    item.phoneticTranslit.lowercase().contains(trimmed) ||
                    item.bnPron.contains(trimmed) ||
                    item.nativeNumeral?.contains(trimmed) == true
            }
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = config.numbers
    )

    fun selectRange(rangeId: String) {
        stopAudio()
        _selectedRangeId.value = rangeId
    }

    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun toggleSpeechRate() {
        _speechRate.value = if (_speechRate.value >= 0.95f) 0.7f else 1.0f
    }

    fun selectNumberForDetail(number: LanguageNumber?) {
        _selectedNumberForDetail.value = number
    }

    fun playNumber(number: LanguageNumber) {
        stopAutoPlay()
        audioPlayer.speakText(
            text = number.ttsText,
            letterId = number.number.toString(),
            lang = config.speechLang,
            speechRate = _speechRate.value
        )
    }

    fun toggleAutoPlay(numbersToPlay: List<LanguageNumber>) {
        if (_isAutoPlaying.value) {
            stopAutoPlay()
        } else {
            startAutoPlay(numbersToPlay)
        }
    }

    private fun startAutoPlay(numbersToPlay: List<LanguageNumber>) {
        stopAutoPlay()
        if (numbersToPlay.isEmpty()) return

        _isAutoPlaying.value = true
        autoPlayJob = viewModelScope.launch {
            for (num in numbersToPlay) {
                if (!_isAutoPlaying.value) break
                audioPlayer.speakText(
                    text = num.ttsText,
                    letterId = num.number.toString(),
                    lang = config.speechLang,
                    speechRate = _speechRate.value
                )
                // Short pause between numbers
                val pauseMs = if (_speechRate.value <= 0.75f) 650L else 450L
                delay(pauseMs)
            }
            _isAutoPlaying.value = false
        }
    }

    private fun stopAutoPlay() {
        autoPlayJob?.cancel()
        autoPlayJob = null
        _isAutoPlaying.value = false
    }

    fun stopAudio() {
        stopAutoPlay()
        audioPlayer.stop()
    }

    override fun onCleared() {
        super.onCleared()
        stopAutoPlay()
        audioPlayer.shutdown()
    }
}

