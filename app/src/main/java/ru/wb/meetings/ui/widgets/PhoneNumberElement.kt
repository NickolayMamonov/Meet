package ru.wb.meetings.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.wb.meetings.ui.theme.MainColorScheme
import ru.wb.meetings.ui.theme.MeetTheme
import ru.wb.meetings.ui.utils.Country
import ru.wb.meetings.ui.utils.mobileNumberFilter


private const val PHONE_NUM_WITHOUT_COUNTRY_CODE = 10
@Composable
fun PhoneNumberElement(
    onPhoneNumberChange: (String) -> Unit,
    onCountryCodeChange: (String) -> Unit
) {
    var phoneNumber by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var selectedCountryCode by remember { mutableStateOf(Country.RUSSIA) }

    LaunchedEffect(phoneNumber) {
        onPhoneNumberChange(phoneNumber)
    }
    LaunchedEffect(selectedCountryCode) {
        onCountryCodeChange(selectedCountryCode.phoneCode)

    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxHeight()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(MainColorScheme.neutralSecondaryBackground)
                .clickable { expanded = true }

            ) {
                Row(
                    modifier = Modifier.padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = selectedCountryCode.flagId),
                        contentDescription = "Flag"
                    )
                    Text(
                        text = selectedCountryCode.phoneCode,
                        style = MeetTheme.typography.bodyText1,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .background(MainColorScheme.neutralSecondaryBackground)
                ) {
                    Country.entries.forEach { code ->
                        DropdownMenuItem(
                            leadingIcon = {
                                Image(
                                    painter = painterResource(id = code.flagId),
                                    contentDescription = "Flag"
                                )
                            },
                            text = {
                                Text(
                                    text = code.phoneCode,
                                    style = MeetTheme.typography.bodyText1
                                )
                            },
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
                    .clip(RoundedCornerShape(8.dp))
                    .weight(1f)
                    .background(MainColorScheme.neutralSecondaryBackground)
                    .padding(vertical = 8.dp)
            ) {
                BasicTextField(
                    textStyle = MeetTheme.typography.bodyText1,
                    value = phoneNumber,
                    onValueChange = {
                        if (it.filter { char -> char.isDigit() }.length <= PHONE_NUM_WITHOUT_COUNTRY_CODE) {
                            phoneNumber = it
                        }
                    },
                    singleLine = true,
                    cursorBrush = SolidColor(Color.Transparent),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    visualTransformation = { mobileNumberFilter(it) },
                    decorationBox = { innerTextField ->
                        Box(
                            contentAlignment = Alignment.CenterStart,
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .fillMaxWidth()
                        ) {
                            if (phoneNumber.isEmpty()) {
                                Text(
                                    "000 000-00-00",
                                    style = MeetTheme.typography.bodyText1,
                                    color = MeetTheme.colors.neutralWeak
                                )
                            }
                            innerTextField()
                        }
                    },
                    modifier = Modifier
                        .padding(start = 8.dp)
                )

            }

        }

    }

}
