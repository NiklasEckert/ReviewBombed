package de.niklaseckert.reviewbombed.feature_review.domain.repository

import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_review.data.remote.dto.ReviewPostDto
import de.niklaseckert.reviewbombed.feature_review.domain.model.Review
import kotlinx.coroutines.flow.Flow

/**
 * Interface which the Review Repository implements.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
interface ReviewRepository {

    /**
     * Method to get all Reviews.
     *
     * @return a Flow Resource of a list which contains all Reviews.
     */
    fun getReviews(): Flow<Resource<List<Review>>>

    /**
     * Method to get a specific Review.
     *
     * @param reviewId contains the id of a Review.
     * @return a Flow Resource of the corresponding Review.
     */
    fun getReview(reviewId: Long): Flow<Resource<Review>>

    /**
     * Method to post a Review.
     *
     * @param review contains the Review that should be posted.
     * @param gameId contains the id of the Game which the Review refers to.
     */
    fun postReview(review: ReviewPostDto, gameId: Long)

    fun deleteReview(reviewId: Long)
}