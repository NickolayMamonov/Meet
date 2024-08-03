package dev.whysoezzy.ui.screens.main

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import dev.whysoezzy.ui.navigation.BottomNavBar
import dev.whysoezzy.ui.navigation.NavGraph


@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavBar(navController = navController)
        }
    ) { innerPadding ->
        NavGraph(
            navController = navController,
            innerPadding = innerPadding
        )
    }

}
