package ru.wb.meetings.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ru.wb.meetings.ui.screens.auth.screens.AddProfileScreen
import ru.wb.meetings.ui.screens.auth.screens.OtpCodeScreen
import ru.wb.meetings.ui.screens.auth.screens.PhoneNumScreen
import ru.wb.meetings.ui.screens.main.MainScreen

@Composable
fun AuthNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = AuthScreens.PhoneNumScreen.route) {
        composable(
            route = AuthScreens.PhoneNumScreen.route
        ) {
            PhoneNumScreen(navController = navController)
        }
        composable(
            route = AuthScreens.OtpCodeScreen.route + "/{phoneNumber}",
            arguments = listOf(
                navArgument("phoneNumber") { type = NavType.StringType },
            )
        ) { backStackEntry ->
            backStackEntry.arguments?.getString("phoneNumber")?.let { phoneNumber ->
                OtpCodeScreen(navController = navController, phoneNumber = phoneNumber)
            }
        }
        composable(AuthScreens.MainScreen.route) {
            MainScreen()
        }
        composable(AuthScreens.AddProfileScreen.route) {
            AddProfileScreen(navController = navController)
        }

    }
}