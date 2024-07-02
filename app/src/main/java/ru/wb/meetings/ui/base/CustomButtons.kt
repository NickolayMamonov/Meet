package ru.wb.meetings.ui.base

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.meetings.ui.theme.MainColorScheme

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    isEnabled: Boolean = true,
    modifier: Modifier
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
        Text(text = text)
    }
}

@Composable
fun CustomTextButton(
    text: String,
    onClick: () -> Unit,
    isEnabled: Boolean = true,
    modifier: Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val backgroundColor = MainColorScheme.neutralWhite
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
    text: String,
    onClick: () -> Unit,
    isEnabled: Boolean = true,
    icon: @Composable (() -> Unit)? = null,
    modifier: Modifier
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
        Text(text = text)
    }
}

data class ButtonProperties(
    val text: String,
    val onClick: () -> Unit,
    val isEnabled: Boolean = true
)

@Composable
fun ButtonColumns(
    buttons1: List<ButtonProperties>,
    buttons2: List<ButtonProperties>,
    buttons3: List<ButtonProperties>,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        items(buttons1.size) { index ->
            Spacer(modifier = Modifier.height(32.dp))
            Row {
                CustomButton(
                    text = buttons1[index].text,
                    onClick = buttons1[index].onClick,
                    isEnabled = buttons1[index].isEnabled,
                    modifier = Modifier
                        .padding(8.dp)
                        .weight(1f)
                        .fillMaxWidth()
                )
                CustomOutlinedButton(
                    text = buttons2[index].text,
                    onClick = buttons2[index].onClick,
                    isEnabled = buttons2[index].isEnabled,
                    modifier = Modifier
                        .padding(8.dp)
                        .weight(1f)
                        .fillMaxWidth()
                )
                CustomTextButton(
                    text = buttons3[index].text,
                    onClick = buttons3[index].onClick,
                    isEnabled = buttons3[index].isEnabled,
                    modifier = Modifier
                        .padding(8.dp)
                        .weight(1f)
                        .fillMaxWidth()
                )
            }
        }
    }
}

