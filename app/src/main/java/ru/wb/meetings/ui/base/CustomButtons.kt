package ru.wb.meetings.ui.base

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.wb.meetings.ui.theme.MainColorScheme
import ru.wb.meetings.ui.theme.MainTypographyTextStyle
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
        isPressed -> MainColorScheme.brandDark
        !isEnabled -> MainColorScheme.brandDefault.copy(alpha = 0.5f)
        else -> MainColorScheme.brandDefault
    }
    val contentColor = MainColorScheme.neutralWhite

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
        Text(text = text, style = MeetTheme.typography.subheading2, color = MeetTheme.colors.brandLight)
    }
}

@Composable
fun CustomTextButton(
    text: String,
    onClick: () -> Unit,
    isEnabled: Boolean = true,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val backgroundColor = Color.Transparent
    val contentColor = when {
        isPressed -> MainColorScheme.brandDark
        !isEnabled -> MainColorScheme.brandDefault.copy(alpha = 0.5f)
        else -> MainColorScheme.brandDefault
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
        Text(text = text)
    }
}

@Composable
fun CustomOutlinedButton(
    text: String = "",
    onClick: () -> Unit,
    isEnabled: Boolean = true,
    icon: @Composable (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val backgroundColor = MainColorScheme.neutralWhite
    val contentColor = when {
        isPressed -> MainColorScheme.brandDark
        !isEnabled -> MainColorScheme.brandDefault.copy(alpha = 0.5f)
        else -> MainColorScheme.brandDefault
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
        Text(text = text, style = MainTypographyTextStyle.subheading2, color = MainColorScheme.brandDefault)
    }
}



