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

/**
 * Converter class for feature game package.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@ProvidedTypeConverter
class Converters(

    /** The Json parser that is used to convert. */
    private val jsonParser: JsonParser
) {

    /**
     * Method to convert a list of Developer Excerpts to Json.
     *
     * @param list contains a list of Developer Excerpts that should be converted.
     * @return the resulting Json.
     */
    @TypeConverter
    fun fromDevelopersListToJson(list: List<DeveloperExcerpt>): String {
        return jsonParser.toJson(
            list,
            object : TypeToken<ArrayList<DeveloperExcerpt>>(){}.type
        ) ?: "[]"
    }

    /**
     * Method to convert a Json to a list of Developer Excerpts.
     *
     * @param json contains the Json that should be converted to a list of Developer Excerpts.
     * @return the resulting list of Developer Excerpts.
     */
    @TypeConverter
    fun fromJsonToDevelopersList(json: String): List<DeveloperExcerpt> {
        return jsonParser.fromJson<ArrayList<DeveloperExcerpt>>(
            json,
            object : TypeToken<ArrayList<DeveloperExcerpt>>(){}.type
        ) ?: emptyList()
    }

    /**
     * Method to convert a list of Publisher Excerpts to Json.
     *
     * @param list contains a list of Publisher Excerpts that should be converted.
     * @return the resulting Json.
     */
    @TypeConverter
    fun fromPublishersListToJson(list: List<PublisherExcerpt>): String {
        return jsonParser.toJson(
            list,
            object : TypeToken<ArrayList<PublisherExcerpt>>(){}.type
        ) ?: "[]"
    }

    /**
     * Method to convert a Json to a list of Publisher Excerpts.
     *
     * @param json contains the Json that should be converted to a list of Publisher Excerpts.
     * @return the resulting list of Publisher Excerpts.
     */
    @TypeConverter
    fun fromJsonToPublishersList(json: String): List<PublisherExcerpt> {
        return jsonParser.fromJson<ArrayList<PublisherExcerpt>>(
            json,
            object : TypeToken<ArrayList<PublisherExcerpt>>(){}.type
        ) ?: emptyList()
    }

    /**
     * Method to convert a list of Screenshot Excerpts to Json.
     *
     * @param list contains a list of Screenshot Excerpts that should be converted.
     * @return the resulting Json.
     */
    @TypeConverter
    fun fromScreenshotsListToJson(list: List<ScreenshotExcerpt>): String {
        return jsonParser.toJson(
            list,
            object : TypeToken<ArrayList<ScreenshotExcerpt>>(){}.type
        ) ?: "[]"
    }

    /**
     * Method to convert a Json to a list of Screenshot Excerpts.
     *
     * @param json contains the Json that should be converted to a list of Screenshot Excerpts.
     * @return the resulting list of Screenshot Excerpts.
     */
    @TypeConverter
    fun fromJsonToScreenshotsList(json: String): List<ScreenshotExcerpt> {
        return jsonParser.fromJson<ArrayList<ScreenshotExcerpt>>(
            json,
            object : TypeToken<ArrayList<ScreenshotExcerpt>>(){}.type
        ) ?: emptyList()
    }
}