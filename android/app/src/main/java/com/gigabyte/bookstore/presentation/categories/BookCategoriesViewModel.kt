package com.gigabyte.bookstore.presentation.categories

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.gigabyte.bookstore.BanglaAudiobookApp
import com.gigabyte.bookstore.data.models.AudioBundle
import com.gigabyte.bookstore.data.models.PlaybackState
import com.gigabyte.bookstore.data.models.RemoteBook
import com.gigabyte.bookstore.data.repository.HomeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class BookCategoryGroup(
    val name: String,
    val banglaName: String,
    val iconEmoji: String,
    val description: String,
    val books: List<RemoteBook>
)

data class BookCategoriesUiState(
    val isLoading: Boolean = true,
    val bundles: List<AudioBundle> = emptyList(),
    val allBooks: List<RemoteBook> = emptyList(),
    val selectedBundleId: String? = null,
    val selectedCategory: String = "all",
    val searchQuery: String = "",
    val categoryGroups: List<BookCategoryGroup> = emptyList(),
    val isAudiobookUnlocked: Boolean = false,
    val errorMessage: String? = null
)

class BookCategoriesViewModel(application: Application) : AndroidViewModel(application) {

    private val app = application as BanglaAudiobookApp
    private val homeRepository = HomeRepository()
    val player = app.player

    val playbackState: StateFlow<PlaybackState> = player.playbackState

    val userStatus: StateFlow<String> = app.appPreferences.userStatus
    val unlockedBundles: StateFlow<Set<String>> = app.appPreferences.unlockedBundles

    private val _uiState = MutableStateFlow(BookCategoriesUiState())
    val uiState: StateFlow<BookCategoriesUiState> = _uiState.asStateFlow()

    init {
        loadData()
    }

    fun initBundleSelection(bundleId: String?) {
        if (!bundleId.isNullOrBlank()) {
            _uiState.value = _uiState.value.copy(selectedBundleId = bundleId)
            recomputeGroups()
        }
    }

    fun selectCategory(category: String) {
        _uiState.value = _uiState.value.copy(selectedCategory = category)
        recomputeGroups()
    }

    fun selectBundle(bundleId: String?) {
        _uiState.value = _uiState.value.copy(
            selectedBundleId = if (_uiState.value.selectedBundleId == bundleId) null else bundleId
        )
        recomputeGroups()
    }

    fun updateSearchQuery(query: String) {
        _uiState.value = _uiState.value.copy(searchQuery = query)
        recomputeGroups()
    }

    fun loadData() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, errorMessage = null)
            try {
                val bundles = homeRepository.getAudioBundles()
                var books = homeRepository.getAllBooks()

                if (books.isEmpty()) {
                    books = app.syncManager.cachedBooks.value
                }

                // If remote books are still empty, map from local room repository
                if (books.isEmpty()) {
                    val localEntities = app.database.bookDao().getAllBooks().first()
                    books = localEntities.map { entity ->
                        RemoteBook(
                            id = entity.id,
                            title = entity.title,
                            author = entity.author,
                            coverPath = entity.coverPath,
                            category = "আত্মউন্নয়ন ও ক্লাসিক"
                        )
                    }
                }

                val isUnlocked = app.appPreferences.isBundleUnlocked("audiobook_bundle")

                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    bundles = bundles,
                    allBooks = books,
                    isAudiobookUnlocked = isUnlocked
                )
                recomputeGroups()
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    errorMessage = e.message ?: "বই লোড করতে সমস্যা হয়েছে"
                )
            }
        }
    }

    private fun recomputeGroups() {
        val currentState = _uiState.value
        var filteredBooks = currentState.allBooks

        // 1. Filter by bundle if selected
        if (!currentState.selectedBundleId.isNullOrBlank()) {
            val bundle = currentState.bundles.find { it.id == currentState.selectedBundleId }
            if (bundle != null && (bundle.bookIds.isNotEmpty() || bundle.bookTitles.isNotEmpty())) {
                val allowedIds = bundle.bookIds.toSet()
                val allowedTitles = bundle.bookTitles.map { it.trim().lowercase() }.filter { it.isNotBlank() }
                val matched = filteredBooks.filter { book ->
                    allowedIds.contains(book.id) ||
                    allowedTitles.any { allowed ->
                        val bt = book.title.trim().lowercase()
                        bt == allowed || bt.contains(allowed) || allowed.contains(bt)
                    }
                }
                if (matched.isNotEmpty()) {
                    filteredBooks = matched
                }
            }
        }

        // 2. Filter by search query
        if (currentState.searchQuery.isNotBlank()) {
            val q = currentState.searchQuery.trim().lowercase()
            filteredBooks = filteredBooks.filter {
                it.title.lowercase().contains(q) ||
                (it.author?.lowercase()?.contains(q) == true) ||
                (it.category?.lowercase()?.contains(q) == true)
            }
        }

        // 3. Group by category
        val groupedMap = filteredBooks.groupBy { book ->
            val cat = book.category?.trim()
            if (cat.isNullOrBlank() || cat.equals("General", ignoreCase = true)) {
                "আত্মউন্নয়ন ও ক্লাসিক"
            } else {
                cat
            }
        }

        val groups = groupedMap.map { (catName, booksInCat) ->
            val meta = getCategoryMeta(catName)
            BookCategoryGroup(
                name = catName,
                banglaName = meta.banglaName,
                iconEmoji = meta.emoji,
                description = meta.description,
                books = booksInCat
            )
        }.sortedByDescending { it.books.size }

        _uiState.value = currentState.copy(categoryGroups = groups)
    }

    private data class CategoryMeta(val banglaName: String, val emoji: String, val description: String)

    private fun getCategoryMeta(cat: String): CategoryMeta {
        return when {
            cat.contains("জীবনী", ignoreCase = true) || cat.contains("সাহিত্য", ignoreCase = true) || cat.contains("Classic", ignoreCase = true) ->
                CategoryMeta("অনুপ্রেরণামূলক জীবনী ও ক্লাসিক", "🌟", "বিশ্বসেরা ব্যক্তিত্বদের জীবনসংগ্রাম ও কালজয়ী সাহিত্যের অনুপ্রেরণা")
            cat.contains("ব্যবসা", ignoreCase = true) || cat.contains("ক্যারিয়ার", ignoreCase = true) || cat.contains("Business", ignoreCase = true) ->
                CategoryMeta("ক্যারিয়ার, ব্যবসা ও নেতৃত্ব", "💼", "বিজনেস স্ট্র্যাটেজি, উদ্যোগ ও লিডারশিপ গাইড")
            cat.contains("উন্নয়ন", ignoreCase = true) || cat.contains("আত্মউন্নয়ন", ignoreCase = true) || cat.contains("Self", ignoreCase = true) ->
                CategoryMeta("মনস্তত্ত্ব ও আত্মউন্নয়ন", "🧠", "চিন্তার বিকাশ, মানসিক শক্তি ও ইতিবাচক জীবনধারা")
            cat.contains("সময়", ignoreCase = true) || cat.contains("উৎপাদনশীলতা", ignoreCase = true) || cat.contains("Productivity", ignoreCase = true) ->
                CategoryMeta("সময় ব্যবস্থাপনা ও সাফল্য", "⏳", "ফোকাস, শৃঙ্ক্ষলা ও সর্বোচ্চ উৎপাদনশীলতার উপায়")
            cat.contains("শান্তি", ignoreCase = true) || cat.contains("স্বাস্থ্য", ignoreCase = true) || cat.contains("Health", ignoreCase = true) ->
                CategoryMeta("স্বাস্থ্য ও মানসিক শান্তি", "🌱", "সুস্থ শরীর, প্রশান্ত মন ও সুখী জীবন")
            else ->
                CategoryMeta(cat, "📚", "সমৃদ্ধ জ্ঞানের অডিওবই সংকলন")
        }
    }
}
