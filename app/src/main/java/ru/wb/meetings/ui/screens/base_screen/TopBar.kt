package ru.wb.meetings.ui.screens.base_screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.wb.meetings.R
import ru.wb.meetings.ui.base.MainIcon
import ru.wb.meetings.ui.theme.MainTypographyTextStyle

@Composable
fun TopNavigationBar(navController: NavController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val currentScreen = when (currentDestination?.route) {
        "Events" -> TopBarItems.Events
        "Communities" -> TopBarItems.Communities
        "More" -> TopBarItems.More
        else -> null
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .statusBarsPadding()
            .padding(32.dp)
    ) {
        if (currentScreen?.showBackButton == true) {
            MainIcon(
                showBadge = false,
                isClickable = true,
                onClick = { navController.popBackStack() },
                image = painterResource(
                    id = R.drawable.back_button
                ),
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        Text(
            text = "Text",
            style = MainTypographyTextStyle.subheading1,
            modifier = Modifier
        )
        if (currentScreen?.showActionButton == true) {
            MainIcon(
                showBadge = false,
                isClickable = true,
                onClick = { navController.popBackStack() },
                image = painterResource(
                    id = R.drawable.add_new
                )
            )
        }


    }
}

sealed class TopBarItems(
    val route: String,
    val title: String,
    val showBackButton: Boolean,
    val showActionButton: Boolean
) {
    object Events : TopBarItems(
        route = "Events",
        title = "Events",
        showBackButton = false,
        showActionButton = true
    )


    object Communities : TopBarItems(
        route = "Communities",
        title = "Communities",
        showBackButton = false,
        showActionButton = true
    )

    object More : TopBarItems(
        route = "More",
        title = "More",
        showBackButton = true,
        showActionButton = false
    )
}