package dev.whysoezzy.ui.screens.auth.otp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.focus.FocusRequester
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import dev.whysoezzy.ui.screens.auth.otp.components.OtpCodeScreenContent
import org.koin.androidx.compose.koinViewModel


@Composable
internal fun OtpCodeScreen(
    navController: NavController,
    phoneNumber: String,
    otpCodeViewModel: OtpCodeViewModel = koinViewModel()
) {

    val focusRequester = remember { FocusRequester() }
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
    val isOtpValid by otpCodeViewModel.isOtpValid().collectAsStateWithLifecycle()
    OtpCodeScreenContent(navController, phoneNumber, otpCodeViewModel, focusRequester, isOtpValid)
}