package com.gigabyte.bookstore.data.ads

/**
 * Central configuration for Meta Audience Network (Facebook Ads).
 * When running in test mode, test placement IDs or test mode flags are enabled.
 */
object AdConfig {
    /**
     * Official Meta Audience Network test placement ID format for Banners.
     * Replace with your production Placement ID from Meta Monetization Manager when publishing.
     * Format: "YOUR_PLACEMENT_ID" or "IMG_16_9_APP_INSTALL#YOUR_PLACEMENT_ID"
     */
    const val FB_BANNER_PLACEMENT_ID = "IMG_16_9_APP_INSTALL#YOUR_PLACEMENT_ID"

    /**
     * When true, requests Meta test ads so developers can test on any device or emulator
     * without risking account suspension.
     */
    var isTestMode: Boolean = true

    /**
     * Master switch to enable or disable ads across the app.
     */
    var isAdsEnabled: Boolean = true
}
