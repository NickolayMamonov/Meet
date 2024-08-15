package dev.whysoezzy.ui.widgets

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
import dev.whysoezzy.domain.models.CommunityEventModel
import dev.whysoezzy.ui.base.MainNetworkIcon
import dev.whysoezzy.ui.base.text.TextBody1
import dev.whysoezzy.ui.base.text.TextMetadata1
import dev.whysoezzy.ui.theme.MeetTheme
import dev.whysoezzy.ui.utils.getPeopleQuantityText

@Composable
fun CommunityEvent(
    community: CommunityEventModel,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit
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
            TextBody1(
                text = community.title,
                color = MeetTheme.colors.neutralActive
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextMetadata1(
                text = getPeopleQuantityText(community.quantity),
                color = MeetTheme.colors.neutralWeak
            )
        }

    }
    HorizontalDivider(
        thickness = 1.dp,
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
    )
}





