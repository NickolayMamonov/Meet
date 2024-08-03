package dev.whysoezzy.ui.screens.more.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import dev.whysoezzy.ui.screens.more.profile.components.ProfileScreenContent
import dev.whysoezzy.ui.screens.more.profile.components.ProfileTopBar
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun ProfileScreen(
    navController: NavController,
    viewModel: ProfileViewModel = koinViewModel()
) {
    val screenState by viewModel.screenState().collectAsStateWithLifecycle()
    Column {
        ProfileTopBar(navController)
        ProfileScreenContent(screenState = screenState)
    }
}