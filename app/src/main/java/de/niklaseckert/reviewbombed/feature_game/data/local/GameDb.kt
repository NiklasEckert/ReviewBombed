package de.niklaseckert.reviewbombed.feature_game.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import de.niklaseckert.reviewbombed.core.data.local.entity.DeveloperExcerptEntity
import de.niklaseckert.reviewbombed.core.data.local.entity.PublisherExcerptEntity
import de.niklaseckert.reviewbombed.feature_game.data.local.dao.GameDao
import de.niklaseckert.reviewbombed.feature_game.data.local.entity.GameEntity

@Database(
    entities = [GameEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class GameDb : RoomDatabase() {

    abstract val dao: GameDao
}