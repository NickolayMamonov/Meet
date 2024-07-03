package ru.wb.meetings.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.whysoezzy.testwbproject.navigation.Graph
import dev.whysoezzy.testwbproject.navigation.MoreRouteScreen
import ru.wb.meetings.ui.screens.more.MyEventsScreen
import ru.wb.meetings.ui.screens.more.ProfileScreen

fun NavGraphBuilder.moreNavGraph(rootNavController: NavHostController){
    navigation(
        route = Graph.MoreGraph,
        startDestination = MoreRouteScreen.MyEvents.route
    ){
        composable(route = MoreRouteScreen.MyEvents.route){
            MyEventsScreen(navController = rootNavController)

        }
        composable(route = MoreRouteScreen.Profile.route) {
            ProfileScreen(navController = rootNavController)
        }
    }

}