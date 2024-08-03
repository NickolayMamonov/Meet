package dev.whysoezzy.ui.screens.more.profile.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.whysoezzy.common.ScreenState
import dev.whysoezzy.domain.models.UserProfileModel
import dev.whysoezzy.ui.base.UserAvatar
import dev.whysoezzy.ui.screens.ErrorScreen
import dev.whysoezzy.ui.screens.LoadingScreen

@Composable
internal fun ProfileScreenContent(
    screenState: ScreenState<UserProfileModel>,
) {
    when (screenState) {
        is ScreenState.Content -> {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 50.dp),
            ) {
                item { UserAvatar(size = 200.dp) }
                item {
                    ProfileTitle(screenState)
                }
                item {
                    ProfileSubTitle(screenState)
                }
                item { ProfileSocialButtons() }
            }
        }

        is ScreenState.Loading -> LoadingScreen()
        is ScreenState.Error -> ErrorScreen()
    }
}