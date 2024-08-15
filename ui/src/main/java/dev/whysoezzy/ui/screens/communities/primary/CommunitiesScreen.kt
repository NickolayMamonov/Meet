package dev.whysoezzy.ui.screens.communities.primary

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import dev.whysoezzy.ui.screens.communities.primary.components.CommunitiesScreenContent
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun CommunitiesScreen(
    navController: NavController,
    viewModel: CommunitiesViewModel = koinViewModel()
) {
    val screenState by viewModel.screenState().collectAsStateWithLifecycle()
    CommunitiesScreenContent(screenState, navController)
}