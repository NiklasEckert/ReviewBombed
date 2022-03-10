package de.niklaseckert.reviewbombed.feature_review.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import de.niklaseckert.reviewbombed.feature_review.data.local.dao.ReviewDao
import de.niklaseckert.reviewbombed.feature_review.data.local.entity.ReviewEntity

@Database(
    entities = [ReviewEntity::class],
    version = 1
)
@TypeConverters(ReviewTypeConverter::class)
abstract class ReviewDb : RoomDatabase() {

    abstract val dao: ReviewDao
}