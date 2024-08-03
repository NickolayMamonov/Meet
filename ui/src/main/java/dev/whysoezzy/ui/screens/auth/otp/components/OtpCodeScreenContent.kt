package dev.whysoezzy.ui.screens.auth.otp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.focus.FocusRequester
import androidx.navigation.NavController
import dev.whysoezzy.ui.screens.auth.otp.OtpCodeViewModel

@Composable
internal fun OtpCodeScreenContent(
    navController: NavController,
    phoneNumber: String,
    otpCodeViewModel: OtpCodeViewModel,
    focusRequester: FocusRequester,
    isOtpValid: Boolean
) {
    Column {
        OtpScreenTopBar(navController)
        OtpCodeContent(phoneNumber, otpCodeViewModel, navController, focusRequester, isOtpValid)
    }
}

