package com.gigabyte.bookstore.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gigabyte.bookstore.data.local.entities.ChapterEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ChapterDao {
    @Query("SELECT * FROM chapters WHERE bookId = :bookId ORDER BY `index` ASC")
    fun getChaptersForBook(bookId: String): Flow<List<ChapterEntity>>

    @Query("SELECT * FROM chapters WHERE bookId = :bookId ORDER BY `index` ASC")
    suspend fun getChaptersForBookSync(bookId: String): List<ChapterEntity>

    @Query("SELECT * FROM chapters WHERE bookId = :bookId AND `index` = :index LIMIT 1")
    suspend fun getChapterByIndex(bookId: String, index: Int): ChapterEntity?

    @Query("SELECT * FROM chapters WHERE bookId = :bookId AND (title LIKE '%' || :query || '%' OR content LIKE '%' || :query || '%') ORDER BY `index` ASC")
    suspend fun searchChapters(bookId: String, query: String): List<ChapterEntity>

    @Query("SELECT * FROM chapters WHERE title LIKE '%' || :query || '%' OR content LIKE '%' || :query || '%' ORDER BY `index` ASC")
    suspend fun searchAllChapters(query: String): List<ChapterEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChapters(chapters: List<ChapterEntity>)

    @Query("DELETE FROM chapters WHERE bookId = :bookId")
    suspend fun deleteChaptersForBook(bookId: String)

    @Query("DELETE FROM chapters WHERE bookId LIKE 'asset-%'")
    suspend fun deleteBuiltInChapters()
}

