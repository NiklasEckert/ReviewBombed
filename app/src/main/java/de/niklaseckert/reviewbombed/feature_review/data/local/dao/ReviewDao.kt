package de.niklaseckert.reviewbombed.feature_review.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import de.niklaseckert.reviewbombed.feature_review.data.local.entity.ReviewEntity

/**
 * Interface which represents the Data Access Object for Games.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Dao
interface ReviewDao {

    /**
     * Method to insert a list of Review.
     *
     * @param list contains a list of Reviews which should be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReviews(list: List<ReviewEntity>)

    /**
     * Method to delete a list of Reviews.
     *
     * @param ids contains a list of ids of Reviews which should be deleted.
     */
    @Query("DELETE FROM reviewentity WHERE id IN (:ids)")
    suspend fun deleteReviews(ids: List<Long>)

    /**
     * Method to select all Reviews.
     *
     * @return a list of all Reviews.
     */
    @Query("SELECT * FROM reviewentity")
    suspend fun getAllReviews(): List<ReviewEntity>

    /**
     * Method to select a specific Review.
     *
     * @param id contains the id of a Review.
     * @return the corresponding Review.
     */
    @Query("SELECT * FROM reviewentity WHERE id = :id LIMIT 1")
    suspend fun getReviewById(id: Long): ReviewEntity?
}