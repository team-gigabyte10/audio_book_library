package com.gigabyte.bookstore.data.ads

/**
 * Central configuration for Meta Audience Network (Facebook Ads).
 * When running in test mode, test placement IDs or test mode flags are enabled.
 */
object AdConfig {
    /**
     * Official Google AdMob Application ID.
     */
    const val ADMOB_APP_ID = "ca-app-pub-5437449031023884~6246574950"

    /**
     * Official Google AdMob Banner Ad Unit ID (Home Banner Ad).
     * Mediates Meta Audience Network in real-time.
     */
    const val ADMOB_BANNER_AD_UNIT_ID = "ca-app-pub-5437449031023884/5175880910"

    /**
     * Official Google AdMob Rewarded Ad Unit ID (Course Unlock Reward Ad).
     * Mediates Meta Audience Network in real-time.
     */
    const val ADMOB_REWARDED_AD_UNIT_ID = "ca-app-pub-5437449031023884/5670317892"

    /**
     * Official Google AdMob App Open Ad Unit ID.
     */
    const val ADMOB_APP_OPEN_AD_UNIT_ID = "ca-app-pub-5437449031023884/6421729571"

    /**
     * Official Google AdMob Smart Interstitial Ad Unit ID.
     * Mediates Meta Audience Network in real-time.
     */
    const val ADMOB_INTERSTITIAL_AD_UNIT_ID = "ca-app-pub-5437449031023884/6448156446"

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
     * Official Meta Audience Network placement ID for Smart Interstitial Ads.
     */
    const val FB_INTERSTITIAL_PLACEMENT_ID = "29550780014571719_29650193074630412"

    // Google Official Test Ad Unit IDs (used in debug builds when isTestMode is enabled)
    const val TEST_APP_OPEN_AD_UNIT_ID = "ca-app-pub-3940256099942544/9257395921"
    const val TEST_INTERSTITIAL_AD_UNIT_ID = "ca-app-pub-3940256099942544/1033173712"

    fun getAppOpenAdUnitId(): String {
        return if (com.gigabyte.bookstore.BuildConfig.DEBUG && isTestMode) TEST_APP_OPEN_AD_UNIT_ID else ADMOB_APP_OPEN_AD_UNIT_ID
    }

    fun getInterstitialAdUnitId(): String {
        return if (com.gigabyte.bookstore.BuildConfig.DEBUG && isTestMode) TEST_INTERSTITIAL_AD_UNIT_ID else ADMOB_INTERSTITIAL_AD_UNIT_ID
    }

    /**
     * Duration in milliseconds for which a course module remains unlocked after watching a video ad.
     * 24 Hours = 24 * 60 * 60 * 1000 ms.
     */
    const val MODULE_UNLOCK_DURATION_MS = 24 * 60 * 60 * 1000L

    /**
     * When true, requests Meta test ads.
     * Automatically true on debug builds, and false on release production builds
     * so real ad impressions and bid requests are recorded in Meta Monetisation Manager.
     */
    var isTestMode: Boolean = com.gigabyte.bookstore.BuildConfig.DEBUG

    /**
     * Master switch to enable or disable ads across the app.
     */
    var isAdsEnabled: Boolean = true

    /**
     * Returns false for sacred learning content (Holy Quran & Tajweed recitation).
     * Quran learning is 100% ad-free and free for all users.
     * Arabic language and spoken course allows ads (e.g., rewarded ads to unlock lessons) like other language courses.
     */
    fun isAdAllowedForCourse(courseType: String?): Boolean {
        if (courseType == null) return true
        val clean = courseType.trim().lowercase()
        val isQuran = clean == "quran" || clean.startsWith("qr") || clean.contains("quran")
        return !isQuran
    }

    /**
     * Returns false for sacred or Islamic recitation/Quranic texts.
     * Quran reading and meaning are completely ad-free.
     */
    fun isAdAllowedForContent(title: String?, id: String?): Boolean {
        val combined = "${title.orEmpty()} ${id.orEmpty()}".lowercase()
        val isQuran = combined.contains("quran") || combined.contains("কুরআন") || combined.contains("কোরআন") || combined.contains("তাজবীদ")
        return !isQuran
    }
}
