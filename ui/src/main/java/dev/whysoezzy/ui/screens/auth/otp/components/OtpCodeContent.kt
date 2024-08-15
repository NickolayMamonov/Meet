package dev.whysoezzy.ui.screens.auth.otp.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.whysoezzy.ui.screens.auth.otp.OtpCodeViewModel

@Composable
internal fun OtpCodeContent(
    phoneNumber: String,
    otpCodeViewModel: OtpCodeViewModel,
    navController: NavController,
    focusRequester: FocusRequester,
    isOtpValid: Boolean
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        item {
            OtpTitle()
        }
        item {
            OtpSubTitle()
        }
        item {
            OtpPhoneNum(phoneNumber)
        }
        item {
            OtpCode(otpCodeViewModel, navController, focusRequester)
        }
        item {
            RequestCodeButton(isOtpValid)
        }
    }
}