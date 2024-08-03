package dev.whysoezzy.ui.screens.more.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dev.whysoezzy.ui.R
import dev.whysoezzy.ui.base.MainIcon
import dev.whysoezzy.ui.base.buttons.CustomOutlinedButton

@Composable
internal fun ProfileSocialButtons() {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        CustomOutlinedButton(
            icon = {
                MainIcon(
                    sizeIcon = 24.dp,
                    image = painterResource(id = R.drawable.icon_twittter)
                )
            },
            onClick = {},
        )
        CustomOutlinedButton(
            icon = {
                MainIcon(
                    sizeIcon = 24.dp,
                    image = painterResource(id = R.drawable.icon_inst)
                )
            },
            onClick = {},
        )
        CustomOutlinedButton(
            icon = {
                MainIcon(
                    sizeIcon = 24.dp,
                    image = painterResource(id = R.drawable.icon_in)
                )
            },
            onClick = {},
        )
        CustomOutlinedButton(
            icon = {
                MainIcon(
                    sizeIcon = 24.dp,
                    image = painterResource(id = R.drawable.icon_fb)
                )
            },
            onClick = {},
        )
    }
}