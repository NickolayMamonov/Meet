package ru.wb.meetings.ui.screens.auth.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.wb.meetings.R
import ru.wb.meetings.navigation.AuthScreens
import ru.wb.meetings.ui.base.buttons.CustomTextButton
import ru.wb.meetings.ui.base.text.TextBody2
import ru.wb.meetings.ui.base.text.TextHeading2
import ru.wb.meetings.ui.screens.auth.viewmodels.OtpCodeViewModel
import ru.wb.meetings.ui.theme.MeetTheme
import ru.wb.meetings.ui.utils.formatPhoneNumber
import ru.wb.meetings.ui.widgets.OtpElement

private const val TEST_CODE = "1234"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtpCodeScreen(navController: NavController, phoneNumber: String, countryCode: String,otpCodeViewModel: OtpCodeViewModel = koinViewModel()) {
    val otpCode by otpCodeViewModel.otpCode.collectAsState()
    val isOtpValid by otpCodeViewModel.isOtpValid.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_back),
                            contentDescription = null
                        )
                    }

                },
                title = {}
            )
        }
    ) { innerPadding ->
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 24.dp)
        ) {
            item {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    TextHeading2(
                        text = stringResource(R.string.enter_code),
                        color = MeetTheme.colors.neutralActive,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(
                            top = 32.dp,
                            start = 16.dp,
                            end = 16.dp,
                            bottom = 12.dp
                        )
                    )
                }
            }
            item {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    TextBody2(
                        text = stringResource(R.string.we_send_code),
                        color = MeetTheme.colors.neutralActive,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }

            }
            item {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 32.dp, top = 16.dp)
                ) {
                    TextBody2(
                        text = "$countryCode ${formatPhoneNumber(phoneNumber)}",
                        color = MeetTheme.colors.neutralActive,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            }
            item {
                OtpElement(onOtpComplete = {otp ->
                    otpCodeViewModel.updateOtpCode(otp)
                    if (otp == TEST_CODE) {
                        navController.navigate(AuthScreens.AddProfileScreen.route)
                    }
                })
            }
            item {
                CustomTextButton(
                    text = stringResource(R.string.request_code_again),
                    onClick = { /*TODO*/ },
                    isEnabled = isOtpValid.not(),
                    modifier = Modifier.padding(top = 64.dp)
                )
            }
        }
    }

}

