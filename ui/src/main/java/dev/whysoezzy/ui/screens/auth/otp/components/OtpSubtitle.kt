package dev.whysoezzy.ui.screens.auth.otp.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.whysoezzy.ui.R
import dev.whysoezzy.ui.base.text.TextBody2
import dev.whysoezzy.ui.theme.MeetTheme

@Composable
internal fun OtpSubTitle() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        TextBody2(
            text = stringResource(R.string.we_send_code),
            color = MeetTheme.colors.neutralActive,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}