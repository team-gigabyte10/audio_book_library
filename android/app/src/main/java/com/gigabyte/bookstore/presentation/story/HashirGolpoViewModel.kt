package com.gigabyte.bookstore.presentation.story

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.gigabyte.bookstore.BanglaAudiobookApp
import com.gigabyte.bookstore.data.models.HashirGolpoCategory
import com.gigabyte.bookstore.data.models.HashirGolpoStory
import com.gigabyte.bookstore.domain.tts.TTSPlaybackListener
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HashirGolpoViewModel(application: Application) : AndroidViewModel(application) {

    private val app = application as BanglaAudiobookApp
    private val repository = app.hashirGolpoRepository
    private val ttsManager = app.ttsManager

    private var allStories: List<HashirGolpoStory> = emptyList()

    private val _categories = MutableStateFlow<List<HashirGolpoCategory>>(emptyList())
    val categories: StateFlow<List<HashirGolpoCategory>> = _categories.asStateFlow()

    private val _selectedCategorySlug = MutableStateFlow("all")
    val selectedCategorySlug: StateFlow<String> = _selectedCategorySlug.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _filteredStories = MutableStateFlow<List<HashirGolpoStory>>(emptyList())
    val filteredStories: StateFlow<List<HashirGolpoStory>> = _filteredStories.asStateFlow()

    private val _activeStory = MutableStateFlow<HashirGolpoStory?>(null)
    val activeStory: StateFlow<HashirGolpoStory?> = _activeStory.asStateFlow()

    private val _isSpeaking = MutableStateFlow(false)
    val isSpeaking: StateFlow<Boolean> = _isSpeaking.asStateFlow()

    private val _fontSize = MutableStateFlow(18)
    val fontSize: StateFlow<Int> = _fontSize.asStateFlow()

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val ttsListener = object : TTSPlaybackListener {
        override fun onChunkStarted(utteranceId: String, chunkIndex: Int) {
            _isSpeaking.value = true
        }

        override fun onChunkCompleted(utteranceId: String, chunkIndex: Int) {
            _isSpeaking.value = false
        }

        override fun onPlaybackError(utteranceId: String, errorMessage: String) {
            _isSpeaking.value = false
        }
    }

    init {
        ttsManager.addListener(ttsListener)
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _isLoading.value = true
            allStories = repository.getAllStories()
            _categories.value = repository.getCategories()
            applyFilters()
            _isLoading.value = false
        }
    }

    fun selectCategory(slug: String) {
        if (_selectedCategorySlug.value == slug) return
        _selectedCategorySlug.value = slug
        applyFilters()
    }

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
        applyFilters()
    }

    private fun applyFilters() {
        val slug = _selectedCategorySlug.value
        val query = _searchQuery.value.trim().lowercase()

        val filtered = allStories.filter { story ->
            val matchCategory = slug == "all" || story.categorySlug == slug
            val matchQuery = if (query.isBlank()) {
                true
            } else {
                story.title.lowercase().contains(query) ||
                        story.content.lowercase().contains(query) ||
                        story.category.lowercase().contains(query)
            }
            matchCategory && matchQuery
        }
        _filteredStories.value = filtered
    }

    fun openStory(story: HashirGolpoStory) {
        stopTts()
        _activeStory.value = story
    }

    fun closeStory() {
        stopTts()
        _activeStory.value = null
    }

    fun goToNextStory() {
        val current = _activeStory.value ?: return
        val list = _filteredStories.value
        val idx = list.indexOfFirst { it.id == current.id }
        if (idx != -1 && idx + 1 < list.size) {
            openStory(list[idx + 1])
        }
    }

    fun goToPreviousStory() {
        val current = _activeStory.value ?: return
        val list = _filteredStories.value
        val idx = list.indexOfFirst { it.id == current.id }
        if (idx > 0) {
            openStory(list[idx - 1])
        }
    }

    fun toggleTts(story: HashirGolpoStory) {
        if (_isSpeaking.value) {
            stopTts()
        } else {
            ttsManager.resetToBanglaLanguage()
            val textToRead = "${story.title}।\n${story.content}"
            val success = ttsManager.speakChunk(textToRead, 0)
            _isSpeaking.value = success
        }
    }

    fun stopTts() {
        if (_isSpeaking.value) {
            ttsManager.stop()
            _isSpeaking.value = false
        }
    }

    fun increaseFontSize() {
        if (_fontSize.value < 28) {
            _fontSize.value += 2
        }
    }

    fun decreaseFontSize() {
        if (_fontSize.value > 14) {
            _fontSize.value -= 2
        }
    }

    override fun onCleared() {
        super.onCleared()
        stopTts()
    }
}
