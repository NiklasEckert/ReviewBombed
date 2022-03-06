package de.niklaseckert.reviewbombed.feature_developer.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import de.niklaseckert.reviewbombed.feature_developer.data.util.JsonParser
import de.niklaseckert.reviewbombed.feature_developer.domain.model.Developer

@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun fromDevelopersJson(json: String): List<Developer> {
        return jsonParser.fromJson<ArrayList<Developer>>(
            json,
            object : TypeToken<ArrayList<Developer>>(){}.type
        ) ?: emptyList()
    }

}