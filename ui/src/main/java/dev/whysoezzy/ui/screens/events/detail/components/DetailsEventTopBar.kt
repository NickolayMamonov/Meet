package dev.whysoezzy.ui.screens.events.detail.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import dev.whysoezzy.ui.R
import dev.whysoezzy.ui.base.text.TextSubheading1
import dev.whysoezzy.ui.theme.MeetTheme

@Composable
@OptIn(ExperimentalMaterial3Api::class)
internal fun DetailsEventTopBar(
    name: String,
    navController: NavController,
    buttonPressed: Boolean
) {
    TopAppBar(
        title = {
            TextSubheading1(
                text = name,
                color = MeetTheme.colors.neutralActive
            )
        },
        navigationIcon = {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = "Back Button"
                )
            }
        },
        actions = {
            if (buttonPressed) {
                IconButton(onClick = {
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_accept),
                        tint = MeetTheme.colors.brandDefault,
                        contentDescription = "Action Icon"
                    )
                }
            }
        }
    )
}