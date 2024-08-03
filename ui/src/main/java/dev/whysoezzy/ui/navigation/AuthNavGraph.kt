package dev.whysoezzy.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import dev.whysoezzy.ui.screens.auth.otp.OtpCodeScreen
import dev.whysoezzy.ui.screens.auth.phone.PhoneNumScreen
import dev.whysoezzy.ui.screens.auth.profile.AddProfileScreen
import dev.whysoezzy.ui.screens.main.MainScreen

@Composable
internal fun AuthNavGraph(navController: NavHostController) {
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