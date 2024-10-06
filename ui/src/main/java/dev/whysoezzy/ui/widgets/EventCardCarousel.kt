package dev.whysoezzy.ui.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.whysoezzy.ui.base.text.TextHeading2
import dev.whysoezzy.ui.models.EventBlockModelUI
import dev.whysoezzy.ui.models.EventModelUI

@Composable
internal fun EventCardCarousel(
    modifier: Modifier = Modifier,
    eventList: List<EventModelUI>,
    onEventClick: (EventModelUI) -> Unit,
) {

    LazyRow {
        items(eventList) { event ->
            BigEventCard(
                event = event,
                onClick = { onEventClick(event) },
                modifier = Modifier.padding(end = 10.dp)
            )
        }
    }

}

@Composable
internal fun MainEventCardCarousel(
    modifier: Modifier = Modifier,
    event: EventBlockModelUI,
    onEventClick: (EventModelUI) -> Unit,
){
    Column(modifier = modifier) {
        TextHeading2(text = event.title)
        LazyRow {
            items(event.events) { event ->
                MediumEventCard(
                    event = event,
                    onClick = { onEventClick(event) },
                    modifier = Modifier.padding(end = 10.dp)
                )
            }
        }
    }

}

@Preview
@Composable
fun EventCardCarouselPreview() {
    EventCardCarousel(
        eventList = listOf(
            EventModelUI(
                id = "1",
                title = "Event 1",
                image = null,
                date = "12.12.2021",
                address = "Address 1",
                tags = listOf("Tag 1", "Tag 2")
            ),
            EventModelUI(
                id = "2",
                title = "Event 2",
                image = null,
                date = "12.12.2021",
                address = "Address 2",
                tags = listOf("Tag 1", "Tag 2")
            ),
            EventModelUI(
                id = "3",
                title = "Event 3",
                image = null,
                date = "12.12.2021",
                address = "Address 3",
                tags = listOf("Tag 1", "Tag 2")
            ),
        ),
        onEventClick = {},
    )
}