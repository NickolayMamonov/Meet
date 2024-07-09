package ru.wb.meetings.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ru.wb.meetings.R
import ru.wb.meetings.ui.screens.communities.DetailsCommunityScreen
import ru.wb.meetings.ui.screens.events.DetailsEventScreen
import ru.wb.meetings.ui.screens.communities.CommunitiesScreen
import ru.wb.meetings.ui.screens.events.EventsScreen
import ru.wb.meetings.ui.screens.more.MoreScreen
import ru.wb.meetings.ui.screens.more.MyEventsScreen
import ru.wb.meetings.ui.screens.more.ProfileScreen

@Composable
fun AppNavigation(navController: NavHostController, modifier: Modifier = Modifier,innerPadding:PaddingValues) {
    NavHost(navController = navController, startDestination = "events_screen") {
        composable("events_screen") { EventsScreen(navController,innerPadding) }
        composable("communities_screen") { CommunitiesScreen(navController,innerPadding) }
        composable("more_screen") { MoreScreen(navController,innerPadding) }
        composable("profile_screen"){ ProfileScreen(navController =navController,innerPadding = innerPadding)}
        composable("myEvents_screen"){ MyEventsScreen(navController =navController,innerPadding = innerPadding) }
        composable(
            "detailsCommunity_screen/{data}",
            arguments = listOf(navArgument("data") { type = NavType.StringType })
        ) { backStackEntry ->
            DetailsCommunityScreen(navController, backStackEntry.arguments?.getString("data") ?: "",innerPadding = innerPadding)
        }
        composable(
            "detailsEvent_screen/{data}",
            arguments = listOf(navArgument("data") { type = NavType.StringType })
        ) { backStackEntry ->
            DetailsEventScreen(navController, backStackEntry.arguments?.getString("data") ?: "",innerPadding = innerPadding)
        }
    }
}

val bottomNavigationItems = listOf(
    NavigationItem("events_screen", "Встречи", R.drawable.events),
    NavigationItem("communities_screen", "Сообщества", R.drawable.communities),
    NavigationItem("more_screen", "Ещё", R.drawable.navbar_dots)
)

val topBarItems = listOf(
//    TopBarItem("screen1", "Screen 1", Icons.Filled.ArrowBack, Icons.Default.Add),
//    TopBarItem("screen2", "Screen 2", Icons.Filled.ArrowBack,null),
    TopBarItem("events_screen", "Встречи", null,null),
    TopBarItem("communities_screen", "Сообщества", null,null),
    TopBarItem("more_screen", "Ещё",null,null),
    TopBarItem("profile_screen", "Профиль",R.drawable.arrow_back ,null),
    TopBarItem("myEvents_screen", "Мои встречи",R.drawable.arrow_back ,null),
    TopBarItem("detailsCommunity_screen/{data}", "Meeting",R.drawable.arrow_back ,null),
    TopBarItem("detailsEvent_screen/{data}", "Meeting",R.drawable.arrow_back ,null),
    )

val bottomBarRoutes = setOf("events_screen", "communities_screen","more_screen","profile_screen","myEvents_screen","detailsCommunity_screen/{data}","detailsEvent_screen/{data}")


val topBarRoutes = setOf("events_screen","communities_screen","more_screen","profile_screen","myEvents_screen","detailsCommunity_screen/{data}","detailsEvent_screen/{data}")

data class TopBarItem(val route: String, val title: String, val icon: Int? , val action: Int?)

data class NavigationItem(val route: String, val title: String, val unSelectedIcon: Int)