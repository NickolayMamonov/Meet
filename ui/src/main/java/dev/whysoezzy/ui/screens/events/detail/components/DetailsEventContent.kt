package dev.whysoezzy.ui.screens.events.detail.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.whysoezzy.domain.models.DetailsEventModel
import dev.whysoezzy.ui.base.ChipGroup
import dev.whysoezzy.ui.base.text.TextBody1
import dev.whysoezzy.ui.theme.MeetTheme
import dev.whysoezzy.ui.widgets.EventsRow

@Composable
internal fun DetailsEventContent(
    event: DetailsEventModel,
    showImageDialog: Boolean,
    setShowImageDialog: (Boolean) -> Unit,
    fullText: Boolean,
    toggleFullText: () -> Unit,
    buttonPressed: Boolean,
    setButtonPressed: (Boolean) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp)
    ) {
        item { TextBody1(event.location, MeetTheme.colors.neutralWeak) }
        item { ChipGroup(event.tags) }
        item { EventMap(event.map, showImageDialog, setShowImageDialog) }
        item { EventDescription(event.description, fullText, toggleFullText) }
        item { EventsRow(avatars = event.images) }
        item { EventButton(buttonPressed, setButtonPressed) }
    }
}