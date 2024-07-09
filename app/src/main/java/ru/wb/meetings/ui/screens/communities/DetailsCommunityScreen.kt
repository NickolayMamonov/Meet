package ru.wb.meetings.ui.screens.communities

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.wb.meetings.ui.widgets.MeetingEvent
import ru.wb.meetings.ui.widgets.MeetingEventModel
import ru.wb.meetings.ui.theme.MainColorScheme
import ru.wb.meetings.ui.theme.MainTypographyTextStyle

@Composable
fun DetailsCommunityScreen(navController: NavController, id: String?, innerPadding: PaddingValues) {
    val description = LoremIpsum().values.first()
    val myMeetingsList = listOf(
        MeetingEventModel("1","Developer Meeting", "13.09.2024 — Москва", false),
        MeetingEventModel("2","Developer Meeting", "13.09.2024 — Москва", false),
        MeetingEventModel("3","Developer Meeting", "13.09.2024 — Москва", true),
        MeetingEventModel("4","Developer Meeting", "13.09.2024 — Москва", false),
        MeetingEventModel("5","Developer Meeting", "13.09.2024 — Москва", true),
    )
    LazyColumn(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .padding(18.dp)
    ) {
        item {
            Text(
                text = description,
                maxLines = 13,
                overflow = TextOverflow.Ellipsis,
                style = MainTypographyTextStyle.metadata1,
                color = MainColorScheme.neutralWeak,
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Встречи сообщества",
                style = MainTypographyTextStyle.bodyText1,
                color = MainColorScheme.neutralWeak
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        items(myMeetingsList) { meeting ->
            MeetingEvent(meeting, onClick = { id ->
                navController.navigate("detailsMeeting_screen/$id")
            })
        }


    }

}

