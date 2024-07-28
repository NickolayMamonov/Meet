package dev.whysoezzy.ui.screens.communities.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import dev.whysoezzy.common.ScreenState
import dev.whysoezzy.ui.R
import dev.whysoezzy.ui.navigation.Screen
import dev.whysoezzy.ui.base.text.TextBody1
import dev.whysoezzy.ui.base.text.TextSubheading1
import dev.whysoezzy.ui.screens.communities.viewmodels.DetailsCommunityViewModel
import dev.whysoezzy.ui.theme.MeetTheme
import dev.whysoezzy.ui.widgets.MeetingEvent


private const val MAX_LINE = 13

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsCommunityScreen(
    navController: NavController,
    name: String,
    viewModel: DetailsCommunityViewModel = koinViewModel(parameters ={ parametersOf(name) } )
) {
    val screenState by viewModel.screenState().collectAsState()
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
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()) {
            when (currentState) {
                is ScreenState.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }

                is ScreenState.Error -> {
                    Text(
                        text = "Error: ${currentState.message}",
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                is ScreenState.Content -> {
                    val details = currentState.data
                    val fullText by viewModel.fullText().collectAsState()
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(18.dp)
                    ) {
                        item {
                            Text(
                                text = details.description,
                                maxLines = if (fullText) Int.MAX_VALUE else MAX_LINE,
                                overflow = TextOverflow.Ellipsis,
                                style = MeetTheme.typography.metadata1,
                                color = MeetTheme.colors.neutralWeak,
                                modifier = Modifier.clickable {
                                    viewModel.toggleFullText()
                                }
                            )
                        }
                        item {
                            TextBody1(
                                text = stringResource(R.string.community_events),
                                color = MeetTheme.colors.neutralWeak,
                                modifier = Modifier.padding(top = 32.dp, bottom = 16.dp)
                            )
                        }

                        items(details.events) { meeting ->
                            MeetingEvent(meeting, onClick = {
                                navController.navigate(Screen.CommunitiesRoot.DetailsCommunity.DetailsEvent.route + "/${meeting.title}")
                            })
                        }

                    }
                }
            }
        }

    }

}


