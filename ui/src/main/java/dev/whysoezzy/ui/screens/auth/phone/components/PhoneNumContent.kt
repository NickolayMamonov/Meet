package dev.whysoezzy.ui.screens.auth.phone.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.whysoezzy.ui.screens.auth.phone.PhoneNumViewModel
import dev.whysoezzy.ui.widgets.PhoneNumberElement

@Composable
internal fun PhoneNumContent(
    phoneNumViewModel: PhoneNumViewModel,
    focusRequester: FocusRequester,
    countryCode: String,
    phoneNumber: String,
    navController: NavController,
    isPhoneNumberValid: Boolean
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        item {
            PhoneTitle()
        }
        item {
            PhoneSubTitle()
        }
        item {
            PhoneNumberElement(
                onPhoneNumberChange = phoneNumViewModel::updatePhoneNumber,
                onCountryCodeChange = phoneNumViewModel::updateCountryCode,
                modifier = Modifier.focusRequester(focusRequester)
            )
        }
        item {
            PhoneNumButton(countryCode, phoneNumber, navController, isPhoneNumberValid)
        }
    }
}