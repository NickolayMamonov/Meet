package dev.whysoezzy.ui.screens.more.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.TopAppBarDefaults
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
import dev.whysoezzy.ui.base.MainIcon
import dev.whysoezzy.ui.base.UserAvatar
import dev.whysoezzy.ui.base.buttons.CustomOutlinedButton
import dev.whysoezzy.ui.base.text.TextBody2
import dev.whysoezzy.ui.base.text.TextHeading2
import dev.whysoezzy.ui.base.text.TextSubheading1
import dev.whysoezzy.ui.screens.more.viewmodels.ProfileViewModel
import dev.whysoezzy.ui.theme.MeetTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: ProfileViewModel = koinViewModel()
) {
    val screenState by viewModel.screenState().collectAsState()
    val currentState = screenState
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    TextSubheading1(
                        text = stringResource(id = R.string.profile),
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
                },
                actions = {
                    IconButton(onClick = {
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.edit),
                            contentDescription = null
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MeetTheme.colors.neutralWhite
                )
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)){
            when (currentState) {
                is ScreenState.Loading -> CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))

                is ScreenState.Error -> Text(
                    text = "Error: ${currentState.message}",
                    modifier = Modifier.align(Alignment.Center)
                )
                is ScreenState.Content -> {
                    val userProfile = currentState.data
                    LazyColumn(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .background(MeetTheme.colors.neutralWhite)
                            .padding(top = 50.dp),
                    ) {
                        userProfile.let { profile ->
                            item {
                                UserAvatar(
                                    size = 200.dp,
                                )
                            }
                            item {
                                TextHeading2(
                                    text = profile.name,
                                    color = MeetTheme.colors.neutralActive,
                                    modifier = Modifier.padding(top = 16.dp, bottom = 4.dp)
                                )
                            }
                            item {
                                TextBody2(
                                    text = profile.phoneNumber,
                                    color = MeetTheme.colors.neutralDisabled,
                                    modifier = Modifier.padding(bottom = 16.dp)
                                )
                            }
                            item {
                                Row(
                                    horizontalArrangement = Arrangement.SpaceEvenly,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 16.dp)
                                ) {
                                    CustomOutlinedButton(
                                        icon = {
                                            MainIcon(
                                                showBadge = false,
                                                isClickable = false,
                                                sizeIcon = 24.dp,
                                                image = painterResource(id = R.drawable.icon_twittter)
                                            )
                                        },
                                        onClick = {

                                        },
                                    )
                                    CustomOutlinedButton(
                                        icon = {
                                            MainIcon(
                                                showBadge = false,
                                                isClickable = false,
                                                sizeIcon = 24.dp,
                                                image = painterResource(id = R.drawable.icon_inst)
                                            )
                                        },
                                        onClick = {

                                        },
                                    )
                                    CustomOutlinedButton(
                                        icon = {
                                            MainIcon(
                                                showBadge = false,
                                                isClickable = false,
                                                sizeIcon = 24.dp,
                                                image = painterResource(id = R.drawable.icon_in)
                                            )
                                        },
                                        onClick = {

                                        },
                                    )
                                    CustomOutlinedButton(
                                        icon = {
                                            MainIcon(
                                                showBadge = false,
                                                isClickable = false,
                                                sizeIcon = 24.dp,
                                                image = painterResource(id = R.drawable.icon_fb)
                                            )
                                        },
                                        onClick = {

                                        },
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
