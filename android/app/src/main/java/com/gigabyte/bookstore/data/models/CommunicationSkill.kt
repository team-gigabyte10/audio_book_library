package com.gigabyte.bookstore.data.models

data class CommunicationSkill(
    val id: String = "",
    val order: Int = 0,
    val title: String = "",
    val category: String = "মানুষের মন জয় করার ভিত্তি",
    val categorySlug: String = "foundations",
    val categoryIcon: String = "💖",
    val ruleQuote: String = "",
    val summary: String = "",
    val content: String = "",
    val actionStep: String = "",
    val readingMinutes: Int = 3
)

data class CommunicationCategory(
    val slug: String,
    val name: String,
    val icon: String,
    val count: Int
)
