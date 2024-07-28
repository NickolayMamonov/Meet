package dev.whysoezzy.ui.screens.auth.screens

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import dev.whysoezzy.ui.R
import dev.whysoezzy.ui.base.buttons.CustomButton
import dev.whysoezzy.ui.base.text.TextBody2
import dev.whysoezzy.ui.base.text.TextHeading2
import dev.whysoezzy.ui.navigation.AuthScreens
import org.koin.androidx.compose.koinViewModel
import dev.whysoezzy.ui.screens.auth.viewmodels.PhoneNumViewModel
import dev.whysoezzy.ui.theme.MeetTheme
import dev.whysoezzy.ui.widgets.PhoneNumberElement



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhoneNumScreen(
    navController: NavController,
    phoneNumViewModel: PhoneNumViewModel = koinViewModel()
) {
    val phoneNumber by phoneNumViewModel.phoneNumber().collectAsState()
    val countryCode by phoneNumViewModel.countryCode().collectAsState()
    val isPhoneNumberValid by phoneNumViewModel.isPhoneNumberValid().collectAsState()

    val focusRequester = remember { FocusRequester() }
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
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
                    onCountryCodeChange = phoneNumViewModel::updateCountryCode,
                    modifier = Modifier.focusRequester(focusRequester)
                )
            }
            item {
                CustomButton(
                    text = stringResource(R.string.Continue),
                    onClick = {
                        val fullPhoneNumber = "$countryCode$phoneNumber"
                        navController.navigate(AuthScreens.OtpCodeScreen.route + "/${fullPhoneNumber}")
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