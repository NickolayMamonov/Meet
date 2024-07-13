package ru.wb.meetings.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.wb.meetings.R
import ru.wb.meetings.ui.theme.MainColorScheme
import ru.wb.meetings.ui.theme.MainTypographyTextStyle

private const val OTP_LENGTH = 4


@Composable
fun OtpElement(onOtpComplete: (String) -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()

    ) {
        var otp by remember { mutableStateOf("") }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.width(220.dp)
        ) {
            repeat(OTP_LENGTH) { index ->
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .width(40.dp)
                        .height(50.dp)
                ) {
                    when {
                        index >= otp.length -> {
                            Image(
                                painter = painterResource(id = R.drawable.navbar_dot),
                                contentDescription = "Dot",
                                colorFilter = ColorFilter.tint(MainColorScheme.neutralLine),
                                modifier = Modifier.size(24.dp)
                            )
                        }

                        else -> {
                            Text(
                                text = otp[index].toString(),
                                style = MainTypographyTextStyle.heading1
                            )
                        }
                    }
                }
            }
        }

        BasicTextField(
            value = otp,
            onValueChange = { value ->
                when {
                    value.length <= OTP_LENGTH -> {
                        otp = value.filter { it.isDigit() }
                        when (value.length) {
                            OTP_LENGTH -> {
                                onOtpComplete(value)
                            }
                        }
                    }
                }
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                autoCorrect = false
            ),
            textStyle = MainTypographyTextStyle.bodyText1.copy(color = Color.Transparent),
            cursorBrush = SolidColor(Color.Transparent),
            modifier = Modifier
                .width(200.dp)
                .height(50.dp)
                .background(Color.Transparent)
        )
    }


}


@Preview(showBackground = true)
@Composable
fun PreviewOtpElement() {
//    OtpElement()
}