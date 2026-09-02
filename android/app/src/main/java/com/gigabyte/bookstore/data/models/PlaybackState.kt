package com.gigabyte.bookstore.data.models

data class PlaybackState(
    val bookId: String = "",
    val bookTitle: String = "",
    val author: String? = null,
    val coverPath: String? = null,
    val chapterIndex: Int = 0,
    val chapterTitle: String = "",
    val totalChapters: Int = 0,
    val chunkIndex: Int = 0,
    val totalChunks: Int = 0,
    val currentChunkText: String = "",
    val position: Long = 0L,
    val isPlaying: Boolean = false,
    val isLoading: Boolean = false,
    val speed: Float = 1.0f,
    val pitch: Float = 1.0f,
    val isFullAudiobookMode: Boolean = true,
    val sleepTimerMinutesRemaining: Int? = null,
    val errorMessage: String? = null
)
