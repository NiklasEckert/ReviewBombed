package de.niklaseckert.reviewbombed.feature_review.domain.use_case

import de.niklaseckert.reviewbombed.feature_review.domain.repository.ReviewRepository

class DeleteReview(
    private val repository: ReviewRepository
) {
    operator fun invoke(reviewId: Long) {
        repository.deleteReview(reviewId = reviewId)
    }
}