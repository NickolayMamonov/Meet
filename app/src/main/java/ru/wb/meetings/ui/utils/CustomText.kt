package ru.wb.meetings.ui.utils

fun getPeopleQuantityText(quantity: Int): String {
    val lastDigit = quantity % 10
    val lastTwoDigits = quantity % 100
    return if ((lastDigit in 2..4) && lastTwoDigits !in 12..14) {
        "$quantity человека"
    } else {
        "$quantity человек"
    }
}