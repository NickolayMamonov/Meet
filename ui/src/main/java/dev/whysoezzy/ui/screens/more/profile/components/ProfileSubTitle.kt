package dev.whysoezzy.ui.screens.more.profile.components

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.whysoezzy.common.ScreenState
import dev.whysoezzy.domain.models.UserProfileModel
import dev.whysoezzy.ui.base.text.TextBody2
import dev.whysoezzy.ui.theme.MeetTheme

@Composable
internal fun ProfileSubTitle(screenState: ScreenState.Content<UserProfileModel>) {
    TextBody2(
        text = screenState.data.phoneNumber,
        color = MeetTheme.colors.neutralDisabled,
        modifier = Modifier.padding(bottom = 16.dp)
    )
}