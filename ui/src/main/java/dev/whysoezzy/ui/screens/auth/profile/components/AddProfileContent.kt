package dev.whysoezzy.ui.screens.auth.profile.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.whysoezzy.ui.screens.auth.profile.AddProfileViewModel

@Composable
internal fun AddProfileContent(
    focusRequester: FocusRequester,
    firstName: String,
    viewModel: AddProfileViewModel,
    lastName: String,
    navController: NavController
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)

    ) {
        item {
            AddProfileIcon()
        }
        item {
            AddProfilePrimaryTextField(focusRequester, firstName, viewModel)

        }
        item {
            AddProfileSecondaryTextField(lastName, viewModel)
        }
        item {
            AddProfileButton(firstName, navController)
        }
    }
}