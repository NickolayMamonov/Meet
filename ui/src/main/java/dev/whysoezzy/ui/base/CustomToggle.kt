import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.whysoezzy.ui.theme.LocalColorScheme

@Composable
fun CustomToggle(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    val colorScheme = LocalColorScheme.current

    Box(
        modifier = modifier
            .width(48.dp)
            .height(24.dp)
            .background(
                if (checked) colorScheme.brandDefault
                else colorScheme.neutralLine,
                shape = RoundedCornerShape(68.dp)

            ),
        contentAlignment = Alignment.CenterStart
    ) {
        val thumbOffset by animateFloatAsState(
            targetValue = if (checked) 26.dp.value else 2.dp.value,
            label = "thumb position"
        )

        Box(
            modifier = Modifier
                .padding(
                    start = thumbOffset.dp,
                    top = 1.71.dp,
                    bottom = 1.72.dp
                )
                .size(20.dp)
                .background(
                    color = colorScheme.neutralWhite,
                    shape = RoundedCornerShape(68.dp)
                )
                .clickable(
                    enabled = enabled,
                    indication = rememberRipple(bounded = false),
                    interactionSource = remember { MutableInteractionSource() },
                    onClick = { onCheckedChange(!checked) }
                )
        )
    }
}


@Preview
@Composable
fun TogglePreview() {
    var checked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Enabled Toggle
        CustomToggle(
            checked = checked,
            onCheckedChange = { checked = it },
            modifier = Modifier.padding(start = 20.dp, top = 20.dp)
        )

        // Disabled Toggle
        CustomToggle(
            checked = true,
            onCheckedChange = { },
            enabled = false,
            modifier = Modifier.padding(start = 20.dp, top = 20.dp)
        )
    }
}