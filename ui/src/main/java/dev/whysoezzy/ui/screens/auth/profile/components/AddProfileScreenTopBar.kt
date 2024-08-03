package dev.whysoezzy.ui.screens.auth.profile.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import dev.whysoezzy.ui.R
import dev.whysoezzy.ui.base.text.TextSubheading1
import dev.whysoezzy.ui.navigation.AuthScreens
import dev.whysoezzy.ui.theme.MeetTheme

@Composable
@OptIn(ExperimentalMaterial3Api::class)
internal fun AddProfileScreenTopBar(navController: NavController) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = {
                navController.navigate(AuthScreens.MainScreen.route) {
                    popUpTo(AuthScreens.PhoneNumScreen.route) {
                        inclusive = false
                    }
                }
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = null
                )
            }

        },
        title = {
            TextSubheading1(
                text = stringResource(id = R.string.profile),
                color = MeetTheme.colors.neutralActive
            )
        },
    )
}