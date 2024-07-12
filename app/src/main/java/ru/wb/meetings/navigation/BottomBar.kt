package ru.wb.meetings.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.wb.meetings.R
import ru.wb.meetings.ui.theme.MainTypographyTextStyle

@Composable
fun BottomNavBar(navController: NavController) {
    val items = listOf(
        Screen.EventsRoot,
        Screen.CommunitiesRoot,
        Screen.MoreRoot
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    NavigationBar(
        containerColor = Color.White
    ) {
        items.forEachIndexed { _, navigationItem ->
            val selected = currentDestination?.hierarchy?.any {
                it.route == navigationItem.route
            } == true
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent
                ),
                selected = selected,
                onClick = {
                    navController.navigate(navigationItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    when {
                        selected -> {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = navigationItem.title,
                                    style = MainTypographyTextStyle.bodyText1
                                )
                                Icon(
                                    painter = painterResource(id = R.drawable.navbar_dot),
                                    contentDescription = null,
                                )
                            }
                        }

                        else -> {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = navigationItem.unSelectedIcon),
                                contentDescription = null,
                            )
                        }
                    }

                }

            )
        }
    }

}