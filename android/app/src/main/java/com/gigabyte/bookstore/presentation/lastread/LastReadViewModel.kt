package com.gigabyte.bookstore.presentation.lastread

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.gigabyte.bookstore.BanglaAudiobookApp
import com.gigabyte.bookstore.data.local.entities.PlaybackHistoryEntity
import com.gigabyte.bookstore.data.models.PlaybackState
import com.gigabyte.bookstore.learning.data.ContinueLesson
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class LastReadViewModel(application: Application) : AndroidViewModel(application) {
    private val app = application as BanglaAudiobookApp
    private val bookRepository = app.repository
    private val learningRepository = app.learningRepository
    private val player = app.player

    val playbackHistoryList: StateFlow<List<PlaybackHistoryEntity>> = bookRepository.allPlaybackHistory
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val lastPlayedBook: StateFlow<PlaybackHistoryEntity?> = bookRepository.lastPlayedHistory
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    val continueLesson: StateFlow<ContinueLesson?> = learningRepository.observeContinueLesson()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    val playbackState: StateFlow<PlaybackState> = player.playbackState

    fun isBundleUnlocked(bundleId: String): Boolean = app.appPreferences.isBundleUnlocked(bundleId)

    fun playHistoryBook(history: PlaybackHistoryEntity) {
        viewModelScope.launch {
            val book = bookRepository.getBookById(history.bookId) ?: return@launch
            player.loadAndPlayBook(
                book = book,
                startChapterIndex = history.chapterIndex,
                startChunkIndex = history.chunkIndex,
                autoPlay = true
            )
        }
    }

    fun continueLastPlayedBook() {
        val history = lastPlayedBook.value ?: return
        playHistoryBook(history)
    }
}
