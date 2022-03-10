package de.niklaseckert.reviewbombed.feature_review.data.remote.dto

import de.niklaseckert.reviewbombed.core.domain.model.GameExcerpt
import de.niklaseckert.reviewbombed.feature_review.data.local.entity.ReviewEntity
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class ReviewDto(
    val id: Long,
    val title: String,
    val reviewDate: String,
    val rate: Int,
    val reviewText: String,
    val game: GameExcerpt
) {
    fun toReviewEntity(): ReviewEntity {
        return ReviewEntity(
            id = id,
            title = title,
            reviewDate = LocalDate.parse(reviewDate, DateTimeFormatter.ofPattern("yyyy-MM-dd")),
            rate = rate,
            reviewText = reviewText,
            gameExcerpt = game
        )
    }
}
