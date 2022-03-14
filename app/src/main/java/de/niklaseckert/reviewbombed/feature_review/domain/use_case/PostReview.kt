package de.niklaseckert.reviewbombed.feature_review.domain.use_case

import de.niklaseckert.reviewbombed.feature_review.data.remote.dto.ReviewPostDto
import de.niklaseckert.reviewbombed.feature_review.domain.repository.ReviewRepository

/**
 * Use Case post a Review.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
class PostReview(

    /** Repository which contains the Reviews. */
    private val repository: ReviewRepository
) {

    /**
     * Method to post a Review to the repository.
     *
     * @param review contains the Review that should be posted.
     * @param gameId contains the id of the Game which the Review refers to.
     */
    operator fun invoke(review: ReviewPostDto, gameId: Long) {
        repository.postReview(review = review, gameId = gameId)
    }
}