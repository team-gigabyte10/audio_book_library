package com.gigabyte.bookstore.data.models

data class AppNotice(
    val id: String = "",
    val title: String = "",
    val message: String = "",
    val isActive: Boolean = true,
    val priority: Int = 1,
    val actionUrl: String? = null,
    val createdAt: Long = System.currentTimeMillis(),
    val authorEmail: String? = null
)
