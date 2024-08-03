package dev.whysoezzy.ui.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dev.whysoezzy.ui.R
import dev.whysoezzy.ui.base.MainIcon
import dev.whysoezzy.ui.base.UserAvatar
import dev.whysoezzy.ui.base.text.TextBody1
import dev.whysoezzy.ui.base.text.TextMetadata1
import dev.whysoezzy.ui.theme.MeetTheme


@Composable
fun ProfileElement(
    text: String,
    subtext: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, bottom = 16.dp)
            .clickable(
                interactionSource = remember {
                    MutableInteractionSource()
                },
                indication = null, onClick = onClick
            ),
    ) {
        UserAvatar(size = 40.dp)
        Column(
            modifier = Modifier
                .padding(start = 10.dp)
                .weight(1f)

        ) {
            TextBody1(
                text = text,
                color = MeetTheme.colors.neutralActive
            )
            TextMetadata1(
                text = subtext,
                color = MeetTheme.colors.neutralDisabled,
                modifier = Modifier.padding(top = 6.dp)
            )
        }
        MainIcon(
            showBadge = false,
            isClickable = false,
            image = painterResource(id = R.drawable.arrow_forward),
            sizeIcon = 12.dp,
        )
    }
}
