package com.gigabyte.bookstore.data.ads

/**
 * Central configuration for Meta Audience Network (Facebook Ads).
 * When running in test mode, test placement IDs or test mode flags are enabled.
 */
object AdConfig {
    const val FB_APP_ID = "29550780014571719"

    /**
     * Official Meta Audience Network placement ID for Banners.
     */
    const val FB_BANNER_PLACEMENT_ID = "29550780014571719_29552070077776046"

    /**
     * Official Meta Audience Network placement ID for Rewarded Ads.
     */
    const val FB_REWARDED_PLACEMENT_ID = "29550780014571719_29552101711106216"

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

    /**
     * Returns false for sacred and sensitive learning courses (Quran & Arabic).
     * No ads (rewarded video, banner, or interstitial) will ever be loaded or shown for these courses.
     */
    fun isAdAllowedForCourse(courseType: String?): Boolean {
        if (courseType == null) return true
        val clean = courseType.trim().lowercase()
        val isQuran = clean == "quran" || clean.startsWith("qr") || clean.contains("quran")
        val isArabic = clean == "arabic" || clean.startsWith("ar") || clean.contains("arabic")
        return !isQuran && !isArabic
    }

    /**
     * Returns false for sacred or Islamic books/content (Quran, Hadith, Arabic).
     * No banner or promotional ads will be shown on reader pages for such titles.
     */
    fun isAdAllowedForContent(title: String?, id: String?): Boolean {
        val combined = "${title.orEmpty()} ${id.orEmpty()}".lowercase()
        val isQuran = combined.contains("quran") || combined.contains("কুরআন") || combined.contains("কোরআন") || combined.contains("তাজবীদ")
        val isArabic = combined.contains("arabic") || combined.contains("আরবি")
        return !isQuran && !isArabic
    }
}
