package com.guimor.tennisumpire.room_database.converter

import androidx.room.TypeConverter
import java.time.LocalDate

class LocalDateConverter {
    @TypeConverter
    fun toDatabase(date: LocalDate?): String? {
        return date?.toString()
    }

    @TypeConverter
    fun fromDatabase(dateString: String?): LocalDate? {
        return dateString?.let { LocalDate.parse(it) }
    }
}