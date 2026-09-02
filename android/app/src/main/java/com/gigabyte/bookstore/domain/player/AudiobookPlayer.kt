package com.gigabyte.bookstore.domain.player

import android.content.Context
import android.content.Intent
import android.os.Build
import com.gigabyte.bookstore.data.local.entities.PlaybackHistoryEntity
import com.gigabyte.bookstore.data.models.Book
import com.gigabyte.bookstore.data.models.Chapter
import com.gigabyte.bookstore.data.models.ChunkInfo
import com.gigabyte.bookstore.data.models.PlaybackState
import com.gigabyte.bookstore.data.preferences.AppPreferences
import com.gigabyte.bookstore.data.repository.AudiobookRepository
import com.gigabyte.bookstore.domain.parser.MarkdownCleaner
import com.gigabyte.bookstore.domain.parser.SentenceChunker
import com.gigabyte.bookstore.domain.tts.BanglaTTSManager
import com.gigabyte.bookstore.domain.tts.BanglaVoicePresets
import com.gigabyte.bookstore.domain.tts.BanglaVoiceProfile
import com.gigabyte.bookstore.domain.tts.TTSPlaybackListener
import com.gigabyte.bookstore.service.AudiobookForegroundService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class AudiobookPlayer(
    private val context: Context,
    private val repository: AudiobookRepository,
    private val ttsManager: BanglaTTSManager,
    private val preferences: AppPreferences,
    private val scope: CoroutineScope
) : TTSPlaybackListener {

    private val _playbackState = MutableStateFlow(PlaybackState())
    val playbackState: StateFlow<PlaybackState> = _playbackState.asStateFlow()

    private var currentBook: Book? = null
    private var lastBook: Book? = null
    private var chaptersList: List<Chapter> = emptyList()
    private var currentChapterIndex: Int = 0
    private var currentChunks: List<ChunkInfo> = emptyList()
    private var currentChunkIndex: Int = 0

    private var sleepTimerJob: Job? = null
    private var sleepTimerOption: SleepTimerOption = SleepTimerOption.OFF

    init {
        ttsManager.addListener(this)

        // Restore saved voice profile if available
        val savedVoiceId = preferences.selectedVoiceId.value
        val initialProfile = BanglaVoicePresets.PRESETS.firstOrNull { it.id == savedVoiceId }
            ?: BanglaVoicePresets.PRESETS[0]
        ttsManager.selectVoiceProfile(initialProfile, applyPitchSpeed = false)

        scope.launch {
            preferences.speechRate.collect { rate ->
                ttsManager.setSpeechRate(rate)
                _playbackState.value = _playbackState.value.copy(speed = rate)
            }
        }
        scope.launch {
            preferences.speechPitch.collect { pitch ->
                ttsManager.setPitch(pitch)
                _playbackState.value = _playbackState.value.copy(pitch = pitch)
            }
        }
        scope.launch {
            preferences.fullAudiobookMode.collect { isFull ->
                _playbackState.value = _playbackState.value.copy(isFullAudiobookMode = isFull)
            }
        }
    }

    fun loadAndPlayBook(book: Book, startChapterIndex: Int = 0, startChunkIndex: Int = 0, autoPlay: Boolean = true) {
        scope.launch(Dispatchers.Main) {
            _playbackState.value = _playbackState.value.copy(isLoading = true)
            currentBook = book
            lastBook = book
            chaptersList = repository.getChaptersForBookSync(book.id)
            currentChapterIndex = startChapterIndex.coerceIn(0, (chaptersList.size - 1).coerceAtLeast(0))

            loadChapterChunks(currentChapterIndex)
            currentChunkIndex = startChunkIndex.coerceIn(0, (currentChunks.size - 1).coerceAtLeast(0))

            val currentChap = chaptersList.getOrNull(currentChapterIndex)
            val currentChunk = currentChunks.getOrNull(currentChunkIndex)

            _playbackState.value = _playbackState.value.copy(
                bookId = book.id,
                bookTitle = book.title,
                author = book.author,
                coverPath = book.coverPath,
                chapterIndex = currentChapterIndex,
                chapterTitle = currentChap?.title ?: "অধ্যায় ${currentChapterIndex + 1}",
                totalChapters = chaptersList.size,
                chunkIndex = currentChunkIndex,
                totalChunks = currentChunks.size,
                currentChunkText = currentChunk?.text ?: "",
                isLoading = false,
                errorMessage = null
            )

            if (autoPlay && currentChunks.isNotEmpty()) {
                playChunk(currentChunkIndex)
            }
        }
    }

    private fun loadChapterChunks(chapterIndex: Int) {
        val chapter = chaptersList.getOrNull(chapterIndex)
        if (chapter != null) {
            val fullCleanText = "${chapter.title}。\n\n" + MarkdownCleaner.cleanForTTS(chapter.content)
            currentChunks = SentenceChunker.splitIntoChunks(fullCleanText)
        } else {
            currentChunks = emptyList()
        }
    }

    fun play() {
        val targetBook = currentBook ?: lastBook
        if (targetBook != null && currentChunks.isNotEmpty()) {
            currentBook = targetBook
            val currentChap = chaptersList.getOrNull(currentChapterIndex)
            val currentChunk = currentChunks.getOrNull(currentChunkIndex)
            _playbackState.value = _playbackState.value.copy(
                bookId = targetBook.id,
                bookTitle = targetBook.title,
                author = targetBook.author,
                coverPath = targetBook.coverPath,
                chapterIndex = currentChapterIndex,
                chapterTitle = currentChap?.title ?: "অধ্যায় ${currentChapterIndex + 1}",
                totalChapters = chaptersList.size,
                chunkIndex = currentChunkIndex,
                totalChunks = currentChunks.size,
                currentChunkText = currentChunk?.text ?: "",
                isLoading = false,
                errorMessage = null
            )
            playChunk(currentChunkIndex)
        } else {
            scope.launch(Dispatchers.Main) {
                val lastHistory = repository.getLastPlayedSync()
                val activeBook = targetBook ?: (if (lastHistory != null) repository.getBookById(lastHistory.bookId) else null)
                if (activeBook != null) {
                    val chapIdx = lastHistory?.chapterIndex ?: currentChapterIndex
                    val chunkIdx = lastHistory?.chunkIndex ?: currentChunkIndex
                    loadAndPlayBook(
                        book = activeBook,
                        startChapterIndex = chapIdx,
                        startChunkIndex = chunkIdx,
                        autoPlay = true
                    )
                }
            }
        }
    }

    private fun playChunk(chunkIndex: Int) {
        val chunk = currentChunks.getOrNull(chunkIndex) ?: return
        currentChunkIndex = chunkIndex

        _playbackState.value = _playbackState.value.copy(
            isPlaying = true,
            chunkIndex = chunkIndex,
            currentChunkText = chunk.text,
            totalChunks = currentChunks.size
        )

        ttsManager.speakChunk(chunk.text, chunkIndex)
        saveCurrentPosition()
        startForegroundServiceNotification()
    }

    fun pause() {
        ttsManager.stop()
        _playbackState.value = _playbackState.value.copy(isPlaying = false)
        saveCurrentPosition()
        updateForegroundServiceNotification()
    }

    fun togglePlayPause() {
        if (_playbackState.value.isPlaying) {
            pause()
        } else {
            play()
        }
    }

    fun seekToChunk(chunkIndex: Int) {
        if (currentChunks.isEmpty()) return
        val targetIndex = chunkIndex.coerceIn(0, currentChunks.size - 1)
        currentChunkIndex = targetIndex
        val wasPlaying = _playbackState.value.isPlaying

        val chunk = currentChunks.getOrNull(targetIndex)
        _playbackState.value = _playbackState.value.copy(
            chunkIndex = targetIndex,
            currentChunkText = chunk?.text ?: ""
        )

        if (wasPlaying) {
            playChunk(targetIndex)
        } else {
            saveCurrentPosition()
        }
    }

    fun skipBackward10Seconds() {
        // Step back 2 chunks (approximately 10-15 seconds)
        val targetIndex = (currentChunkIndex - 2).coerceAtLeast(0)
        seekToChunk(targetIndex)
    }

    fun skipForward10Seconds() {
        // Step forward 2 chunks (approximately 10-15 seconds)
        val targetIndex = (currentChunkIndex + 2).coerceAtMost((currentChunks.size - 1).coerceAtLeast(0))
        seekToChunk(targetIndex)
    }

    fun nextChapter() {
        if (currentChapterIndex < chaptersList.size - 1) {
            val nextIdx = currentChapterIndex + 1
            currentChapterIndex = nextIdx
            loadChapterChunks(nextIdx)
            val currentChap = chaptersList.getOrNull(nextIdx)

            currentChunkIndex = 0
            val currentChunk = currentChunks.getOrNull(0)

            _playbackState.value = _playbackState.value.copy(
                chapterIndex = nextIdx,
                chapterTitle = currentChap?.title ?: "অধ্যায় ${nextIdx + 1}",
                chunkIndex = 0,
                totalChunks = currentChunks.size,
                currentChunkText = currentChunk?.text ?: ""
            )

            if (_playbackState.value.isPlaying) {
                playChunk(0)
            } else {
                saveCurrentPosition()
            }
        } else {
            // End of book
            pause()
        }
    }

    fun previousChapter() {
        if (currentChunkIndex > 2) {
            // If already into current chapter, restart it
            seekToChunk(0)
        } else if (currentChapterIndex > 0) {
            val prevIdx = currentChapterIndex - 1
            currentChapterIndex = prevIdx
            loadChapterChunks(prevIdx)
            val currentChap = chaptersList.getOrNull(prevIdx)

            currentChunkIndex = 0
            val currentChunk = currentChunks.getOrNull(0)

            _playbackState.value = _playbackState.value.copy(
                chapterIndex = prevIdx,
                chapterTitle = currentChap?.title ?: "অধ্যায় ${prevIdx + 1}",
                chunkIndex = 0,
                totalChunks = currentChunks.size,
                currentChunkText = currentChunk?.text ?: ""
            )

            if (_playbackState.value.isPlaying) {
                playChunk(0)
            } else {
                saveCurrentPosition()
            }
        } else {
            seekToChunk(0)
        }
    }

    fun restartChapter() {
        seekToChunk(0)
    }

    fun setSpeechRate(rate: Float) {
        preferences.setSpeechRate(rate)
    }

    fun setSpeechPitch(pitch: Float) {
        preferences.setSpeechPitch(pitch)
    }

    fun selectVoiceProfile(profile: BanglaVoiceProfile, applyPitchSpeed: Boolean = true) {
        preferences.setSelectedVoiceId(profile.id)
        if (applyPitchSpeed) {
            preferences.setSpeechPitch(profile.targetPitch)
            preferences.setSpeechRate(profile.targetSpeed)
        }
        ttsManager.selectVoiceProfile(profile, applyPitchSpeed)
    }

    fun testVoiceSample(profile: BanglaVoiceProfile) {
        ttsManager.testVoiceSample(profile)
    }

    fun setSleepTimer(option: SleepTimerOption) {
        sleepTimerOption = option
        sleepTimerJob?.cancel()

        if (option == SleepTimerOption.OFF) {
            _playbackState.value = _playbackState.value.copy(sleepTimerMinutesRemaining = null)
            return
        }

        if (option == SleepTimerOption.END_OF_CHAPTER) {
            _playbackState.value = _playbackState.value.copy(sleepTimerMinutesRemaining = -1)
            return
        }

        val minutes = option.minutes ?: return
        _playbackState.value = _playbackState.value.copy(sleepTimerMinutesRemaining = minutes)

        sleepTimerJob = scope.launch {
            var remaining = minutes
            while (isActive && remaining > 0) {
                delay(60_000L)
                remaining--
                _playbackState.value = _playbackState.value.copy(sleepTimerMinutesRemaining = remaining)
            }
            if (isActive) {
                pause()
                _playbackState.value = _playbackState.value.copy(sleepTimerMinutesRemaining = null)
                sleepTimerOption = SleepTimerOption.OFF
            }
        }
    }

    override fun onChunkStarted(utteranceId: String, chunkIndex: Int) {
        val chunk = currentChunks.getOrNull(chunkIndex)
        _playbackState.value = _playbackState.value.copy(
            isPlaying = true,
            chunkIndex = chunkIndex,
            currentChunkText = chunk?.text ?: _playbackState.value.currentChunkText
        )
    }

    override fun onChunkCompleted(utteranceId: String, chunkIndex: Int) {
        if (!_playbackState.value.isPlaying) return

        if (chunkIndex + 1 < currentChunks.size) {
            // Speak next chunk in current chapter
            playChunk(chunkIndex + 1)
        } else {
            // Current chapter finished!
            if (sleepTimerOption == SleepTimerOption.END_OF_CHAPTER) {
                pause()
                sleepTimerOption = SleepTimerOption.OFF
                _playbackState.value = _playbackState.value.copy(sleepTimerMinutesRemaining = null)
                return
            }

            if (preferences.autoPlayNext.value && preferences.fullAudiobookMode.value) {
                if (currentChapterIndex + 1 < chaptersList.size) {
                    nextChapter()
                } else {
                    // All chapters finished
                    pause()
                }
            } else {
                pause()
            }
        }
    }

    override fun onPlaybackError(utteranceId: String, errorMessage: String) {
        _playbackState.value = _playbackState.value.copy(
            isPlaying = false,
            errorMessage = errorMessage
        )
    }

    private fun saveCurrentPosition() {
        val book = currentBook ?: return
        val currentChap = chaptersList.getOrNull(currentChapterIndex) ?: return

        scope.launch(Dispatchers.IO) {
            repository.savePlaybackHistory(
                PlaybackHistoryEntity(
                    bookId = book.id,
                    bookTitle = book.title,
                    author = book.author,
                    coverPath = book.coverPath,
                    chapterIndex = currentChapterIndex,
                    chapterTitle = currentChap.title,
                    chunkIndex = currentChunkIndex,
                    totalChunks = currentChunks.size,
                    lastPlayedTimestamp = System.currentTimeMillis()
                )
            )
        }
    }

    private fun startForegroundServiceNotification() {
        try {
            val intent = Intent(context, AudiobookForegroundService::class.java).apply {
                action = AudiobookForegroundService.ACTION_UPDATE
                putExtra("TITLE", _playbackState.value.bookTitle)
                putExtra("CHAPTER", _playbackState.value.chapterTitle)
                putExtra("IS_PLAYING", true)
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(intent)
            } else {
                context.startService(intent)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun updateForegroundServiceNotification() {
        try {
            val intent = Intent(context, AudiobookForegroundService::class.java).apply {
                action = AudiobookForegroundService.ACTION_UPDATE
                putExtra("TITLE", _playbackState.value.bookTitle)
                putExtra("CHAPTER", _playbackState.value.chapterTitle)
                putExtra("IS_PLAYING", _playbackState.value.isPlaying)
            }
            context.startService(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun stopService() {
        try {
            val intent = Intent(context, AudiobookForegroundService::class.java).apply {
                action = AudiobookForegroundService.ACTION_STOP
            }
            context.startService(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * Completely stops the running audio playback, cancels sleep timer,
     * stops foreground notification service, and resets playback state.
     */
    fun stopAndClose() {
        ttsManager.stop()
        stopService()
        sleepTimerJob?.cancel()
        sleepTimerOption = SleepTimerOption.OFF
        if (currentBook != null) {
            lastBook = currentBook
        }
        currentBook = null
        _playbackState.value = PlaybackState()
    }

    fun getCurrentChunks(): List<ChunkInfo> = currentChunks
}
