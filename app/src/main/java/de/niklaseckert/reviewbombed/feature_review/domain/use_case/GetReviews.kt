package de.niklaseckert.reviewbombed.feature_review.domain.use_case

import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_review.domain.model.Review
import de.niklaseckert.reviewbombed.feature_review.domain.repository.ReviewRepository
import kotlinx.coroutines.flow.Flow

class GetReviews(
    private val repository: ReviewRepository
) {

    operator fun invoke(): Flow<Resource<List<Review>>> {
        return repository.getReviews()
    }
}