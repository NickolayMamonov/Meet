package dev.whysoezzy.ui.screens.events.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import coil.compose.AsyncImage
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import dev.whysoezzy.common.ScreenState
import dev.whysoezzy.ui.R
import dev.whysoezzy.ui.base.ChipGroup
import dev.whysoezzy.ui.base.MainNetworkIcon
import dev.whysoezzy.ui.base.buttons.CustomButton
import dev.whysoezzy.ui.base.buttons.CustomOutlinedButton
import dev.whysoezzy.ui.base.text.TextMetadata1
import dev.whysoezzy.ui.base.text.TextSubheading1
import dev.whysoezzy.ui.screens.events.viewmodels.DetailsEventViewModel
import dev.whysoezzy.ui.theme.MeetTheme
import dev.whysoezzy.ui.widgets.EventsRow


private const val MAX_LINE = 8

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsEventScreen(
    navController: NavController,
    name: String,
    viewModel: DetailsEventViewModel = koinViewModel(parameters = {parametersOf(name)})
) {
    val screenState by viewModel.screenState().collectAsState()
    val showImageDialog by viewModel.showImageDialog().collectAsState()
    val buttonPressed by viewModel.buttonPressed().collectAsState()
    val currentState = screenState

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    TextSubheading1(
                        text = name,
                        color = MeetTheme.colors.neutralActive
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_back),
                            contentDescription = "Back Button"
                        )
                    }
                },
                actions = {
                    if (buttonPressed) {
                        IconButton(onClick = {
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_accept),
                                tint = MeetTheme.colors.brandDefault,
                                contentDescription = "Action Icon"
                            )
                        }
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (currentState) {
                is ScreenState.Loading -> CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                is ScreenState.Error -> Text(
                    text = "Error: ${currentState.message}",
                    modifier = Modifier.align(Alignment.Center)
                )
                is ScreenState.Content -> {
                    val event = currentState.data
                    val fullText by viewModel.fullText().collectAsState()
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(18.dp)
                    ) {
                        item {
                            Text(
                                text = event.location,
                                style = MeetTheme.typography.bodyText1,
                                color = MeetTheme.colors.neutralWeak,
                            )
                        }
                        item {
                            ChipGroup(event.tags)
                        }
                        item {
                            Box(modifier = Modifier.fillMaxWidth()) {
                                MainNetworkIcon(
                                    image = event.map,
                                    isClickable = true,
                                    showClip = true,
                                    sizeIcon = 320.dp,
                                    clipPercent = 16,
                                    onClick = { viewModel.setShowImageDialog(true) },
                                    modifier = Modifier.align(Alignment.Center)
                                )
                            }
                            if (showImageDialog) {
                                Dialog(onDismissRequest = { viewModel.setShowImageDialog(false) }) {
                                    Box(modifier = Modifier.fillMaxSize()) {
                                        AsyncImage(
                                            model = event.map,
                                            contentDescription = "Full Image",
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .scale(1.5f),
                                            contentScale = ContentScale.Fit
                                        )
                                    }
                                }
                            }
                        }
                        item {
                            TextMetadata1(
                                text = event.description,
                                color = MeetTheme.colors.neutralWeak,
                                maxLines = if (fullText) Int.MAX_VALUE else MAX_LINE,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.clickable {
                                    viewModel.toggleFullText()
                                }
                            )
                        }
                        item {
                            EventsRow(avatars = event.images)
                        }
                        item {
                            when {
                                !buttonPressed -> {
                                    CustomButton(
                                        text = stringResource(R.string.go_to_event),
                                        onClick = { viewModel.setButtonPressed(true) },
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    )
                                }
                                else -> {
                                    CustomOutlinedButton(
                                        text = stringResource(R.string.go_another_time),
                                        onClick = { viewModel.setButtonPressed(false) },
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

