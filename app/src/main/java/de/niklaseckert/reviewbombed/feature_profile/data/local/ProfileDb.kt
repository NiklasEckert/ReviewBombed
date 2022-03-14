package de.niklaseckert.reviewbombed.feature_profile.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import de.niklaseckert.reviewbombed.feature_profile.data.local.dao.ProfileDao
import de.niklaseckert.reviewbombed.feature_profile.data.local.entity.ProfileEntity

/**
 * Class which represents the database for Profiles.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Database(
    entities = [ProfileEntity::class],
    version = 1
)
@TypeConverters(ProfileConverters::class)
abstract class ProfileDb : RoomDatabase() {

    /** Data Access Object to access the Profiles. */
    abstract val dao: ProfileDao
}