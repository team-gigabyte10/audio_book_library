package com.gigabyte.bookstore.data.models

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class User(
    val name: String = "",
    val email: String = "",
    val institute: String = "",
    val address: String = "",
    val phone: String? = null,
    val deviceId: String = "",
    val status: String = "trial", // "trial" or "active"
    val balance: Double = 0.0,
    val createdAt: String = getCurrentFormattedDate(),
    val lastLoginAt: String = getCurrentFormattedDate()
) {
    companion object {
        fun getCurrentFormattedDate(): String {
            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
            return sdf.format(Date())
        }

        fun getCurrentDateOnly(): String {
            val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            return sdf.format(Date())
        }
    }
}
