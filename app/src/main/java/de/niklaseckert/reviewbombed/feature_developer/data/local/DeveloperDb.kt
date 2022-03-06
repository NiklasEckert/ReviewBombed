package de.niklaseckert.reviewbombed.feature_developer.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import de.niklaseckert.reviewbombed.feature_developer.data.local.dao.DeveloperDao
import de.niklaseckert.reviewbombed.feature_developer.data.local.entity.DeveloperEntity

@Database(
    entities = [DeveloperEntity::class],
    version = 1
)
//@TypeConverters(Converters::class)
abstract class DeveloperDb : RoomDatabase() {

    abstract val developerDao : DeveloperDao
}