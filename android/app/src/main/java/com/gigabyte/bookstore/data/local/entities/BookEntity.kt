package com.gigabyte.bookstore.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gigabyte.bookstore.data.models.Book

@Entity(tableName = "books")
data class BookEntity(
    @PrimaryKey val id: String,
    val title: String,
    val author: String?,
    val filePath: String,
    val coverPath: String?,
    val chapterCount: Int,
    val description: String?,
    val addedDate: Long,
    val isAsset: Boolean
) {
    fun toDomainModel(): Book = Book(
        id = id,
        title = title,
        author = author,
        filePath = filePath,
        coverPath = coverPath,
        chapterCount = chapterCount,
        description = description,
        addedDate = addedDate,
        isAsset = isAsset
    )

    companion object {
        fun fromDomainModel(book: Book): BookEntity = BookEntity(
            id = book.id,
            title = book.title,
            author = book.author,
            filePath = book.filePath,
            coverPath = book.coverPath,
            chapterCount = book.chapterCount,
            description = book.description,
            addedDate = book.addedDate,
            isAsset = book.isAsset
        )
    }
}
