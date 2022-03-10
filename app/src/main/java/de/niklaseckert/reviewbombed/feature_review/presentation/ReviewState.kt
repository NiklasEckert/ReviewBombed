package de.niklaseckert.reviewbombed.feature_review.presentation

import de.niklaseckert.reviewbombed.feature_review.domain.model.Review

data class ReviewState(
    val reviewItem: Review? = null,
    val isLoading: Boolean = false
)
