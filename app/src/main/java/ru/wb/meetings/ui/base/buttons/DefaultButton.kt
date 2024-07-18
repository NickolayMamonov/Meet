package ru.wb.meetings.ui.base.buttons

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import ru.wb.meetings.ui.base.text.TextSubheading2
import ru.wb.meetings.ui.theme.MeetTheme


@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    isEnabled: Boolean = true,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val backgroundColor = when {
        isPressed -> MeetTheme.colors.brandDark
        !isEnabled -> MeetTheme.colors.brandDefault.copy(alpha = 0.5f)
        else -> MeetTheme.colors.brandDark
    }
    val contentColor = MeetTheme.colors.neutralWhite

    Button(
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