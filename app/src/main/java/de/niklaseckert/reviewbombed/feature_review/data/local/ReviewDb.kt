package de.niklaseckert.reviewbombed.feature_review.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import de.niklaseckert.reviewbombed.core.data.LocalDateConverter
import de.niklaseckert.reviewbombed.feature_review.data.local.dao.ReviewDao
import de.niklaseckert.reviewbombed.feature_review.data.local.entity.ReviewEntity

/**
 * Class which represents the database for Reviews.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Database(
    entities = [ReviewEntity::class],
    version = 1
)
@TypeConverters(ReviewTypeConverter::class, LocalDateConverter::class)
abstract class ReviewDb : RoomDatabase() {

    /** Data Access Object to access the Reviews. */
    abstract val dao: ReviewDao
}