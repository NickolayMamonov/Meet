package dev.whysoezzy.ui.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.whysoezzy.ui.R
import dev.whysoezzy.ui.base.SmallTag
import dev.whysoezzy.ui.base.text.TextBody2
import dev.whysoezzy.ui.base.text.TextHeading1
import dev.whysoezzy.ui.base.text.TextHeading2
import dev.whysoezzy.ui.models.EventModelUI
import dev.whysoezzy.ui.theme.MeetTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun BigEventCard(
    event: EventModelUI,
    size: Dp = 320.dp,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Box(contentAlignment = Alignment.Center, modifier = modifier.clickable { onClick() }) {
        Column(modifier = Modifier.width(size)) {
            AsyncImage(
                model = event.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.event_card),
                error = painterResource(id = R.drawable.event_card),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
            )
            TextHeading1(
                text = event.title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = 8.dp)
            )
            TextBody2(
                text = "${event.date} · ${event.address}",
                color = MeetTheme.colors.neutralSecondaryBackground,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = 2.dp)
            )
            FlowRow(modifier = Modifier.padding(top = 8.dp)) {
                event.tags.forEach {
                    SmallTag(text = it, modifier = Modifier.padding(4.dp))
                }
            }
        }

    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun MediumEventCard(
    modifier: Modifier = Modifier,
    event: EventModelUI,
    size: Dp = 212.dp,
    onClick: () -> Unit = {},
) {
    Box(contentAlignment = Alignment.Center, modifier = modifier.clickable { onClick() }) {
        Column(modifier = Modifier.width(size)) {
            AsyncImage(
                model = event.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.event_card),
                error = painterResource(id = R.drawable.event_card),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
            )
            TextHeading2(
                text = event.title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = 8.dp)
            )
            TextBody2(
                text = "${event.date} · ${event.address}",
                color = MeetTheme.colors.neutralSecondaryBackground,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = 2.dp)
            )
            FlowRow(modifier = Modifier.padding(top = 8.dp)) {
                event.tags.forEach {
                    SmallTag(text = it, modifier = Modifier.padding(4.dp))
                }
            }
        }

    }
}

@Preview
@Composable
internal fun PreviewEventCard() {
    BigEventCard(
        event = EventModelUI(
            id = "1",
            title = "Python days",
            image = null,
            date = "10 августа",
            address = "Кожевенная линия, 40",
            tags = listOf(
                "Тестирование",
                "Тестирование",
                "Тестирование",
                "Концерт",
                "Концерт",
                "Концерт"
            )
        ),
    )
}