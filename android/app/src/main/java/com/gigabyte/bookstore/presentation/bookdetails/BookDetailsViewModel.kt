package com.gigabyte.bookstore.presentation.bookdetails

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.gigabyte.bookstore.BanglaAudiobookApp
import com.gigabyte.bookstore.data.local.entities.PlaybackHistoryEntity
import com.gigabyte.bookstore.data.models.Book
import com.gigabyte.bookstore.data.models.Chapter
import com.gigabyte.bookstore.data.models.PlaybackState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BookDetailsViewModel(
    application: Application,
    private val bookId: String
) : AndroidViewModel(application) {

    private val app = application as BanglaAudiobookApp
    private val repository = app.repository
    val player = app.player

    private val _book = MutableStateFlow<Book?>(null)
    val book: StateFlow<Book?> = _book.asStateFlow()

    private val _chapters = MutableStateFlow<List<Chapter>>(emptyList())
    val chapters: StateFlow<List<Chapter>> = _chapters.asStateFlow()

    private val _history = MutableStateFlow<PlaybackHistoryEntity?>(null)
    val history: StateFlow<PlaybackHistoryEntity?> = _history.asStateFlow()

    val playbackState: StateFlow<PlaybackState> = player.playbackState

    init {
        loadBookDetails()
    }

    private fun loadBookDetails() {
        viewModelScope.launch {
            _book.value = repository.getBookById(bookId)
            repository.getChaptersForBook(bookId).collect {
                _chapters.value = it
            }
        }
        viewModelScope.launch {
            _history.value = repository.getHistoryForBook(bookId)
        }
    }

    fun playChapter(chapterIndex: Int) {
        val currentBook = _book.value ?: return
        player.loadAndPlayBook(
            book = currentBook,
            startChapterIndex = chapterIndex,
            startChunkIndex = 0,
            autoPlay = true
        )
    }

    fun continueListening() {
        val currentBook = _book.value ?: return
        val savedHistory = _history.value
        val startChapter = savedHistory?.chapterIndex ?: 0
        val startChunk = savedHistory?.chunkIndex ?: 0

        player.loadAndPlayBook(
            book = currentBook,
            startChapterIndex = startChapter,
            startChunkIndex = startChunk,
            autoPlay = true
        )
    }
}
