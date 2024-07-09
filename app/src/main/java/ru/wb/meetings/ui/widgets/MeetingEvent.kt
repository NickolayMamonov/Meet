package ru.wb.meetings.ui.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.wb.meetings.R
import ru.wb.meetings.ui.base.ChipGroup
import ru.wb.meetings.ui.base.MainSmallNetworkIcon
import ru.wb.meetings.ui.theme.MainColorScheme
import ru.wb.meetings.ui.theme.MainTypographyTextStyle

@Composable
fun MeetingEvent(
    meeting: MeetingEventModel,
    onClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    Row(
        verticalAlignment = Alignment.Top,
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable {
                onClick(meeting.id)
            }
    ) {
        MainSmallNetworkIcon(
            showBadge = false,
            isClickable = false,
            image = meeting.icon,
            showClip = true,
            useContentScaleCrop = true,
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            Row {
                Text(
                    text = meeting.title,
                    style = MainTypographyTextStyle.bodyText1,
                    color = MainColorScheme.neutralActive,
                    modifier = Modifier.weight(1f)
                )
                if (meeting.isEnded) {
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = stringResource(R.string.ended),
                        style = MainTypographyTextStyle.metadata2,
                        color = MainColorScheme.neutralWeak,
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = meeting.subTitle,
                style = MainTypographyTextStyle.metadata1,
                color = MainColorScheme.neutralWeak
            )
            ChipGroup()
        }

    }
    HorizontalDivider(
        thickness = 1.dp,
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
    )

}

data class MeetingEventModel(
    val id: String,
    val title: String,
    val subTitle: String,
    val isEnded: Boolean,
    val icon: String = "https://picsum.photos/200/300"
)

