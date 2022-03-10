package de.niklaseckert.reviewbombed.feature_review.domain.model

import de.niklaseckert.reviewbombed.core.domain.model.GameExcerpt

class Review(
    val id: Long,
    val title: String,
    val rate: Int,
    val reviewText: String,
    val gameExcerpt: GameExcerpt
) {
}