package dev.whysoezzy.ui.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dev.whysoezzy.ui.R
import dev.whysoezzy.ui.base.MainIcon
import dev.whysoezzy.ui.base.text.TextBody1

@Composable
fun SettingsElement(
    icon: Painter,
    name: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clickable(
                interactionSource = remember {
                    MutableInteractionSource()
                },
                indication = null, onClick = onClick,
            )
    ) {
        MainIcon(
            showBadge = false,
            isClickable = false,
            image = icon,
            sizeIcon = 24.dp
        )
        TextBody1(
            text = name,
            modifier = Modifier.padding(start = 6.dp).weight(1f).align(Alignment.CenterVertically)
        )
        MainIcon(
            showBadge = false,
            isClickable = false,
            image = painterResource(id = R.drawable.arrow_forward),
            sizeIcon = 12.dp,
        )
    }
}