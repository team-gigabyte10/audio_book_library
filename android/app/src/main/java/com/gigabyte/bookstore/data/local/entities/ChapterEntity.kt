package com.gigabyte.bookstore.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.gigabyte.bookstore.data.models.Chapter

@Entity(
    tableName = "chapters",
    foreignKeys = [
        ForeignKey(
            entity = BookEntity::class,
            parentColumns = ["id"],
            childColumns = ["bookId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["bookId"])]
)
data class ChapterEntity(
    @PrimaryKey val id: String,
    val bookId: String,
    val index: Int,
    val title: String,
    val content: String,
    val chunkCount: Int
) {
    fun toDomainModel(): Chapter = Chapter(
        id = id,
        bookId = bookId,
        index = index,
        title = title,
        content = content,
        chunkCount = chunkCount
    )

    companion object {
        fun fromDomainModel(chapter: Chapter): ChapterEntity = ChapterEntity(
            id = chapter.id,
            bookId = chapter.bookId,
            index = chapter.index,
            title = chapter.title,
            content = chapter.content,
            chunkCount = chapter.chunkCount
        )
    }
}
