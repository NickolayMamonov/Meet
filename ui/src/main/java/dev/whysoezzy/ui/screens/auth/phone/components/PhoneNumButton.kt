package dev.whysoezzy.ui.screens.auth.phone.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.whysoezzy.ui.R
import dev.whysoezzy.ui.base.buttons.CustomButton
import dev.whysoezzy.ui.navigation.AuthScreens

@Composable
internal fun PhoneNumButton(
    countryCode: String,
    phoneNumber: String,
    navController: NavController,
    isPhoneNumberValid: Boolean
) {
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