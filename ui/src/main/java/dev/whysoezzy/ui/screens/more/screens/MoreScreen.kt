package dev.whysoezzy.ui.screens.more.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import dev.whysoezzy.common.ScreenState
import dev.whysoezzy.ui.R
import dev.whysoezzy.ui.navigation.Screen
import dev.whysoezzy.ui.base.text.TextSubheading1
import dev.whysoezzy.ui.screens.more.viewmodels.MoreViewModel
import dev.whysoezzy.ui.theme.MeetTheme
import dev.whysoezzy.ui.widgets.ProfileElement
import dev.whysoezzy.ui.widgets.SettingsElement

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoreScreen(
    navController: NavController,
    viewModel: MoreViewModel = koinViewModel()
) {
    val screenState by viewModel.screenState().collectAsState()
    val currentState =screenState
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    TextSubheading1(
                        text = stringResource(R.string.more),
                        color = MeetTheme.colors.neutralActive
                    )
                }
            )
        }
    ) { innerPadding ->
        when(currentState){
            is ScreenState.Loading -> CircularProgressIndicator()
            is ScreenState.Error -> Text(text = "Error: ${currentState.message}")
            is ScreenState.Content -> {
                val userProfile = currentState.data
                LazyColumn(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                        .background(MeetTheme.colors.neutralWhite),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    item {
                        userProfile.let{ profile ->
                            ProfileElement(
                                text = profile.name,
                                subtext = profile.phoneNumber,
                                onClick = {
                                    navController.navigate(Screen.MoreRoot.Profile.route)
                                },
                                modifier = Modifier.padding(top = 8.dp)
                            )
                        }
                    }
                    item {
                        SettingsElement(
                            icon = painterResource(id = R.drawable.events),
                            name = stringResource(id = R.string.my_meetings),
                            onClick = {
                                navController.navigate(Screen.MoreRoot.MyEvents.route)
                            },
                            modifier = Modifier
                                .padding(bottom = 20.dp)
                        )
                    }
                    item {
                        SettingsElement(
                            icon = painterResource(id = R.drawable.ic_theme),
                            name = stringResource(R.string.theme),
                            onClick = {},
                        )
                    }
                    item {
                        SettingsElement(
                            icon = painterResource(id = R.drawable.ic_notification),
                            name = stringResource(R.string.notifications),
                            onClick = {},
                        )
                    }
                    item {
                        SettingsElement(
                            icon = painterResource(id = R.drawable.ic_security),
                            name = stringResource(R.string.security),
                            onClick = {},
                        )
                    }
                    item {
                        SettingsElement(
                            icon = painterResource(id = R.drawable.ic_memory_and_storage),
                            name = stringResource(R.string.memory_and_resources),
                            onClick = {},
                        )
                    }
                    item {
                        HorizontalDivider(
                            thickness = 1.dp,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                        )
                    }
                    item {
                        SettingsElement(
                            icon = painterResource(id = R.drawable.ic_help),
                            name = stringResource(R.string.help),
                            onClick = {},
                        )
                    }
                    item {
                        SettingsElement(
                            icon = painterResource(id = R.drawable.ic_invite_friend),
                            name = stringResource(R.string.invite_friend),
                            onClick = {},
                        )
                    }
                }
            }
        }
    }
}