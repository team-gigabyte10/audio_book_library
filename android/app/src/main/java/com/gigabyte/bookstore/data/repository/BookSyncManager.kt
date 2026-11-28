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
import kotlinx.coroutines.withTimeoutOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import org.json.JSONObject
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

    private val catalogFile: File by lazy {
        File(context.filesDir, "cached_catalog_books.json")
    }

    private val _syncState = MutableStateFlow<SyncProgressState>(SyncProgressState.Idle)
    val syncState: StateFlow<SyncProgressState> = _syncState.asStateFlow()

    private val _cachedBooks = MutableStateFlow<List<RemoteBook>>(emptyList())
    val cachedBooks: StateFlow<List<RemoteBook>> = _cachedBooks.asStateFlow()

    init {
        try {
            val initialDiskBooks = loadCatalogFromDisk()
            if (initialDiskBooks.isNotEmpty()) {
                _cachedBooks.value = initialDiskBooks
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    suspend fun syncBooksForUser(userStatus: String): List<RemoteBook> = withContext(Dispatchers.IO) {
        try {
            // 1. Fetch remote book records from Firestore
            val snapshot = firestore.collection("books").get().await()
            val remoteList = mutableListOf<RemoteBook>()

            for (doc in snapshot.documents) {
                val rawPdfUrl = doc.getString("pdfUrl")
                val rawPdfDriveUrl = doc.getString("pdfDriveUrl")
                val effectivePdfUrl = rawPdfUrl?.takeIf { it.isNotBlank() } ?: rawPdfDriveUrl?.takeIf { it.isNotBlank() }

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
                    pdfUrl = effectivePdfUrl,
                    pdfDriveUrl = rawPdfDriveUrl,
                    pdfPath = doc.getString("pdfPath"),
                    pdfFilename = doc.getString("pdfFilename"),
                    coverUrl = doc.getString("coverUrl"),
                    coverPath = doc.getString("coverPath"),
                    summarySnippet = doc.getString("summarySnippet"),
                    totalWords = doc.getLong("totalWords")?.toInt() ?: 0,
                    estimatedMinutes = doc.getLong("estimatedMinutes")?.toInt() ?: 1,
                    hasSummary = doc.getBoolean("hasSummary") ?: (!doc.getString("summaryMdUrl").isNullOrBlank() || !doc.getString("summaryMdPath").isNullOrBlank()),
                    hasFullBook = doc.getBoolean("hasFullBook") ?: (!doc.getString("fullBookMdUrl").isNullOrBlank() || !doc.getString("fullBookMdPath").isNullOrBlank()),
                    hasPdf = doc.getBoolean("hasPdf") ?: (!effectivePdfUrl.isNullOrBlank() || !doc.getString("pdfPath").isNullOrBlank()),
                    slug = doc.getString("slug"),
                    publishedAtIso = doc.getString("publishedAtIso")
                )

                // Include all books from Firestore so the library displays the entire catalog
                remoteList.add(book)
            }

            // 2. Fast Metadata Sync: link existing local files without blocking splash screen.
            // Covers are loaded & cached dynamically by Coil AsyncImage from coverUrl.
            // Full & Summary Markdown books are loaded on demand when a user taps to read or play.
            for (book in remoteList) {
                // Cover file check (if already cached on disk)
                if (!book.coverUrl.isNullOrBlank()) {
                    val coverExt = if (book.coverUrl.contains(".png")) "png" else "jpg"
                    val coverLocal = File(booksDir, "${book.id}_cover.$coverExt")
                    if (coverLocal.exists() && coverLocal.length() > 0) {
                        book.localCoverPath = coverLocal.absolutePath
                    }
                }

                // Summary Markdown file check (if already downloaded)
                if (!book.summaryMdUrl.isNullOrBlank()) {
                    val summaryLocal = File(booksDir, "${book.id}_summary.md")
                    if (summaryLocal.exists() && summaryLocal.length() > 0) {
                        book.localSummaryPath = summaryLocal.absolutePath
                    }
                }

                // Full Book Markdown file check (if already downloaded)
                if (!book.fullBookMdUrl.isNullOrBlank()) {
                    val fullLocal = File(booksDir, "${book.id}_full.md")
                    if (fullLocal.exists() && fullLocal.length() > 0) {
                        book.localFullBookPath = fullLocal.absolutePath
                    }
                }

                // PDF file check
                if (!book.pdfUrl.isNullOrBlank()) {
                    val pdfLocal = File(booksDir, "${book.id}.pdf")
                    if (pdfLocal.exists() && pdfLocal.length() > 0) {
                        book.localPdfPath = pdfLocal.absolutePath
                    }
                }
            }

            // 3. Immediately index all books into Room so the library populates in 1-2 seconds.
            // Placeholder records are created for any non-downloaded books with remote cover URLs.
            for (book in remoteList) {
                val summaryPath = book.localSummaryPath
                val fullPath = book.localFullBookPath
                var primaryImported = false

                // 1. If summary markdown exists, import it as primary book (book.id)
                if (!summaryPath.isNullOrBlank()) {
                    val file = File(summaryPath)
                    if (file.exists() && file.length() > 0) {
                        audiobookRepository?.importDownloadedBook(
                            file = file,
                            bookId = book.id,
                            title = book.title,
                            author = book.author,
                            coverPath = book.localCoverPath ?: book.coverUrl
                        )
                        primaryImported = true
                    }
                }

                // 2. If no summary, but full markdown exists, import full book as primary book (book.id)
                if (!primaryImported && !fullPath.isNullOrBlank()) {
                    val file = File(fullPath)
                    if (file.exists() && file.length() > 0) {
                        audiobookRepository?.importDownloadedBook(
                            file = file,
                            bookId = book.id,
                            title = book.title,
                            author = book.author,
                            coverPath = book.localCoverPath ?: book.coverUrl
                        )
                        primaryImported = true
                    }
                }

                // 3. Always import full book under "${book.id}_full" if full file exists
                if (!fullPath.isNullOrBlank()) {
                    val fullFile = File(fullPath)
                    if (fullFile.exists() && fullFile.length() > 0) {
                        audiobookRepository?.importDownloadedBook(
                            file = fullFile,
                            bookId = "${book.id}_full",
                            title = "${book.title} (সম্পূর্ণ)",
                            author = book.author,
                            coverPath = book.localCoverPath ?: book.coverUrl
                        )
                    }
                }

                // 4. If neither markdown file is downloaded yet, ensure placeholder entry in Room
                if (!primaryImported) {
                    audiobookRepository?.ensureBookPlaceholder(
                        bookId = book.id,
                        title = book.title,
                        author = book.author,
                        coverPath = book.localCoverPath ?: book.coverUrl,
                        description = book.subtitle ?: book.tagline
                    )
                }
            }

            _cachedBooks.value = remoteList
            // Persist full catalog to local disk so it is always available 100% offline
            saveCatalogToDisk(remoteList)
            // Instant sync complete! Splash screen opens library in 1-2s.
            _syncState.value = SyncProgressState.Completed(remoteList, isFromCacheOnly = false)
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

    private fun convertDriveUrlToDirectDownload(url: String): String {
        if (!url.contains("drive.google.com")) return url
        val fileId = when {
            url.contains("/file/d/") -> {
                url.substringAfter("/file/d/").substringBefore("/").substringBefore("?")
            }
            url.contains("id=") -> {
                url.substringAfter("id=").substringBefore("&")
            }
            else -> null
        }
        return if (!fileId.isNullOrBlank()) {
            "https://drive.google.com/uc?export=download&id=$fileId"
        } else {
            url
        }
    }

    suspend fun downloadMarkdownFile(
        url: String?,
        storagePath: String?,
        destination: File
    ): Boolean = withContext(Dispatchers.IO) {
        try {
            destination.parentFile?.mkdirs()
            if (!url.isNullOrBlank()) {
                val effectiveUrl = convertDriveUrlToDirectDownload(url)
                val request = Request.Builder().url(effectiveUrl).build()
                okHttpClient.newCall(request).execute().use { response ->
                    if (response.isSuccessful) {
                        response.body?.byteStream()?.use { input ->
                            FileOutputStream(destination).use { output ->
                                input.copyTo(output)
                            }
                        }
                    }
                }
            }

            if (destination.exists() && destination.length() > 0) {
                return@withContext true
            }

            val cleanStoragePath = storagePath?.trim()?.trimStart('/')
            val storageRef = when {
                !cleanStoragePath.isNullOrBlank() -> storage.reference.child(cleanStoragePath)
                !url.isNullOrBlank() && url.contains("firebasestorage.googleapis.com") -> {
                    try { storage.getReferenceFromUrl(url) } catch (e: Exception) { null }
                }
                else -> null
            }

            if (storageRef != null) {
                storageRef.getFile(destination).await()
                return@withContext destination.exists() && destination.length() > 0
            }

            false
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    /**
     * Downloads a single book's markdown (summary or full) on-demand when the user opens or plays it,
     * and automatically indexes it into Room.
     * Takes ~200-500ms instead of mass-downloading 100+ books upfront.
     */
    suspend fun ensureBookDownloadedOnDemand(
        bookId: String,
        isFull: Boolean = false
    ): File? = withContext(Dispatchers.IO) {
        val cleanBookId = if (isFull) bookId.removeSuffix("_full") else bookId
        val targetFileName = if (isFull) "${cleanBookId}_full.md" else "${cleanBookId}_summary.md"
        val targetFile = File(booksDir, targetFileName)

        if (targetFile.exists() && targetFile.length() > 0) {
            val importBookId = if (isFull) "${cleanBookId}_full" else cleanBookId
            ensureFileImportedIntoRoom(targetFile, importBookId, cleanBookId, isFull)
            return@withContext targetFile
        }
        val altFile = if (isFull) File(booksDir, "${cleanBookId}_summary.md") else File(booksDir, "${cleanBookId}_full.md")
        if (altFile.exists() && altFile.length() > 0) {
            val importBookId = if (isFull) "${cleanBookId}_full" else cleanBookId
            ensureFileImportedIntoRoom(altFile, importBookId, cleanBookId, isFull)
            return@withContext altFile
        }

        var book = cachedBooks.value.find { it.id == cleanBookId || it.slug == cleanBookId }
        if (book == null) {
            try {
                val doc = withTimeoutOrNull(1500L) {
                    firestore.collection("books").document(cleanBookId).get().await()
                }
                if (doc != null && doc.exists()) {
                    val rawPdfUrl = doc.getString("pdfUrl")
                    val rawPdfDriveUrl = doc.getString("pdfDriveUrl")
                    val effectivePdfUrl = rawPdfUrl?.takeIf { it.isNotBlank() } ?: rawPdfDriveUrl?.takeIf { it.isNotBlank() }

                    book = RemoteBook(
                        id = doc.id,
                        title = doc.getString("title") ?: "বই",
                        subtitle = doc.getString("subtitle"),
                        author = doc.getString("author"),
                        category = doc.getString("category") ?: "সাধারণ",
                        summaryMdUrl = doc.getString("summaryMdUrl"),
                        summaryMdPath = doc.getString("summaryMdPath"),
                        fullBookMdUrl = doc.getString("fullBookMdUrl"),
                        fullBookMdPath = doc.getString("fullBookMdPath"),
                        pdfUrl = effectivePdfUrl,
                        pdfDriveUrl = rawPdfDriveUrl,
                        coverUrl = doc.getString("coverUrl")
                    )
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        val hasSummary = !book?.summaryMdUrl.isNullOrBlank() || !book?.summaryMdPath.isNullOrBlank()
        val mdUrl = if (isFull || !hasSummary) (book?.fullBookMdUrl ?: book?.summaryMdUrl) else (book?.summaryMdUrl ?: book?.fullBookMdUrl)
        val mdPath = if (isFull || !hasSummary) (book?.fullBookMdPath ?: book?.summaryMdPath) else (book?.summaryMdPath ?: book?.fullBookMdPath)

        if (mdUrl.isNullOrBlank() && mdPath.isNullOrBlank()) {
            return@withContext null
        }

        val effectiveDestination = if (!hasSummary && !isFull) File(booksDir, "${cleanBookId}_full.md") else targetFile
        val downloaded = downloadMarkdownFile(mdUrl, mdPath, effectiveDestination)
        if (downloaded && effectiveDestination.exists() && effectiveDestination.length() > 0) {
            val importBookId = if (isFull) "${cleanBookId}_full" else cleanBookId
            val title = if (isFull) "${book?.title ?: "বই"} (সম্পূর্ণ)" else (book?.title ?: "বই")
            audiobookRepository?.importDownloadedBook(
                file = effectiveDestination,
                bookId = importBookId,
                title = title,
                author = book?.author,
                coverPath = book?.localCoverPath ?: book?.coverUrl
            )
            // If there's no summary, also register cleanBookId so both normal and full routes find the book
            if (!hasSummary && isFull) {
                audiobookRepository?.importDownloadedBook(
                    file = effectiveDestination,
                    bookId = cleanBookId,
                    title = book?.title ?: "বই",
                    author = book?.author,
                    coverPath = book?.localCoverPath ?: book?.coverUrl
                )
            }
            return@withContext effectiveDestination
        }
        null
    }

    private suspend fun ensureFileImportedIntoRoom(
        file: File,
        importBookId: String,
        cleanBookId: String,
        isFull: Boolean
    ) {
        val repo = audiobookRepository ?: return
        val existingChapters = repo.getChaptersForBookSync(importBookId)
        val existingBook = repo.getBookById(importBookId)
        if (existingBook == null || existingChapters.isEmpty() || existingBook.filePath.isBlank()) {
            val cached = _cachedBooks.value.find { it.id == cleanBookId || it.slug == cleanBookId }
            val title = if (isFull) {
                "${cached?.title ?: cleanBookId} (সম্পূর্ণ)"
            } else {
                cached?.title ?: cleanBookId
            }
            repo.importDownloadedBook(
                file = file,
                bookId = importBookId,
                title = title,
                author = cached?.author,
                coverPath = cached?.localCoverPath ?: cached?.coverUrl
            )
            if (isFull && repo.getBookById(cleanBookId) == null) {
                repo.importDownloadedBook(
                    file = file,
                    bookId = cleanBookId,
                    title = cached?.title ?: cleanBookId,
                    author = cached?.author,
                    coverPath = cached?.localCoverPath ?: cached?.coverUrl
                )
            }
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

    private suspend fun loadOfflineCachedBooks(userStatus: String): List<RemoteBook> {
        val diskCatalog = loadCatalogFromDisk()
        if (diskCatalog.isNotEmpty()) {
            for (book in diskCatalog) {
                val summaryFile = File(booksDir, "${book.id}_summary.md").takeIf { it.exists() && it.length() > 0 }
                val fullBookFile = File(booksDir, "${book.id}_full.md").takeIf { it.exists() && it.length() > 0 }
                val primaryFile = summaryFile ?: fullBookFile
                if (primaryFile != null) {
                    audiobookRepository?.importDownloadedBook(
                        file = primaryFile,
                        bookId = book.id,
                        title = book.title,
                        author = book.author,
                        coverPath = book.localCoverPath ?: book.coverUrl
                    )
                }
                if (fullBookFile != null) {
                    audiobookRepository?.importDownloadedBook(
                        file = fullBookFile,
                        bookId = "${book.id}_full",
                        title = "${book.title} (সম্পূর্ণ)",
                        author = book.author,
                        coverPath = book.localCoverPath ?: book.coverUrl
                    )
                }
            }
            return diskCatalog
        }

        val allFiles = booksDir.listFiles() ?: return emptyList()
        val bookIds = allFiles
            .map { it.name }
            .filter { it.endsWith("_summary.md") || it.endsWith("_full.md") || it.endsWith(".pdf") }
            .map {
                it.removeSuffix("_summary.md")
                    .removeSuffix("_full.md")
                    .removeSuffix(".pdf")
            }
            .distinct()

        return bookIds.map { bookId ->
            val summaryFile = File(booksDir, "${bookId}_summary.md").takeIf { it.exists() && it.length() > 0 }
            val fullBookFile = File(booksDir, "${bookId}_full.md").takeIf { it.exists() && it.length() > 0 }
            val pdfFile = File(booksDir, "${bookId}.pdf").takeIf { it.exists() && it.length() > 0 }
            val cover = File(booksDir, "${bookId}_cover.jpg").takeIf { it.exists() }
                ?: File(booksDir, "${bookId}_cover.png").takeIf { it.exists() }

            val titleGuess = if (bookId == "hasir_golpo_50") "হাসির গল্প সংকলন" else bookId.replace("_", " ")
            val authorGuess = if (bookId == "hasir_golpo_50") "নির্বাচিত লোকজ ও ধ্রুপদী সাহিত্য" else null
            val categoryGuess = if (bookId == "hasir_golpo_50") "হাসির গল্প ও নির্মল বিনোদন" else "আত্মউন্নয়ন"

            if (summaryFile != null) {
                audiobookRepository?.importDownloadedBook(
                    file = summaryFile,
                    bookId = bookId,
                    title = titleGuess,
                    author = authorGuess,
                    coverPath = cover?.absolutePath
                )
            } else if (fullBookFile != null) {
                audiobookRepository?.importDownloadedBook(
                    file = fullBookFile,
                    bookId = bookId,
                    title = titleGuess,
                    author = authorGuess,
                    coverPath = cover?.absolutePath
                )
            }

            if (fullBookFile != null) {
                audiobookRepository?.importDownloadedBook(
                    file = fullBookFile,
                    bookId = "${bookId}_full",
                    title = "$titleGuess (সম্পূর্ণ)",
                    author = authorGuess,
                    coverPath = cover?.absolutePath
                )
            }

            val contentSnippet = try {
                (summaryFile ?: fullBookFile)?.bufferedReader()?.use { it.readLines().take(5).joinToString(" ") } ?: ""
            } catch (e: Exception) { "" }

            RemoteBook(
                id = bookId,
                title = titleGuess,
                author = authorGuess,
                category = categoryGuess,
                summarySnippet = contentSnippet,
                localSummaryPath = summaryFile?.absolutePath,
                localFullBookPath = fullBookFile?.absolutePath,
                localPdfPath = pdfFile?.absolutePath,
                localCoverPath = cover?.absolutePath,
                hasSummary = summaryFile != null,
                hasFullBook = fullBookFile != null,
                hasPdf = pdfFile != null
            )
        }
    }

    fun saveCatalogToDisk(books: List<RemoteBook>) {
        if (books.isEmpty()) return
        try {
            val jsonArray = JSONArray()
            for (b in books) {
                val obj = JSONObject()
                obj.put("id", b.id)
                obj.put("title", b.title)
                obj.put("subtitle", b.subtitle ?: "")
                obj.put("author", b.author ?: "")
                obj.put("translator", b.translator ?: "")
                obj.put("tagline", b.tagline ?: "")
                obj.put("category", b.category ?: "সাধারণ")
                obj.put("language", b.language ?: "Bangla")
                obj.put("audioUrl", b.audioUrl ?: "")
                obj.put("summaryMdUrl", b.summaryMdUrl ?: "")
                obj.put("summaryMdPath", b.summaryMdPath ?: "")
                obj.put("summaryFilename", b.summaryFilename ?: "")
                obj.put("fullBookMdUrl", b.fullBookMdUrl ?: "")
                obj.put("fullBookMdPath", b.fullBookMdPath ?: "")
                obj.put("fullBookFilename", b.fullBookFilename ?: "")
                obj.put("pdfUrl", b.pdfUrl ?: "")
                obj.put("pdfDriveUrl", b.pdfDriveUrl ?: "")
                obj.put("pdfPath", b.pdfPath ?: "")
                obj.put("pdfFilename", b.pdfFilename ?: "")
                obj.put("coverUrl", b.coverUrl ?: "")
                obj.put("coverPath", b.coverPath ?: "")
                obj.put("summarySnippet", b.summarySnippet ?: "")
                obj.put("totalWords", b.totalWords)
                obj.put("estimatedMinutes", b.estimatedMinutes)
                obj.put("hasSummary", b.hasSummary)
                obj.put("hasFullBook", b.hasFullBook)
                obj.put("hasPdf", b.hasPdf)
                obj.put("slug", b.slug ?: "")
                obj.put("publishedAtIso", b.publishedAtIso ?: "")
                jsonArray.put(obj)
            }
            catalogFile.writeText(jsonArray.toString())
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun loadCatalogFromDisk(): List<RemoteBook> {
        if (!catalogFile.exists() || catalogFile.length() == 0L) return emptyList()
        return try {
            val jsonString = catalogFile.readText()
            val jsonArray = JSONArray(jsonString)
            val list = mutableListOf<RemoteBook>()
            for (i in 0 until jsonArray.length()) {
                val obj = jsonArray.getJSONObject(i)
                val id = obj.optString("id")
                if (id.isBlank()) continue

                val summaryLocal = File(booksDir, "${id}_summary.md").takeIf { it.exists() && it.length() > 0 }
                val fullLocal = File(booksDir, "${id}_full.md").takeIf { it.exists() && it.length() > 0 }
                val pdfLocal = File(booksDir, "$id.pdf").takeIf { it.exists() && it.length() > 0 }
                val coverLocal = File(booksDir, "${id}_cover.jpg").takeIf { it.exists() }
                    ?: File(booksDir, "${id}_cover.png").takeIf { it.exists() }

                val book = RemoteBook(
                    id = id,
                    title = obj.optString("title", "বই"),
                    subtitle = obj.optString("subtitle").takeIf { it.isNotBlank() },
                    author = obj.optString("author").takeIf { it.isNotBlank() },
                    translator = obj.optString("translator").takeIf { it.isNotBlank() },
                    tagline = obj.optString("tagline").takeIf { it.isNotBlank() },
                    category = obj.optString("category", "সাধারণ").takeIf { it.isNotBlank() } ?: "সাধারণ",
                    language = obj.optString("language", "Bangla"),
                    audioUrl = obj.optString("audioUrl").takeIf { it.isNotBlank() },
                    summaryMdUrl = obj.optString("summaryMdUrl").takeIf { it.isNotBlank() },
                    summaryMdPath = obj.optString("summaryMdPath").takeIf { it.isNotBlank() },
                    summaryFilename = obj.optString("summaryFilename").takeIf { it.isNotBlank() },
                    fullBookMdUrl = obj.optString("fullBookMdUrl").takeIf { it.isNotBlank() },
                    fullBookMdPath = obj.optString("fullBookMdPath").takeIf { it.isNotBlank() },
                    fullBookFilename = obj.optString("fullBookFilename").takeIf { it.isNotBlank() },
                    pdfUrl = obj.optString("pdfUrl").takeIf { it.isNotBlank() },
                    pdfDriveUrl = obj.optString("pdfDriveUrl").takeIf { it.isNotBlank() },
                    pdfPath = obj.optString("pdfPath").takeIf { it.isNotBlank() },
                    pdfFilename = obj.optString("pdfFilename").takeIf { it.isNotBlank() },
                    coverUrl = obj.optString("coverUrl").takeIf { it.isNotBlank() },
                    coverPath = obj.optString("coverPath").takeIf { it.isNotBlank() },
                    summarySnippet = obj.optString("summarySnippet").takeIf { it.isNotBlank() },
                    totalWords = obj.optInt("totalWords", 0),
                    estimatedMinutes = obj.optInt("estimatedMinutes", 1),
                    hasSummary = obj.optBoolean("hasSummary", false),
                    hasFullBook = obj.optBoolean("hasFullBook", false),
                    hasPdf = obj.optBoolean("hasPdf", false),
                    slug = obj.optString("slug").takeIf { it.isNotBlank() },
                    publishedAtIso = obj.optString("publishedAtIso").takeIf { it.isNotBlank() },
                    localSummaryPath = summaryLocal?.absolutePath,
                    localFullBookPath = fullLocal?.absolutePath,
                    localPdfPath = pdfLocal?.absolutePath,
                    localCoverPath = coverLocal?.absolutePath
                )
                list.add(book)
            }
            list
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}

