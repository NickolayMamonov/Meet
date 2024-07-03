package ru.wb.meetings.ui.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.meetings.ui.base.SearchBar
import ru.wb.meetings.ui.events.MeetingEvent

@Composable
fun EventsScreen(innerPadding: PaddingValues) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val allMeetingsList = listOf(
        MeetingEventModel("Встреча 1", "Описание 1", false),
        MeetingEventModel("Встреча 2", "Описание 2", true),
        MeetingEventModel("Встреча 2", "Описание 2", true),
        MeetingEventModel("Встреча 2", "Описание 2", false),
        MeetingEventModel("Встреча 2", "Описание 2", true),
    )
    val activeMeetingsList = allMeetingsList.filter { !it.isEnded }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            SearchBar()
            TabRow(selectedTabIndex = selectedTabIndex) {
                Tabs.entries.forEachIndexed { index, tab ->
                    Tab(
                        text = { Text(tab.title) },
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index }
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            when (selectedTabIndex) {
                0 -> MeetingsList(allMeetingsList)
                1 -> MeetingsList(activeMeetingsList)
            }


        }
    }

}
enum class Tabs(val title: String) {
    ALL_MEETINGS("Все встречи"),
    ACTIVE("Активные")
}


@Composable
fun MeetingsList(meetings: List<MeetingEventModel>) {
    LazyColumn {
        items(meetings) { meeting ->
            MeetingEvent(meeting.title, meeting.subTitle, meeting.isEnded)
        }
    }
}

data class MeetingEventModel(val title: String, val subTitle: String, val isEnded: Boolean)