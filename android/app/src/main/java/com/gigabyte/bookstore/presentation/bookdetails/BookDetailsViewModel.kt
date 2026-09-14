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

import android.content.Context
import android.net.Uri
import androidx.core.content.FileProvider
import com.gigabyte.bookstore.data.repository.BookSyncManager
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.io.File

class BookDetailsViewModel(
    application: Application,
    private val bookId: String
) : AndroidViewModel(application) {

    private val app = application as BanglaAudiobookApp
    private val repository = app.repository
    val player = app.player
    val appPreferences = app.appPreferences
    val syncManager = app.syncManager
    private val firestore: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }

    val userStatus: StateFlow<String> = appPreferences.userStatus

    private val _book = MutableStateFlow<Book?>(null)
    val book: StateFlow<Book?> = _book.asStateFlow()

    private val _chapters = MutableStateFlow<List<Chapter>>(emptyList())
    val chapters: StateFlow<List<Chapter>> = _chapters.asStateFlow()

    private val _history = MutableStateFlow<PlaybackHistoryEntity?>(null)
    val history: StateFlow<PlaybackHistoryEntity?> = _history.asStateFlow()

    val playbackState: StateFlow<PlaybackState> = player.playbackState

    private val booksDir: File by lazy {
        File(application.filesDir, "book-store").apply { if (!exists()) mkdirs() }
    }

    private val _isPdfDownloaded = MutableStateFlow(false)
    val isPdfDownloaded: StateFlow<Boolean> = _isPdfDownloaded.asStateFlow()

    private val _isFullBookDownloaded = MutableStateFlow(false)
    val isFullBookDownloaded: StateFlow<Boolean> = _isFullBookDownloaded.asStateFlow()

    private val _pdfDownloadProgress = MutableStateFlow<Int?>(null)
    val pdfDownloadProgress: StateFlow<Int?> = _pdfDownloadProgress.asStateFlow()

    // We can also track the remote PDF URL & Path from Firestore or cached books
    private val _remotePdfUrl = MutableStateFlow<String?>(null)
    val remotePdfUrl: StateFlow<String?> = _remotePdfUrl.asStateFlow()

    private val _remotePdfPath = MutableStateFlow<String?>(null)
    val remotePdfPath: StateFlow<String?> = _remotePdfPath.asStateFlow()

    private val _downloadErrorMessage = MutableStateFlow<String?>(null)
    val downloadErrorMessage: StateFlow<String?> = _downloadErrorMessage.asStateFlow()

    private val _downloadSuccessMessage = MutableStateFlow<String?>(null)
    val downloadSuccessMessage: StateFlow<String?> = _downloadSuccessMessage.asStateFlow()

    fun clearMessages() {
        _downloadErrorMessage.value = null
        _downloadSuccessMessage.value = null
    }

    init {
        loadBookDetails()
        checkLocalFiles()
        viewModelScope.launch {
            resolvePdfUrl()
        }
    }

    fun checkLocalFiles() {
        val pdfFile = File(booksDir, "$bookId.pdf")
        _isPdfDownloaded.value = pdfFile.exists() && pdfFile.length() > 0

        val fullFile = File(booksDir, "${bookId}_full.md")
        _isFullBookDownloaded.value = fullFile.exists() && fullFile.length() > 0

        // Find remote book URL if available in cached books
        val cached = syncManager.cachedBooks.value.find {
            it.id == bookId || it.slug == bookId
        }
        if (cached != null) {
            if (!cached.pdfUrl.isNullOrBlank()) _remotePdfUrl.value = cached.pdfUrl
            if (!cached.pdfPath.isNullOrBlank()) _remotePdfPath.value = cached.pdfPath
        }
    }

    private fun loadBookDetails() {
        viewModelScope.launch {
            _book.value = repository.getBookById(bookId)
            checkLocalFiles()
            resolvePdfUrl()
            repository.getChaptersForBook(bookId).collect {
                _chapters.value = it
            }
        }
        viewModelScope.launch {
            _history.value = repository.getHistoryForBook(bookId)
        }
    }

    suspend fun resolvePdfUrl(): Pair<String?, String?> = withContext(Dispatchers.IO) {
        if (!_remotePdfUrl.value.isNullOrBlank() || !_remotePdfPath.value.isNullOrBlank()) {
            return@withContext Pair(_remotePdfUrl.value, _remotePdfPath.value)
        }

        // 1. Check in cachedBooks
        val cached = syncManager.cachedBooks.value.find {
            it.id == bookId ||
            it.slug == bookId ||
            (_book.value?.title != null && it.title.equals(_book.value?.title, ignoreCase = true))
        }
        if (cached != null && (!cached.pdfUrl.isNullOrBlank() || !cached.pdfPath.isNullOrBlank())) {
            _remotePdfUrl.value = cached.pdfUrl
            _remotePdfPath.value = cached.pdfPath
            return@withContext Pair(cached.pdfUrl, cached.pdfPath)
        }

        // 2. Query Firestore directly
        try {
            // Direct by ID
            val doc = firestore.collection("books").document(bookId).get().await()
            if (doc.exists()) {
                val url = doc.getString("pdfUrl")
                val path = doc.getString("pdfPath")
                if (!url.isNullOrBlank() || !path.isNullOrBlank()) {
                    _remotePdfUrl.value = url
                    _remotePdfPath.value = path
                    return@withContext Pair(url, path)
                }
            }

            // Query by slug
            val bySlug = firestore.collection("books").whereEqualTo("slug", bookId).get().await()
            val slugDoc = bySlug.documents.firstOrNull()
            if (slugDoc != null) {
                val url = slugDoc.getString("pdfUrl")
                val path = slugDoc.getString("pdfPath")
                if (!url.isNullOrBlank() || !path.isNullOrBlank()) {
                    _remotePdfUrl.value = url
                    _remotePdfPath.value = path
                    return@withContext Pair(url, path)
                }
            }

            // Query by title
            val currentTitle = _book.value?.title
            if (!currentTitle.isNullOrBlank()) {
                val byTitle = firestore.collection("books").whereEqualTo("title", currentTitle).get().await()
                val titleDoc = byTitle.documents.firstOrNull()
                if (titleDoc != null) {
                    val url = titleDoc.getString("pdfUrl")
                    val path = titleDoc.getString("pdfPath")
                    if (!url.isNullOrBlank() || !path.isNullOrBlank()) {
                        _remotePdfUrl.value = url
                        _remotePdfPath.value = path
                        return@withContext Pair(url, path)
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        Pair(null, null)
    }

    fun downloadPdf() {
        if (_isPdfDownloaded.value) return
        _pdfDownloadProgress.value = 0
        _downloadErrorMessage.value = null
        _downloadSuccessMessage.value = null

        viewModelScope.launch {
            val (resolvedUrl, resolvedPath) = resolvePdfUrl()
            val currentTitle = _book.value?.title

            val result = syncManager.downloadPdfManually(
                bookId = bookId,
                providedPdfUrl = resolvedUrl,
                providedPdfPath = resolvedPath,
                bookTitle = currentTitle,
                onProgress = { progress ->
                    _pdfDownloadProgress.value = progress
                }
            )

            result.fold(
                onSuccess = { file ->
                    _pdfDownloadProgress.value = null
                    _isPdfDownloaded.value = file.exists() && file.length() > 0
                    _downloadSuccessMessage.value = "পিডিএফ সফলভাবে ডাউনলোড করা হয়েছে!"
                },
                onFailure = { error ->
                    _pdfDownloadProgress.value = null
                    _downloadErrorMessage.value = error.localizedMessage ?: "পিডিএফ ডাউনলোড ব্যর্থ হয়েছে"
                }
            )
        }
    }

    fun getPdfFileUri(context: Context): Uri? {
        val file = File(booksDir, "$bookId.pdf")
        if (!file.exists() || file.length() == 0L) return null
        return try {
            FileProvider.getUriForFile(
                context,
                "${context.packageName}.fileprovider",
                file
            )
        } catch (e: Exception) {
            e.printStackTrace()
            null
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

