package ru.wb.meetings.ui.screens.main

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import ru.wb.meetings.navigation.BottomNavBar
import ru.wb.meetings.navigation.NavGraph


@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavBar(navController = navController)
        }
    ) { innerPadding ->
        NavGraph(navController = navController, innerPadding = innerPadding)
    }

}
