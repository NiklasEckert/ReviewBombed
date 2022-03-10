package de.niklaseckert.reviewbombed.core.data

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@ProvidedTypeConverter
class LocalDateConverter() {
    @TypeConverter
    fun fromLocalDateToString(date: LocalDate): String = date.format(DateTimeFormatter.BASIC_ISO_DATE)

    @TypeConverter
    fun fromStringToLocalDate(s: String): LocalDate = LocalDate.parse(s, DateTimeFormatter.BASIC_ISO_DATE)
}