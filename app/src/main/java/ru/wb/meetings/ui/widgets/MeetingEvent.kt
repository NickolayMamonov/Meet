package ru.wb.meetings.ui.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import ru.wb.meetings.ui.base.MainNetworkIcon
import ru.wb.meetings.ui.base.text.TextBody1
import ru.wb.meetings.ui.base.text.TextMetadata1
import ru.wb.meetings.ui.base.text.TextMetadata2
import ru.wb.meetings.ui.models.MeetingEventModel
import ru.wb.meetings.ui.theme.MainColorScheme
import ru.wb.meetings.ui.theme.MainTypographyTextStyle
import ru.wb.meetings.ui.theme.MeetTheme

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
        MainNetworkIcon(
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
                TextBody1(text = meeting.title, color = MeetTheme.colors.neutralActive, modifier = Modifier.weight(1f))
                if (meeting.isEnded) {
                    TextMetadata2(text = stringResource(R.string.ended), color = MainColorScheme.neutralWeak, modifier = Modifier.padding(start = 8.dp))
                }
            }
            TextMetadata1(text = meeting.subTitle, color = MainColorScheme.neutralWeak, modifier = Modifier.padding(top = 8.dp))
            ChipGroup()
        }
    }
    HorizontalDivider(
        thickness = 1.dp,
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
    )

}



