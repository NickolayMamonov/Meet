package ru.wb.meetings.ui.utils

import dev.whysoezzy.testwbproject.navigation.MainRouteScreen
import dev.whysoezzy.testwbproject.navigation.NavigationItem
import ru.wb.meetings.R


val bottomNavigationItemsList = listOf(
    NavigationItem(
        title = "Встречи",
        route = MainRouteScreen.Events.route,
        selectedIcon = R.drawable.navbar_dot,
        unSelectedIcon = R.drawable.events,
    ),
    NavigationItem(
        title = "Сообщества",
        route = MainRouteScreen.Communities.route,
        selectedIcon = R.drawable.navbar_dot,
        unSelectedIcon = R.drawable.communities,
    ),
    NavigationItem(
        title = "Ещё",
        route = MainRouteScreen.More.route,
        selectedIcon = R.drawable.navbar_dot,
        unSelectedIcon = R.drawable.navbar_dots,
    ),

    )