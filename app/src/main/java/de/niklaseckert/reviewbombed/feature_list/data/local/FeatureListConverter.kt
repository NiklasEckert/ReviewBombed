package de.niklaseckert.reviewbombed.feature_list.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import de.niklaseckert.reviewbombed.core.data.util.JsonParser
import de.niklaseckert.reviewbombed.core.domain.model.GameExcerpt

@ProvidedTypeConverter
class FeatureListConverter(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun fromGameExcerptListToJson(gameExcerpts: List<GameExcerpt>): String {
        return jsonParser.toJson(
            gameExcerpts,
            object : TypeToken<ArrayList<GameExcerpt>>(){}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromJsonToGameExcerptList(json: String): List<GameExcerpt> {
        return jsonParser.fromJson<ArrayList<GameExcerpt>>(
            json,
            object : TypeToken<ArrayList<GameExcerpt>>(){}.type
        ) ?: emptyList()
    }
}