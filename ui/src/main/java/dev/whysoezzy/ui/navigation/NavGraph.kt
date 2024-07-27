package dev.whysoezzy.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import dev.whysoezzy.ui.screens.communities.screens.CommunitiesScreen
import dev.whysoezzy.ui.screens.communities.screens.DetailsCommunityScreen
import dev.whysoezzy.ui.screens.events.screens.DetailsEventScreen
import dev.whysoezzy.ui.screens.events.screens.EventsScreen
import dev.whysoezzy.ui.screens.more.screens.MoreScreen
import dev.whysoezzy.ui.screens.more.screens.MyEventsScreen
import dev.whysoezzy.ui.screens.more.screens.ProfileScreen


@Composable
fun NavGraph(navController: NavHostController, innerPadding: PaddingValues) {
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
                backStackEntry.arguments?.getString("name")?.let { DetailsEventScreen(navController = navController, name = it) }
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
                backStackEntry.arguments?.getString("name")?.let { DetailsCommunityScreen(navController = navController, name = it)  }
            }
            composable(
                route = Screen.CommunitiesRoot.DetailsCommunity.DetailsEvent.route + "/{name}",
                arguments = listOf(
                    navArgument("name") { type = NavType.StringType },
                )
            ) { backStackEntry ->
                backStackEntry.arguments?.getString("name")?.let { DetailsEventScreen(navController = navController, name = it) }
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
                backStackEntry.arguments?.getString("name")?.let { DetailsEventScreen(navController = navController, name = it)  }
            }
        }
    }
}