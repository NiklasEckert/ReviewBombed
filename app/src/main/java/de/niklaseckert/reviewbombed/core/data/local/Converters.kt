package de.niklaseckert.reviewbombed.core.data.local

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import de.niklaseckert.reviewbombed.core.data.local.entity.GameExcerptScope

class Converters {

    @TypeConverter
    fun fromGameExcerptScopeToString(scope: GameExcerptScope): String = scope.name

    @TypeConverter
    fun fromStringToGameExcerptScope(scopeName: String): GameExcerptScope = enumValueOf(scopeName)
}