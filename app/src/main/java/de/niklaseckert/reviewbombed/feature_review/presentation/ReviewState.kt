package de.niklaseckert.reviewbombed.feature_review.presentation

import de.niklaseckert.reviewbombed.feature_review.domain.model.Review

/**
 * Data class that represents the Review State.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
data class ReviewState(

    /** Contains a Review which the Review State refers to. */
    val reviewItem: Review? = null,

    /** Expresses if the Game State is loading or not. */
    val isLoading: Boolean = false
)
