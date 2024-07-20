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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.koinViewModel
import ru.wb.meetings.R
import ru.wb.meetings.ui.navigation.AuthScreens
import ru.wb.meetings.ui.base.buttons.CustomButton
import ru.wb.meetings.ui.base.text.TextBody2
import ru.wb.meetings.ui.base.text.TextHeading2
import ru.wb.meetings.ui.screens.auth.viewmodels.PhoneNumViewModel
import ru.wb.meetings.ui.theme.MeetTheme
import ru.wb.meetings.ui.widgets.PhoneNumberElement


private const val PHONE_NUM_LENGTH = 10

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhoneNumScreen(
    navController: NavController,
    phoneNumViewModel: PhoneNumViewModel = koinViewModel()
) {
    val phoneNumber by phoneNumViewModel.phoneNumber.collectAsState()
    val countryCode by phoneNumViewModel.countryCode.collectAsState()
    val isPhoneNumberValid by phoneNumViewModel.isPhoneNumberValid.collectAsState()

    Scaffold(topBar = {
        TopAppBar(navigationIcon = {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = null
                )
            }
        }, title = {})
    }) { innerPadding ->
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 24.dp)
        ) {
            item {
                Box(
                    contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()
                ) {
                    TextHeading2(
                        text = stringResource(R.string.enter_phone_num),
                        color = MeetTheme.colors.neutralActive,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 32.dp)
                    )
                }
            }
            item {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 32.dp)
                ) {
                    TextBody2(
                        text = stringResource(R.string.we_will_send_confirmation_code),
                        textAlign = TextAlign.Center,
                        color = MeetTheme.colors.neutralActive,
                        lineHeight = 28.sp,
                        modifier = Modifier
                            .padding(16.dp)
                            .padding(horizontal = 64.dp)
                    )
                }
            }
            item {
                PhoneNumberElement(
                    onPhoneNumberChange = phoneNumViewModel::updatePhoneNumber,
                    onCountryCodeChange = phoneNumViewModel::updateCountryCode
                )
            }
            item {
                CustomButton(
                    text = stringResource(R.string.Continue),
                    onClick = {
                        navController.navigate(AuthScreens.OtpCodeScreen.route + "/${phoneNumber}/${countryCode}")
                    },
                    isEnabled = isPhoneNumberValid,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 64.dp)
                )
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun PreviewAuthPhoneNumScreen() {
    val navController = rememberNavController()
    PhoneNumScreen(navController = navController)
}