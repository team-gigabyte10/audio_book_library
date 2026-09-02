package com.gigabyte.bookstore.presentation.player

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.gigabyte.bookstore.BanglaAudiobookApp
import com.gigabyte.bookstore.data.models.Book
import com.gigabyte.bookstore.data.models.ChunkInfo
import com.gigabyte.bookstore.data.models.PlaybackState
import com.gigabyte.bookstore.domain.player.SleepTimerOption
import com.gigabyte.bookstore.domain.tts.BanglaVoiceProfile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PlayerViewModel(
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
    val allVoices: StateFlow<List<BanglaVoiceProfile>> = ttsManager.allVoices
    val currentVoice: StateFlow<BanglaVoiceProfile> = ttsManager.currentVoice
    val isSamplePlaying: StateFlow<Boolean> = ttsManager.isSamplePlaying

    private val _book = MutableStateFlow<Book?>(null)
    val book: StateFlow<Book?> = _book.asStateFlow()

    init {
        loadBook()
    }

    private fun loadBook() {
        viewModelScope.launch {
            val loadedBook = repository.getBookById(bookId)
            _book.value = loadedBook

            if (loadedBook != null) {
                // If this book is not already playing, load and play it
                val currentState = playbackState.value
                if (currentState.bookId != bookId || currentState.chapterIndex != initialChapterIndex) {
                    player.loadAndPlayBook(
                        book = loadedBook,
                        startChapterIndex = initialChapterIndex,
                        startChunkIndex = 0,
                        autoPlay = true
                    )
                }
            }
        }
    }

    fun play() = player.play()
    fun pause() = player.pause()
    fun togglePlayPause() = player.togglePlayPause()
    fun nextChapter() = player.nextChapter()
    fun previousChapter() = player.previousChapter()
    fun restartChapter() = player.restartChapter()
    fun skipBackward10s() = player.skipBackward10Seconds()
    fun skipForward10s() = player.skipForward10Seconds()
    fun seekToChunk(index: Int) = player.seekToChunk(index)
    fun setSpeechRate(rate: Float) = player.setSpeechRate(rate)
    fun setSpeechPitch(pitch: Float) = player.setSpeechPitch(pitch)
    fun setSleepTimer(option: SleepTimerOption) = player.setSleepTimer(option)

    fun selectVoiceProfile(profile: BanglaVoiceProfile) {
        player.selectVoiceProfile(profile, applyPitchSpeed = true)
    }

    fun testVoiceSample(profile: BanglaVoiceProfile) {
        player.testVoiceSample(profile)
    }

    fun openTtsSettings() {
        ttsManager.openTtsSettings()
    }

    fun toggleFullAudiobookMode() {
        val current = preferences.fullAudiobookMode.value
        preferences.setFullAudiobookMode(!current)
    }

    fun closePlayer() {
        player.stopAndClose()
    }

    fun getCurrentChunks(): List<ChunkInfo> = player.getCurrentChunks()
}
