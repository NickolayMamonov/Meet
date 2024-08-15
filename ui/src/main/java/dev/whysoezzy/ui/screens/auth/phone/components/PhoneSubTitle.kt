package dev.whysoezzy.ui.screens.auth.phone.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.whysoezzy.ui.R
import dev.whysoezzy.ui.base.text.TextBody2
import dev.whysoezzy.ui.theme.MeetTheme

@Composable
internal fun PhoneSubTitle() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 32.dp)
    ) {
        TextBody2(
            text = stringResource(R.string.we_will_send_confirmation_code),
            textAlign = TextAlign.Center,
            color = MeetTheme.colors.neutralActive,
            lineHeight = 28.sp,
            modifier = Modifier
                .padding(16.dp)
                .padding(horizontal = 64.dp)
        )
    }
}