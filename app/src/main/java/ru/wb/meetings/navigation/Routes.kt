package dev.whysoezzy.testwbproject.navigation

object Graph{
    const val RootGraph ="rootGraph"
    const val MainScreenGraph = "mainGraph"
    const val EventsGraph = "eventsScreenGraph"
    const val CommunitiesGraph = "communitiesScreenGraph"
    const val MoreGraph = "MoreScreenGraph"
}

sealed class MainRouteScreen(val route: String){
    object Events: MainRouteScreen("events")

    object Communities: MainRouteScreen("communities")

    object More: MainRouteScreen("more")
}

sealed class EventsRouteScreen(val route: String){
    object AddEvent: EventsRouteScreen("addEvent")
}
sealed class MoreRouteScreen(val route:String){
    object MyEvents: MoreRouteScreen("myEvents")
    object Profile: MoreRouteScreen("profile")
}
