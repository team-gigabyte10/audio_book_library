package com.gigabyte.bookstore.data.ads

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import com.gigabyte.bookstore.BanglaAudiobookApp
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.appopen.AppOpenAd
import java.util.Date

private const val TAG = "AppOpenAdManager"

/**
 * Manages Google AdMob App Open Ads for highest eCPM monetization ($2.50 - $5.00+).
 * Automatically handles preloading, foreground resume tracking, 4-hour cooldowns,
 * and background audio playback safety (never interrupts when user is listening).
 */
class AppOpenAdManager(private val app: BanglaAudiobookApp) : Application.ActivityLifecycleCallbacks {

    private var currentActivity: Activity? = null
    private var appOpenAd: AppOpenAd? = null
    private var isLoadingAd = false
    private var isShowingAd = false
    private var loadTime: Long = 0L
    private var lastShownTime: Long = 0L

    // 4 hours cooldown between App Open Ads on background return
    private val COOLDOWN_MS = 4 * 60 * 60 * 1000L

    // Do NOT show jarring ads on cold start app launch
    private var coldStartAdAttempted = true

    init {
        app.registerActivityLifecycleCallbacks(this)
        preloadAd(app)
    }

    /**
     * Preloads an App Open Ad silently in background.
     */
    fun preloadAd(context: Context) {
        if (!AdConfig.isAdsEnabled || isLoadingAd || isAdAvailable()) return

        isLoadingAd = true
        val adRequest = AdRequest.Builder().build()
        val adUnitId = AdConfig.getAppOpenAdUnitId()

        AppOpenAd.load(
            context,
            adUnitId,
            adRequest,
            object : AppOpenAd.AppOpenAdLoadCallback() {
                override fun onAdLoaded(ad: AppOpenAd) {
                    Log.d(TAG, "App Open Ad loaded successfully: $adUnitId")
                    appOpenAd = ad
                    isLoadingAd = false
                    loadTime = Date().time

                    // If cold-start ad was waiting on first launch, attempt to show
                    if (!coldStartAdAttempted && currentActivity != null) {
                        showAdIfAvailable(currentActivity!!)
                    }
                }

                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                    Log.w(TAG, "App Open Ad failed to load: ${loadAdError.message} (code: ${loadAdError.code})")
                    appOpenAd = null
                    isLoadingAd = false
                }
            }
        )
    }

    /**
     * Checks if cached ad exists and was loaded less than 4 hours ago.
     */
    private fun isAdAvailable(): Boolean {
        return appOpenAd != null && wasLoadTimeLessThanNHoursAgo(4)
    }

    private fun wasLoadTimeLessThanNHoursAgo(numHours: Long): Boolean {
        val dateDifference: Long = Date().time - loadTime
        val numMilliSecondsPerHour: Long = 3600000
        return dateDifference < numMilliSecondsPerHour * numHours
    }

    /**
     * Shows the App Open Ad if available, passes all safety checks, and adheres to cooldown.
     */
    fun showAdIfAvailable(
        activity: Activity,
        onShowAdCompleteListener: () -> Unit = {}
    ) {
        if (isShowingAd) {
            onShowAdCompleteListener()
            return
        }

        // Safety 1: Global ads switch
        if (!AdConfig.isAdsEnabled) {
            onShowAdCompleteListener()
            return
        }

        // Safety 2: Check if user is a paid member
        val isPaid = app.appPreferences.let {
            it.isBundleUnlocked("audiobook_bundle") ||
            it.isBundleUnlocked("mega_bundle") ||
            it.isAdmin.value ||
            it.userStatus.value == "active"
        }
        if (isPaid) {
            Log.d(TAG, "Skipping App Open Ad: User is a paid/premium member.")
            onShowAdCompleteListener()
            return
        }

        // Safety 3: Do NOT interrupt active audio playback or active lesson speech
        val isAudioPlaying = try {
            app.player.playbackState.value.isPlaying || app.ttsManager.isSpeaking.value
        } catch (_: Exception) {
            false
        }
        if (isAudioPlaying) {
            Log.d(TAG, "Skipping App Open Ad: Audio playback or TTS is actively playing.")
            onShowAdCompleteListener()
            return
        }

        // Safety 3: Ad availability
        if (!isAdAvailable()) {
            Log.d(TAG, "App Open Ad is not available yet. Preloading...")
            onShowAdCompleteListener()
            preloadAd(activity)
            return
        }

        // Safety 4: Cooldown check (unless it's the very first cold start)
        val now = System.currentTimeMillis()
        if (coldStartAdAttempted && (now - lastShownTime < COOLDOWN_MS)) {
            Log.d(TAG, "App Open Ad skipped: In cooldown period.")
            onShowAdCompleteListener()
            return
        }

        coldStartAdAttempted = true
        isShowingAd = true

        appOpenAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
            override fun onAdDismissedFullScreenContent() {
                Log.d(TAG, "App Open Ad dismissed.")
                appOpenAd = null
                isShowingAd = false
                lastShownTime = System.currentTimeMillis()
                onShowAdCompleteListener()
                preloadAd(activity)
            }

            override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                Log.w(TAG, "App Open Ad failed to show: ${adError.message}")
                appOpenAd = null
                isShowingAd = false
                onShowAdCompleteListener()
                preloadAd(activity)
            }

            override fun onAdShowedFullScreenContent() {
                Log.d(TAG, "App Open Ad shown on screen.")
            }
        }

        appOpenAd?.show(activity)
    }

    // --- ActivityLifecycleCallbacks ---

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}

    override fun onActivityStarted(activity: Activity) {
        currentActivity = activity
        // Attempt to show on cold start or when returning from long background
        val now = System.currentTimeMillis()
        if (!coldStartAdAttempted || (now - lastShownTime > COOLDOWN_MS)) {
            showAdIfAvailable(activity)
        }
    }

    override fun onActivityResumed(activity: Activity) {
        currentActivity = activity
    }

    override fun onActivityPaused(activity: Activity) {}

    override fun onActivityStopped(activity: Activity) {}

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}

    override fun onActivityDestroyed(activity: Activity) {
        if (currentActivity === activity) {
            currentActivity = null
        }
    }
}
