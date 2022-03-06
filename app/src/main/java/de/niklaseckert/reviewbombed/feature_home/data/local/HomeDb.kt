package de.niklaseckert.reviewbombed.feature_home.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import de.niklaseckert.reviewbombed.core.data.local.entity.GameExcerptEntity
import de.niklaseckert.reviewbombed.feature_home.data.local.dao.HomeDao

@Database(
    entities = [GameExcerptEntity::class],
    version = 1
)
abstract class HomeDb : RoomDatabase() {

    abstract val homeDao: HomeDao
}