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
            if (offset <= 3) return offset
            if (offset <= 6) return offset + 1
            if (offset <= 8) return offset + 2
            if (offset <= 10) return offset + 3
            return 13
        }

        override fun transformedToOriginal(offset: Int): Int {
            if (offset <= 4) return offset
            if (offset <= 7) return offset - 1
            if (offset <= 10) return offset - 2
            if (offset <= 13) return offset - 3
            return 10
        }
    }

    return TransformedText(AnnotatedString(formattedString), offsetMapping)
}