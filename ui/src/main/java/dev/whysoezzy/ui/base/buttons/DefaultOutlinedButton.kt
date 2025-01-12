package dev.whysoezzy.ui.base.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.whysoezzy.ui.base.text.TextSubheading2
import dev.whysoezzy.ui.theme.MeetTheme

@Composable
internal fun CustomOutlinedButton(
    modifier: Modifier = Modifier,
    text: String = "",
    onClick: () -> Unit,
    isEnabled: Boolean = true,
    icon: @Composable (() -> Unit)? = null,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val backgroundColor = MeetTheme.colors.neutralWhite
    val contentColor = when {
        isPressed -> MeetTheme.colors.brandDark
        !isEnabled -> MeetTheme.colors.brandDefault.copy(alpha = 0.5f)
        else -> MeetTheme.colors.brandDefault
    }
    OutlinedButton(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor,
            disabledContainerColor = backgroundColor,
            disabledContentColor = contentColor
        ),
        border = BorderStroke(1.dp, contentColor),
        enabled = isEnabled,
        interactionSource = interactionSource,
        modifier = modifier

    ) {
        if (icon != null) {
            icon()
        }
        TextSubheading2(text = text)
    }
}