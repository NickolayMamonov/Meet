package dev.whysoezzy.ui.screens.events.primary.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.whysoezzy.domain.models.MeetingEventModel
import dev.whysoezzy.ui.base.SearchBar
import dev.whysoezzy.ui.utils.EventsTabs
import dev.whysoezzy.ui.utils.TabType
import dev.whysoezzy.ui.widgets.MeetingEvent
import dev.whysoezzy.ui.widgets.TabRow

@Composable
internal fun EventsContent(
    currentList: List<MeetingEventModel>,
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit,
    onMeetingClick: (MeetingEventModel) -> Unit
) {
    val eventsTabs = listOf(
        TabType.EventsTab(EventsTabs.ALL_MEETINGS.title),
        TabType.EventsTab(EventsTabs.ACTIVE.title)
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {
            SearchBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {

            }
        }
        item {
            TabRow(
                selectedTabIndex = selectedTabIndex,
                onTabSelected = onTabSelected,
                tabs = eventsTabs
            )
        }
        items(currentList) { meeting ->
            MeetingEvent(meeting = meeting, onClick = { onMeetingClick(meeting) })
        }
    }
}