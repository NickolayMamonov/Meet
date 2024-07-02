package ru.wb.meetings.ui.events

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.wb.meetings.R
import ru.wb.meetings.ui.base.ChipGroup
import ru.wb.meetings.ui.base.MainIcon
import ru.wb.meetings.ui.theme.MainColorScheme
import ru.wb.meetings.ui.theme.MainTypographyTextStyle

data class Meetings(
    val title: String,
    val subTitle: String,
    val isEnded: Boolean

)

@Composable
fun MeetingEvent(
    title: String,
    subTitle: String,
    isEnded: Boolean, modifier: Modifier = Modifier
) {

    Row(
        verticalAlignment = Alignment.Top,
        modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        MainIcon(
            showBadge = false,
            isClickable = false,
            image = painterResource(id = R.drawable.meeting_avatar),
            showClip = true,
            useContentScaleCrop = true
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            Row {
                Text(
                    text = title,
                    style = MainTypographyTextStyle.bodyText1,
                    color = MainColorScheme.neutralActive,
                    modifier = Modifier.weight(1f)
                )
                if (isEnded) {
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Закончилось",
                        style = MainTypographyTextStyle.metadata2,
                        color = MainColorScheme.neutralWeak,
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = subTitle,
                style = MainTypographyTextStyle.metadata1,
                color = MainColorScheme.neutralWeak
            )
            ChipGroup()
        }

    }
}

