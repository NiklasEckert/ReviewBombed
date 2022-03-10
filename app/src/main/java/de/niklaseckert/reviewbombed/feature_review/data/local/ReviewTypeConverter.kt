package de.niklaseckert.reviewbombed.feature_review.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import de.niklaseckert.reviewbombed.core.data.util.JsonParser
import de.niklaseckert.reviewbombed.core.domain.model.GameExcerpt

@ProvidedTypeConverter
class ReviewTypeConverter(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun fromGameExcerptToJson(gameExcerpt: GameExcerpt): String? {
        return jsonParser.toJson(
            gameExcerpt,
            object : TypeToken<GameExcerpt>(){}.type
        )
    }

    @TypeConverter
    fun fromJsonToGameExcerpt(json: String): GameExcerpt? {
        return jsonParser.fromJson<GameExcerpt>(
            json,
            object : TypeToken<GameExcerpt>(){}.type
        )
    }
}