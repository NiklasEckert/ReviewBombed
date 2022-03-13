package de.niklaseckert.reviewbombed.core.data.local

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import de.niklaseckert.reviewbombed.core.data.local.entity.GameExcerptScope

/**
 * Converter class for core package.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
class Converters {

    /**
     * Converter that converts a Game Excerpt Scope to a Json.
     *
     * @param scope contains the Game Excerpt Scope that should be converted.
     * @return the resulting Json.
     */
    @TypeConverter
    fun fromGameExcerptScopeToString(scope: GameExcerptScope): String = scope.name

    /**
     * Converter that converts a Json to a Game Excerpt Scope.
     *
     * @param scopeName contains the Json that should be converted.
     * @return the resulting Game Excerpt Scope.
     */
    @TypeConverter
    fun fromStringToGameExcerptScope(scopeName: String): GameExcerptScope = enumValueOf(scopeName)
}