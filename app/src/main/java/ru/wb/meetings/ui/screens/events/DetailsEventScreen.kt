package ru.wb.meetings.ui.screens.events

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import coil.compose.AsyncImage
import ru.wb.meetings.R
import ru.wb.meetings.ui.base.ChipGroup
import ru.wb.meetings.ui.base.CustomButton
import ru.wb.meetings.ui.base.CustomOutlinedButton
import ru.wb.meetings.ui.base.MainNetworkIcon
import ru.wb.meetings.ui.theme.MainColorScheme
import ru.wb.meetings.ui.theme.MainTypographyTextStyle
import ru.wb.meetings.ui.theme.MeetTheme
import ru.wb.meetings.ui.widgets.EventsRow


private const val MAX_LINE = 8

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsEventScreen(navController: NavController, name: String) {
    val text = "13.09.2024 — Москва,ул.Громова,4"
    var showImageDialog by remember { mutableStateOf(false) }
    val imageUrl = "https://cdn.pixabay.com/photo/2016/03/27/16/24/holidays-1283014_1280.jpg"
    val description = LoremIpsum().values.first()
    val avatars = listOf(
        "https://picsum.photos/200/300",
        "https://picsum.photos/200/300",
        "https://picsum.photos/200/300",
        "https://picsum.photos/200/300",
        "https://picsum.photos/200/300",
        "https://picsum.photos/200/300",
        "https://picsum.photos/200/300",
    )
    var isFullText by rememberSaveable {
        mutableStateOf(false)
    }
    var isButtonPressed by rememberSaveable { mutableStateOf(false) }

    if (showImageDialog) {
        Dialog(onDismissRequest = { showImageDialog = false }) {
            Box(modifier = Modifier.fillMaxSize()) {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = "Full Image",
                    modifier = Modifier
                        .fillMaxSize()
                        .scale(1.5f),
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = name,
                        style = MainTypographyTextStyle.subheading1,
                        color = MainColorScheme.neutralActive
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_back),
                            contentDescription = null
                        )
                    }

                },
                actions = {
                    if (isButtonPressed) {
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
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .padding(18.dp)
        ) {
            item {
                Text(
                    text = text,
                    style = MainTypographyTextStyle.bodyText1,
                    color = MainColorScheme.neutralWeak
                )
            }
            item {
                ChipGroup()
            }
            item {
                MainNetworkIcon(
                    image = imageUrl,
                    showBadge = false,
                    showBorder = false,
                    isClickable = true,
                    showClip = true,
                    clipPercent = 16,
                    onClick = { showImageDialog = true },
                )
            }
            item {
                Text(
                    text = description,
                    style = MainTypographyTextStyle.metadata1,
                    color = MainColorScheme.neutralWeak,
                    maxLines = if (isFullText) Int.MAX_VALUE else MAX_LINE,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.clickable {
                        isFullText = !isFullText
                    }
                )
            }
            item {
                EventsRow(avatars = avatars)
            }
            item {
                when {
                    !isButtonPressed -> {
                        CustomButton(
                            text = stringResource(R.string.go_to_event),
                            onClick = { isButtonPressed = true },
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    }

                    else -> {
                        CustomOutlinedButton(
                            text = stringResource(R.string.go_to_event),
                            onClick = { isButtonPressed = false },
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}

