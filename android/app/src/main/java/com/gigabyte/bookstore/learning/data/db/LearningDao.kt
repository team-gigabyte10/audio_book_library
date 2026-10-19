package com.gigabyte.bookstore.learning.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

/**
 * Content-quality gate (plan §6), kept in one place for every query:
 * show an item if it was reviewed, or if it has no review flags and has a Bangla meaning.
 */
private const val VISIBLE_ITEM = "(i.status = 'reviewed' OR (i.reviewFlags = '' AND i.bn IS NOT NULL AND TRIM(i.bn) != ''))"

@Dao
interface LearningDao {

    // ---- content import ----

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertParts(parts: List<PartEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLessons(lessons: List<LessonEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItems(items: List<ItemEntity>)

    @Upsert
    suspend fun upsertMeta(meta: ContentMetaEntity)

    @Query("DELETE FROM items")
    suspend fun clearItems()

    @Query("DELETE FROM lessons")
    suspend fun clearLessons()

    @Query("DELETE FROM parts")
    suspend fun clearParts()

    @Query("SELECT * FROM content_meta WHERE id = 0")
    suspend fun getMeta(): ContentMetaEntity?

    @Query("SELECT * FROM content_meta WHERE id = 0")
    fun observeMeta(): Flow<ContentMetaEntity?>

    // ---- content reads ----

    /** lessonCount = lessons with at least MIN_VISIBLE_ITEMS (3) visible items, i.e. what the learner sees. */
    @Query(
        """
        SELECT p.*, (
            SELECT COUNT(*) FROM lessons l WHERE l.partId = p.id
            AND (SELECT COUNT(*) FROM items i WHERE i.lessonId = l.id AND $VISIBLE_ITEM) >= 3
        ) AS lessonCount
        FROM parts p ORDER BY p.sort_order
        """
    )
    fun observeParts(): Flow<List<PartWithCount>>

    @Query("SELECT * FROM parts WHERE id = :partId")
    suspend fun getPart(partId: String): PartEntity?

    @Query(
        """
        SELECT l.*, (SELECT COUNT(*) FROM items i WHERE i.lessonId = l.id AND $VISIBLE_ITEM) AS visibleCount
        FROM lessons l WHERE l.partId = :partId ORDER BY l.sort_order
        """
    )
    suspend fun getLessonsWithCount(partId: String): List<LessonWithCount>

    @Query(
        """
        SELECT l.*, (SELECT COUNT(*) FROM items i WHERE i.lessonId = l.id AND $VISIBLE_ITEM) AS visibleCount
        FROM lessons l ORDER BY l.sort_order
        """
    )
    suspend fun getAllLessonsWithCount(): List<LessonWithCount>

    @Query("SELECT * FROM lessons WHERE id = :lessonId")
    suspend fun getLesson(lessonId: String): LessonEntity?

    @Query("SELECT i.* FROM items i WHERE i.lessonId = :lessonId AND $VISIBLE_ITEM ORDER BY i.sort_order")
    suspend fun getVisibleItems(lessonId: String): List<ItemEntity>

    /** Distractor pool for quizzes: visible items elsewhere in the same part. */
    @Query(
        """
        SELECT i.* FROM items i JOIN lessons l ON l.id = i.lessonId
        WHERE l.partId = :partId AND i.lessonId != :excludeLessonId AND $VISIBLE_ITEM
        ORDER BY RANDOM() LIMIT :limit
        """
    )
    suspend fun getDistractorPool(partId: String, excludeLessonId: String, limit: Int): List<ItemEntity>

    // ---- progress ----

    @Query("SELECT * FROM lesson_progress")
    fun observeProgress(): Flow<List<LessonProgressEntity>>

    @Query("SELECT * FROM lesson_progress WHERE lessonId = :lessonId")
    suspend fun getProgress(lessonId: String): LessonProgressEntity?

    @Query("SELECT * FROM lesson_progress ORDER BY updatedAt DESC LIMIT 1")
    fun observeLastProgress(): Flow<LessonProgressEntity?>

    @Upsert
    suspend fun upsertProgress(progress: LessonProgressEntity)

    @Insert
    suspend fun insertAttempts(attempts: List<AttemptEntity>)
}
