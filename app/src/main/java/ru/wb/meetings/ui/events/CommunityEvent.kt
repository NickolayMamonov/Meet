package ru.wb.meetings.ui.events

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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import ru.wb.meetings.ui.base.MainIcon
import ru.wb.meetings.ui.theme.MainColorScheme
import ru.wb.meetings.ui.theme.MainTypographyTextStyle

@Composable
fun CommunityEvent(
    avatar: Painter,
    title: String,
    subTitle: String,
    modifier: Modifier = Modifier
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        MainIcon(image = avatar, isClickable = false, showClip = true, useContentScaleCrop = true, showBadge = false)
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = title,
                style = MainTypographyTextStyle.bodyText1,
                color = MainColorScheme.neutralActive
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = subTitle,
                style = MainTypographyTextStyle.metadata1,
                color = MainColorScheme.neutralWeak
            )
        }

    }
}