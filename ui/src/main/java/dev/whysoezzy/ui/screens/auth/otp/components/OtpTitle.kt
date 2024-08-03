package dev.whysoezzy.ui.screens.auth.otp.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.whysoezzy.ui.R
import dev.whysoezzy.ui.base.text.TextHeading2
import dev.whysoezzy.ui.theme.MeetTheme

@Composable
internal fun OtpTitle() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        TextHeading2(
            text = stringResource(R.string.enter_code),
            color = MeetTheme.colors.neutralActive,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(
                top = 32.dp,
                start = 16.dp,
                end = 16.dp,
                bottom = 12.dp
            )
        )
    }
}