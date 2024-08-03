package dev.whysoezzy.ui.screens.auth.otp.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.whysoezzy.ui.base.text.TextBody2
import dev.whysoezzy.ui.theme.MeetTheme
import dev.whysoezzy.ui.utils.formatPhoneNumber

@Composable
internal fun OtpPhoneNum(phoneNumber: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 32.dp, top = 16.dp)
    ) {
        TextBody2(
            text = formatPhoneNumber(phoneNumber),
            color = MeetTheme.colors.neutralActive,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}