package com.gigabyte.bookstore.data.models

/**
 * Backend-controlled pricing and referral bonus configuration.
 * Synced in real-time from Firebase Firestore (`settings/pricing`).
 */
data class AppPricingConfig(
    val megaBundlePrice: Double = 300.0,
    val singleCoursePrice: Double = 100.0,
    val bundleReferralBonus: Double = 40.0,
    val singleReferralBonus: Double = 20.0,
    val minWithdrawalAmount: Double = 100.0,
    val packagePrices: Map<String, Double> = emptyMap(),
    val updatedAt: String = "",
    val updatedBy: String = ""
) {
    /**
     * Resolves the price for a specific package ID or falls back to singleCoursePrice / megaBundlePrice.
     */
    fun getPackagePrice(packageId: String): Double {
        return packagePrices[packageId] ?: when (packageId) {
            "mega_bundle" -> megaBundlePrice
            else -> singleCoursePrice
        }
    }

    /**
     * Calculates the referral bonus for a referrer when a referred user buys a package.
     * Bundle purchases (mega_bundle or amount >= megaBundlePrice) reward bundleReferralBonus (৳40),
     * while single course purchases reward singleReferralBonus (৳20).
     */
    fun getReferralBonus(packageId: String, amount: Double): Double {
        return if (packageId.equals("mega_bundle", ignoreCase = true) || amount >= megaBundlePrice) {
            bundleReferralBonus
        } else {
            singleReferralBonus
        }
    }
}
