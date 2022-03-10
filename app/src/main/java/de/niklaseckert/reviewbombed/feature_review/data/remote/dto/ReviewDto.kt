package de.niklaseckert.reviewbombed.feature_review.data.remote.dto

import de.niklaseckert.reviewbombed.core.domain.model.GameExcerpt
import de.niklaseckert.reviewbombed.feature_review.data.local.entity.ReviewEntity

data class ReviewDto(
    val id: Long,
    val title: String,
    val rate: Int,
    val reviewText: String,
    val game: GameExcerpt
) {
    fun toReviewEntity(): ReviewEntity {
        return ReviewEntity(
            id = id,
            title = title,
            rate = rate,
            reviewText = reviewText,
            gameExcerpt = game
        )
    }
}
