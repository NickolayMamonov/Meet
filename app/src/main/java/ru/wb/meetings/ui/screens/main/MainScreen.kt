package ru.wb.meetings.ui.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.wb.meetings.R
import ru.wb.meetings.navigation.AppNavigation
import ru.wb.meetings.navigation.bottomBarRoutes
import ru.wb.meetings.navigation.bottomNavigationItems
import ru.wb.meetings.navigation.topBarItems
import ru.wb.meetings.navigation.topBarRoutes
import ru.wb.meetings.ui.base.MainIcon
import ru.wb.meetings.ui.theme.MainColorScheme
import ru.wb.meetings.ui.theme.MainTypographyTextStyle


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavHostController

) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Scaffold(
        topBar = {
            topBarItems.find { it.route == currentRoute }?.let { topBarItem ->
                if (currentRoute in topBarRoutes) {
                    TopAppBar(
                        title = {
                            Text(
                                text = topBarItem.title,
                                style = MainTypographyTextStyle.subheading1,
                                color = MainColorScheme.neutralActive
                            )
                        },
                        navigationIcon = {
                            if (topBarItem.icon != null) {
                                topBarItem.icon.let { icon ->
                                    MainIcon(
                                        showBadge = false,
                                        isClickable = true,
                                        sizeIcon = 12.dp,
                                        image = painterResource(id = R.drawable.arrow_back),
                                        onClick = {
                                            navController.navigateUp()
                                        }
                                    )
                                }
                            }

                        },
                        actions = {
                            if (topBarItem.action != null) {
                                topBarItem.action.let { actionIcon ->
                                    MainIcon(
                                        showBadge = false,
                                        isClickable = true,
                                        sizeIcon = 18.dp,
                                        image = painterResource(id = R.drawable.edit),
                                        onClick = {
                                        }
                                    )
                                }
                            }

                        }
                    )
                }
            }
        },
        bottomBar = {
            if (currentRoute in bottomBarRoutes) {
                NavigationBar(
                    containerColor = Color.White
                ) {
                    bottomNavigationItems.forEach { item ->
                        NavigationBarItem(
                            colors = NavigationBarItemDefaults.colors(
                                indicatorColor = Color.Transparent
                            ),
                            icon = {
                                if (currentRoute == item.route) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Column(
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Text(
                                                text = item.title,
                                                style = MainTypographyTextStyle.bodyText1
                                            )
                                            Icon(
                                                painter = painterResource(id = R.drawable.navbar_dot),
                                                contentDescription = null,
                                                tint = Color.Black
                                            )
                                        }


                                    }
                                } else {
                                    Icon(
                                        painter = painterResource(id = item.unSelectedIcon),
                                        contentDescription = null,
                                        tint = Color.Black
                                    )
                                }
                            },
                            selected = currentRoute == item.route,
                            onClick = {
                                if (currentRoute != item.route) {
                                    navController.navigate(item.route) {
                                        popUpTo(navController.graph.startDestinationId)
                                        launchSingleTop = true
                                    }
                                }
                            }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        AppNavigation(navController = navController, innerPadding = innerPadding)
    }
}
