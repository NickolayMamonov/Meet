package dev.whysoezzy.data.utils

import androidx.room.TypeConverter
import java.time.LocalDateTime
import java.util.Date

class Converters {
    @TypeConverter
    fun fromTimestamp(value: String?): Date? {
        return value?.let { DateTimeUtils.parseDate(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): String? {
        return date?.let { DateTimeUtils.formatDate(it) }
    }
}
