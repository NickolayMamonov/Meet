package dev.whysoezzy.ui.screens.events.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import dev.whysoezzy.ui.screens.events.detail.components.DetailsEventScreenContent
import dev.whysoezzy.ui.screens.events.detail.components.DetailsEventTopBar
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
internal fun DetailsEventScreen(
    navController: NavController,
    name: String,
    viewModel: DetailsEventViewModel = koinViewModel(parameters = { parametersOf(name) })
) {
    val screenState by viewModel.screenState().collectAsStateWithLifecycle()
    val showImageDialog by viewModel.showImageDialog().collectAsStateWithLifecycle()
    val buttonPressed by viewModel.buttonPressed().collectAsStateWithLifecycle()
    val fullText by viewModel.fullText().collectAsStateWithLifecycle()
    Column {
        DetailsEventTopBar(name, navController, buttonPressed)
        DetailsEventScreenContent(
            screenState = screenState,
            showImageDialog = showImageDialog,
            setShowImageDialog = { viewModel.setShowImageDialog(it) },
            fullText = fullText,
            toggleFullText = { viewModel.toggleFullText() },
            buttonPressed = buttonPressed,
            setButtonPressed = { viewModel.setButtonPressed(it) }
        )
    }
}