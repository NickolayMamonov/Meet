package dev.whysoezzy.ui.screens.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import dev.whysoezzy.ui.navigation.AuthNavGraph

@Composable
fun AuthScreen(){
    val navController = rememberNavController()
    AuthNavGraph(navController = navController)
}