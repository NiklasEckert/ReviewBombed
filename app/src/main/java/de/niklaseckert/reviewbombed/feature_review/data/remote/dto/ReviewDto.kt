package de.niklaseckert.reviewbombed.feature_review.data.remote.dto

import de.niklaseckert.reviewbombed.core.domain.model.GameExcerpt
import de.niklaseckert.reviewbombed.feature_profile.domain.model.Profile
import de.niklaseckert.reviewbombed.feature_review.data.local.entity.ReviewEntity
import de.niklaseckert.reviewbombed.feature_review.domain.model.Review
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * Data class which represents the data transfer object for a Review.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
data class ReviewDto(

    /** Represents the id of a Review. */
    val id: Long,

    /** Represents the title of a Review. */
    val title: String,

    /** Represents the date when the Review got created. */
    val reviewDate: String,

    /** Represents the rating of a Review. */
    val rate: Int,

    /** Represents the text of a Review. */
    val reviewText: String,

    /** Represents the Game which the Review refers to. */
    val game: GameExcerpt,

    /** Represents the User who created the Review. */
    val user: Profile
) {

    /**
     * Method that converts a Review Dto into a Review Entity.
     *
     * @return the resulting Review Entity.
     */
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

    /**
     * Method that converts a Review Dto into a Review.
     *
     * @return the resulting Review.
     */
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
