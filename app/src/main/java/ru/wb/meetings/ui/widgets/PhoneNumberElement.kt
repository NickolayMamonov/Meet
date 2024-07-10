package ru.wb.meetings.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.wb.meetings.R
import ru.wb.meetings.ui.theme.MainColorScheme

@Composable
fun PhoneNumberElement() {
    var phoneNumber by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var selectedCountryCode by remember { mutableStateOf("+7") }

    val countryCodes = listOf("+7", "+8", "+9")
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxHeight()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier
                .background(MainColorScheme.neutralSecondaryBackground)
                .clickable { expanded = true }
            ) {
                Row(
                    modifier = Modifier.padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_ru_flag),
                        contentDescription = "Flag"
                    )
                    Text(text = selectedCountryCode, modifier = Modifier.padding(start = 4.dp))
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .background(MainColorScheme.neutralSecondaryBackground)
                ) {
                    countryCodes.forEach { code ->
                        DropdownMenuItem(
                            leadingIcon = {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_ru_flag),
                                    contentDescription = "Flag"
                                )
                            },
                            text = { Text(text = code) },
                            onClick = {
                                selectedCountryCode = code
                                expanded = false
                            })
                    }
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(MainColorScheme.neutralSecondaryBackground)
                    .padding(vertical = 8.dp)
            ) {
                BasicTextField(
                    value = phoneNumber,
                    onValueChange = {
                        phoneNumber = it
                    },
                    singleLine = true,
                    cursorBrush = SolidColor(Color.Transparent),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    visualTransformation = { mobileNumberFilter(it) },
                    modifier = Modifier
                        .padding(start = 8.dp)
                )

            }

        }

    }

}

const val mask = "000 000-00-00"
fun mobileNumberFilter(text: AnnotatedString): TransformedText {
    val trimmed =
        when {
            text.text.length >= 10 -> text.text.substring(0..9)
            else -> text.text
        }

    val annotatedString = AnnotatedString.Builder().run {
        for (i in trimmed.indices) {
            append(trimmed[i])
            when (i) {
                2 -> {
                    append(" ")
                }

                5, 7 -> {
                    append("-")
                }
            }

        }
        pushStyle(SpanStyle(color = Color.LightGray))
        append(mask.takeLast(mask.length - length))
        toAnnotatedString()
    }

    val phoneNumberOffsetTranslator = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            if (offset <= 2) return offset
            if (offset <= 5) return offset + 1
            if (offset <= 7) return offset + 2
            if (offset <= 9) return offset + 3
            return 13
        }

        override fun transformedToOriginal(offset: Int): Int {
            if (offset <= 2) return offset
            if (offset <= 5) return offset - 1
            if (offset <= 7) return offset - 2
            if (offset <= 10) return offset - 3
            return 10
        }
    }

    return TransformedText(annotatedString, phoneNumberOffsetTranslator)
}

@Preview(showBackground = true)
@Composable
fun PreviewPhoneNumberElement() {
    PhoneNumberElement()
}