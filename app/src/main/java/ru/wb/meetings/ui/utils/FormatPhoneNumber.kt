package ru.wb.meetings.ui.utils

fun formatPhoneNumber(phoneNumber: String): String {
    return when (phoneNumber.length) {
        NUMBER_LENGTH_WITHOUT_CODE_COUNTRY -> {
            "${phoneNumber.substring(0, 3)} ${phoneNumber.substring(3, 6)}-${
                phoneNumber.substring(
                    6,
                    8
                )
            }-${phoneNumber.substring(8)}"
        }
        else -> {
            phoneNumber
        }
    }
}

private const val NUMBER_LENGTH_WITHOUT_CODE_COUNTRY = 10