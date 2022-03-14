package de.niklaseckert.reviewbombed.feature_review.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import de.niklaseckert.reviewbombed.feature_review.data.local.entity.ReviewEntity

@Dao
interface ReviewDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReviews(list: List<ReviewEntity>)

    @Query("DELETE FROM reviewentity WHERE id IN (:ids)")
    suspend fun deleteReviews(ids: List<Long>)

    @Query("SELECT * FROM reviewentity ORDER BY reviewDate DESC")
    suspend fun getAllReviews(): List<ReviewEntity>

    @Query("SELECT * FROM reviewentity WHERE id = :id LIMIT 1")
    suspend fun getReviewById(id: Long): ReviewEntity?
}