package de.niklaseckert.reviewbombed.feature_review.data.remote.dto

import de.niklaseckert.reviewbombed.core.domain.model.GameExcerpt
import de.niklaseckert.reviewbombed.feature_profile.domain.model.Profile
import de.niklaseckert.reviewbombed.feature_review.data.local.entity.ReviewEntity
import de.niklaseckert.reviewbombed.feature_review.domain.model.Review
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class ReviewDto(
    val id: Long,
    val title: String,
    val reviewDate: String,
    val rate: Int,
    val reviewText: String,
    val game: GameExcerpt,
    val user: Profile
) {
    fun toReviewEntity(): ReviewEntity {
        return ReviewEntity(
            id = id,
            title = title,
            reviewDate = LocalDate.parse(reviewDate, DateTimeFormatter.ofPattern("yyyy-MM-dd")),
            rate = rate,
            reviewText = reviewText,
            gameExcerpt = game,
            user = user
        )
    }

    fun toReview(): Review {
        return Review(
            id = id,
            title = title,
            reviewDate = LocalDate.parse(reviewDate, DateTimeFormatter.ofPattern("yyyy-MM-dd")),
            rate = rate,
            reviewText = reviewText,
            gameExcerpt = game,
            user = user
        )
    }
}
