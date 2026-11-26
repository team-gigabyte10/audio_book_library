package com.gigabyte.bookstore.data.ads

import android.app.Activity
import android.content.Context
import android.util.Log
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback

private const val TAG = "AdMobRewardAdManager"

/**
 * Singleton manager to preload and display Google AdMob Rewarded Video Ads,
 * with real-time Meta Audience Network Bidding mediation.
 * Used to grant 24-hour course module unlocks to trial users.
 */
class FacebookRewardAdManager(private val context: Context) {

    private var admobRewardedAd: RewardedAd? = null
    private var isAdLoaded = false
    private var isAdLoading = false

    private var activeOnRewardEarned: (() -> Unit)? = null
    private var activeOnClosed: (() -> Unit)? = null
    private var activeOnError: ((String) -> Unit)? = null

    init {
        preloadAd()
    }

    /**
     * Clears all active callbacks to prevent callback leaks across screen transitions.
     */
    fun clearCallbacks() {
        activeOnRewardEarned = null
        activeOnClosed = null
        activeOnError = null
    }

    private fun dispatchRewardEarned() {
        val callback = activeOnRewardEarned
        activeOnRewardEarned = null
        callback?.invoke()
    }

    private fun dispatchClosed() {
        val callback = activeOnClosed
        clearCallbacks()
        callback?.invoke()
    }

    private fun dispatchError(errorMsg: String) {
        val callback = activeOnError
        clearCallbacks()
        callback?.invoke(errorMsg)
    }

    /**
     * Preloads a rewarded video ad in background via AdMob Mediation (bidding Meta Audience Network).
     * Preload runs completely silently; background errors are never dispatched to user-facing callbacks.
     */
    fun preloadAd(adUnitId: String = AdConfig.ADMOB_REWARDED_AD_UNIT_ID) {
        if (!AdConfig.isAdsEnabled || isAdLoaded || isAdLoading) return

        isAdLoading = true
        val adRequest = AdRequest.Builder().build()
        RewardedAd.load(
            context,
            adUnitId,
            adRequest,
            object : RewardedAdLoadCallback() {
                override fun onAdLoaded(ad: RewardedAd) {
                    Log.d(TAG, "Rewarded video preloaded successfully via AdMob + Meta Mediation: $adUnitId")
                    admobRewardedAd = ad
                    isAdLoaded = true
                    isAdLoading = false
                }

                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                    Log.w(TAG, "Silent preload failed: ${loadAdError.message} (code: ${loadAdError.code})")
                    admobRewardedAd = null
                    isAdLoaded = false
                    isAdLoading = false
                }
            }
        )
    }

    fun isAdReady(): Boolean {
        return isAdLoaded && admobRewardedAd != null
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
        placementId: String = AdConfig.ADMOB_REWARDED_AD_UNIT_ID,
        onRewardEarned: () -> Unit,
        onClosed: (() -> Unit)? = null,
        onError: ((String) -> Unit)? = null
    ) {
        this.activeOnRewardEarned = onRewardEarned
        this.activeOnClosed = onClosed
        this.activeOnError = onError

        val ad = admobRewardedAd
        if (ad != null && isAdLoaded) {
            ad.fullScreenContentCallback = object : FullScreenContentCallback() {
                override fun onAdShowedFullScreenContent() {
                    Log.d(TAG, "Ad showed full screen content.")
                }

                override fun onAdDismissedFullScreenContent() {
                    Log.d(TAG, "Ad dismissed by user.")
                    isAdLoaded = false
                    admobRewardedAd = null
                    dispatchClosed()
                    preloadAd(placementId)
                }

                override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                    Log.e(TAG, "Ad failed to show: ${adError.message}")
                    isAdLoaded = false
                    admobRewardedAd = null
                    dispatchError(adError.message)
                    preloadAd(placementId)
                }
            }

            try {
                ad.show(activity) { rewardItem ->
                    Log.d(TAG, "User earned reward: ${rewardItem.amount} ${rewardItem.type}")
                    dispatchRewardEarned()
                }
            } catch (e: Exception) {
                Log.e(TAG, "Exception while showing rewarded ad", e)
                dispatchError(e.localizedMessage ?: "বিজ্ঞাপন দেখানো সম্ভব হয়নি")
                preloadAd(placementId)
            }
        } else {
            // Ad not ready: try to load and notify caller
            Log.w(TAG, "Ad was not preloaded, attempting direct load & show via AdMob")
            isAdLoading = true
            val adRequest = AdRequest.Builder().build()
            RewardedAd.load(
                activity,
                placementId,
                adRequest,
                object : RewardedAdLoadCallback() {
                    override fun onAdLoaded(freshAd: RewardedAd) {
                        isAdLoading = false
                        isAdLoaded = true
                        admobRewardedAd = freshAd

                        freshAd.fullScreenContentCallback = object : FullScreenContentCallback() {
                            override fun onAdDismissedFullScreenContent() {
                                isAdLoaded = false
                                admobRewardedAd = null
                                dispatchClosed()
                                preloadAd(placementId)
                            }

                            override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                                isAdLoaded = false
                                admobRewardedAd = null
                                dispatchError(adError.message)
                                preloadAd(placementId)
                            }
                        }

                        try {
                            freshAd.show(activity) {
                                dispatchRewardEarned()
                            }
                        } catch (e: Exception) {
                            dispatchError("বিজ্ঞাপন দেখানো সম্ভব হয়নি")
                        }
                    }

                    override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                        isAdLoading = false
                        isAdLoaded = false
                        Log.w(TAG, "Fresh ad load failed: ${loadAdError.message}")
                        dispatchError(loadAdError.message)
                    }
                }
            )
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
