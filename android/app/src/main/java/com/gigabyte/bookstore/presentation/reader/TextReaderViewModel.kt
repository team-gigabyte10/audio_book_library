package com.gigabyte.bookstore.presentation.reader

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.gigabyte.bookstore.BanglaAudiobookApp
import com.gigabyte.bookstore.data.models.Book
import com.gigabyte.bookstore.data.models.Chapter
import com.gigabyte.bookstore.data.models.ChunkInfo
import com.gigabyte.bookstore.data.models.PlaybackState
import com.gigabyte.bookstore.domain.parser.MarkdownCleaner
import com.gigabyte.bookstore.domain.parser.SentenceChunker
import com.gigabyte.bookstore.domain.tts.BanglaVoiceProfile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TextReaderViewModel(
    application: Application,
    private val bookId: String,
    private val initialChapterIndex: Int
) : AndroidViewModel(application) {

    private val app = application as BanglaAudiobookApp
    private val repository = app.repository
    val player = app.player
    val preferences = app.preferences
    val ttsManager = app.ttsManager

    val playbackState: StateFlow<PlaybackState> = player.playbackState
    val fontSize: StateFlow<Int> = preferences.readerFontSize
    val allVoices: StateFlow<List<BanglaVoiceProfile>> = ttsManager.allVoices
    val currentVoice: StateFlow<BanglaVoiceProfile> = ttsManager.currentVoice
    val isSamplePlaying: StateFlow<Boolean> = ttsManager.isSamplePlaying

    private val _book = MutableStateFlow<Book?>(null)
    val book: StateFlow<Book?> = _book.asStateFlow()

    private val _chapters = MutableStateFlow<List<Chapter>>(emptyList())
    val chapters: StateFlow<List<Chapter>> = _chapters.asStateFlow()

    private val _currentChapterIndex = MutableStateFlow(initialChapterIndex)
    val currentChapterIndex: StateFlow<Int> = _currentChapterIndex.asStateFlow()

    private val _chapterChunksMap = MutableStateFlow<Map<Int, List<ChunkInfo>>>(emptyMap())
    val chapterChunksMap: StateFlow<Map<Int, List<ChunkInfo>>> = _chapterChunksMap.asStateFlow()

    private val _chapterChunks = MutableStateFlow<List<ChunkInfo>>(emptyList())
    val chapterChunks: StateFlow<List<ChunkInfo>> = _chapterChunks.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _book.value = repository.getBookById(bookId)
            val chapList = repository.getChaptersForBookSync(bookId)
            _chapters.value = chapList

            val idx = initialChapterIndex.coerceIn(0, (chapList.size - 1).coerceAtLeast(0))
            _currentChapterIndex.value = idx

            // Pre-process chunks for all chapters so sliding between pages is instantaneous
            val chunksMap = mutableMapOf<Int, List<ChunkInfo>>()
            chapList.forEachIndexed { index, chap ->
                val fullCleanText = "${chap.title}。\n\n" + MarkdownCleaner.cleanForTTS(chap.content)
                val chunks = SentenceChunker.splitIntoChunks(fullCleanText)
                chunksMap[index] = chunks
            }
            _chapterChunksMap.value = chunksMap
            _chapterChunks.value = chunksMap[idx] ?: emptyList()
        }
    }

    fun getChunksForPage(pageIndex: Int): List<ChunkInfo> {
        val map = _chapterChunksMap.value
        map[pageIndex]?.let { return it }

        val chap = _chapters.value.getOrNull(pageIndex) ?: return emptyList()
        val fullCleanText = "${chap.title}。\n\n" + MarkdownCleaner.cleanForTTS(chap.content)
        val chunks = SentenceChunker.splitIntoChunks(fullCleanText)
        val updated = map.toMutableMap()
        updated[pageIndex] = chunks
        _chapterChunksMap.value = updated
        return chunks
    }

    fun onPageSelected(pageIndex: Int, playAudioIfActive: Boolean = false) {
        if (pageIndex in 0 until _chapters.value.size) {
            _currentChapterIndex.value = pageIndex
            _chapterChunks.value = getChunksForPage(pageIndex)

            if (playAudioIfActive && playbackState.value.isPlaying && playbackState.value.chapterIndex != pageIndex) {
                val currentBook = _book.value ?: return
                player.loadAndPlayBook(
                    book = currentBook,
                    startChapterIndex = pageIndex,
                    startChunkIndex = 0,
                    autoPlay = true
                )
            }
        }
    }

    fun selectChapter(index: Int) {
        if (index in 0 until _chapters.value.size) {
            _currentChapterIndex.value = index
            _chapterChunks.value = getChunksForPage(index)

            val currentBook = _book.value ?: return
            player.loadAndPlayBook(
                book = currentBook,
                startChapterIndex = index,
                startChunkIndex = 0,
                autoPlay = playbackState.value.isPlaying
            )
        }
    }

    fun speakFromChunk(chapterIndex: Int, chunkIndex: Int) {
        val currentBook = _book.value ?: return

        if (playbackState.value.bookId == bookId && playbackState.value.chapterIndex == chapterIndex) {
            player.seekToChunk(chunkIndex)
            if (!playbackState.value.isPlaying) {
                player.play()
            }
        } else {
            player.loadAndPlayBook(
                book = currentBook,
                startChapterIndex = chapterIndex,
                startChunkIndex = chunkIndex,
                autoPlay = true
            )
        }
    }

    fun closePlayer() {
        player.stopAndClose()
    }

    fun selectVoiceProfile(profile: BanglaVoiceProfile) {
        player.selectVoiceProfile(profile, applyPitchSpeed = true)
    }

    fun testVoiceSample(profile: BanglaVoiceProfile) {
        player.testVoiceSample(profile)
    }

    fun openTtsSettings() {
        ttsManager.openTtsSettings()
    }

    fun increaseFontSize() {
        val current = preferences.readerFontSize.value
        if (current < 28) {
            preferences.setReaderFontSize(current + 2)
        }
    }

    fun decreaseFontSize() {
        val current = preferences.readerFontSize.value
        if (current > 14) {
            preferences.setReaderFontSize(current - 2)
        }
    }
}
