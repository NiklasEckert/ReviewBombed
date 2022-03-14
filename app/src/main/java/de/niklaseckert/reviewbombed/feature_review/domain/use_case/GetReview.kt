package de.niklaseckert.reviewbombed.feature_review.domain.use_case

import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_review.domain.model.Review
import de.niklaseckert.reviewbombed.feature_review.domain.repository.ReviewRepository
import kotlinx.coroutines.flow.Flow

/**
 * Use Case to get a specific Review.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
class GetReview(

    /** Repository which contains the Reviews. */
    private val repository: ReviewRepository
) {

    /**
     * Method to get a specific Review from the repository.
     *
     * @param reviewId contains the id of a Review.
     * @return a Flow Resource of the Review.
     */
    operator fun invoke(reviewId: Long): Flow<Resource<Review>> {
        return repository.getReview(reviewId = reviewId)
    }
}