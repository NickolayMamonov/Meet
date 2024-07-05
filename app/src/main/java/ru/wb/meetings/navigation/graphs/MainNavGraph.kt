package ru.wb.meetings.navigation.graphs

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.whysoezzy.testwbproject.navigation.Graph
import dev.whysoezzy.testwbproject.navigation.MainRouteScreen
import ru.wb.meetings.ui.screens.main.CommunitiesScreen
import ru.wb.meetings.ui.screens.main.EventsScreen
import ru.wb.meetings.ui.screens.main.MoreScreen


@Composable
fun MainNavGraph(
    rootNavController: NavHostController,
    eventsNavController: NavHostController,
    innerPadding:PaddingValues
) {
    NavHost(navController = eventsNavController,
        route = Graph.MainScreenGraph,
        startDestination = MainRouteScreen.Events.route
    ){
        composable(route = MainRouteScreen.Events.route){
            EventsScreen(innerPadding = innerPadding)

        }
        composable(route = MainRouteScreen.Communities.route){
            CommunitiesScreen(innerPadding = innerPadding)

        }
        composable(route = MainRouteScreen.More.route){
            MoreScreen(navController = rootNavController, innerPadding = innerPadding)

        }

    }


}