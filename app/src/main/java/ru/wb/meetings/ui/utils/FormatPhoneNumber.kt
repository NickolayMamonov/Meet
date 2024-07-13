package ru.wb.meetings.ui.utils

fun formatPhoneNumber(phoneNumber: String): String {
    return if (phoneNumber.length == 10) {
        "${phoneNumber.substring(0, 3)} ${phoneNumber.substring(3, 6)}-${
            phoneNumber.substring(
                6,
                8
            )
        }-${phoneNumber.substring(8)}"
    } else {
        phoneNumber
    }
}