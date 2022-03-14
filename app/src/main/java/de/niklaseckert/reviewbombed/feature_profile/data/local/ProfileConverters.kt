package de.niklaseckert.reviewbombed.feature_profile.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import de.niklaseckert.reviewbombed.core.data.util.JsonParser
import de.niklaseckert.reviewbombed.core.domain.model.ListExcerpt
import de.niklaseckert.reviewbombed.feature_review.domain.model.Review
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * Converter class for feature profile package.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@ProvidedTypeConverter
class ProfileConverters(

    /** The Json parser that is used to convert. */
    private val jsonParser: JsonParser
) {

    /**
     * Method to convert a list of List Excerpts to Json.
     *
     * @param listExcerpts contains a list of List Excerpts that should be converted.
     * @return the resulting Json.
     */
    @TypeConverter
    fun fromListExcerptsListToJson(listExcerpts: List<ListExcerpt>): String {
        return jsonParser.toJson(
            listExcerpts,
            object : TypeToken<ArrayList<ListExcerpt>>(){}.type
        ) ?: "[]"
    }

    /**
     * Method to convert a Json to a list of List Excerpts.
     *
     * @param json contains the Json that should be converted to a list of List Excerpts.
     * @return the resulting list of List Excerpts.
     */
    @TypeConverter
    fun fromJsonToListExcerptsList(json: String): List<ListExcerpt> {
        return jsonParser.fromJson<ArrayList<ListExcerpt>>(
            json,
            object : TypeToken<ArrayList<ListExcerpt>>(){}.type
        ) ?: emptyList()
    }

    /**
     * Method to convert a list of Reviews to Json.
     *
     * @param reviews contains a list of Reviews that should be converted.
     * @return the resulting Json.
     */
    @TypeConverter
    fun fromReviewsListToJson(reviews: List<Review>): String {
        return jsonParser.toJson(
            reviews,
            object : TypeToken<ArrayList<Review>>(){}.type
        ) ?: "[]"
    }

    /**
     * Method to convert a Json to a list of Reviews.
     *
     * @param json contains the Json that should be converted to a list of Reviews.
     * @return the resulting list of Reviews.
     */
    @TypeConverter
    fun fromJsonToReviewsList(json: String): List<Review> {
        return jsonParser.fromJson<ArrayList<Review>>(
            json,
            object : TypeToken<ArrayList<Review>>(){}.type
        ) ?: emptyList()
    }

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