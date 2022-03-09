package de.niklaseckert.reviewbombed.feature_game.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import de.niklaseckert.reviewbombed.core.data.util.JsonParser
import de.niklaseckert.reviewbombed.core.domain.model.DeveloperExcerpt
import de.niklaseckert.reviewbombed.core.domain.model.PublisherExcerpt
import de.niklaseckert.reviewbombed.core.domain.model.ScreenshotExcerpt
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {

    @TypeConverter
    fun fromLocalDateToString(date: LocalDate): String = date.format(DateTimeFormatter.BASIC_ISO_DATE)

    @TypeConverter
    fun fromStringToLocalDate(s: String): LocalDate = LocalDate.parse(s, DateTimeFormatter.BASIC_ISO_DATE)

    @TypeConverter
    fun fromDevelopersListToJson(list: List<DeveloperExcerpt>): String {
        return jsonParser.toJson(
            list,
            object : TypeToken<ArrayList<DeveloperExcerpt>>(){}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromJsonToDevelopersList(json: String): List<DeveloperExcerpt> {
        return jsonParser.fromJson<ArrayList<DeveloperExcerpt>>(
            json,
            object : TypeToken<ArrayList<DeveloperExcerpt>>(){}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun fromPublishersListToJson(list: List<PublisherExcerpt>): String {
        return jsonParser.toJson(
            list,
            object : TypeToken<ArrayList<PublisherExcerpt>>(){}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromJsonToPublishersList(json: String): List<PublisherExcerpt> {
        return jsonParser.fromJson<ArrayList<PublisherExcerpt>>(
            json,
            object : TypeToken<ArrayList<PublisherExcerpt>>(){}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun fromScreenshotsListToJson(list: List<ScreenshotExcerpt>): String {
        return jsonParser.toJson(
            list,
            object : TypeToken<ArrayList<ScreenshotExcerpt>>(){}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromJsonToScreenshotsList(json: String): List<ScreenshotExcerpt> {
        return jsonParser.fromJson<ArrayList<ScreenshotExcerpt>>(
            json,
            object : TypeToken<ArrayList<ScreenshotExcerpt>>(){}.type
        ) ?: emptyList()
    }
}