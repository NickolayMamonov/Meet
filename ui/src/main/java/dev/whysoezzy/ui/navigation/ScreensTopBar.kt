package dev.whysoezzy.ui.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable

sealed class ScreensTopBar(
    val navigationIcon: @Composable (() -> Unit)? = null,
    val title: @Composable (() -> Unit)? = null,
    val actions: @Composable RowScope.() -> Unit = {}
)