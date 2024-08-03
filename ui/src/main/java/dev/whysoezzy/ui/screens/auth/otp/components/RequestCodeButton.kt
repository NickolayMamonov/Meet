package dev.whysoezzy.ui.screens.auth.otp.components

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.whysoezzy.ui.R
import dev.whysoezzy.ui.base.buttons.CustomTextButton

@Composable
internal fun RequestCodeButton(isOtpValid: Boolean) {
    CustomTextButton(
        text = stringResource(R.string.request_code_again),
        onClick = { /*TODO*/ },
        isEnabled = isOtpValid.not(),
        modifier = Modifier.padding(top = 64.dp)
    )
}