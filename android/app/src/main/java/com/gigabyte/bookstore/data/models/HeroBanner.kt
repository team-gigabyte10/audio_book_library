package com.gigabyte.bookstore.data.models

data class HeroBanner(
    val id: String = "",
    val title: String = "",
    val subtitle: String = "",
    val tag: String = "",
    val tagColor: String? = null,
    val imageUrl: String = "",
    val actionType: String = "", // "course", "bundle", "book"
    val targetId: String = "",
    val order: Int = 0
)
