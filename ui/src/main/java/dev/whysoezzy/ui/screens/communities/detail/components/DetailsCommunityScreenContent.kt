package dev.whysoezzy.ui.screens.communities.detail.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import dev.whysoezzy.common.ScreenState
import dev.whysoezzy.domain.models.CommunityDetailModel
import dev.whysoezzy.ui.screens.ErrorScreen
import dev.whysoezzy.ui.screens.LoadingScreen

@Composable
internal fun DetailsCommunityScreenContent(
    screenState: ScreenState<CommunityDetailModel>,
    navController: NavController,
    fullText: Boolean,
    toggleFullText: () -> Unit,

    ) {
    when (screenState) {
        is ScreenState.Content -> {
            DetailsCommunityContent(
                community = screenState.data,
                navController = navController,
                fullText = fullText,
                toggleFullText = toggleFullText,
            )
        }

        is ScreenState.Loading -> LoadingScreen()
        is ScreenState.Error -> ErrorScreen()
    }
}