package com.gigabyte.bookstore.presentation.search

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.gigabyte.bookstore.BanglaAudiobookApp
import com.gigabyte.bookstore.data.models.Book
import com.gigabyte.bookstore.data.models.Chapter
import com.gigabyte.bookstore.data.models.PlaybackState
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class SearchResultItem(
    val bookId: String,
    val bookTitle: String,
    val chapterIndex: Int,
    val chapterTitle: String,
    val matchedSnippet: String
)

class SearchViewModel(
    application: Application,
    private val specificBookId: String?
) : AndroidViewModel(application) {

    private val app = application as BanglaAudiobookApp
    private val repository = app.repository
    val player = app.player

    val playbackState: StateFlow<PlaybackState> = player.playbackState

    private val _query = MutableStateFlow("")
    val query: StateFlow<String> = _query.asStateFlow()

    private val _results = MutableStateFlow<List<SearchResultItem>>(emptyList())
    val results: StateFlow<List<SearchResultItem>> = _results.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching: StateFlow<Boolean> = _isSearching.asStateFlow()

    private var searchJob: Job? = null

    fun onQueryChange(newQuery: String) {
        _query.value = newQuery
        searchJob?.cancel()

        if (newQuery.isBlank()) {
            _results.value = emptyList()
            _isSearching.value = false
            return
        }

        searchJob = viewModelScope.launch {
            _isSearching.value = true
            delay(300L) // Debounce

            val matchedChapters = if (specificBookId != null) {
                repository.searchInBook(specificBookId, newQuery)
            } else {
                repository.searchAllBooks(newQuery)
            }

            val items = mutableListOf<SearchResultItem>()
            for (chap in matchedChapters) {
                val book = repository.getBookById(chap.bookId)
                val snippet = extractSnippet(chap.content, newQuery)
                items.add(
                    SearchResultItem(
                        bookId = chap.bookId,
                        bookTitle = book?.title ?: "বই",
                        chapterIndex = chap.index,
                        chapterTitle = chap.title,
                        matchedSnippet = snippet
                    )
                )
            }

            _results.value = items
            _isSearching.value = false
        }
    }

    private fun extractSnippet(content: String, query: String): String {
        val index = content.indexOf(query, ignoreCase = true)
        if (index == -1) return content.take(120) + "..."
        val start = (index - 40).coerceAtLeast(0)
        val end = (index + query.length + 60).coerceAtMost(content.length)
        val prefix = if (start > 0) "..." else ""
        val suffix = if (end < content.length) "..." else ""
        return prefix + content.substring(start, end).trim() + suffix
    }

    fun playResult(item: SearchResultItem) {
        viewModelScope.launch {
            val book = repository.getBookById(item.bookId) ?: return@launch
            player.loadAndPlayBook(
                book = book,
                startChapterIndex = item.chapterIndex,
                startChunkIndex = 0,
                autoPlay = true
            )
        }
    }
}
