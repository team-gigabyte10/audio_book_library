package com.gigabyte.bookstore.data.models

data class AudioBundle(
    val id: String = "",
    val title: String = "",
    val subtitle: String? = null,
    val description: String? = null,
    val coverUrl: String? = null,
    val bookIds: List<String> = emptyList(),
    val bookTitles: List<String> = emptyList(),
    val bookCount: Int = 0,
    val originalPrice: Double = 0.0,
    val discountedPrice: Double = 0.0,
    val savingsPercentage: Int = 0,
    val totalDurationHours: Double = 0.0,
    val badge: String = "বান্ডেল",
    val rating: Double = 5.0,
    val reviewCount: Int = 0,
    val isFeatured: Boolean = false
)
