package ru.wb.meetings.ui.navigation

import ru.wb.meetings.R


sealed class Screen(
    val route: String,
    val title: String,
    val unSelectedIcon: Int
) {
    data object EventsRoot : Screen(
        route = "EventsRoot",
        title = "Встречи",
        unSelectedIcon = R.drawable.events
    ) {
        data object Events : Screen(
            route = "Events",
            title = "Встречи",
            unSelectedIcon = R.drawable.events
        )

        data object DetailsEvent : Screen(
            route = "DetailsEvent",
            title = "Встречи",
            unSelectedIcon = R.drawable.events
        )
    }

    data object CommunitiesRoot : Screen(
        route = "CommunitiesRoot",
        title = "Сообщества",
        unSelectedIcon = R.drawable.communities
    ) {
        data object Communities : Screen(
            route = "Communities",
            title = "Сообщества",
            unSelectedIcon = R.drawable.communities
        )

        data object DetailsCommunity : Screen(
            route = "DetailsCommunity",
            title = "Сообщества",
            unSelectedIcon = R.drawable.communities
        ) {
            data object DetailsEvent : Screen(
                route = "DetailsCommunityEvent",
                title = "Встречи",
                unSelectedIcon = R.drawable.events
            )
        }
    }

    data object MoreRoot : Screen(
        route = "MoreRoot",
        title = "Еще",
        unSelectedIcon = R.drawable.navbar_dots
    ) {
        data object More : Screen(
            route = "More",
            title = "Еще",
            unSelectedIcon = R.drawable.navbar_dots
        )

        data object Profile : Screen(
            route = "Profile",
            title = "Профиль",
            unSelectedIcon = R.drawable.navbar_dots
        )

        data object MyEvents : Screen(
            route = "MyEvents",
            title = "Мои встречи",
            unSelectedIcon = R.drawable.navbar_dots
        ) {
            data object DetailsEvent : Screen(
                route = "MoreDetailsEvent",
                title = "Встречи",
                unSelectedIcon = R.drawable.events
            )
        }


    }

}