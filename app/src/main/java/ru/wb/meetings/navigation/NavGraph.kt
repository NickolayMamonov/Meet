package ru.wb.meetings.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import ru.wb.meetings.ui.screens.communities.CommunitiesScreen
import ru.wb.meetings.ui.screens.communities.DetailsCommunityScreen
import ru.wb.meetings.ui.screens.events.DetailsEventScreen
import ru.wb.meetings.ui.screens.events.EventsScreen
import ru.wb.meetings.ui.screens.more.MoreScreen
import ru.wb.meetings.ui.screens.more.MyEventsScreen
import ru.wb.meetings.ui.screens.more.ProfileScreen

@Composable
fun NavGraph(navController: NavHostController,innerPadding:PaddingValues){
    NavHost(navController = navController, startDestination = Screen.EventsRoot.route) {
        navigation(
            startDestination = Screen.EventsRoot.Events.route,
            route = Screen.EventsRoot.route
        ) {
            composable(Screen.EventsRoot.Events.route) {
                EventsScreen(navController = navController)
            }
            composable(
                route = Screen.EventsRoot.DetailsEvent.route + "/{name}",
                arguments = listOf(
                    navArgument("name") { type = NavType.StringType },
                )
            ) { backStackEntry ->
                val name = backStackEntry.arguments?.getString("name")
                when {
                    name != null -> {
                        DetailsEventScreen(navController = navController, name = name)
                    }
                }

            }

        }

        navigation(
            startDestination = Screen.CommunitiesRoot.Communities.route,
            route = Screen.CommunitiesRoot.route
        ) {
            composable(Screen.CommunitiesRoot.Communities.route) {
                CommunitiesScreen(navController)
            }
            composable(
                Screen.CommunitiesRoot.DetailsCommunity.route + "/{name}",
                arguments = listOf(
                    navArgument("name") { type = NavType.StringType },
                )
            ) { backStackEntry ->
                val name = backStackEntry.arguments?.getString("name")
                when {
                    name != null -> {
                        DetailsCommunityScreen(navController = navController, name = name)
                    }
                }
            }
            composable(
                route = Screen.CommunitiesRoot.DetailsCommunity.DetailsEvent.route + "/{name}",
                arguments = listOf(
                    navArgument("name") { type = NavType.StringType },
                )
            ) { backStackEntry ->
                val name = backStackEntry.arguments?.getString("name")
                when {
                    name != null -> {
                        DetailsEventScreen(navController = navController, name = name)
                    }
                }

            }
        }

        navigation(
            startDestination = Screen.MoreRoot.More.route,
            route = Screen.MoreRoot.route
        ) {
            composable(Screen.MoreRoot.More.route) {
                MoreScreen(navController = navController)
            }
            composable(Screen.MoreRoot.Profile.route) {
                ProfileScreen(navController = navController)
            }
            composable(Screen.MoreRoot.MyEvents.route) {
                MyEventsScreen(navController = navController)
            }
            composable(
                route = Screen.MoreRoot.MyEvents.DetailsEvent.route + "/{name}",
                arguments = listOf(
                    navArgument("name") { type = NavType.StringType },
                )
            ) { backStackEntry ->
                val name = backStackEntry.arguments?.getString("name")
                when {
                    name != null -> {
                        DetailsEventScreen(navController = navController, name = name)
                    }
                }
            }
        }


    }

}