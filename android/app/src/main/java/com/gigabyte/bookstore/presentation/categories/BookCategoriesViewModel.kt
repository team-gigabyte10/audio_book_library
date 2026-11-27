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

    private val _bundles = MutableStateFlow<List<AudioBundle>>(emptyList())
    private val _allBooks = MutableStateFlow<List<RemoteBook>>(emptyList())
    private val _selectedBundleId = MutableStateFlow<String?>(null)
    private val _selectedCategory = MutableStateFlow<String>("all")
    private val _searchQuery = MutableStateFlow<String>("")
    private val _errorMessage = MutableStateFlow<String?>(null)

    private val _uiState = MutableStateFlow(BookCategoriesUiState(isLoading = true))
    val uiState: StateFlow<BookCategoriesUiState> = _uiState.asStateFlow()

    init {
        startRealtimeSync()
    }

    private fun startRealtimeSync() {
        // 1. Initial immediate offline/cache load so UI renders instantly without waiting for network
        viewModelScope.launch {
            try {
                val cached = app.syncManager.cachedBooks.value
                if (cached.isNotEmpty()) {
                    _allBooks.value = cached
                } else {
                    val local = app.database.bookDao().getAllBooks().first()
                    if (local.isNotEmpty()) {
                        _allBooks.value = local.map { entity ->
                            RemoteBook(
                                id = entity.id,
                                title = entity.title,
                                author = entity.author,
                                coverPath = entity.coverPath,
                                category = "আত্মউন্নয়ন ও ক্লাসিক"
                            )
                        }
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        // 2. Real-time Firestore Bundle listener
        viewModelScope.launch {
            homeRepository.listenToAudioBundles().collect { bundles ->
                if (bundles.isNotEmpty()) {
                    _bundles.value = bundles
                }
            }
        }

        // 3. Real-time Firestore Books listener
        viewModelScope.launch {
            homeRepository.listenToAllBooks().collect { books ->
                if (books.isNotEmpty()) {
                    _allBooks.value = books
                }
            }
        }

        // 4. Reactive State Combination: recomputes categories, filter chips, counts and unlock state whenever any stream changes
        viewModelScope.launch {
            combine(
                _bundles,
                _allBooks,
                _selectedBundleId,
                _selectedCategory,
                _searchQuery,
                app.appPreferences.unlockedBundles,
                app.appPreferences.userStatus
            ) { args ->
                @Suppress("UNCHECKED_CAST")
                val bundles = args[0] as List<AudioBundle>
                @Suppress("UNCHECKED_CAST")
                val allBooks = args[1] as List<RemoteBook>
                val bundleId = args[2] as? String
                val category = args[3] as String
                val query = args[4] as String

                val targetBundle = bundleId ?: "audiobook_bundle"
                val isUnlocked = app.appPreferences.isBundleUnlocked(targetBundle)
                val groups = computeCategoryGroups(allBooks, bundles, bundleId, query)

                BookCategoriesUiState(
                    isLoading = allBooks.isEmpty() && bundles.isEmpty(),
                    bundles = bundles,
                    allBooks = allBooks,
                    selectedBundleId = bundleId,
                    selectedCategory = category,
                    searchQuery = query,
                    categoryGroups = groups,
                    isAudiobookUnlocked = isUnlocked,
                    errorMessage = _errorMessage.value
                )
            }.collect { newState ->
                _uiState.value = newState
            }
        }
    }

    fun initBundleSelection(bundleId: String?) {
        if (!bundleId.isNullOrBlank()) {
            _selectedBundleId.value = bundleId
        }
    }

    fun selectCategory(category: String) {
        _selectedCategory.value = category
    }

    fun selectBundle(bundleId: String?) {
        val newId = if (_selectedBundleId.value == bundleId) null else bundleId
        _selectedBundleId.value = newId
        _selectedCategory.value = "all"
    }

    val unlockedModuleUpdates: StateFlow<Long> = app.appPreferences.unlockedModuleUpdates

    fun isBookUnlocked(bookId: String): Boolean = app.appPreferences.isBookUnlockedForReading(bookId)

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun refresh() {
        viewModelScope.launch {
            try {
                val freshBundles = homeRepository.getAudioBundles()
                if (freshBundles.isNotEmpty()) _bundles.value = freshBundles
                val freshBooks = homeRepository.getAllBooks()
                if (freshBooks.isNotEmpty()) _allBooks.value = freshBooks
            } catch (e: Exception) {
                _errorMessage.value = e.message
            }
        }
    }

    private fun computeCategoryGroups(
        allBooks: List<RemoteBook>,
        bundles: List<AudioBundle>,
        selectedBundleId: String?,
        searchQuery: String
    ): List<BookCategoryGroup> {
        var filteredBooks = allBooks

        // 1. Filter by bundle if selected
        if (!selectedBundleId.isNullOrBlank()) {
            val bundle = bundles.find { it.id == selectedBundleId }
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
        if (searchQuery.isNotBlank()) {
            val q = searchQuery.trim().lowercase()
            filteredBooks = filteredBooks.filter {
                it.title.lowercase().contains(q) ||
                (it.author?.lowercase()?.contains(q) == true) ||
                (it.category?.lowercase()?.contains(q) == true)
            }
        }

        // 3. Group by category dynamically
        val groupedMap = filteredBooks.groupBy { book ->
            val cat = book.category?.trim()
            if (cat.isNullOrBlank() || cat.equals("General", ignoreCase = true)) {
                "আত্মউন্নয়ন ও ক্লাসিক"
            } else {
                cat
            }
        }

        return groupedMap.map { (catName, booksInCat) ->
            val meta = getCategoryMeta(catName)
            BookCategoryGroup(
                name = catName,
                banglaName = meta.banglaName,
                iconEmoji = meta.emoji,
                description = meta.description,
                books = booksInCat
            )
        }.sortedByDescending { it.books.size }
    }

    private data class CategoryMeta(val banglaName: String, val emoji: String, val description: String)

    private fun getCategoryMeta(cat: String): CategoryMeta {
        return when {
            cat.contains("জীবনী", ignoreCase = true) || cat.contains("সাহিত্য", ignoreCase = true) || cat.contains("Classic", ignoreCase = true) ->
                CategoryMeta("অনুপ্রেরণামূলক জীবনী ও ক্লাসিক", "🌟", "বিশ্বসেরা ব্যক্তিত্বদের জীবনসংগ্রাম ও কালজয়ী সাহিত্যের অনুপ্রেরণা")
            cat.contains("ব্যবসা", ignoreCase = true) || cat.contains("ক্যারিয়ার", ignoreCase = true) || cat.contains("Business", ignoreCase = true) || cat.contains("নেতৃত্ব", ignoreCase = true) ->
                CategoryMeta("ক্যারিয়ার, ব্যবসা ও নেতৃত্ব", "💼", "বিজনেস স্ট্র্যাটেজি, উদ্যোগ ও লিডারশিপ গাইড")
            cat.contains("উন্নয়ন", ignoreCase = true) || cat.contains("আত্মউন্নয়ন", ignoreCase = true) || cat.contains("Self", ignoreCase = true) ->
                CategoryMeta("মনস্তত্ত্ব ও আত্মউন্নয়ন", "🧠", "চিন্তার বিকাশ, মানসিক শক্তি ও ইতিবাচক জীবনধারা")
            cat.contains("সময়", ignoreCase = true) || cat.contains("উৎপাদনশীলতা", ignoreCase = true) || cat.contains("Productivity", ignoreCase = true) ->
                CategoryMeta("সময় ব্যবস্থাপনা ও সাফল্য", "⏳", "ফোকাস, শৃঙ্ক্ষলা ও সর্বোচ্চ উৎপাদনশীলতার উপায়")
            cat.contains("শান্তি", ignoreCase = true) || cat.contains("স্বাস্থ্য", ignoreCase = true) || cat.contains("Health", ignoreCase = true) ->
                CategoryMeta("স্বাস্থ্য ও মানসিক শান্তি", "🌱", "সুস্থ শরীর, প্রশান্ত মন ও সুখী জীবন")
            cat.contains("ইসলাম", ignoreCase = true) || cat.contains("ধর্মীয়", ignoreCase = true) || cat.contains("Islamic", ignoreCase = true) ->
                CategoryMeta("ইসলামিক মোটিভেশন ও জ্ঞান", "🕌", "কুরআন-সুন্নাহর আলোকে চরিত্র ও জীবনের দিকনির্দেশনা")
            cat.contains("অর্থ", ignoreCase = true) || cat.contains("সম্পদ", ignoreCase = true) || cat.contains("টাকা", ignoreCase = true) || cat.contains("Money", ignoreCase = true) || cat.contains("Finance", ignoreCase = true) ->
                CategoryMeta("অর্থনীতি ও সম্পদ ব্যবস্থাপনা", "💰", "আর্থিক স্বাধীনতা, সঞ্চয় ও অর্থ ব্যবস্থাপনার নিয়ম")
            else ->
                CategoryMeta(cat, "📚", "সমৃদ্ধ জ্ঞানের অডিওবই সংকলন")
        }
    }
}
