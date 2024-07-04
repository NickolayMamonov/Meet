package ru.wb.meetings.ui.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.whysoezzy.testwbproject.navigation.BottomNavigationBar
import dev.whysoezzy.testwbproject.navigation.MainRouteScreen
import ru.wb.meetings.navigation.graphs.MainNavGraph
import ru.wb.meetings.ui.theme.MainColorScheme
import ru.wb.meetings.ui.theme.MainTypographyTextStyle
import ru.wb.meetings.ui.utils.bottomNavigationItemsList


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    rootNavHostController: NavHostController,
    eventsNavController: NavHostController = rememberNavController()

) {
    val navBackStackEntry by eventsNavController.currentBackStackEntryAsState()
    val currentRoute by remember(navBackStackEntry) {
        derivedStateOf {
            navBackStackEntry?.destination?.route
        }
    }
    val topBarTitle by remember(currentRoute) {
        derivedStateOf {
            if (currentRoute != null) {
                bottomNavigationItemsList[bottomNavigationItemsList.indexOfFirst {
                    it.route == currentRoute
                }].title
            } else {
                bottomNavigationItemsList[0].title
            }
        }
    }
    Scaffold(
        topBar = {
            when (currentRoute) {
                MainRouteScreen.Events.route -> {
                    TopAppBar(
                        title = {
                            Text(
                                text = topBarTitle,
                                style = MainTypographyTextStyle.subheading1,
                                color = MainColorScheme.neutralActive
                            )
                        },
                        actions = {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = null,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    )
                }

                MainRouteScreen.Communities.route, MainRouteScreen.More.route -> {
                    TopAppBar(
                        title = {
                            Text(
                                text = topBarTitle,
                                style = MainTypographyTextStyle.subheading1,
                                color = MainColorScheme.neutralActive
                            )
                        }
                    )
                }
            }
        },
        bottomBar = {
            BottomNavigationBar(
                items = bottomNavigationItemsList,
                currentRoute = currentRoute
            ) { currentNavigationItem ->
                eventsNavController.navigate(currentNavigationItem.route) {

                    eventsNavController.graph.startDestinationRoute?.let { startDestinationRoute ->
                        popUpTo(startDestinationRoute) {
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        }
    ) { innerPadding ->
        MainNavGraph(
            rootNavHostController,
            eventsNavController,
            innerPadding

        )
    }
}