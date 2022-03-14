package de.niklaseckert.reviewbombed.feature_review.domain.use_case

import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_review.domain.model.Review
import de.niklaseckert.reviewbombed.feature_review.domain.repository.ReviewRepository
import kotlinx.coroutines.flow.Flow

/**
 * Use Case to get all Reviews.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
class GetReviews(

    /** Repository which contains the Reviews. */
    private val repository: ReviewRepository
) {

    /**
     * Method to get all Reviews from the repository.
     *
     * @return a Flow Resource of a list which contains the Reviews.
     */
    operator fun invoke(): Flow<Resource<List<Review>>> {
        return repository.getReviews()
    }
}