package com.gigabyte.bookstore.data.models

data class Chapter(
    val id: String,
    val bookId: String,
    val index: Int,
    val title: String,
    val content: String,
    val chunkCount: Int = 0
)

data class ChunkInfo(
    val index: Int,
    val text: String,
    val rawText: String,
    val paragraphIndex: Int = 0
)
