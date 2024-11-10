package dev.whysoezzy.ui.base.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.whysoezzy.ui.R
import dev.whysoezzy.ui.theme.LocalColorScheme
import dev.whysoezzy.ui.theme.SecondaryGradient

@Composable
fun CustomSubscribeButton(
    selected: Boolean,
    onSelectedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val colorScheme = LocalColorScheme.current




    Box(
        modifier = modifier
            .height(37.dp)
            .clip(RoundedCornerShape(12.dp))
            .then(
                if (selected) {
                    Modifier.background(colorScheme.brandDefault)
                } else {
                    Modifier.background(SecondaryGradient)
                }
            )
            .clickable { onSelectedChange(!selected) }
            .padding(vertical = 10.dp, horizontal = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = if (selected) painterResource(id = R.drawable.ic_accept) else painterResource(
                id = R.drawable.ic_plus
            ),
            contentDescription = if (selected) "Subscribed" else "Subscribe",
            tint = if (selected) colorScheme.neutralWhite else colorScheme.brandDefault,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview
@Composable
fun SubscribeButtonPreview() {
    var isSubscribed by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Unselected state
        CustomSubscribeButton(
            selected = false,
            onSelectedChange = { }
        )

        // Selected state
        CustomSubscribeButton(
            selected = true,
            onSelectedChange = { }
        )

        // Interactive example
        CustomSubscribeButton(
            selected = isSubscribed,
            onSelectedChange = { isSubscribed = it }
        )
    }
}