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
     * Official Meta Audience Network test placement ID format for Rewarded Video Ads.
     * Replace with your production Rewarded Placement ID from Meta Monetization Manager.
     * Format: "YOUR_PLACEMENT_ID" or "VID_HD_16_9_15S_APP_INSTALL#YOUR_PLACEMENT_ID"
     */
    const val FB_REWARDED_PLACEMENT_ID = "VID_HD_16_9_15S_APP_INSTALL#YOUR_PLACEMENT_ID"

    /**
     * Duration in milliseconds for which a course module remains unlocked after watching a video ad.
     * 24 Hours = 24 * 60 * 60 * 1000 ms.
     */
    const val MODULE_UNLOCK_DURATION_MS = 24 * 60 * 60 * 1000L

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
