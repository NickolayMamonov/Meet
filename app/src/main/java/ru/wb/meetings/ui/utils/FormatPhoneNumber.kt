package ru.wb.meetings.ui.utils

fun formatPhoneNumber(phoneNumber: String): String {
    return when (phoneNumber.length) {
        NUMBER_LENGTH_WITHOUT_CODE_COUNTRY -> {
            "${phoneNumber.substring(0, 2)} ${phoneNumber.substring(2, 5)} ${phoneNumber.substring(5, 8)}-${phoneNumber.substring(8, 10)}-${phoneNumber.substring(10,12)}"
        }
        else -> {
            phoneNumber
        }
    }
}

private const val NUMBER_LENGTH_WITHOUT_CODE_COUNTRY = 12