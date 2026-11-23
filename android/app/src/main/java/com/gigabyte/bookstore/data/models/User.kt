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
    val status: String = "trial", // "trial" or "paid"
    val balance: Double = 0.0,
    val referralCode: String = "",
    val referredBy: String? = null,
    val referralRewardPaid: Boolean = false,
    val unlockedBundles: List<String> = emptyList(),
    val role: String = "customer", // "customer" or "admin"
    val isAdmin: Boolean = false,
    val walletPin: String = "",
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

        fun generateReferralCode(name: String): String {
            val cleanName = name.trim().filter { it.isLetter() }.uppercase(Locale.getDefault())
            val prefix = if (cleanName.length >= 3) cleanName.take(4) else "BOOK"
            val randomSuffix = (1000..9999).random()
            return "$prefix$randomSuffix"
        }
    }
}

data class RecipientValidationResult(
    val email: String,
    val name: String,
    val isAlreadyUnlocked: Boolean,
    val unlockedBundles: List<String> = emptyList(),
    val message: String = ""
) {
    fun isPackageUnlocked(pkgId: String): Boolean {
        val normalized = com.gigabyte.bookstore.data.preferences.AppPreferences.normalizeBundleId(pkgId)
        val normalizedBundles = unlockedBundles.map { com.gigabyte.bookstore.data.preferences.AppPreferences.normalizeBundleId(it) }
        return normalizedBundles.contains("mega_bundle") || normalizedBundles.contains(normalized)
    }
}
