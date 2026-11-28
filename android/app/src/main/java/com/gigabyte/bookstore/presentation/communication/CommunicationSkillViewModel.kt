package com.gigabyte.bookstore.presentation.communication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.gigabyte.bookstore.BanglaAudiobookApp
import com.gigabyte.bookstore.data.models.CommunicationCategory
import com.gigabyte.bookstore.data.models.CommunicationSkill
import com.gigabyte.bookstore.domain.parser.MarkdownCleaner
import com.gigabyte.bookstore.domain.tts.TTSPlaybackListener
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CommunicationSkillViewModel(application: Application) : AndroidViewModel(application) {

    private val app = application as BanglaAudiobookApp
    private val repository = app.communicationSkillRepository
    private val ttsManager = app.ttsManager

    private var allSkills: List<CommunicationSkill> = emptyList()

    private val _categories = MutableStateFlow<List<CommunicationCategory>>(emptyList())
    val categories: StateFlow<List<CommunicationCategory>> = _categories.asStateFlow()

    private val _selectedCategorySlug = MutableStateFlow("all")
    val selectedCategorySlug: StateFlow<String> = _selectedCategorySlug.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _filteredSkills = MutableStateFlow<List<CommunicationSkill>>(emptyList())
    val filteredSkills: StateFlow<List<CommunicationSkill>> = _filteredSkills.asStateFlow()

    private val _activeSkill = MutableStateFlow<CommunicationSkill?>(null)
    val activeSkill: StateFlow<CommunicationSkill?> = _activeSkill.asStateFlow()

    private val _isSpeaking = MutableStateFlow(false)
    val isSpeaking: StateFlow<Boolean> = _isSpeaking.asStateFlow()

    private val _speakingSkillId = MutableStateFlow<String?>(null)
    val speakingSkillId: StateFlow<String?> = _speakingSkillId.asStateFlow()

    private val _fontSize = MutableStateFlow(17)
    val fontSize: StateFlow<Int> = _fontSize.asStateFlow()

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val ttsListener = object : TTSPlaybackListener {
        override fun onChunkStarted(utteranceId: String, chunkIndex: Int) {
            _isSpeaking.value = true
        }

        override fun onChunkCompleted(utteranceId: String, chunkIndex: Int) {
            _isSpeaking.value = false
            _speakingSkillId.value = null
        }

        override fun onPlaybackError(utteranceId: String, errorMessage: String) {
            _isSpeaking.value = false
            _speakingSkillId.value = null
        }
    }

    init {
        ttsManager.addListener(ttsListener)
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _isLoading.value = true
            allSkills = repository.getAllSkills()
            _categories.value = repository.getCategories()
            applyFilter()
            _isLoading.value = false
        }
    }

    fun selectCategory(slug: String) {
        _selectedCategorySlug.value = slug
        applyFilter()
    }

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
        applyFilter()
    }

    fun selectSkill(skill: CommunicationSkill?) {
        if (_activeSkill.value?.id != skill?.id) {
            stopAudio()
        }
        _activeSkill.value = skill
    }

    fun setFontSize(size: Int) {
        _fontSize.value = size.coerceIn(14, 26)
    }

    fun toggleAudio(skill: CommunicationSkill) {
        if (_isSpeaking.value && _speakingSkillId.value == skill.id) {
            stopAudio()
        } else {
            playAudio(skill)
        }
    }

    private fun playAudio(skill: CommunicationSkill) {
        ttsManager.stop()
        ttsManager.resetToBanglaLanguage()
        _speakingSkillId.value = skill.id

        val speechText = buildString {
            append(skill.title).append("।\n\n")
            if (skill.ruleQuote.isNotBlank()) {
                append("মূল নীতি: ").append(skill.ruleQuote).append("।\n\n")
            }
            if (skill.summary.isNotBlank()) {
                append("সংক্ষেপে: ").append(skill.summary).append("।\n\n")
            }
            append(skill.content).append("।\n\n")
            if (skill.actionStep.isNotBlank()) {
                append("আজকের বাস্তব প্রয়োগ: ").append(skill.actionStep)
            }
        }

        val cleaned = MarkdownCleaner.cleanForTTS(speechText)
        val success = ttsManager.speakChunk(cleaned, 0)
        _isSpeaking.value = success
    }

    fun stopAudio() {
        ttsManager.stop()
        _isSpeaking.value = false
        _speakingSkillId.value = null
    }

    private fun applyFilter() {
        val slug = _selectedCategorySlug.value
        val query = _searchQuery.value.trim().lowercase()

        var list = allSkills

        if (slug != "all") {
            list = list.filter { it.categorySlug == slug }
        }

        if (query.isNotBlank()) {
            list = list.filter { skill ->
                skill.title.lowercase().contains(query) ||
                skill.content.lowercase().contains(query) ||
                skill.summary.lowercase().contains(query) ||
                skill.ruleQuote.lowercase().contains(query) ||
                skill.actionStep.lowercase().contains(query) ||
                skill.category.lowercase().contains(query)
            }
        }

        _filteredSkills.value = list
    }

    override fun onCleared() {
        super.onCleared()
        ttsManager.removeListener(ttsListener)
        stopAudio()
    }
}
