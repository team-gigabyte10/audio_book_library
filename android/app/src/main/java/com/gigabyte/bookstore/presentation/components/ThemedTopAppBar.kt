package com.gigabyte.bookstore.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import com.gigabyte.bookstore.ui.theme.DarkAppBarColor
import com.gigabyte.bookstore.ui.theme.DarkAppBarTitleColor
import com.gigabyte.bookstore.ui.theme.DarkStatusBarColor
import com.gigabyte.bookstore.ui.theme.LightAppBarColor
import com.gigabyte.bookstore.ui.theme.LightAppBarTitleColor
import com.gigabyte.bookstore.ui.theme.LightStatusBarColor

/**
 * A custom top app bar that ensures a distinct, dedicated color for the System Status Bar
 * above the standard App Bar, providing visual depth and a polished aesthetic.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThemedTopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    statusBarColor: Color? = null,
    appBarColor: Color? = null,
    titleContentColor: Color? = null,
    navigationIconContentColor: Color? = null,
    actionIconContentColor: Color? = null
) {
    val isDark = MaterialTheme.colorScheme.surface.luminance() < 0.5f

    val resolvedStatusBarColor = statusBarColor ?: if (isDark) DarkStatusBarColor else LightStatusBarColor
    val resolvedAppBarColor = appBarColor ?: if (isDark) DarkAppBarColor else LightAppBarColor
    val resolvedTitleColor = titleContentColor ?: if (isDark) DarkAppBarTitleColor else LightAppBarTitleColor
    val resolvedNavColor = navigationIconContentColor ?: resolvedTitleColor
    val resolvedActionColor = actionIconContentColor ?: resolvedTitleColor

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        // Status bar area background
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .windowInsetsTopHeight(WindowInsets.statusBars)
                .background(resolvedStatusBarColor)
        )
        // TopAppBar with zero window insets so it doesn't duplicate the status bar inset
        TopAppBar(
            title = title,
            navigationIcon = navigationIcon,
            actions = actions,
            windowInsets = WindowInsets(0, 0, 0, 0),
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = resolvedAppBarColor,
                titleContentColor = resolvedTitleColor,
                navigationIconContentColor = resolvedNavColor,
                actionIconContentColor = resolvedActionColor
            )
        )
    }
}
