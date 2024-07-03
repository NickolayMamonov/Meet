package ru.wb.meetings.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.whysoezzy.testwbproject.navigation.Graph
import ru.wb.meetings.ui.screens.main.MainScreen

@Composable
fun RootNavGraph() {
    val rootNavController = rememberNavController()
    NavHost(
        navController = rootNavController,
        route = Graph.RootGraph,
        startDestination = Graph.MainScreenGraph
    ){
        eventsNavGraph(rootNavController)
        moreNavGraph(rootNavController)
        composable(route = Graph.MainScreenGraph){
            MainScreen(rootNavHostController = rootNavController)
        }


    }
}