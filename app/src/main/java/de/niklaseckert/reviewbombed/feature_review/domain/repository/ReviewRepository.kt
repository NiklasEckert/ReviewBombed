package de.niklaseckert.reviewbombed.feature_review.domain.repository

import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_review.domain.model.Review
import kotlinx.coroutines.flow.Flow

interface ReviewRepository {

    fun getReviews(): Flow<Resource<List<Review>>>
    fun getReview(reviewId: Long): Flow<Resource<Review>>
}