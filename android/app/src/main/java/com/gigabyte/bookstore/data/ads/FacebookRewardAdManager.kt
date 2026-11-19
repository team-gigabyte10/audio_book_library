package com.gigabyte.bookstore.data.ads

import android.app.Activity
import android.content.Context
import android.util.Log
import com.facebook.ads.Ad
import com.facebook.ads.AdError
import com.facebook.ads.RewardedVideoAd
import com.facebook.ads.RewardedVideoAdListener

private const val TAG = "FacebookRewardAdManager"

/**
 * Singleton manager to preload and display Meta Audience Network Rewarded Video Ads.
 * Used to grant 24-hour course module unlocks to trial users.
 */
class FacebookRewardAdManager(private val context: Context) {

    private var rewardedVideoAd: RewardedVideoAd? = null
    private var isAdLoaded = false
    private var isAdLoading = false

    private var activeOnRewardEarned: (() -> Unit)? = null
    private var activeOnClosed: (() -> Unit)? = null
    private var activeOnError: ((String) -> Unit)? = null

    init {
        preloadAd()
    }

    /**
     * Preloads a rewarded video ad in background so it displays instantly when requested.
     */
    fun preloadAd(placementId: String = AdConfig.FB_REWARDED_PLACEMENT_ID) {
        if (!AdConfig.isAdsEnabled || isAdLoaded || isAdLoading) return

        isAdLoading = true
        val ad = RewardedVideoAd(context, placementId)
        val listener = object : RewardedVideoAdListener {
            override fun onError(ad: Ad?, error: AdError?) {
                Log.w(TAG, "Preload failed: ${error?.errorMessage} (code: ${error?.errorCode})")
                isAdLoaded = false
                isAdLoading = false
                activeOnError?.invoke(error?.errorMessage ?: "বিজ্ঞাপন প্লে করা যায়নি")
            }

            override fun onAdLoaded(ad: Ad?) {
                Log.d(TAG, "Rewarded video preloaded successfully for placement: $placementId")
                isAdLoaded = true
                isAdLoading = false
            }

            override fun onAdClicked(ad: Ad?) {}
            override fun onLoggingImpression(ad: Ad?) {}
            override fun onRewardedVideoCompleted() {
                Log.d(TAG, "User completed video. Reward earned!")
                activeOnRewardEarned?.invoke()
            }
            override fun onRewardedVideoClosed() {
                Log.d(TAG, "Rewarded video dismissed.")
                isAdLoaded = false
                activeOnClosed?.invoke()
                preloadAd(placementId)
            }
        }

        try {
            ad.loadAd(ad.buildLoadAdConfig().withAdListener(listener).build())
            rewardedVideoAd = ad
        } catch (e: Exception) {
            Log.e(TAG, "Exception while preloading rewarded ad", e)
            isAdLoading = false
        }
    }

    fun isAdReady(): Boolean {
        val ad = rewardedVideoAd
        return isAdLoaded && ad != null && ad.isAdLoaded && !ad.isAdInvalidated
    }

    /**
     * Shows the rewarded video ad.
     * @param activity The host Activity
     * @param onRewardEarned Called only when the user finishes watching the video completely
     * @param onClosed Called when the ad is closed (regardless of whether reward was given)
     * @param onError Called if the ad failed to show or load
     */
    fun showAd(
        activity: Activity,
        placementId: String = AdConfig.FB_REWARDED_PLACEMENT_ID,
        onRewardEarned: () -> Unit,
        onClosed: (() -> Unit)? = null,
        onError: ((String) -> Unit)? = null
    ) {
        this.activeOnRewardEarned = onRewardEarned
        this.activeOnClosed = onClosed
        this.activeOnError = onError

        val ad = rewardedVideoAd
        if (ad != null && ad.isAdLoaded && !ad.isAdInvalidated) {
            try {
                ad.show(ad.buildShowAdConfig().build())
            } catch (e: Exception) {
                Log.e(TAG, "Exception while showing rewarded ad", e)
                onError?.invoke(e.localizedMessage ?: "Unknown error")
                preloadAd(placementId)
            }
        } else {
            // Ad not ready: try to load and notify caller
            Log.w(TAG, "Ad was not preloaded, attempting direct load & show")
            isAdLoading = true
            val freshAd = RewardedVideoAd(activity, placementId)

            val freshListener = object : RewardedVideoAdListener {
                override fun onAdLoaded(ad: Ad?) {
                    isAdLoading = false
                    isAdLoaded = true
                    try {
                        freshAd.show(freshAd.buildShowAdConfig().build())
                    } catch (e: Exception) {
                        onError?.invoke("বিজ্ঞাপন দেখানো সম্ভব হয়নি")
                    }
                }

                override fun onRewardedVideoCompleted() {
                    activeOnRewardEarned?.invoke()
                }

                override fun onRewardedVideoClosed() {
                    isAdLoaded = false
                    activeOnClosed?.invoke()
                    preloadAd(placementId)
                }

                override fun onError(ad: Ad?, error: AdError?) {
                    isAdLoading = false
                    isAdLoaded = false
                    Log.w(TAG, "Fresh ad load failed: ${error?.errorMessage}")
                    activeOnError?.invoke(error?.errorMessage ?: "বিজ্ঞাপন লোড করা যায়নি")
                }

                override fun onAdClicked(ad: Ad?) {}
                override fun onLoggingImpression(ad: Ad?) {}
            }

            try {
                freshAd.loadAd(freshAd.buildLoadAdConfig().withAdListener(freshListener).build())
                rewardedVideoAd = freshAd
            } catch (e: Exception) {
                isAdLoading = false
                onError?.invoke("বিজ্ঞাপন সার্ভিস প্রস্তুত নয়")
            }
        }
    }

    companion object {
        @Volatile
        private var instance: FacebookRewardAdManager? = null

        fun getInstance(context: Context): FacebookRewardAdManager {
            return instance ?: synchronized(this) {
                instance ?: FacebookRewardAdManager(context.applicationContext).also { instance = it }
            }
        }
    }
}
