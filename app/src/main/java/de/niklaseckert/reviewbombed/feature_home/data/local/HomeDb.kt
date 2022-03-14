package de.niklaseckert.reviewbombed.feature_home.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import de.niklaseckert.reviewbombed.core.data.local.Converters
import de.niklaseckert.reviewbombed.core.data.local.entity.GameExcerptEntity
import de.niklaseckert.reviewbombed.feature_home.data.local.dao.HomeDao

/**
 * Class which represents the database for the home screen.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Database(
    entities = [GameExcerptEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class HomeDb : RoomDatabase() {

    /** Data Access Object to access the home items. */
    abstract val homeDao: HomeDao
}