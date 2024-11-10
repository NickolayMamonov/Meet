package dev.whysoezzy.ui.base

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.whysoezzy.ui.theme.LocalColorScheme

enum class InputState {
    EMPTY,
    FOCUSED,
    FILLED,
    ERROR
}

@Composable
fun CustomInput(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    hint: String = "",
    isError: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    maxLines: Int = 1,
    errorMessage: String = ""
) {
    val colorScheme = LocalColorScheme.current
    var isFocused by remember { mutableStateOf(false) }

    val inputState = when {
        isError -> InputState.ERROR
        isFocused -> InputState.FOCUSED
        value.isNotEmpty() -> InputState.FILLED
        else -> InputState.EMPTY
    }


    Column {
        Box(
            modifier = modifier
                .width(343.dp)
                .height(56.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(
                    when (inputState) {
                        InputState.ERROR -> Color(0xFFFDE7ED)
                        else -> colorScheme.neutralSecondaryBackground
                    },
                    shape = RoundedCornerShape(16.dp)
                )
                .then(
                    when (inputState) {
                        InputState.FOCUSED -> Modifier.border(
                            width = 1.dp,
                            color = colorScheme.brandDefault,
                            shape = RoundedCornerShape(16.dp)
                        )

                        InputState.ERROR -> Modifier.border(
                            width = 1.dp,
                            color = colorScheme.accentDanger,
                            shape = RoundedCornerShape(16.dp)
                        )

                        else -> Modifier
                    }
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.Center
            ) {
                BasicTextField(
                    value = value,
                    onValueChange = onValueChange,
                    modifier = Modifier
                        .fillMaxWidth()
                        .onFocusChanged { isFocused = it.isFocused },
                    textStyle = TextStyle(
                        fontSize = 16.sp,
                        color = when {
                            isError -> colorScheme.accentDanger
                            else -> colorScheme.neutralBody
                        }
                    ),
                    cursorBrush = SolidColor(colorScheme.brandDefault),
                    keyboardOptions = keyboardOptions,
                    visualTransformation = visualTransformation,
                    maxLines = maxLines,
                    decorationBox = { innerTextField ->
                        Box(
                            modifier = Modifier
                        ) {
                            if (value.isEmpty() && !isFocused) {
                                Text(
                                    text = hint,
                                    color = colorScheme.neutralWeak,
                                    fontSize = 16.sp
                                )
                            }
                            innerTextField()
                        }
                    }
                )
            }
        }

        if (isError && errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = colorScheme.accentDanger,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 12.dp, top = 4.dp)
            )
        }
    }
}

@Preview
@Composable
fun InputPreview() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Empty state
        var emptyText by remember { mutableStateOf("") }
        CustomInput(
            value = emptyText,
            onValueChange = { emptyText = it },
            hint = "Enter text"
        )

        // Focused state
        var focusedText by remember { mutableStateOf("") }
        CustomInput(
            value = focusedText,
            onValueChange = { focusedText = it },
            hint = "Focused input"
        )

        // Filled state
        var filledText by remember { mutableStateOf("Some text") }
        CustomInput(
            value = filledText,
            onValueChange = { filledText = it },
            hint = "Enter text"
        )

        // Error state
        var errorText by remember { mutableStateOf("Invalid input") }
        CustomInput(
            value = errorText,
            onValueChange = { errorText = it },
            hint = "Enter text",
            isError = true,
            errorMessage = "Error message"
        )
    }
}