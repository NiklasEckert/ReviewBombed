package de.niklaseckert.reviewbombed.feature_profile.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import de.niklaseckert.reviewbombed.core.data.util.JsonParser
import de.niklaseckert.reviewbombed.core.domain.model.ListExcerpt
import de.niklaseckert.reviewbombed.feature_review.domain.model.Review
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@ProvidedTypeConverter
class ProfileConverters(
    private val jsonParser: JsonParser
) {

    @TypeConverter
    fun fromListExcerptsListToJson(listExcerpts: List<ListExcerpt>): String {
        return jsonParser.toJson(
            listExcerpts,
            object : TypeToken<ArrayList<ListExcerpt>>(){}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromJsonToListExcerptsList(json: String): List<ListExcerpt> {
        return jsonParser.fromJson<ArrayList<ListExcerpt>>(
            json,
            object : TypeToken<ArrayList<ListExcerpt>>(){}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun fromReviewsListToJson(reviews: List<Review>): String {
        return jsonParser.toJson(
            reviews,
            object : TypeToken<ArrayList<Review>>(){}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromJsonToReviewsList(json: String): List<Review> {
        return jsonParser.fromJson<ArrayList<Review>>(
            json,
            object : TypeToken<ArrayList<Review>>(){}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun fromLocalDateToString(date: LocalDate): String = date.format(DateTimeFormatter.BASIC_ISO_DATE)

    @TypeConverter
    fun fromStringToLocalDate(s: String): LocalDate = LocalDate.parse(s, DateTimeFormatter.BASIC_ISO_DATE)
}