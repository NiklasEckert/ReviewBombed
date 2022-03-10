package de.niklaseckert.reviewbombed.feature_review.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import de.niklaseckert.reviewbombed.core.domain.model.GameExcerpt
import de.niklaseckert.reviewbombed.feature_review.domain.model.Review
import java.time.LocalDate

@Entity
data class ReviewEntity(
    @PrimaryKey val id: Long,
    val title: String,
    val reviewDate: LocalDate,
    val rate: Int,
    val reviewText: String,
    val gameExcerpt: GameExcerpt
) {

    fun toReview(): Review {
        return Review(
            id = id,
            title = title,
            reviewDate = reviewDate,
            rate = rate,
            reviewText = reviewText,
            gameExcerpt = gameExcerpt
        )
    }
}