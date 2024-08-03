package dev.whysoezzy.ui.screens.events.primary

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import dev.whysoezzy.ui.navigation.Screen
import dev.whysoezzy.ui.screens.events.primary.components.EventsScreenContent
import dev.whysoezzy.ui.screens.events.primary.components.EventsScreenTopBar
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun EventsScreen(
    navController: NavController,
    viewModel: EventsViewModel = koinViewModel()
) {
    val screenState by viewModel.screenState().collectAsStateWithLifecycle()
    val selectedTabIndex by viewModel.selectedTabIndex().collectAsStateWithLifecycle()
    val currentList by viewModel.currentList.collectAsStateWithLifecycle()
    Column {
        EventsScreenTopBar()
        EventsScreenContent(
            screenState = screenState,
            currentList = currentList,
            selectedTabIndex = selectedTabIndex,
            onTabSelected = { viewModel.setSelectedTabIndex(it) },
            onMeetingClick = { meeting ->
                navController.navigate(Screen.EventsRoot.DetailsEvent.route + "/${meeting.title}")
            }
        )
    }
}