package com.gigabyte.bookstore.data.models

data class Book(
    val id: String,
    val title: String,
    val author: String?,
    val filePath: String,
    val coverPath: String? = null,
    val chapterCount: Int = 0,
    val description: String? = null,
    val addedDate: Long = System.currentTimeMillis(),
    val isAsset: Boolean = false
)
