package com.gigabyte.bookstore.presentation.library

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.gigabyte.bookstore.BanglaAudiobookApp
import com.gigabyte.bookstore.data.local.entities.PlaybackHistoryEntity
import com.gigabyte.bookstore.data.models.Book
import com.gigabyte.bookstore.data.models.PlaybackState
import com.gigabyte.bookstore.domain.tts.TTSVoiceStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

sealed class ImportUiState {
    object Idle : ImportUiState()
    object Loading : ImportUiState()
    data class Success(val book: Book) : ImportUiState()
    data class Error(val message: String) : ImportUiState()
}

class LibraryViewModel(application: Application) : AndroidViewModel(application) {

    private val app = application as BanglaAudiobookApp
    private val repository = app.repository
    val player = app.player
    val ttsManager = app.ttsManager

    val books: StateFlow<List<Book>> = repository.allBooks
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val lastPlayed: StateFlow<PlaybackHistoryEntity?> = repository.lastPlayedHistory
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    val playbackState: StateFlow<PlaybackState> = player.playbackState

    val voiceStatus: StateFlow<TTSVoiceStatus> = ttsManager.voiceStatus

    private val _importState = MutableStateFlow<ImportUiState>(ImportUiState.Idle)
    val importState: StateFlow<ImportUiState> = _importState.asStateFlow()

    fun importBook(uri: Uri) {
        viewModelScope.launch {
            _importState.value = ImportUiState.Loading
            val result = repository.importBookFromUri(uri)
            result.onSuccess { book ->
                _importState.value = ImportUiState.Success(book)
            }.onFailure { error ->
                _importState.value = ImportUiState.Error(error.localizedMessage ?: "বই ইমপোর্ট ব্যর্থ হয়েছে।")
            }
        }
    }

    fun clearImportState() {
        _importState.value = ImportUiState.Idle
    }

    fun continueLastPlayed() {
        viewModelScope.launch {
            val history = lastPlayed.value ?: return@launch
            val book = repository.getBookById(history.bookId) ?: return@launch
            player.loadAndPlayBook(
                book = book,
                startChapterIndex = history.chapterIndex,
                startChunkIndex = history.chunkIndex,
                autoPlay = true
            )
        }
    }

    fun deleteBook(bookId: String) {
        viewModelScope.launch {
            if (playbackState.value.bookId == bookId) {
                player.pause()
            }
            repository.deleteBook(bookId)
        }
    }

    fun testBanglaVoice() {
        ttsManager.testBanglaVoice()
    }

    fun openTtsSettings() {
        ttsManager.openTtsSettings()
    }
}
