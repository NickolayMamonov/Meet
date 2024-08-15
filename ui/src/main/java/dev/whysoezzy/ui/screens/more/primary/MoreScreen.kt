package dev.whysoezzy.ui.screens.more.primary

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import dev.whysoezzy.ui.screens.more.primary.components.MoreScreenContent
import dev.whysoezzy.ui.screens.more.primary.components.MoreScreenTopBar
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun MoreScreen(
    navController: NavController,
    viewModel: MoreViewModel = koinViewModel()
) {
    val screenState by viewModel.screenState().collectAsStateWithLifecycle()
    Column {
        MoreScreenTopBar()
        MoreScreenContent(
            screenState = screenState,
            navController = navController
        )
    }
}