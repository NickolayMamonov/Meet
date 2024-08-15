package dev.whysoezzy.ui.screens.auth.profile.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import dev.whysoezzy.ui.base.UserAvatar

@Composable
internal fun AddProfileIcon() {
    UserAvatar(
        size = 120.dp,
        image = null,
        onClick = {},
        isBadge = true
    )
}