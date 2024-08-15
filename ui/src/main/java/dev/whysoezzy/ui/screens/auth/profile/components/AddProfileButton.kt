package dev.whysoezzy.ui.screens.auth.profile.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.whysoezzy.ui.R
import dev.whysoezzy.ui.base.buttons.CustomButton
import dev.whysoezzy.ui.navigation.AuthScreens

@Composable
internal fun AddProfileButton(firstName: String, navController: NavController) {
    when {
        firstName.isNotEmpty() -> {
            CustomButton(
                text = stringResource(R.string.save),
                onClick = {
                    navController.navigate(AuthScreens.MainScreen.route) {
                        popUpTo(route = AuthScreens.PhoneNumScreen.route) {
                            inclusive = true
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 64.dp)
            )
        }

        else -> {
            CustomButton(
                text = stringResource(R.string.save),
                isEnabled = false,
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 64.dp)
            )
        }
    }
}
