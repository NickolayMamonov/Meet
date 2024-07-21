package ru.wb.meetings.ui.screens.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import ru.wb.meetings.ui.navigation.AuthNavGraph

@Composable
fun AuthScreen(){
    val navController = rememberNavController()
    AuthNavGraph(navController = navController)
}