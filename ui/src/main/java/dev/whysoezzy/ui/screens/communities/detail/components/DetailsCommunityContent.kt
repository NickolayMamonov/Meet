package dev.whysoezzy.ui.screens.communities.detail.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.whysoezzy.domain.models.CommunityDetailModel
import dev.whysoezzy.ui.R
import dev.whysoezzy.ui.base.text.TextBody1
import dev.whysoezzy.ui.navigation.Screen
import dev.whysoezzy.ui.theme.MeetTheme
import dev.whysoezzy.ui.widgets.MeetingEvent

@Composable
internal fun DetailsCommunityContent(
    community: CommunityDetailModel,
    fullText: Boolean,
    toggleFullText: () -> Unit,
    navController: NavController
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp)
    ) {
        item { CommunityDescription(community, fullText, toggleFullText) }
        item {
            TextBody1(
                text = stringResource(R.string.community_events),
                color = MeetTheme.colors.neutralWeak,
                modifier = Modifier.padding(top = 32.dp, bottom = 16.dp)
            )
        }
        items(community.events) { meeting ->
            MeetingEvent(meeting, onClick = {
                navController.navigate(Screen.CommunitiesRoot.DetailsCommunity.DetailsEvent.route + "/${meeting.title}")
            })
        }
    }
}