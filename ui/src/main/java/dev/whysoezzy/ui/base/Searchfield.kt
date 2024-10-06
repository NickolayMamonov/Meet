package dev.whysoezzy.ui.base

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.whysoezzy.ui.base.text.TextSubheading2
import dev.whysoezzy.ui.theme.MeetTheme

@Composable
internal fun SearchField(
    modifier: Modifier = Modifier,
    searchField: String,
    onFieldChange: (String) -> Unit,
    onClearField: () -> Unit,
    placeholder: String = "Поиск"
) {
    val focusManager = LocalFocusManager.current
    var focusState by remember {
        mutableStateOf(false)
    }

    BasicTextField(
        modifier = modifier
            .height(44.dp)
            .background(color = MeetTheme.colors.neutralSecondaryBackground)
            .onFocusChanged { focusState = it.isFocused },
        value = searchField,
        onValueChange = {
            onFieldChange(it)
        },
        textStyle = MeetTheme.typography.subheading2,
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
            }
        ),
        decorationBox = { innerTextField ->
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
            ) {
                when {
                    !focusState && searchField.isEmpty() -> {
                        Placeholder(
                            placeholder =placeholder
                        )
                    }

                    else -> {
                        innerTextField()
                    }
                }
                if (searchField.isNotEmpty()) {
                    ClearButton(
                        onClearClick = onClearField
                    )
                }
            }
        }
    )
}

@Composable
fun Placeholder(
    placeholder: String
) {
    Icon(
        imageVector = Icons.Outlined.Search,
        contentDescription = null,
        modifier = Modifier.size(22.dp)
    )
    TextSubheading2(text = placeholder)
}

@Composable
fun ClearButton(
    modifier: Modifier = Modifier,
    onClearClick: () -> Unit
) {
    Icon(
        modifier = modifier
            .clickable { onClearClick() }
            .size(22.dp),
        imageVector = Icons.Outlined.Clear,
        contentDescription = null
    )
}

@Preview
@Composable
fun PreviewSearchField() {
    var searchField by remember { mutableStateOf("") }

    SearchField(
        searchField = searchField,
        onFieldChange = { searchField = it },
        onClearField = { searchField = "" },
        modifier = Modifier.fillMaxWidth()
    )
}