package dev.whysoezzy.ui.screens.auth.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.focus.FocusRequester
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import dev.whysoezzy.ui.screens.auth.profile.components.AddProfileScreenContent
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun AddProfileScreen(
    navController: NavController,
    viewModel: AddProfileViewModel = koinViewModel()
) {
    val firstName by viewModel.firstName().collectAsStateWithLifecycle()
    val lastName by viewModel.lastName().collectAsStateWithLifecycle()
    val focusRequester = remember { FocusRequester() }
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
    AddProfileScreenContent(navController, focusRequester, firstName, viewModel, lastName)
}