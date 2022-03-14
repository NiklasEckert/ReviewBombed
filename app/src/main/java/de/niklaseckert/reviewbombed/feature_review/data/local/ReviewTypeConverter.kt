package de.niklaseckert.reviewbombed.feature_review.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import de.niklaseckert.reviewbombed.core.data.util.JsonParser
import de.niklaseckert.reviewbombed.core.domain.model.GameExcerpt
import de.niklaseckert.reviewbombed.feature_profile.domain.model.Profile

/**
 * Converter class for feature review package.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@ProvidedTypeConverter
class ReviewTypeConverter(

    /** The Json parser that is used to convert. */
    private val jsonParser: JsonParser
) {

    /**
     * Method to convert a Game Excerpt to Json.
     *
     * @param gameExcerpt contains a Game Excerpt that should be converted.
     * @return the resulting Json.
     */
    @TypeConverter
    fun fromGameExcerptToJson(gameExcerpt: GameExcerpt): String? {
        return jsonParser.toJson(
            gameExcerpt,
            object : TypeToken<GameExcerpt>(){}.type
        )
    }

    /**
     * Method to convert a Json to a Game Excerpt.
     *
     * @param json contains the Json that should be converted to a Game Excerpt.
     * @return the resulting Game Excerpt.
     */
    @TypeConverter
    fun fromJsonToGameExcerpt(json: String): GameExcerpt? {
        return jsonParser.fromJson<GameExcerpt>(
            json,
            object : TypeToken<GameExcerpt>(){}.type
        )
    }

    /**
     * Method to convert a Profile to Json.
     *
     * @param profile contains a Profile that should be converted.
     * @return the resulting Json.
     */
    @TypeConverter
    fun fromProfileToJson(profile: Profile): String? {
        return jsonParser.toJson(
            profile,
            object : TypeToken<Profile>(){}.type
        )
    }

    /**
     * Method to convert a Json to a Profile.
     *
     * @param json contains the Json that should be converted to a Profile.
     * @return the resulting Profile.
     */
    @TypeConverter
    fun fromJsonToProfile(json: String): Profile? {
        return jsonParser.fromJson<Profile>(
            json,
            object : TypeToken<Profile>(){}.type
        )
    }
}