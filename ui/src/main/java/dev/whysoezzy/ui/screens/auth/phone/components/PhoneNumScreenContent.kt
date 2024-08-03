package dev.whysoezzy.ui.screens.auth.phone.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.focus.FocusRequester
import androidx.navigation.NavController
import dev.whysoezzy.ui.screens.auth.phone.PhoneNumViewModel

@Composable
internal fun PhoneNumScreenContent(
    navController: NavController,
    phoneNumViewModel: PhoneNumViewModel,
    focusRequester: FocusRequester,
    countryCode: String,
    phoneNumber: String,
    isPhoneNumberValid: Boolean
) {
    Column {
        PhoneNumTopBar(navController)
        PhoneNumContent(
            phoneNumViewModel,
            focusRequester,
            countryCode,
            phoneNumber,
            navController,
            isPhoneNumberValid
        )
    }
}