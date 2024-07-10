package ru.wb.meetings.ui.screens.events

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import ru.wb.meetings.navigation.Screen
import ru.wb.meetings.ui.base.SearchBar
import ru.wb.meetings.ui.models.MeetingEventModel
import ru.wb.meetings.ui.theme.MainColorScheme
import ru.wb.meetings.ui.theme.MainTypographyTextStyle
import ru.wb.meetings.ui.utils.EventsTabs
import ru.wb.meetings.ui.widgets.MeetingEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventsScreen(navController: NavController) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val allMeetingsList = listOf(
        MeetingEventModel("1", "Developer Meeting", "13.09.2024 — Москва", false),
        MeetingEventModel("2", "Developer Meeting", "13.09.2024 — Москва", true),
        MeetingEventModel("3", "Developer Meeting", "13.09.2024 — Москва", true),
        MeetingEventModel("4", "Developer Meeting", "13.09.2024 — Москва", false),
        MeetingEventModel("5", "Developer Meeting", "13.09.2024 — Москва", true),
    )
    val activeMeetingsList = allMeetingsList.filter { !it.isEnded }
    val currentList = if (selectedTabIndex == 0) allMeetingsList else activeMeetingsList
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.meetings),
                        style = MainTypographyTextStyle.subheading1,
                        color = MainColorScheme.neutralActive
                    )
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            item {
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
                    EventsTabs.entries.forEachIndexed { index, tab ->
                        Tab(
                            text = {
                                Text(
                                    stringResource(id = tab.title),
                                    style = MainTypographyTextStyle.bodyText1
                                )
                            },
                            selected = selectedTabIndex == index,
                            onClick = { selectedTabIndex = index }
                        )
                    }
                }


            }
            items(currentList) { meeting ->
                MeetingEvent(meeting = meeting, onClick = {
                    navController.navigate(Screen.EventsRoot.DetailsEvent.route + "/${meeting.title}")
                })
            }


        }


    }


}


