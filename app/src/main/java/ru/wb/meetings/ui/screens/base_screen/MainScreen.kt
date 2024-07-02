package ru.wb.meetings.ui.screens.base_screen

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.wb.meetings.navigation.EventsNavGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navHostController: NavHostController = rememberNavController()) {
    Scaffold(
//        topBar = { TopNavigationBar(navController= navHostController) },
        bottomBar = { BottomNavigationBar(navController = navHostController) })
    {
        EventsNavGraph(navController = navHostController)
    }
}