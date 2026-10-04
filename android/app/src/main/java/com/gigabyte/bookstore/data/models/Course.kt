package com.gigabyte.bookstore.data.models

data class CourseLesson(
    val id: String = "",
    val title: String = "",
    val duration: String = "",
    val audioUrl: String? = null,
    val pdfUrl: String? = null,
    val isFree: Boolean = false
)

data class CourseModule(
    val moduleTitle: String = "",
    val lessons: List<CourseLesson> = emptyList()
)

data class Course(
    val id: String = "",
    val title: String = "",
    val subtitle: String? = null,
    val language: String = "English", // "English" or "Japanese"
    val level: String = "Beginner",
    val instructor: String? = null,
    val description: String? = null,
    val thumbnailUrl: String? = null,
    val bannerUrl: String? = null,
    val totalHours: Double = 0.0,
    val lessonCount: Int = 0,
    val rating: Double = 5.0,
    val enrolledCount: Int = 0,
    val originalPrice: Double = 0.0,
    val discountedPrice: Double = 0.0,
    val isFree: Boolean = false,
    val tags: List<String> = emptyList(),
    val modules: List<CourseModule> = emptyList()
)
