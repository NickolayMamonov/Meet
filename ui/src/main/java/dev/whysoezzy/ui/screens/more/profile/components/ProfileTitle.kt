package dev.whysoezzy.ui.screens.more.profile.components

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.whysoezzy.common.ScreenState
import dev.whysoezzy.domain.models.UserProfileModel
import dev.whysoezzy.ui.base.text.TextHeading2
import dev.whysoezzy.ui.theme.MeetTheme

@Composable
internal fun ProfileTitle(screenState: ScreenState.Content<UserProfileModel>) {
    TextHeading2(
        text = screenState.data.name,
        color = MeetTheme.colors.neutralActive,
        modifier = Modifier.padding(top = 16.dp, bottom = 4.dp)
    )
}