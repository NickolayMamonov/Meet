package ru.wb.meetings.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.wb.meetings.ui.screens.EventsScreen
import ru.wb.meetings.ui.screens.base_screen.MainScreen

@Composable
fun RootNavHost(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Graphs.EventsGraph.route
    ) {
        composable(route = Graphs.EventsGraph.route) {
            MainScreen()
        }
//        composable(route = Graphs.EventsGraph.route){
//             EventsScreen()
//        }
//        composable(route = Graphs.CommunitiesGraph.route){
//             CommunitiesScreen()
//        }
//        composable(route = Graphs.MoreGraph.route){
//            MoreScreen()
//        }

    }
}

sealed class Graphs(val route: String) {
    object EventsGraph : Graphs("events")
    object CommunitiesGraph : Graphs("communities")
    object MoreGraph : Graphs("more")
}