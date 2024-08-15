package dev.whysoezzy.ui.screens.more.myevents

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import dev.whysoezzy.ui.navigation.Screen
import dev.whysoezzy.ui.screens.more.myevents.components.MyEventsScreenContent
import dev.whysoezzy.ui.screens.more.myevents.components.MyEventsScreenTopBar
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun MyEventsScreen(
    navController: NavController,
    viewModel: MyEventsViewModel = koinViewModel()
) {
    val screenState by viewModel.screenState().collectAsStateWithLifecycle()
    val selectedTabIndex by viewModel.selectedTabIndex().collectAsStateWithLifecycle()
    val currentList by viewModel.currentList.collectAsStateWithLifecycle()
    Column {
        MyEventsScreenTopBar(navController)
        MyEventsScreenContent(
            screenState = screenState,
            currentList = currentList,
            selectedTabIndex = selectedTabIndex,
            onTabSelected = { viewModel.setSelectedTabIndex(it) }
        ) {
            navController.navigate(Screen.MoreRoot.MyEvents.DetailsEvent.route + "/${it.id}")
        }
    }
}