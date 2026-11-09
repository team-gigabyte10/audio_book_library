package com.gigabyte.bookstore.learning.presentation.vocab

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.gigabyte.bookstore.learning.domain.model.SpeechLang
import com.gigabyte.bookstore.learning.presentation.alphabet.MultiLangAudioPlayer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

data class VocabVaultUiState(
    val config: VocabLanguageConfig,
    val selectedCategory: VocabCategory = VocabCategory.ALL,
    val searchQuery: String = "",
    val items: List<VocabItem> = emptyList(),
    val totalCount: Int = 0,
    val filteredCount: Int = 0,
    val activeSpeakingId: String? = null,
    val isSpeaking: Boolean = false
)

class VocabVaultViewModel(
    private val langCode: String,
    private val audioPlayer: MultiLangAudioPlayer
) : ViewModel() {

    private val config = VocabRepository.getConfigForLanguage(langCode)

    private val _selectedCategory = MutableStateFlow(VocabCategory.ALL)
    val selectedCategory: StateFlow<VocabCategory> = _selectedCategory.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    val activeSpeakingId: StateFlow<String?> = audioPlayer.activeSpeakingId
    val isSpeaking: StateFlow<Boolean> = audioPlayer.isSpeaking

    val uiState: StateFlow<VocabVaultUiState> = combine(
        _selectedCategory,
        _searchQuery,
        activeSpeakingId,
        isSpeaking
    ) { category, query, speakingId, speaking ->
        val filtered = config.items.filter { item ->
            val matchesCategory = (category == VocabCategory.ALL || item.category == category)
            val matchesQuery = if (query.isBlank()) true else {
                val q = query.trim().lowercase()
                item.singularTarget.lowercase().contains(q) ||
                (item.pluralTarget?.lowercase()?.contains(q) == true) ||
                item.bnMeaning.lowercase().contains(q) ||
                item.singularBnPron.lowercase().contains(q) ||
                (item.pluralBnPron?.lowercase()?.contains(q) == true) ||
                (item.singularSecondary?.lowercase()?.contains(q) == true) ||
                (item.pluralSecondary?.lowercase()?.contains(q) == true)
            }
            matchesCategory && matchesQuery
        }
        VocabVaultUiState(
            config = config,
            selectedCategory = category,
            searchQuery = query,
            items = filtered,
            totalCount = config.items.size,
            filteredCount = filtered.size,
            activeSpeakingId = speakingId,
            isSpeaking = speaking
        )
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        VocabVaultUiState(
            config = config,
            items = config.items,
            totalCount = config.items.size,
            filteredCount = config.items.size
        )
    )

    fun onCategorySelected(category: VocabCategory) {
        _selectedCategory.value = category
    }

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
    }

    fun playSingular(item: VocabItem) {
        val playId = "${item.id}_sg"
        if (activeSpeakingId.value == playId) {
            audioPlayer.stop()
            return
        }
        val textToSpeak = if (config.speechLang == SpeechLang.DE && !item.germanArticleSingular.isNullOrBlank()) {
            "${item.germanArticleSingular} ${item.singularTarget}"
        } else {
            item.singularTarget
        }
        audioPlayer.speakText(
            text = textToSpeak,
            letterId = playId,
            lang = config.speechLang
        )
    }

    fun playPlural(item: VocabItem) {
        val pluralText = item.pluralTarget ?: return
        val playId = "${item.id}_pl"
        if (activeSpeakingId.value == playId) {
            audioPlayer.stop()
            return
        }
        val textToSpeak = if (config.speechLang == SpeechLang.DE && !item.germanArticlePlural.isNullOrBlank()) {
            "${item.germanArticlePlural} $pluralText"
        } else {
            pluralText
        }
        audioPlayer.speakText(
            text = textToSpeak,
            letterId = playId,
            lang = config.speechLang
        )
    }

    fun stopAudio() {
        audioPlayer.stop()
    }

    override fun onCleared() {
        super.onCleared()
        audioPlayer.shutdown()
    }

    class Factory(
        private val context: Context,
        private val langCode: String
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            val player = MultiLangAudioPlayer(context.applicationContext)
            return VocabVaultViewModel(langCode, player) as T
        }
    }
}

