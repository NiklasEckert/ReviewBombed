package de.niklaseckert.reviewbombed.feature_game.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import de.niklaseckert.reviewbombed.core.data.LocalDateConverter
import de.niklaseckert.reviewbombed.feature_game.data.local.dao.GameDao
import de.niklaseckert.reviewbombed.feature_game.data.local.entity.GameEntity

/**
 * Class which represents the database for Games.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Database(
    entities = [GameEntity::class],
    version = 1
)
@TypeConverters(Converters::class, LocalDateConverter::class)
abstract class GameDb : RoomDatabase() {

    /** Data Access Object to access the Games. */
    abstract val dao: GameDao
}