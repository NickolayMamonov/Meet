package ru.wb.meetings.ui.screens.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.wb.meetings.R
import ru.wb.meetings.ui.base.SearchBar
import ru.wb.meetings.ui.widgets.MeetingEvent
import ru.wb.meetings.ui.widgets.MeetingEventModel
import ru.wb.meetings.ui.theme.MainColorScheme
import ru.wb.meetings.ui.theme.MainTypographyTextStyle

@Composable
fun EventsScreen(navController: NavController,innerPadding: PaddingValues) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val allMeetingsList = listOf(
        MeetingEventModel("1","Developer Meeting", "13.09.2024 — Москва", false),
        MeetingEventModel("2","Developer Meeting", "13.09.2024 — Москва", true),
        MeetingEventModel("3","Developer Meeting", "13.09.2024 — Москва", true),
        MeetingEventModel("4","Developer Meeting", "13.09.2024 — Москва", false),
        MeetingEventModel("5","Developer Meeting", "13.09.2024 — Москва", true),
    )
    val activeMeetingsList = allMeetingsList.filter { !it.isEnded }
    val currentList = if (selectedTabIndex == 0) allMeetingsList else activeMeetingsList
    LazyColumn(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
    ) {
        item{
            SearchBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {

            }
            TabRow(
                selectedTabIndex = selectedTabIndex,
                contentColor = MainColorScheme.brandDefault,
                indicator = { tabPositions ->
                    SecondaryIndicator(
                        modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                        color = MainColorScheme.brandDefault
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 8.dp)
            ) {
                Tabs.entries.forEachIndexed { index, tab ->
                    Tab(
                        text = { Text(stringResource(id = tab.title),style = MainTypographyTextStyle.bodyText1) },
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index }
                    )
                }
            }


        }
        items(currentList) { meeting ->
            MeetingEvent(meeting = meeting, onClick = { id ->
                navController.navigate("detailsEvent_screen/$id")
            })
        }



    }

}

enum class Tabs(val title: Int) {
    ALL_MEETINGS(R.string.all_meetings),
    ACTIVE(R.string.meeting_active)
}


@Composable
fun MeetingsList(meetings: List<MeetingEventModel>, onClick:(String) -> Unit) {
    LazyColumn {
        itemsIndexed(meetings) { index, meeting ->
            MeetingEvent(meeting = meeting, onClick ={id ->
                onClick(id)
            } )
            if (index < meetings.size - 1) {
                HorizontalDivider(
                    thickness = 1.dp,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                )
            }
        }
    }
}

