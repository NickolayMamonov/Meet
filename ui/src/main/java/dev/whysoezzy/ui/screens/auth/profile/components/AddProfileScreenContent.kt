package dev.whysoezzy.ui.screens.auth.profile.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.focus.FocusRequester
import androidx.navigation.NavController
import dev.whysoezzy.ui.screens.auth.profile.AddProfileViewModel

@Composable
internal fun AddProfileScreenContent(
    navController: NavController,
    focusRequester: FocusRequester,
    firstName: String,
    viewModel: AddProfileViewModel,
    lastName: String
) {
    Column {
        AddProfileScreenTopBar(navController)
        AddProfileContent(focusRequester, firstName, viewModel, lastName, navController)
    }
}