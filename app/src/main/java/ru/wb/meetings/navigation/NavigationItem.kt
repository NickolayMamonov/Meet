package dev.whysoezzy.testwbproject.navigation

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val title : String,
    val route : String,
    val selectedIcon: Int,
    val unSelectedIcon : Int,
    val badgeCount : Int? = null
)