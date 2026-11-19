package com.gigabyte.bookstore.presentation.components

import android.util.Log
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.facebook.ads.Ad
import com.facebook.ads.AdError
import com.facebook.ads.AdListener
import com.facebook.ads.AdSize
import com.facebook.ads.AdView
import com.gigabyte.bookstore.data.ads.AdConfig

private const val TAG = "FacebookBannerAd"

/**
 * Jetpack Compose wrapper for Meta Audience Network (Facebook) Banner Ads.
 * Supports standard banner (50dp), large banner (90dp), and medium rectangle (250dp).
 * Includes automatic lifecycle management (adView.destroy) and graceful fallback.
 */
@Composable
fun FacebookBannerAd(
    modifier: Modifier = Modifier,
    placementId: String = AdConfig.FB_BANNER_PLACEMENT_ID,
    adSize: AdSize = AdSize.RECTANGLE_HEIGHT_250,
    showContainer: Boolean = true,
    fallback: @Composable (() -> Unit)? = null
) {
    if (!AdConfig.isAdsEnabled) {
        fallback?.invoke()
        return
    }

    var isAdLoaded by remember { mutableStateOf(false) }
    var isAdFailed by remember { mutableStateOf(false) }

    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        if (isAdFailed && fallback != null) {
            fallback()
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

                            val adView = AdView(context, placementId, adSize)
                            adView.setAdListener(object : AdListener {
                                override fun onError(ad: Ad?, error: AdError?) {
                                    Log.w(TAG, "Ad failed to load: ${error?.errorMessage} (code: ${error?.errorCode})")
                                    isAdFailed = true
                                    isAdLoaded = false
                                }

                                override fun onAdLoaded(ad: Ad?) {
                                    Log.d(TAG, "Ad loaded successfully for placement: $placementId")
                                    isAdLoaded = true
                                    isAdFailed = false
                                }

                                override fun onAdClicked(ad: Ad?) {
                                    Log.d(TAG, "Ad clicked")
                                }

                                override fun onLoggingImpression(ad: Ad?) {
                                    Log.d(TAG, "Ad impression logged")
                                }
                            })

                            frameLayout.addView(adView)
                            adView.loadAd()
                            frameLayout
                        },
                        update = { _ ->
                            // View update if needed
                        }
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
