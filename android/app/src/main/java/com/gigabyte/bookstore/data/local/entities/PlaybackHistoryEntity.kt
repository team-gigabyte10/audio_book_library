package com.gigabyte.bookstore.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "playback_history")
data class PlaybackHistoryEntity(
    @PrimaryKey val bookId: String,
    val bookTitle: String,
    val author: String?,
    val coverPath: String?,
    val chapterIndex: Int,
    val chapterTitle: String,
    val chunkIndex: Int,
    val totalChunks: Int,
    val lastPlayedTimestamp: Long = System.currentTimeMillis()
)
