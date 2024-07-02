package ru.wb.meetings.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.wb.meetings.ui.screens.CommunitiesScreen
import ru.wb.meetings.ui.screens.EventsScreen
import ru.wb.meetings.ui.screens.MoreScreen

@Composable
fun EventsNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = EventsScreenGraph.EventFeed.route) {
        composable(route = EventsScreenGraph.EventFeed.route) {
            EventsScreen()
        }
        composable(route = EventsScreenGraph.COMMUNITIES.route) {
            CommunitiesScreen()
        }
        composable(route = EventsScreenGraph.MORE.route) {
            MoreScreen()
        }
    }

}

sealed class EventsScreenGraph(val route: String) {
    object EventFeed : EventsScreenGraph("Events")
    object COMMUNITIES : EventsScreenGraph("Communities")
    object MORE : EventsScreenGraph("More")
}