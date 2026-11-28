package com.gigabyte.bookstore.presentation.components

import android.util.Log
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.gigabyte.bookstore.BanglaAudiobookApp
import com.gigabyte.bookstore.data.ads.AdConfig
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError

private const val TAG = "AdMobBannerAd"

/**
 * Jetpack Compose wrapper for Google AdMob Banner Ads with Meta Audience Network Bidding mediation.
 * Supports standard banner (320x50), medium rectangle (300x250), etc.
 * Includes automatic lifecycle management (adView.destroy) and graceful fallback.
 */
@Composable
fun FacebookBannerAd(
    modifier: Modifier = Modifier,
    placementId: String = AdConfig.ADMOB_BANNER_AD_UNIT_ID,
    adSize: AdSize = AdSize.MEDIUM_RECTANGLE,
    showContainer: Boolean = true,
    fallback: @Composable (() -> Unit)? = null
) {
    if (!AdConfig.isAdsEnabled) {
        fallback?.invoke()
        return
    }

    val context = LocalContext.current
    val app = context.applicationContext as? BanglaAudiobookApp
    val isPaid = app?.appPreferences?.let {
        it.isBundleUnlocked("audiobook_bundle") ||
        it.isBundleUnlocked("mega_bundle") ||
        it.isAdmin.value ||
        it.userStatus.value == "active"
    } ?: false

    if (isPaid) {
        fallback?.invoke()
        return
    }

    var isAdLoaded by remember { mutableStateOf(false) }
    var isAdFailed by remember { mutableStateOf(false) }
    var currentAdView by remember { mutableStateOf<AdView?>(null) }

    DisposableEffect(Unit) {
        onDispose {
            currentAdView?.destroy()
        }
    }

    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        if (isAdFailed) {
            fallback?.invoke()
        } else {
            val content: @Composable () -> Unit = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    contentAlignment = Alignment.Center
                ) {
                    AndroidView(
                        modifier = Modifier.wrapContentHeight(),
                        factory = { context ->
                            val frameLayout = FrameLayout(context).apply {
                                layoutParams = ViewGroup.LayoutParams(
                                    ViewGroup.LayoutParams.MATCH_PARENT,
                                    ViewGroup.LayoutParams.WRAP_CONTENT
                                )
                            }

                            val adView = AdView(context).apply {
                                setAdSize(adSize)
                                adUnitId = placementId
                                adListener = object : AdListener() {
                                    override fun onAdLoaded() {
                                        Log.d(TAG, "AdMob + Meta Banner loaded successfully: $placementId")
                                        isAdLoaded = true
                                        isAdFailed = false
                                    }

                                    override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                                        Log.w(TAG, "Banner failed to load: ${loadAdError.message} (code: ${loadAdError.code})")
                                        isAdFailed = true
                                        isAdLoaded = false
                                    }

                                    override fun onAdClicked() {
                                        Log.d(TAG, "Banner clicked")
                                    }

                                    override fun onAdImpression() {
                                        Log.d(TAG, "Banner impression logged")
                                    }
                                }
                            }
                            currentAdView = adView
                            frameLayout.addView(adView)
                            adView.loadAd(AdRequest.Builder().build())
                            frameLayout
                        },
                        update = { _ -> }
                    )

                    // Small "Ad" or "বিজ্ঞাপন" sponsored badge in corner
                    if (isAdLoaded) {
                        Surface(
                            color = Color(0x99000000),
                            shape = RoundedCornerShape(topStart = 8.dp, bottomEnd = 6.dp),
                            modifier = Modifier
                                .align(Alignment.TopStart)
                                .padding(2.dp)
                        ) {
                            Text(
                                text = "Ad · বিজ্ঞাপন",
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFE2E8F0),
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }
                }
            }

            if (showContainer) {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.15f)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                ) {
                    content()
                }
            } else {
                content()
            }
        }
    }
}
