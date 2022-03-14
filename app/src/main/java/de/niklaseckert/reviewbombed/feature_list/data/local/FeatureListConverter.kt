package de.niklaseckert.reviewbombed.feature_list.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import de.niklaseckert.reviewbombed.core.data.util.JsonParser
import de.niklaseckert.reviewbombed.core.domain.model.GameExcerpt

/**
 * Converter class for the feature list package.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@ProvidedTypeConverter
class FeatureListConverter(

    /** The Json parser that is used to convert. */
    private val jsonParser: JsonParser
) {

    /**
     * Method to convert a list of Game Excerpts to Json.
     *
     * @param gameExcerpts contains a list of Game Excerpts that should be converted.
     * @return the resulting Json.
     */
    @TypeConverter
    fun fromGameExcerptListToJson(gameExcerpts: List<GameExcerpt>): String {
        return jsonParser.toJson(
            gameExcerpts,
            object : TypeToken<ArrayList<GameExcerpt>>(){}.type
        ) ?: "[]"
    }

    /**
     * Method to convert a Json to a list of Game Excerpts.
     *
     * @param json contains the Json that should be converted into a list of Game Excerpts.
     * @return the resulting list of Game Excerpts.
     */
    @TypeConverter
    fun fromJsonToGameExcerptList(json: String): List<GameExcerpt> {
        return jsonParser.fromJson<ArrayList<GameExcerpt>>(
            json,
            object : TypeToken<ArrayList<GameExcerpt>>(){}.type
        ) ?: emptyList()
    }
}