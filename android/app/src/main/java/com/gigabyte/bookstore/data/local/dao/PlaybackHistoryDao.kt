package com.gigabyte.bookstore.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gigabyte.bookstore.data.local.entities.PlaybackHistoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PlaybackHistoryDao {
    @Query("SELECT * FROM playback_history ORDER BY lastPlayedTimestamp DESC LIMIT 1")
    fun getLastPlayedFlow(): Flow<PlaybackHistoryEntity?>

    @Query("SELECT * FROM playback_history ORDER BY lastPlayedTimestamp DESC LIMIT 1")
    suspend fun getLastPlayedSync(): PlaybackHistoryEntity?

    @Query("SELECT * FROM playback_history WHERE bookId = :bookId LIMIT 1")
    suspend fun getHistoryForBook(bookId: String): PlaybackHistoryEntity?

    @Query("SELECT * FROM playback_history WHERE bookId = :bookId LIMIT 1")
    fun getHistoryForBookFlow(bookId: String): Flow<PlaybackHistoryEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveHistory(history: PlaybackHistoryEntity)

    @Query("DELETE FROM playback_history WHERE bookId = :bookId")
    suspend fun deleteHistory(bookId: String)
}
