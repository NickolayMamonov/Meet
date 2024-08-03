package dev.whysoezzy.ui.base.buttons

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dev.whysoezzy.ui.base.text.TextSubheading2
import dev.whysoezzy.ui.theme.MeetTheme

@Composable
internal fun CustomTextButton(
    text: String,
    onClick: () -> Unit,
    isEnabled: Boolean = true,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val backgroundColor = Color.Transparent
    val contentColor = when {
        isPressed -> MeetTheme.colors.brandDark
        !isEnabled -> MeetTheme.colors.brandDefault.copy(alpha = 0.5f)
        else -> MeetTheme.colors.brandDefault
    }
    TextButton(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor,
            disabledContainerColor = backgroundColor,
            disabledContentColor = contentColor
        ),
        enabled = isEnabled,
        interactionSource = interactionSource,
        modifier = modifier

    ) {
        TextSubheading2(text = text)
    }
}