package de.niklaseckert.reviewbombed.feature_review.domain.use_case

import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_review.domain.model.Review
import de.niklaseckert.reviewbombed.feature_review.domain.repository.ReviewRepository
import kotlinx.coroutines.flow.Flow

class GetReview(
    private val repository: ReviewRepository
) {
    operator fun invoke(reviewId: Long): Flow<Resource<Review>> {
        return repository.getReview(reviewId = reviewId)
    }
}