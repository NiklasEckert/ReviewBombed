package de.niklaseckert.reviewbombed.feature_review.presentation

import de.niklaseckert.reviewbombed.feature_review.domain.model.Review

data class ReviewsState(
    val reviewItems: List<Review> = emptyList(),
    val isLoading: Boolean = false
) {
}