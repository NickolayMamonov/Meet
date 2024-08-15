package dev.whysoezzy.ui.screens.communities.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import dev.whysoezzy.ui.screens.communities.detail.components.DetailsCommunityScreenContent
import dev.whysoezzy.ui.screens.communities.detail.components.DetailsCommunityTopBar
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
internal fun DetailsCommunityScreen(
    navController: NavController,
    name: String,
    viewModel: DetailsCommunityViewModel = koinViewModel(parameters = { parametersOf(name) })
) {
    val screenState by viewModel.screenState().collectAsStateWithLifecycle()
    val fullText by viewModel.fullText().collectAsStateWithLifecycle()
    Column {
        DetailsCommunityTopBar(name, navController)
        DetailsCommunityScreenContent(
            screenState = screenState,
            navController = navController,
            fullText = fullText,
            toggleFullText = { viewModel.toggleFullText() }
        )
    }
}