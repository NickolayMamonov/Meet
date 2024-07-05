package ru.wb.meetings.ui.events

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.meetings.ui.theme.MainColorScheme

//@Composable
//fun EventsList(meetings: List<Meetings>,modifier: Modifier = Modifier) {
//    LazyColumn {
//        itemsIndexed(meetings) { index, index2 ->
//            MeetingEvent(meetings = index2)
//            Spacer(modifier = Modifier.size(12.dp))
//            HorizontalDivider(
//                modifier = Modifier.padding(horizontal = 12.dp),
//                color = MainColorScheme.neutralLine,
//            )
//            Spacer(modifier = Modifier.size(12.dp))
//        }
//    }
//}