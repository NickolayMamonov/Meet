package ru.wb.meetings.ui.utils

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText

fun mobileNumberFilter(text: AnnotatedString): TransformedText {
    val digitsOnly = text.text.filter { it.isDigit() }
    val builder = StringBuilder()
    for (i in digitsOnly.indices) {
        when (i) {
            3 -> builder.append(" ")
            6, 8 -> builder.append("-")
        }
        builder.append(digitsOnly[i])
    }
    val formattedString = builder.toString()

    val offsetMapping = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            return when {
                offset <= 3 -> offset
                offset <= 6 -> offset + 1
                offset <= 8 -> offset + 2
                offset <= 10 -> offset + 3
                else -> 13
            }
        }

        override fun transformedToOriginal(offset: Int): Int {
            return when {
                offset <= 4 -> offset
                offset <= 7 -> offset - 1
                offset <= 10 -> offset - 2
                offset <= 13 -> offset - 3
                else -> 10
            }
        }
    }

    return TransformedText(AnnotatedString(formattedString), offsetMapping)
}