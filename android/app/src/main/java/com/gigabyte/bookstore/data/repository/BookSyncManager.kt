package com.gigabyte.bookstore.data.repository

import android.content.Context
import com.gigabyte.bookstore.data.local.AudiobookDatabase
import com.gigabyte.bookstore.data.models.RemoteBook
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File
import java.io.FileOutputStream
import java.util.concurrent.TimeUnit

sealed class SyncProgressState {
    object Idle : SyncProgressState()
    data class Syncing(
        val completedFiles: Int,
        val totalFiles: Int,
        val percentage: Int,
        val currentFileName: String,
        val userStatus: String
    ) : SyncProgressState()
    data class Completed(val books: List<RemoteBook>, val isFromCacheOnly: Boolean) : SyncProgressState()
    data class Error(val message: String) : SyncProgressState()
}

class BookSyncManager(
    private val context: Context,
    private val database: AudiobookDatabase,
    private val audiobookRepository: AudiobookRepository? = null
) {

    private val firestore: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }
    private val storage: FirebaseStorage by lazy { FirebaseStorage.getInstance() }
    
    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    private val booksDir: File by lazy {
        File(context.filesDir, "book-store").apply { if (!exists()) mkdirs() }
    }

    private val _syncState = MutableStateFlow<SyncProgressState>(SyncProgressState.Idle)
    val syncState: StateFlow<SyncProgressState> = _syncState.asStateFlow()

    private val _cachedBooks = MutableStateFlow<List<RemoteBook>>(emptyList())
    val cachedBooks: StateFlow<List<RemoteBook>> = _cachedBooks.asStateFlow()

    suspend fun syncBooksForUser(userStatus: String): List<RemoteBook> = withContext(Dispatchers.IO) {
        try {
            // 1. Fetch remote book records from Firestore
            val snapshot = firestore.collection("books").get().await()
            val remoteList = mutableListOf<RemoteBook>()

            for (doc in snapshot.documents) {
                val book = RemoteBook(
                    id = doc.id,
                    title = doc.getString("title") ?: "Untitled",
                    subtitle = doc.getString("subtitle"),
                    author = doc.getString("author"),
                    translator = doc.getString("translator"),
                    tagline = doc.getString("tagline"),
                    category = doc.getString("category") ?: "General",
                    language = doc.getString("language") ?: "Bangla",
                    audioUrl = doc.getString("audioUrl"),
                    summaryMdUrl = doc.getString("summaryMdUrl"),
                    summaryMdPath = doc.getString("summaryMdPath"),
                    summaryFilename = doc.getString("summaryFilename"),
                    fullBookMdUrl = doc.getString("fullBookMdUrl"),
                    fullBookMdPath = doc.getString("fullBookMdPath"),
                    fullBookFilename = doc.getString("fullBookFilename"),
                    pdfUrl = doc.getString("pdfUrl"),
                    pdfPath = doc.getString("pdfPath"),
                    pdfFilename = doc.getString("pdfFilename"),
                    coverUrl = doc.getString("coverUrl"),
                    coverPath = doc.getString("coverPath"),
                    summarySnippet = doc.getString("summarySnippet"),
                    totalWords = doc.getLong("totalWords")?.toInt() ?: 0,
                    estimatedMinutes = doc.getLong("estimatedMinutes")?.toInt() ?: 1,
                    hasSummary = doc.getBoolean("hasSummary") ?: false,
                    hasFullBook = doc.getBoolean("hasFullBook") ?: false,
                    hasPdf = doc.getBoolean("hasPdf") ?: false,
                    slug = doc.getString("slug"),
                    publishedAtIso = doc.getString("publishedAtIso")
                )

                // If user status is "trial", include only books that have a summary!
                if (userStatus.equals("trial", ignoreCase = true)) {
                    if (!book.summaryMdUrl.isNullOrBlank()) {
                        remoteList.add(book)
                    }
                } else {
                    remoteList.add(book)
                }
            }

            // 2. Determine which files are missing locally (.md files and covers ONLY)
            data class DownloadTask(
                val bookId: String,
                val fileType: String, // "cover", "summary", "full"
                val url: String,
                val targetFile: File,
                val displayName: String
            )

            val tasksToDownload = mutableListOf<DownloadTask>()

            for (book in remoteList) {
                // Cover file check
                if (!book.coverUrl.isNullOrBlank()) {
                    val coverExt = if (book.coverUrl.contains(".png")) "png" else "jpg"
                    val coverLocal = File(booksDir, "${book.id}_cover.$coverExt")
                    if (coverLocal.exists() && coverLocal.length() > 0) {
                        book.localCoverPath = coverLocal.absolutePath
                    } else {
                        tasksToDownload.add(
                            DownloadTask(book.id, "cover", book.coverUrl, coverLocal, "${book.title} (Cover)")
                        )
                    }
                }

                // Summary Markdown file check (auto-download for both trial & paid)
                if (!book.summaryMdUrl.isNullOrBlank()) {
                    val summaryLocal = File(booksDir, "${book.id}_summary.md")
                    if (summaryLocal.exists() && summaryLocal.length() > 0) {
                        book.localSummaryPath = summaryLocal.absolutePath
                    } else {
                        tasksToDownload.add(
                            DownloadTask(book.id, "summary", book.summaryMdUrl, summaryLocal, "${book.title} (Summary)")
                        )
                    }
                }

                // Full Book Markdown: auto-download only if user is paid
                if (userStatus.equals("paid", ignoreCase = true) || userStatus.equals("active", ignoreCase = true)) {
                    if (!book.fullBookMdUrl.isNullOrBlank()) {
                        val fullLocal = File(booksDir, "${book.id}_full.md")
                        if (fullLocal.exists() && fullLocal.length() > 0) {
                            book.localFullBookPath = fullLocal.absolutePath
                        } else {
                            tasksToDownload.add(
                                DownloadTask(book.id, "full", book.fullBookMdUrl, fullLocal, "${book.title} (Full Book)")
                            )
                        }
                    }
                }

                // PDF file check: NOT auto-downloaded, check if already downloaded manually
                if (!book.pdfUrl.isNullOrBlank()) {
                    val pdfLocal = File(booksDir, "${book.id}.pdf")
                    if (pdfLocal.exists() && pdfLocal.length() > 0) {
                        book.localPdfPath = pdfLocal.absolutePath
                    }
                }
            }


            // 3. Download only missing files with live progress
            val totalFiles = tasksToDownload.size
            var downloadedCount = 0

            if (totalFiles > 0) {
                for (task in tasksToDownload) {
                    val percent = ((downloadedCount.toFloat() / totalFiles) * 100).toInt()
                    _syncState.value = SyncProgressState.Syncing(
                        completedFiles = downloadedCount,
                        totalFiles = totalFiles,
                        percentage = percent,
                        currentFileName = task.displayName,
                        userStatus = userStatus
                    )

                    downloadFile(task.url, task.targetFile)
                    downloadedCount++

                    // Link path to book in list
                    val book = remoteList.find { it.id == task.bookId }
                    if (book != null) {
                        when (task.fileType) {
                            "cover" -> book.localCoverPath = task.targetFile.absolutePath
                            "summary" -> book.localSummaryPath = task.targetFile.absolutePath
                            "full" -> book.localFullBookPath = task.targetFile.absolutePath
                            "pdf" -> book.localPdfPath = task.targetFile.absolutePath
                        }
                    }
                }
            }

            // Index downloaded books into local Room database for offline player & reader access
            for (book in remoteList) {
                val summaryPath = book.localSummaryPath
                if (!summaryPath.isNullOrBlank()) {
                    val file = File(summaryPath)
                    if (file.exists() && file.length() > 0) {
                        audiobookRepository?.importDownloadedBook(
                            file = file,
                            bookId = book.id,
                            title = book.title,
                            author = book.author,
                            coverPath = book.localCoverPath
                        )
                    }
                }
            }

            _cachedBooks.value = remoteList
            _syncState.value = SyncProgressState.Completed(remoteList, isFromCacheOnly = totalFiles == 0)
            remoteList
        } catch (e: Exception) {
            e.printStackTrace()
            // On error / offline: build list from local disk
            val offlineList = loadOfflineCachedBooks(userStatus)
            _cachedBooks.value = offlineList
            _syncState.value = SyncProgressState.Completed(offlineList, isFromCacheOnly = true)
            offlineList
        }
    }

    private fun downloadFile(url: String, destination: File) {
        try {
            val request = Request.Builder().url(url).build()
            okHttpClient.newCall(request).execute().use { response ->
                if (!response.isSuccessful) return
                response.body?.byteStream()?.use { input ->
                    FileOutputStream(destination).use { output ->
                        input.copyTo(output)
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun getPdfLocalFile(bookId: String): File {
        return File(booksDir, "$bookId.pdf")
    }

    suspend fun downloadPdfManually(
        bookId: String,
        providedPdfUrl: String? = null,
        providedPdfPath: String? = null,
        bookTitle: String? = null,
        onProgress: (Int) -> Unit = {}
    ): Result<File> = withContext(Dispatchers.IO) {
        try {
            val destination = getPdfLocalFile(bookId)
            destination.parentFile?.mkdirs()

            var effectivePdfUrl = providedPdfUrl
            var effectivePdfPath = providedPdfPath

            // If neither URL nor Path is known, check in cached books
            if (effectivePdfUrl.isNullOrBlank() && effectivePdfPath.isNullOrBlank()) {
                val cached = _cachedBooks.value.find {
                    it.id == bookId ||
                    it.slug == bookId ||
                    (!bookTitle.isNullOrBlank() && it.title.equals(bookTitle, ignoreCase = true))
                }
                if (cached != null) {
                    effectivePdfUrl = cached.pdfUrl
                    effectivePdfPath = cached.pdfPath
                }
            }

            // If still missing, query Firestore directly
            if (effectivePdfUrl.isNullOrBlank() && effectivePdfPath.isNullOrBlank()) {
                try {
                    val doc = firestore.collection("books").document(bookId).get().await()
                    if (doc.exists()) {
                        effectivePdfUrl = doc.getString("pdfUrl")
                        effectivePdfPath = doc.getString("pdfPath")
                    } else {
                        val bySlug = firestore.collection("books").whereEqualTo("slug", bookId).get().await()
                        val slugDoc = bySlug.documents.firstOrNull()
                        if (slugDoc != null) {
                            effectivePdfUrl = slugDoc.getString("pdfUrl")
                            effectivePdfPath = slugDoc.getString("pdfPath")
                        } else if (!bookTitle.isNullOrBlank()) {
                            val byTitle = firestore.collection("books").whereEqualTo("title", bookTitle).get().await()
                            val titleDoc = byTitle.documents.firstOrNull()
                            if (titleDoc != null) {
                                effectivePdfUrl = titleDoc.getString("pdfUrl")
                                effectivePdfPath = titleDoc.getString("pdfPath")
                            }
                        }
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            // If still missing, but destination file already exists and is non-empty, use it
            if (effectivePdfUrl.isNullOrBlank() && effectivePdfPath.isNullOrBlank()) {
                if (destination.exists() && destination.length() > 0) {
                    return@withContext Result.success(destination)
                }
                return@withContext Result.failure(Exception("এই বইয়ের কোনো পিডিএফ লিঙ্ক বা ফাইল ক্লাউডে পাওয়া যায়নি।"))
            }

            var downloadSuccess = false
            var lastError: Exception? = null

            // 1. Try downloading via HTTP if valid url
            if (!effectivePdfUrl.isNullOrBlank() && (effectivePdfUrl.startsWith("http://") || effectivePdfUrl.startsWith("https://"))) {
                try {
                    val request = Request.Builder().url(effectivePdfUrl).build()
                    val response = okHttpClient.newCall(request).execute()

                    if (response.isSuccessful) {
                        val body = response.body
                        if (body != null) {
                            val contentLength = body.contentLength()
                            body.byteStream().use { input ->
                                FileOutputStream(destination).use { output ->
                                    val buffer = ByteArray(8 * 1024)
                                    var bytesRead: Int
                                    var totalRead = 0L

                                    while (input.read(buffer).also { bytesRead = it } != -1) {
                                        output.write(buffer, 0, bytesRead)
                                        totalRead += bytesRead
                                        if (contentLength > 0) {
                                            val progress = ((totalRead * 100) / contentLength).toInt()
                                            onProgress(progress.coerceIn(0, 100))
                                        }
                                    }
                                    output.flush()
                                }
                            }
                            if (destination.exists() && destination.length() > 0) {
                                downloadSuccess = true
                            }
                        }
                    } else {
                        lastError = Exception("HTTP Error: ${response.code}")
                    }
                } catch (e: Exception) {
                    lastError = e
                }
            }

            // 2. If OkHttp download didn't succeed, try Firebase Storage SDK directly
            if (!downloadSuccess) {
                try {
                    val storageRef = when {
                        !effectivePdfPath.isNullOrBlank() -> storage.reference.child(effectivePdfPath)
                        !effectivePdfUrl.isNullOrBlank() && effectivePdfUrl.contains("firebasestorage.googleapis.com") -> {
                            storage.getReferenceFromUrl(effectivePdfUrl)
                        }
                        else -> null
                    }

                    if (storageRef != null) {
                        val task = storageRef.getFile(destination)
                        task.addOnProgressListener { snapshot ->
                            if (snapshot.totalByteCount > 0) {
                                val progress = ((snapshot.bytesTransferred * 100) / snapshot.totalByteCount).toInt()
                                onProgress(progress.coerceIn(0, 100))
                            }
                        }.await()

                        if (destination.exists() && destination.length() > 0) {
                            downloadSuccess = true
                        }
                    }
                } catch (storageEx: Exception) {
                    storageEx.printStackTrace()
                    lastError = storageEx
                }
            }

            if (downloadSuccess) {
                val book = _cachedBooks.value.find { it.id == bookId }
                if (book != null) {
                    book.localPdfPath = destination.absolutePath
                }
                Result.success(destination)
            } else {
                Result.failure(lastError ?: Exception("পিডিএফ ডাউনলোড সম্পন্ন হয়নি"))
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    private fun loadOfflineCachedBooks(userStatus: String): List<RemoteBook> {
        val files = booksDir.listFiles { _, name -> name.endsWith("_summary.md") } ?: return emptyList()
        return files.map { summaryFile ->
            val bookId = summaryFile.name.removeSuffix("_summary.md")
            val cover = File(booksDir, "${bookId}_cover.jpg").takeIf { it.exists() }
                ?: File(booksDir, "${bookId}_cover.png").takeIf { it.exists() }
            val fullBook = File(booksDir, "${bookId}_full.md").takeIf { it.exists() && it.length() > 0 }
            val pdf = File(booksDir, "${bookId}.pdf").takeIf { it.exists() && it.length() > 0 }

            val contentSnippet = try {
                summaryFile.bufferedReader().use { it.readLines().take(5).joinToString(" ") }
            } catch (e: Exception) { "" }

            val titleGuess = summaryFile.name.removeSuffix("_summary.md").replace("_", " ")

            RemoteBook(
                id = bookId,
                title = titleGuess,
                summarySnippet = contentSnippet,
                localSummaryPath = summaryFile.absolutePath,
                localFullBookPath = fullBook?.absolutePath,
                localPdfPath = pdf?.absolutePath,
                localCoverPath = cover?.absolutePath,
                hasSummary = true,
                hasFullBook = fullBook != null,
                hasPdf = pdf != null
            )
        }
    }
}

