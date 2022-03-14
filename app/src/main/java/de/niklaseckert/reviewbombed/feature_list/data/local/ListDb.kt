package de.niklaseckert.reviewbombed.feature_list.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import de.niklaseckert.reviewbombed.core.data.local.entity.ListExcerptEntity
import de.niklaseckert.reviewbombed.feature_list.data.local.dao.ListDao
import de.niklaseckert.reviewbombed.feature_list.data.local.entity.ListEntity

/**
 * Class which represents the database for Lists.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Database(
    entities = [ListEntity::class, ListExcerptEntity::class],
    version = 1
)
@TypeConverters(FeatureListConverter::class)
abstract class ListDb : RoomDatabase() {

    /** Data Access Object to access the Lists. */
    abstract val listDao: ListDao
}