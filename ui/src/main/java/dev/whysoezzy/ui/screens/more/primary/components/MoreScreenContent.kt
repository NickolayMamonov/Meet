package dev.whysoezzy.ui.screens.more.primary.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import dev.whysoezzy.common.ScreenState
import dev.whysoezzy.domain.models.UserProfileModel
import dev.whysoezzy.ui.screens.ErrorScreen
import dev.whysoezzy.ui.screens.LoadingScreen

@Composable
internal fun MoreScreenContent(
    screenState: ScreenState<UserProfileModel>,
    navController: NavController
) {
    when (screenState) {
        is ScreenState.Content -> {
            MoreContent(screenState, navController)
        }

        is ScreenState.Loading -> LoadingScreen()
        is ScreenState.Error -> ErrorScreen()
    }
}