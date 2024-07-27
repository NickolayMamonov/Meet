package dev.whysoezzy.ui.utils

fun getPeopleQuantityText(quantity: Int): String {
    val lastDigit = quantity % 10
    val lastTwoDigits = quantity % 100
    return when {
        (lastDigit in 2..4) && lastTwoDigits !in 12..14 -> {
            "$quantity человека"
        }
        else -> {
            "$quantity человек"
        }
    }
}