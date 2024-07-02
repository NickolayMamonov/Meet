package ru.wb.meetings.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.meetings.ui.base.SearchBar
import ru.wb.meetings.ui.events.MeetingEvent
import ru.wb.meetings.ui.events.Meetings
import ru.wb.meetings.ui.theme.MainColorScheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EventsScreen() {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val pagerState = rememberPagerState(pageCount = { Tabs.entries.size })
    val meetings1 = listOf(
        Meetings("Developer meeting", "13.09.2024 — Москва", true),
        Meetings("Developer meeting", "13.09.2024 — Москва", false),
        Meetings("Developer meeting", "13.09.2024 — Москва", true),
        Meetings("Developer meeting", "13.09.2024 — Москва", true),
        Meetings("Developer meeting", "13.09.2024 — Москва", false),
    )
    val meetings2 = listOf(
        Meetings("Developer meeting", "13.09.2024 — Москва", false),
        Meetings("Developer meeting", "13.09.2024 — Москва", false),
        Meetings("Developer meeting", "13.09.2024 — Москва", false),
        Meetings("Developer meeting", "13.09.2024 — Москва", false),
        Meetings("Developer meeting", "13.09.2024 — Москва", false),
    )
    var filteredMeetings by remember { mutableStateOf(meetings1) }
    Scaffold() {innerpadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerpadding)) {
//            LaunchedEffect(selectedTabIndex) {
//                filteredMeetings = when (Tabs.entries[selectedTabIndex]) {
//                    Tabs.ALL_MEETINGS -> meetings1
//                    Tabs.ACTIVE -> meetings2
//                }
//            }

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
                HorizontalPager(
                    state = pagerState,
                    contentPadding = PaddingValues(top = 16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) { page ->
                    when (page) {
                        0 -> ListOfMeetingsAllBody(
                            listOfMeetings = List(15){0}
                        )
                        1 -> Stab(page = page)
                    }
                }


            }
        }


    }

}


enum class Tabs(val title: String) {
    ALL_MEETINGS("Все встречи"),
    ACTIVE("Активные")
}

@Composable
fun ListOfMeetingsAllBody(
    listOfMeetings: List<Int>
){
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
    ) {
        items (listOfMeetings){ meeting ->
            MeetingEvent("Developer meeting", "13.09.2024 — Москва", true)
        }
    }
}
@Composable
fun Stab(
    page: Int
){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = Tabs.entries[page].title)
    }
}