package dev.whysoezzy.ui.screens.communities.detail.components

import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import dev.whysoezzy.domain.models.CommunityDetailModel
import dev.whysoezzy.ui.base.text.TextMetadata1
import dev.whysoezzy.ui.theme.MeetTheme
import dev.whysoezzy.ui.utils.DETAILS_MAX_LINE

@Composable
internal fun CommunityDescription(
    community: CommunityDetailModel,
    fullText: Boolean,
    toggleFullText: () -> Unit
) {
    TextMetadata1(
        text = community.description,
        maxLines = if (fullText) Int.MAX_VALUE else DETAILS_MAX_LINE,
        overflow = TextOverflow.Ellipsis,
        color = MeetTheme.colors.neutralWeak,
        modifier = Modifier.clickable {
            toggleFullText()
        }
    )
}