package com.gigabyte.bookstore.learning.data.db

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

// ---- Content tables: rebuilt whenever the bundled JSON changes ----

@Entity(tableName = "parts")
data class PartEntity(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "sort_order") val order: Int,
    val level: String,
    val titleBn: String?,
    val titleTarget: String?,
    val contentNeeded: String?
)

@Entity(tableName = "lessons", indices = [Index(value = ["partId", "sort_order"])])
data class LessonEntity(
    @PrimaryKey val id: String,
    val partId: String,
    @ColumnInfo(name = "sort_order") val order: Int,
    val titleBn: String?,
    val titleTarget: String?,
    val introBn: String?,
    /** Structure formulas joined with '\n'. */
    val structure: String,
    val sourceSection: String?
)

@Entity(
    tableName = "items",
    indices = [Index(value = ["lessonId", "sort_order"]), Index("conceptId")]
)
data class ItemEntity(
    @PrimaryKey val id: String,
    val lessonId: String,
    @ColumnInfo(name = "sort_order") val order: Int,
    val conceptId: String,
    val type: String,
    val level: String,
    val target: String,
    val bn: String?,
    val bnPron: String?,
    /** Token texts joined with [TOKEN_SEPARATOR]. */
    val tokens: String,
    /** Token Bangla glosses joined with [TOKEN_SEPARATOR]; empty string = no gloss. */
    val tokenBn: String,
    val sentenceType: String?,
    val polarity: String?,
    val tense: String?,
    val question: String?,
    val wh: String?,
    val exampleTarget: String?,
    val exampleBn: String?,
    val speaker: String?,
    val source: String?,
    val status: String,
    /** Review flags joined with ','; empty string = no flags. */
    val reviewFlags: String
) {
    companion object {
        const val TOKEN_SEPARATOR = "\u001F"
    }
}

@Entity(tableName = "content_meta")
data class ContentMetaEntity(
    @PrimaryKey val id: Int = 0,
    val schemaVersion: Int,
    val contentHash: String,
    val appVersionCode: Int,
    /** Encoded with LadderStep.encode. */
    val ladder: String,
    val titleBn: String?,
    val titleTarget: String?,
    val importedAt: Long
)

// ---- Progress tables: never wiped by a content re-import ----

@Entity(tableName = "lesson_progress")
data class LessonProgressEntity(
    @PrimaryKey val lessonId: String,
    val state: String,
    val bestScore: Int,
    val lastItemIndex: Int,
    val updatedAt: Long
) {
    companion object {
        const val STATE_IN_PROGRESS = "IN_PROGRESS"
        const val STATE_DONE = "DONE"
    }
}

/** Keyed by conceptId so attempts survive content regeneration (ids depend on extraction order). */
@Entity(tableName = "attempts", indices = [Index("conceptId")])
data class AttemptEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val conceptId: String,
    val lessonId: String,
    val kind: String,
    val correct: Boolean,
    val latencyMs: Long,
    val at: Long
)

// ---- Query projections ----

data class LessonWithCount(
    @Embedded val lesson: LessonEntity,
    val visibleCount: Int
)

data class PartWithCount(
    @Embedded val part: PartEntity,
    val lessonCount: Int
)
