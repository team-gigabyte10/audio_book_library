package com.gigabyte.bookstore

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gigabyte.bookstore.presentation.components.BanglaVoiceInstallPrompt
import com.gigabyte.bookstore.presentation.components.ForceUpdateDialog
import com.gigabyte.bookstore.presentation.navigation.AppNavHost
import com.gigabyte.bookstore.ui.theme.BanglaAudiobookTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val app = application as BanglaAudiobookApp
        setContent {
            val themeMode by app.preferences.themeMode.collectAsStateWithLifecycle()
            val pricingConfig by app.preferences.pricingConfig.collectAsStateWithLifecycle()
            val systemInDark = isSystemInDarkTheme()
            val isDarkTheme = when (themeMode) {
                "light" -> false
                "dark" -> true
                else -> systemInDark
            }

            val currentVersionCode = BuildConfig.VERSION_CODE
            val isMandatoryUpdate = remember(pricingConfig, currentVersionCode) {
                (currentVersionCode < pricingConfig.minRequiredVersionCode) ||
                (pricingConfig.isForceUpdateRequired && currentVersionCode < pricingConfig.latestVersionCode)
            }

            val view = LocalView.current
            if (!view.isInEditMode) {
                SideEffect {
                    val window = (view.context as Activity).window
                    val insetsController = WindowCompat.getInsetsController(window, view)
                    insetsController.isAppearanceLightStatusBars = !isDarkTheme
                    insetsController.isAppearanceLightNavigationBars = !isDarkTheme
                }
            }

            BanglaAudiobookTheme(darkTheme = isDarkTheme) {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppNavHost()
                    BanglaVoiceInstallPrompt()
                    if (isMandatoryUpdate) {
                        ForceUpdateDialog(config = pricingConfig)
                    }
                }
            }
        }
    }
}
