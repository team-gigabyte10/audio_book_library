package com.gigabyte.bookstore.presentation.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.gigabyte.bookstore.BanglaAudiobookApp
import com.gigabyte.bookstore.data.local.entities.PlaybackHistoryEntity
import com.gigabyte.bookstore.data.models.AudioBundle
import com.gigabyte.bookstore.data.models.Course
import com.gigabyte.bookstore.data.models.HeroBanner
import com.gigabyte.bookstore.data.models.PlaybackState
import com.gigabyte.bookstore.data.models.RemoteBook
import com.gigabyte.bookstore.data.repository.HomeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

import com.gigabyte.bookstore.data.models.CourseLesson

enum class HomeTab {
    BUNDLES,
    COURSES
}

data class HomeUiState(
    val isLoading: Boolean = true,
    val isRefreshing: Boolean = false,
    val banners: List<HeroBanner> = emptyList(),
    val audioBundles: List<AudioBundle> = emptyList(),
    val englishCourses: List<Course> = emptyList(),
    val japaneseCourses: List<Course> = emptyList(),
    val trendingBooks: List<RemoteBook> = emptyList(),
    val errorMessage: String? = null
)

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val app = application as BanglaAudiobookApp
    private val homeRepository = HomeRepository()
    private val bookRepository = app.repository
    val player = app.player

    private val _selectedTab = MutableStateFlow(HomeTab.BUNDLES)
    val selectedTab: StateFlow<HomeTab> = _selectedTab.asStateFlow()

    fun selectTab(tab: HomeTab) {
        _selectedTab.value = tab
    }

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    val lastPlayed: StateFlow<PlaybackHistoryEntity?> = bookRepository.lastPlayedHistory
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    val playbackState: StateFlow<PlaybackState> = player.playbackState

    val userName: StateFlow<String> = app.appPreferences.userName
    val userEmail: StateFlow<String> = app.appPreferences.userEmail
    val userStatus: StateFlow<String> = app.appPreferences.userStatus
    val userBalance: StateFlow<Double> = app.appPreferences.userBalance
    val userInstitute: StateFlow<String> = app.appPreferences.userInstitute
    val unlockedBundles: StateFlow<Set<String>> = app.appPreferences.unlockedBundles

    fun isBundleUnlocked(bundleId: String): Boolean = app.appPreferences.isBundleUnlocked(bundleId)

    fun playCourseLesson(course: Course, lesson: CourseLesson) {
        val markdown = lesson.content.ifBlank {
            getSampleLessonMarkdown(course, lesson)
        }
        player.loadAndPlayLesson(
            courseId = course.id,
            courseTitle = course.title,
            lessonTitle = lesson.title,
            markdownContent = markdown,
            language = course.language,
            coverPath = course.thumbnailUrl ?: course.bannerUrl,
            autoPlay = true
        )
    }

    private fun getSampleLessonMarkdown(course: Course, lesson: CourseLesson): String {
        val isJapanese = course.language.equals("Japanese", ignoreCase = true)
        return if (isJapanese) {
            """
            # ${lesson.title}
            
            1. おはようございます。
            2. こんにちは。
            3. こんばんは。
            4. はじめまして。
            5. どうぞよろしくおねがいします。
            6. ありがとう ございます。
            7. また あした。
            """.trimIndent()
        } else {
            """
            # ${lesson.title}
            
            1. Hello! How are you doing today?
            2. I am doing very well, thank you!
            3. Could you please introduce yourself?
            4. It is a pleasure to meet you.
            5. Practice these sentences daily for native fluency.
            6. Have a wonderful day ahead!
            """.trimIndent()
        }
    }

    init {
        loadHomeData()
    }

    fun loadHomeData(isRefresh: Boolean = false) {
        viewModelScope.launch {
            if (isRefresh) {
                _uiState.value = _uiState.value.copy(isRefreshing = true, errorMessage = null)
            } else {
                _uiState.value = _uiState.value.copy(isLoading = true, errorMessage = null)
            }

            try {
                val banners = homeRepository.getBanners()
                val bundles = homeRepository.getAudioBundles()
                val englishCourses = homeRepository.getCourses("English")
                val japaneseCourses = homeRepository.getCourses("Japanese")
                val trendingBooks = homeRepository.getTrendingBooks()

                _uiState.value = HomeUiState(
                    isLoading = false,
                    isRefreshing = false,
                    banners = banners,
                    audioBundles = bundles,
                    englishCourses = englishCourses,
                    japaneseCourses = japaneseCourses,
                    trendingBooks = trendingBooks,
                    errorMessage = null
                )
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    isRefreshing = false,
                    errorMessage = "তথ্য লোড করতে সমস্যা হয়েছে: ${e.localizedMessage}"
                )
            }
        }
    }

    fun continueLastPlayed() {
        viewModelScope.launch {
            val history = lastPlayed.value ?: return@launch
            val book = bookRepository.getBookById(history.bookId) ?: return@launch
            player.loadAndPlayBook(
                book = book,
                startChapterIndex = history.chapterIndex,
                startChunkIndex = history.chunkIndex,
                autoPlay = true
            )
        }
    }
}
