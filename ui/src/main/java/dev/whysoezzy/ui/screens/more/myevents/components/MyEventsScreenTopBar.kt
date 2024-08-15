package dev.whysoezzy.ui.screens.more.myevents.components

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
import dev.whysoezzy.ui.theme.MeetTheme

@Composable
@OptIn(ExperimentalMaterial3Api::class)
internal fun MyEventsScreenTopBar(navController: NavController) {
    TopAppBar(
        title = {
            TextSubheading1(
                text = stringResource(id = R.string.my_meetings),
                color = MeetTheme.colors.neutralActive
            )
        },
        navigationIcon = {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = null
                )
            }
        }
    )
}