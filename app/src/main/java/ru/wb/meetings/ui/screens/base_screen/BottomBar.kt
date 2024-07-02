package ru.wb.meetings.ui.screens.base_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.wb.meetings.R
import ru.wb.meetings.ui.theme.MainColorScheme
import ru.wb.meetings.ui.theme.MainTypographyTextStyle

@Composable
fun BottomNavigationBar(navController: NavController) {
    var selectedIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    NavigationBar(
        containerColor = MainColorScheme.neutralWhite

    ) {
        BottomBarItems.entries.forEachIndexed { index, bottomBarItems ->
            NavigationBarItem(
                selected = selectedIndex == index,
                icon = {
                    if (selectedIndex == index) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(text = bottomBarItems.title, style = MainTypographyTextStyle.bodyText1)
                                Icon(
                                    painter = painterResource(id = R.drawable.navbar_dot),
                                    contentDescription = null,
                                    tint = MainColorScheme.neutralActive
                                )
                            }


                        }
                    }else{
                        Icon(
                            painter = painterResource(id = bottomBarItems.icon),
                            contentDescription = null,
                            tint = MainColorScheme.neutralActive
                        )
                    }
                },
                onClick = {
                    selectedIndex = index
                    navController.navigate(bottomBarItems.route)
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent // Прозрачный цвет для индикатора
                ),
            )

        }
    }

}

@Composable
fun RowScope.AddItem(
    screen: BottomBarItems,
    currentDestination: NavDestination?,
    navController: NavController
) {
    var selectedIndex by rememberSaveable {
        mutableIntStateOf(0)
    }


}

enum class BottomBarItems(
    val route: String,
    val title: String,
    val icon: Int
) {
    Events(route = "Events", title = "Events", icon = R.drawable.events),
    Communities(route = "Communities", title = "Communities", R.drawable.communities),
    More(route = "More", title = "More", icon = R.drawable.navbar_dots)
}
