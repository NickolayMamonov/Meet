package ru.wb.meetings.ui.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.meetings.ui.base.MainSmallNetworkIcon
import ru.wb.meetings.ui.theme.MainColorScheme
import ru.wb.meetings.ui.theme.MainTypographyTextStyle

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
        MainSmallNetworkIcon(
            image = community.avatar,
            isClickable = false,
            showClip = true,
            useContentScaleCrop = true,
            showBadge = false
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = community.title,
                style = MainTypographyTextStyle.bodyText1,
                color = MainColorScheme.neutralActive
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "${community.quantity} человек",
                style = MainTypographyTextStyle.metadata1,
                color = MainColorScheme.neutralWeak
            )
        }

    }
}

data class CommunityEventModel(
    val id: String,
    val title: String,
    val quantity: Int,
    val avatar: String = "https://picsum.photos/200/300",
)

@Composable
fun CommunitiesList(
    communities: List<CommunityEventModel>,
    onClick: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        itemsIndexed(communities) { index, community ->
            CommunityEvent(community = community, onClick = { id ->
                onClick(id)
            })
            if (index < communities.size - 1) {
                HorizontalDivider(
                    thickness = 1.dp,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                )
            }
        }
    }

}