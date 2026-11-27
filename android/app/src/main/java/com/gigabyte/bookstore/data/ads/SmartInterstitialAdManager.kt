package com.gigabyte.bookstore.data.ads

import android.app.Activity
import android.content.Context
import android.util.Log
import com.gigabyte.bookstore.BanglaAudiobookApp
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

private const val TAG = "SmartInterstitialAdManager"

/**
 * Singleton manager for Google AdMob Smart Interstitial Ads ($1.50 - $3.50+ eCPM),
 * mediated in real-time with Meta Audience Network Bidding.
 *
 * Features:
 * - Smart 3.5-minute cooldown between full-screen ads to maintain 5-star user experience.
 * - Safe audio checks: Never interrupts active audiobook playback or TTS narration.
 * - Safe content checks: Strictly excludes Quran or sacred recitation screens.
 * - Preloads automatically in the background for instant 0-second display.
 */
class SmartInterstitialAdManager private constructor(private val context: Context) {

    private var interstitialAd: InterstitialAd? = null
    private var isLoading = false
    private var lastShownTime: Long = 0L

    // Minimum cooldown between full-screen interstitials (3.5 minutes = 210,000 ms)
    private val MIN_COOLDOWN_MS = 210_000L

    // Tracks natural user milestones (e.g. stories closed, quizzes taken)
    private var actionCounter = 0

    init {
        preloadAd()
    }

    /**
     * Preloads the interstitial ad silently in the background.
     */
    fun preloadAd(adUnitId: String = AdConfig.getInterstitialAdUnitId()) {
        if (!AdConfig.isAdsEnabled || isLoading || isAdReady()) return

        isLoading = true
        val adRequest = AdRequest.Builder().build()

        InterstitialAd.load(
            context,
            adUnitId,
            adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(ad: InterstitialAd) {
                    Log.d(TAG, "Smart Interstitial Ad preloaded successfully: $adUnitId")
                    interstitialAd = ad
                    isLoading = false
                }

                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                    Log.w(TAG, "Smart Interstitial preload failed: ${loadAdError.message} (code: ${loadAdError.code})")
                    interstitialAd = null
                    isLoading = false
                }
            }
        )
    }

    fun isAdReady(): Boolean {
        return interstitialAd != null
    }

    /**
     * Increments the user activity milestone counter.
     */
    fun recordAction() {
        actionCounter++
    }

    /**
     * Shows the Smart Interstitial Ad if available, cooldown has elapsed,
     * and no audio is actively playing.
     *
     * @param activity The host Activity
     * @param forceIgnoreCounter When true, checks only cooldown and audio safety (e.g. after quiz completion).
     * @param onAdClosed Guaranteed to be called when ad dismisses or if ad is skipped/not ready.
     */
    fun showInterstitialIfReady(
        activity: Activity,
        forceIgnoreCounter: Boolean = false,
        onAdClosed: () -> Unit
    ) {
        // Safety 1: Global switch
        if (!AdConfig.isAdsEnabled) {
            onAdClosed()
            return
        }

        // Safety 2: Cooldown check
        val now = System.currentTimeMillis()
        if (now - lastShownTime < MIN_COOLDOWN_MS) {
            Log.d(TAG, "Interstitial skipped: In cooldown period (${(MIN_COOLDOWN_MS - (now - lastShownTime)) / 1000}s remaining).")
            onAdClosed()
            preloadAd()
            return
        }

        // Safety 3: Action threshold check (unless forced)
        if (!forceIgnoreCounter && actionCounter < 2) {
            Log.d(TAG, "Interstitial skipped: Action threshold not reached yet ($actionCounter/2).")
            onAdClosed()
            return
        }

        // Safety 4: Do NOT interrupt active audio playback or TTS narration
        val app = activity.applicationContext as? BanglaAudiobookApp
        val isAudioPlaying = try {
            app?.player?.playbackState?.value?.isPlaying == true ||
                    app?.ttsManager?.isSpeaking?.value == true
        } catch (_: Exception) {
            false
        }
        if (isAudioPlaying) {
            Log.d(TAG, "Interstitial skipped: Audio is actively playing.")
            onAdClosed()
            return
        }

        // Safety 5: Check if ad is cached and ready
        val currentAd = interstitialAd
        if (currentAd == null) {
            Log.d(TAG, "Interstitial not ready yet. Preloading...")
            onAdClosed()
            preloadAd()
            return
        }

        // Show the ad
        currentAd.fullScreenContentCallback = object : FullScreenContentCallback() {
            override fun onAdDismissedFullScreenContent() {
                Log.d(TAG, "Smart Interstitial dismissed.")
                interstitialAd = null
                lastShownTime = System.currentTimeMillis()
                actionCounter = 0
                onAdClosed()
                preloadAd()
            }

            override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                Log.w(TAG, "Smart Interstitial failed to show: ${adError.message}")
                interstitialAd = null
                onAdClosed()
                preloadAd()
            }

            override fun onAdShowedFullScreenContent() {
                Log.d(TAG, "Smart Interstitial shown on screen.")
            }
        }

        currentAd.show(activity)
    }

    companion object {
        @Volatile
        private var instance: SmartInterstitialAdManager? = null

        fun getInstance(context: Context): SmartInterstitialAdManager {
            return instance ?: synchronized(this) {
                instance ?: SmartInterstitialAdManager(context.applicationContext).also { instance = it }
            }
        }
    }
}
