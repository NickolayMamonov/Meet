package dev.whysoezzy.ui.screens.events.detail.components

import androidx.compose.runtime.Composable
import dev.whysoezzy.common.ScreenState
import dev.whysoezzy.domain.models.DetailsEventModel
import dev.whysoezzy.ui.screens.ErrorScreen
import dev.whysoezzy.ui.screens.LoadingScreen


@Composable
internal fun DetailsEventScreenContent(
    screenState: ScreenState<DetailsEventModel>,
    showImageDialog: Boolean,
    setShowImageDialog: (Boolean) -> Unit,
    fullText: Boolean,
    toggleFullText: () -> Unit,
    buttonPressed: Boolean,
    setButtonPressed: (Boolean) -> Unit
) {
    when (screenState) {
        is ScreenState.Content -> {
            DetailsEventContent(
                event = screenState.data,
                showImageDialog = showImageDialog,
                setShowImageDialog = setShowImageDialog,
                fullText = fullText,
                toggleFullText = toggleFullText,
                buttonPressed = buttonPressed,
                setButtonPressed = setButtonPressed
            )
        }

        is ScreenState.Loading -> LoadingScreen()
        is ScreenState.Error -> ErrorScreen()
    }
}

