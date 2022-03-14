package de.niklaseckert.reviewbombed.feature_review.presentation

import de.niklaseckert.reviewbombed.feature_review.domain.model.Review

/**
 * Data class that represents the Reviews State.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
data class ReviewsState(

    /** Contains a list of Reviews which the Reviews State refers to. */
    val reviewItems: List<Review> = emptyList(),

    /** Expresses if the Reviews State is loading or not. */
    val isLoading: Boolean = false
) {
}