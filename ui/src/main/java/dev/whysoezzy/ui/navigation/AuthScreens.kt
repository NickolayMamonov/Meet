package dev.whysoezzy.ui.navigation

sealed class AuthScreens( val route: String){
    data object PhoneNumScreen: AuthScreens("PhoneNumScreen")
    data object OtpCodeScreen: AuthScreens("OtpCodeScreen")
    data object MainScreen: AuthScreens("MainScreen")
    data object AddProfileScreen: AuthScreens("AddProfileScreen")
}