package de.niklaseckert.reviewbombed.core.data

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * Converter class for core package.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@ProvidedTypeConverter
class LocalDateConverter() {

    /**
     * Converter that converts a Local Date to Json.
     *
     * @param date contains the Local Date that should be converted.
     * @return the resulting Json.
     */
    @TypeConverter
    fun fromLocalDateToString(date: LocalDate): String = date.format(DateTimeFormatter.BASIC_ISO_DATE)

    /**
     * Converter that converts a Json to a Local Date.
     *
     * @param s contains the Json that should be converted.
     * @return the resulting Local Date.
     */
    @TypeConverter
    fun fromStringToLocalDate(s: String): LocalDate = LocalDate.parse(s, DateTimeFormatter.BASIC_ISO_DATE)
}