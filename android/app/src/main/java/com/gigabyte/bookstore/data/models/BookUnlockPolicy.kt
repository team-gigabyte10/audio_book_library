package com.gigabyte.bookstore.data.models

/**
 * Model representing the dynamic Audiobook / Full Book Unlock Policy
 * controlled via Firebase Firestore (settings/book_config).
 *
 * Mode [MODE_AD_AND_PAID]: Users can watch rewarded video ads for a temporary unlock pass (default 24h) or buy.
 * Mode [MODE_PAID_ONLY]: Books can ONLY be unlocked by paid members who own the bundle. Free preview books per category remain free.
 */
data class BookUnlockPolicy(
    val unlockMode: String = MODE_AD_AND_PAID,
    val allowRewardedAdUnlock: Boolean = true,
    val rewardUnlockHours: Int = 24,
    val freeBooksPerCategoryCount: Int = 1,
    val updatedAt: String = "",
    val updatedBy: String = ""
) {
    val isPaidOnly: Boolean
        get() = unlockMode.equals(MODE_PAID_ONLY, ignoreCase = true) || !allowRewardedAdUnlock

    companion object {
        const val MODE_AD_AND_PAID = "ad_and_paid"
        const val MODE_PAID_ONLY = "paid_only"
    }
}
