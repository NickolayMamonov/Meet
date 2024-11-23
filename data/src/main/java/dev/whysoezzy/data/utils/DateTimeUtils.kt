package dev.whysoezzy.data.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateTimeUtils {
    private const val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss"
    private val dateFormat = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())

    fun parseDate(dateString: String): Date {
        return try {
            dateFormat.parse(dateString) ?: Date()
        } catch (e: ParseException) {
            Date()
        }
    }

    fun formatDate(date: Date): String {
        return dateFormat.format(date)
    }
}