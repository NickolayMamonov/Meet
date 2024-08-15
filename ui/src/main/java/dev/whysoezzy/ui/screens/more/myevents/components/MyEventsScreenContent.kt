package dev.whysoezzy.ui.screens.more.myevents.components

import androidx.compose.runtime.Composable
import dev.whysoezzy.common.ScreenState
import dev.whysoezzy.domain.models.MeetingEventModel
import dev.whysoezzy.ui.screens.ErrorScreen
import dev.whysoezzy.ui.screens.LoadingScreen

@Composable
internal fun MyEventsScreenContent(
    screenState: ScreenState<*>,
    currentList: List<MeetingEventModel>,
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit,
    onMeetingClick: (MeetingEventModel) -> Unit
) {
    when (screenState) {
        is ScreenState.Content<*> -> {
            MyEventsContent(
                currentList = currentList,
                selectedTabIndex = selectedTabIndex,
                onTabSelected = onTabSelected,
                onMeetingClick = onMeetingClick
            )
        }

        is ScreenState.Loading -> LoadingScreen()
        is ScreenState.Error -> ErrorScreen()
    }
}
