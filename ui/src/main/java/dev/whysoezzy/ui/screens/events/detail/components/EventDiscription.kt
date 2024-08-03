package dev.whysoezzy.ui.screens.events.detail.components

import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import dev.whysoezzy.ui.base.text.TextMetadata1
import dev.whysoezzy.ui.theme.MeetTheme
import dev.whysoezzy.ui.utils.DETAILS_MAX_LINE

@Composable
fun EventDescription(description: String, fullText: Boolean, toggleFullText: () -> Unit) {
    TextMetadata1(
        text = description,
        color = MeetTheme.colors.neutralWeak,
        maxLines = if (fullText) Int.MAX_VALUE else DETAILS_MAX_LINE,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier.clickable { toggleFullText() }
    )
}