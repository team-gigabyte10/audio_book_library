package com.gigabyte.bookstore.data.models

data class RemoteBook(
    val id: String = "",
    val title: String = "",
    val subtitle: String? = null,
    val author: String? = null,
    val translator: String? = null,
    val tagline: String? = null,
    val category: String? = "General",
    val language: String? = "Bangla",
    val audioUrl: String? = null,

    // Firebase Storage URLs
    val summaryMdUrl: String? = null,
    val summaryMdPath: String? = null,
    val summaryFilename: String? = null,

    val fullBookMdUrl: String? = null,
    val fullBookMdPath: String? = null,
    val fullBookFilename: String? = null,

    val pdfUrl: String? = null,
    val pdfPath: String? = null,
    val pdfFilename: String? = null,

    val coverUrl: String? = null,
    val coverPath: String? = null,

    val summarySnippet: String? = null,
    val totalWords: Int = 0,
    val estimatedMinutes: Int = 1,

    val hasSummary: Boolean = false,
    val hasFullBook: Boolean = false,
    val hasPdf: Boolean = false,

    val slug: String? = null,
    val publishedAtIso: String? = null,

    // Local cached file locations
    var localSummaryPath: String? = null,
    var localFullBookPath: String? = null,
    var localPdfPath: String? = null,
    var localCoverPath: String? = null
)
