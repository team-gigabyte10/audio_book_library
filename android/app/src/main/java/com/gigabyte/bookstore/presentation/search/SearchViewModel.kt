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

data class SearchResultSnippet(
    val chapterIndex: Int,
    val chapterTitle: String,
    val snippet: String
)

data class BookSearchItem(
    val book: Book,
    val matchedSnippets: List<SearchResultSnippet> = emptyList()
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

    private val _allBooks = MutableStateFlow<List<Book>>(emptyList())

    private val _searchResults = MutableStateFlow<List<BookSearchItem>>(emptyList())
    val searchResults: StateFlow<List<BookSearchItem>> = _searchResults.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching: StateFlow<Boolean> = _isSearching.asStateFlow()

    private var searchJob: Job? = null

    init {
        viewModelScope.launch {
            repository.allBooks.collect { booksList ->
                val uniqueBooks = if (specificBookId != null) {
                    booksList.filter { it.id == specificBookId }
                } else {
                    booksList
                }
                _allBooks.value = uniqueBooks

                if (_query.value.isBlank()) {
                    _searchResults.value = uniqueBooks.map { BookSearchItem(it) }
                } else {
                    filterBooks(_query.value, uniqueBooks)
                }
            }
        }
    }

    fun onQueryChange(newQuery: String) {
        _query.value = newQuery
        searchJob?.cancel()

        if (newQuery.isBlank()) {
            _searchResults.value = _allBooks.value.map { BookSearchItem(it) }
            _isSearching.value = false
            return
        }

        searchJob = viewModelScope.launch {
            _isSearching.value = true
            delay(250L) // Debounce
            filterBooks(newQuery, _allBooks.value)
            _isSearching.value = false
        }
    }

    private suspend fun filterBooks(queryStr: String, books: List<Book>) {
        val trimmed = queryStr.trim()
        val queryLower = trimmed.lowercase()

        // 1. Direct title or author match
        val titleAuthorMatches = mutableMapOf<String, BookSearchItem>()
        for (book in books) {
            val titleMatches = book.title.contains(queryLower, ignoreCase = true)
            val authorMatches = book.author?.contains(queryLower, ignoreCase = true) == true
            if (titleMatches || authorMatches) {
                titleAuthorMatches[book.id] = BookSearchItem(book = book)
            }
        }

        // 2. Search chapter content for deep matches
        val matchedChapters: List<Chapter> = if (specificBookId != null) {
            repository.searchInBook(specificBookId, trimmed)
        } else {
            repository.searchAllBooks(trimmed)
        }

        val chapterSnippetsMap = mutableMapOf<String, MutableList<SearchResultSnippet>>()
        for (chap in matchedChapters) {
            val baseId = chap.bookId.removeSuffix("_full")
            val snippet = extractSnippet(chap.content, trimmed)
            val list = chapterSnippetsMap.getOrPut(baseId) { mutableListOf() }
            if (list.size < 2) { // up to 2 top snippets per book
                list.add(
                    SearchResultSnippet(
                        chapterIndex = chap.index,
                        chapterTitle = chap.title,
                        snippet = snippet
                    )
                )
            }
        }

        // 3. Combine results
        val finalMap = LinkedHashMap<String, BookSearchItem>()

        // Add title/author matches first
        for ((bookId, item) in titleAuthorMatches) {
            val snippets = chapterSnippetsMap[bookId] ?: emptyList()
            finalMap[bookId] = item.copy(matchedSnippets = snippets)
        }

        // Add any additional books that matched solely through chapter content
        for ((bookId, snippets) in chapterSnippetsMap) {
            if (!finalMap.containsKey(bookId)) {
                val book = books.find { it.id == bookId } ?: repository.getBookById(bookId)
                if (book != null) {
                    finalMap[bookId] = BookSearchItem(book = book, matchedSnippets = snippets)
                }
            }
        }

        _searchResults.value = finalMap.values.toList()
    }

    private fun extractSnippet(content: String, query: String): String {
        val index = content.indexOf(query, ignoreCase = true)
        if (index == -1) return content.take(100) + "..."
        val start = (index - 30).coerceAtLeast(0)
        val end = (index + query.length + 50).coerceAtMost(content.length)
        val prefix = if (start > 0) "..." else ""
        val suffix = if (end < content.length) "..." else ""
        return prefix + content.substring(start, end).trim() + suffix
    }

    fun playBook(book: Book) {
        viewModelScope.launch {
            player.loadAndPlayBook(
                book = book,
                startChapterIndex = 0,
                startChunkIndex = 0,
                autoPlay = true
            )
        }
    }

    fun playSnippet(item: BookSearchItem, snippet: SearchResultSnippet) {
        viewModelScope.launch {
            player.loadAndPlayBook(
                book = item.book,
                startChapterIndex = snippet.chapterIndex,
                startChunkIndex = 0,
                autoPlay = true
            )
        }
    }
}
