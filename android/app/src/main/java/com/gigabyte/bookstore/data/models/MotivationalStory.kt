package com.gigabyte.bookstore.data.models

data class MotivationalStory(
    val id: String = "",
    val order: Int = 0,
    val title: String = "",
    val category: String = "ব্যর্থতা জয় ও উদ্ভাবন",
    val categorySlug: String = "failure_to_success",
    val categoryIcon: String = "🚀",
    val content: String = "",
    val wordCount: Int = 0,
    val readingMinutes: Int = 2
)

data class MotivationalCategory(
    val slug: String,
    val name: String,
    val icon: String,
    val storyCount: Int
)
