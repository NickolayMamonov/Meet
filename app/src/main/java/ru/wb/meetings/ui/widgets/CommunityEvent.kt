package ru.wb.meetings.ui.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.meetings.ui.base.MainNetworkIcon
import ru.wb.meetings.ui.base.text.TextBody1
import ru.wb.meetings.ui.base.text.TextMetadata1
import ru.wb.meetings.domain.models.CommunityEventModel
import ru.wb.meetings.ui.theme.MainColorScheme
import ru.wb.meetings.ui.theme.MeetTheme
import ru.wb.meetings.ui.utils.getPeopleQuantityText

@Composable
fun CommunityEvent(
    community: CommunityEventModel,
    onClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(horizontal = 20.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable { onClick(community.id) }
    ) {
        MainNetworkIcon(
            image = community.avatar,
            isClickable = false,
            showClip = true,
            useContentScaleCrop = true,
            showBadge = false
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            TextBody1(text = community.title, color = MeetTheme.colors.neutralActive)
            Spacer(modifier = Modifier.height(8.dp))
            TextMetadata1(text = getPeopleQuantityText(community.quantity), color = MainColorScheme.neutralWeak
            )
        }

    }
    HorizontalDivider(
        thickness = 1.dp,
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
    )
}





