package ru.wb.meetings.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.whysoezzy.testwbproject.navigation.EventsRouteScreen
import dev.whysoezzy.testwbproject.navigation.Graph
import dev.whysoezzy.testwbproject.navigation.MoreRouteScreen
import ru.wb.meetings.ui.screens.more.MyEventsScreen

fun NavGraphBuilder.eventsNavGraph(rootNavController: NavHostController){
    navigation(
        route = Graph.EventsGraph,
        startDestination = EventsRouteScreen.AddEvent.route
    ){
        composable(route = MoreRouteScreen.MyEvents.route){
            MyEventsScreen(navController = rootNavController)

        }
    }

}