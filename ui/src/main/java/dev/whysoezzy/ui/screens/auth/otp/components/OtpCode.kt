package dev.whysoezzy.ui.screens.auth.otp.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.navigation.NavController
import dev.whysoezzy.ui.navigation.AuthScreens
import dev.whysoezzy.ui.screens.auth.otp.OtpCodeViewModel
import dev.whysoezzy.ui.utils.TEST_CODE
import dev.whysoezzy.ui.widgets.OtpElement

@Composable
internal fun OtpCode(
    otpCodeViewModel: OtpCodeViewModel,
    navController: NavController,
    focusRequester: FocusRequester
) {
    OtpElement(
        onOtpComplete = { otp ->
            otpCodeViewModel.updateOtpCode(otp)
            if (otp == TEST_CODE) {
                navController.navigate(AuthScreens.AddProfileScreen.route)
            }
        },
        modifier = Modifier.focusRequester(focusRequester)
    )
}