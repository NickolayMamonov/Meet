package dev.whysoezzy.ui.screens.communities.primary.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import dev.whysoezzy.common.ScreenState
import dev.whysoezzy.domain.models.CommunityEventModel

@Composable
internal fun CommunitiesScreenContent(
    screenState: ScreenState<List<CommunityEventModel>>,
    navController: NavController
) {
    Column {
        CommunitiesScreenTopBar()
        CommunitiesContent(screenState, navController)
    }
}

