package com.gigabyte.bookstore.learning.presentation.calendar

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

class CalendarChartViewModel(
    application: Application,
    val langCode: String
) : AndroidViewModel(application) {

    val audioPlayer = MultiLangAudioPlayer(application)

    val config: CalendarLanguageConfig = when (langCode.lowercase()) {
        "urdu" -> UrduCalendarData.CONFIG
        "hindi" -> HindiCalendarData.CONFIG
        "german" -> GermanCalendarData.CONFIG
        "english" -> EnglishCalendarData.CONFIG
        "chinese", "zh" -> ChineseCalendarData.CONFIG
        "arabic", "ar" -> ArabicCalendarData.CONFIG
        else -> JapaneseCalendarData.CONFIG
    }

    private val _selectedCategory = MutableStateFlow(CalendarCategory.ALL)
    val selectedCategory: StateFlow<CalendarCategory> = _selectedCategory.asStateFlow()

    private val _speechRate = MutableStateFlow(1.0f)
    val speechRate: StateFlow<Float> = _speechRate.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _selectedItemForDetail = MutableStateFlow<CalendarItem?>(null)
    val selectedItemForDetail: StateFlow<CalendarItem?> = _selectedItemForDetail.asStateFlow()

    private val _isAutoPlaying = MutableStateFlow(false)
    val isAutoPlaying: StateFlow<Boolean> = _isAutoPlaying.asStateFlow()

    private var autoPlayJob: Job? = null

    val filteredItems: StateFlow<List<CalendarItem>> = combine(
        _selectedCategory,
        _searchQuery
    ) { category, query ->
        val baseItems = if (category == CalendarCategory.ALL) {
            config.items
        } else {
            config.items.filter { it.category == category }
        }

        val trimmed = query.trim().lowercase()
        if (trimmed.isEmpty()) {
            baseItems
        } else {
            baseItems.filter { item ->
                item.targetWord.lowercase().contains(trimmed) ||
                    item.secondaryDisplay?.lowercase()?.contains(trimmed) == true ||
                    item.bnMeaning.contains(trimmed) ||
                    item.bnPron.contains(trimmed)
            }
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = config.items
    )

    fun selectCategory(category: CalendarCategory) {
        stopAudio()
        _selectedCategory.value = category
    }

    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun toggleSpeechRate() {
        _speechRate.value = if (_speechRate.value >= 0.95f) 0.7f else 1.0f
    }

    fun selectItemForDetail(item: CalendarItem?) {
        _selectedItemForDetail.value = item
    }

    fun playItem(item: CalendarItem) {
        stopAutoPlay()
        audioPlayer.speakText(
            text = item.ttsText,
            letterId = item.id,
            lang = config.speechLang,
            speechRate = _speechRate.value
        )
    }

    fun toggleAutoPlay(itemsToPlay: List<CalendarItem>) {
        if (_isAutoPlaying.value) {
            stopAutoPlay()
        } else {
            startAutoPlay(itemsToPlay)
        }
    }

    private fun startAutoPlay(itemsToPlay: List<CalendarItem>) {
        stopAutoPlay()
        if (itemsToPlay.isEmpty()) return

        _isAutoPlaying.value = true
        autoPlayJob = viewModelScope.launch {
            for (item in itemsToPlay) {
                if (!_isAutoPlaying.value) break
                audioPlayer.speakText(
                    text = item.ttsText,
                    letterId = item.id,
                    lang = config.speechLang,
                    speechRate = _speechRate.value
                )
                val pauseMs = if (_speechRate.value <= 0.75f) 900L else 650L
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

