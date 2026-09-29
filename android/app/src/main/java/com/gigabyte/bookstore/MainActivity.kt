package com.gigabyte.bookstore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gigabyte.bookstore.presentation.navigation.AppNavHost
import com.gigabyte.bookstore.ui.theme.BanglaAudiobookTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val app = application as BanglaAudiobookApp
        setContent {
            val themeMode by app.preferences.themeMode.collectAsStateWithLifecycle()
            val systemInDark = isSystemInDarkTheme()
            val isDarkTheme = when (themeMode) {
                "light" -> false
                "dark" -> true
                else -> systemInDark
            }
            BanglaAudiobookTheme(darkTheme = isDarkTheme) {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppNavHost()
                }
            }
        }
    }
}
