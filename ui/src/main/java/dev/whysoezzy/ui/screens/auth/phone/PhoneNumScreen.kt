package dev.whysoezzy.ui.screens.auth.phone

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.focus.FocusRequester
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import dev.whysoezzy.ui.screens.auth.phone.components.PhoneNumScreenContent
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun PhoneNumScreen(
    navController: NavController,
    phoneNumViewModel: PhoneNumViewModel = koinViewModel()
) {
    val phoneNumber by phoneNumViewModel.phoneNumber().collectAsStateWithLifecycle()
    val countryCode by phoneNumViewModel.countryCode().collectAsStateWithLifecycle()
    val isPhoneNumberValid by phoneNumViewModel.isPhoneNumberValid().collectAsStateWithLifecycle()
    val focusRequester = remember { FocusRequester() }
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
    PhoneNumScreenContent(
        navController,
        phoneNumViewModel,
        focusRequester,
        countryCode,
        phoneNumber,
        isPhoneNumberValid
    )
}