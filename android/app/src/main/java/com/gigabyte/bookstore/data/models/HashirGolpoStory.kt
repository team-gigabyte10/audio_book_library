package com.gigabyte.bookstore.data.models

data class HashirGolpoStory(
    val id: String = "",
    val order: Int = 0,
    val title: String = "",
    val category: String = "লোকজ হাস্যরস",
    val categorySlug: String = "folklore_humor",
    val categoryIcon: String = "😂",
    val content: String = "",
    val wordCount: Int = 0,
    val readingMinutes: Int = 1
)

data class HashirGolpoCategory(
    val slug: String,
    val name: String,
    val icon: String,
    val storyCount: Int
)
