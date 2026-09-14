package com.gigabyte.bookstore.data.repository

import android.content.Context
import android.net.Uri
import com.gigabyte.bookstore.data.local.AudiobookDatabase
import com.gigabyte.bookstore.data.local.entities.BookEntity
import com.gigabyte.bookstore.data.local.entities.ChapterEntity
import com.gigabyte.bookstore.data.local.entities.PlaybackHistoryEntity
import com.gigabyte.bookstore.data.models.Book
import com.gigabyte.bookstore.data.models.Chapter
import com.gigabyte.bookstore.domain.parser.MarkdownParser
import com.gigabyte.bookstore.domain.parser.ParsedBook
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.util.UUID

class AudiobookRepository(
    private val context: Context,
    private val database: AudiobookDatabase
) {
    private val bookDao = database.bookDao()
    private val chapterDao = database.chapterDao()
    private val historyDao = database.playbackHistoryDao()

    val allBooks: Flow<List<Book>> = bookDao.getAllBooks().map { entities ->
        entities.map { it.toDomainModel() }
    }

    val lastPlayedHistory: Flow<PlaybackHistoryEntity?> = historyDao.getLastPlayedFlow()

    suspend fun removeBuiltInBooksIfNeeded() = withContext(Dispatchers.IO) {
        try {
            bookDao.deleteBuiltInBooks()
            chapterDao.deleteBuiltInChapters()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    suspend fun importBookFromUri(uri: Uri): Result<Book> = withContext(Dispatchers.IO) {

        try {
            val content = context.contentResolver.openInputStream(uri)?.bufferedReader()?.use {
                it.readText()
            } ?: return@withContext Result.failure(Exception("ফাইল পড়া সম্ভব হয়নি।"))

            if (content.isBlank()) {
                return@withContext Result.failure(Exception("ফাইলটি খালি বা কোনো টেক্সট নেই।"))
            }

            // Derive fallback title from file name
            var fileName = "imported_book"
            context.contentResolver.query(uri, null, null, null, null)?.use { cursor ->
                val nameIndex = cursor.getColumnIndex(android.provider.OpenableColumns.DISPLAY_NAME)
                if (nameIndex >= 0 && cursor.moveToFirst()) {
                    fileName = cursor.getString(nameIndex)
                }
            }
            val fallbackTitle = fileName.removeSuffix(".md").removeSuffix(".markdown")

            // Copy file to internal app storage for reliable offline access
            val bookId = "book-" + UUID.randomUUID().toString().take(8)
            val bookStoreDir = File(context.filesDir, "book-store").apply { if (!exists()) mkdirs() }
            val internalFile = File(bookStoreDir, "$bookId.md")
            internalFile.writeText(content)


            val parsed = MarkdownParser.parse(
                content = content,
                fallbackId = bookId,
                fallbackTitle = fallbackTitle,
                filePath = internalFile.absolutePath,
                isAsset = false
            )

            saveParsedBook(parsed)
            Result.success(parsed.book)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getBookById(id: String): Book? = withContext(Dispatchers.IO) {
        bookDao.getBookById(id)?.toDomainModel()
    }

    fun getBookFlow(id: String): Flow<Book?> = bookDao.getBookByIdFlow(id).map { it?.toDomainModel() }

    fun getChaptersForBook(bookId: String): Flow<List<Chapter>> =
        chapterDao.getChaptersForBook(bookId).map { list -> list.map { it.toDomainModel() } }

    suspend fun getChaptersForBookSync(bookId: String): List<Chapter> = withContext(Dispatchers.IO) {
        chapterDao.getChaptersForBookSync(bookId).map { it.toDomainModel() }
    }

    suspend fun getChapterByIndex(bookId: String, index: Int): Chapter? = withContext(Dispatchers.IO) {
        chapterDao.getChapterByIndex(bookId, index)?.toDomainModel()
    }

    suspend fun searchInBook(bookId: String, query: String): List<Chapter> = withContext(Dispatchers.IO) {
        chapterDao.searchChapters(bookId, query).map { it.toDomainModel() }
    }

    suspend fun searchAllBooks(query: String): List<Chapter> = withContext(Dispatchers.IO) {
        chapterDao.searchAllChapters(query).map { it.toDomainModel() }
    }

    suspend fun savePlaybackHistory(history: PlaybackHistoryEntity) = withContext(Dispatchers.IO) {
        historyDao.saveHistory(history)
    }

    suspend fun getHistoryForBook(bookId: String): PlaybackHistoryEntity? = withContext(Dispatchers.IO) {
        historyDao.getHistoryForBook(bookId)
    }

    suspend fun getLastPlayedSync(): PlaybackHistoryEntity? = withContext(Dispatchers.IO) {
        historyDao.getLastPlayedSync()
    }

    suspend fun importDownloadedBook(
        file: File,
        bookId: String,
        title: String,
        author: String? = null,
        coverPath: String? = null
    ): Book? = withContext(Dispatchers.IO) {
        try {
            if (!file.exists() || file.length() == 0L) return@withContext null
            val existing = bookDao.getBookById(bookId)
            if (existing != null) return@withContext existing.toDomainModel()

            val content = file.readText()
            val parsed = MarkdownParser.parse(
                content = content,
                fallbackId = bookId,
                fallbackTitle = title,
                filePath = file.absolutePath,
                isAsset = false
            )
            val updatedBook = parsed.book.copy(
                author = author ?: parsed.book.author,
                coverPath = coverPath ?: parsed.book.coverPath
            )
            saveParsedBook(parsed.copy(book = updatedBook))
            updatedBook
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }


    suspend fun deleteBook(bookId: String) = withContext(Dispatchers.IO) {
        bookDao.deleteBookById(bookId)
        chapterDao.deleteChaptersForBook(bookId)
        historyDao.deleteHistory(bookId)
    }

    private suspend fun saveParsedBook(parsed: ParsedBook) {
        bookDao.insertBook(BookEntity.fromDomainModel(parsed.book))
        chapterDao.insertChapters(parsed.chapters.map { ChapterEntity.fromDomainModel(it) })
    }
}
