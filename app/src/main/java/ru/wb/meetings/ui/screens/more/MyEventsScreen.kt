package ru.wb.meetings.ui.screens.more

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import ru.wb.meetings.ui.widgets.MeetingEvent
import ru.wb.meetings.ui.widgets.MeetingEventModel
import ru.wb.meetings.ui.theme.MainColorScheme
import ru.wb.meetings.ui.theme.MainTypographyTextStyle

@Composable
fun MyEventsScreen(
    navController: NavController,
    innerPadding: PaddingValues
) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val allMeetingsList = listOf(
        MeetingEventModel("1", "Встреча 1", "Описание 1", false),
        MeetingEventModel("2", "Встреча 2", "Описание 2", true),
        MeetingEventModel("3", "Встреча 2", "Описание 2", true),
        MeetingEventModel("4", "Встреча 2", "Описание 2", false),
        MeetingEventModel("5", "Встреча 2", "Описание 2", true),
    )
    val activeMeetingsList = allMeetingsList.filter { !it.isEnded }
    val inactiveMeetingsList = allMeetingsList.filter { it.isEnded }
    val currentList = if (selectedTabIndex == 0) activeMeetingsList else inactiveMeetingsList
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(horizontal = 20.dp)
    ) {
        item {
            TabRow(
                selectedTabIndex = selectedTabIndex,
                contentColor = MainColorScheme.brandDefault,
                indicator = { tabPositions ->
                    SecondaryIndicator(
                        modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                        color = MainColorScheme.brandDefault
                    )
                },
            ) {
                Tabs.entries.forEachIndexed { index, tab ->
                    Tab(
                        text = {
                            Text(
                                stringResource(id = tab.title),
                                style = MainTypographyTextStyle.bodyText1,
                                color = MainColorScheme.brandDefault
                            )
                        },
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index }
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
        items(currentList) { meeting ->
            MeetingEvent(meeting = meeting, onClick = { id ->
                navController.navigate("detailsEvent_screen/$id")
            })
        }
    }
}


enum class Tabs(val title: Int) {
    PLANNED(R.string.meeting_planned),
    PASSED(R.string.meeting_passed)
}



