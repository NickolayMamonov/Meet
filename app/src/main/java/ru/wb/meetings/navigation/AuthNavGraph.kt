package ru.wb.meetings.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ru.wb.meetings.ui.screens.auth.AddProfileScreen
import ru.wb.meetings.ui.screens.auth.OtpCodeScreen
import ru.wb.meetings.ui.screens.auth.PhoneNumScreen
import ru.wb.meetings.ui.screens.main.AuthScreen
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
            route = AuthScreens.OtpCodeScreen.route + "/{phoneNumber}/{countryCode}",
            arguments = listOf(
                navArgument("phoneNumber") { type = NavType.StringType },
                navArgument("countryCode") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val phoneNumber = backStackEntry.arguments?.getString("phoneNumber")
            val countryCode = backStackEntry.arguments?.getString("countryCode")
            phoneNumber?.let {
                countryCode?.let {
                    OtpCodeScreen(
                        navController = navController,
                        phoneNumber = phoneNumber,
                        countryCode = countryCode
                    )

                }
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