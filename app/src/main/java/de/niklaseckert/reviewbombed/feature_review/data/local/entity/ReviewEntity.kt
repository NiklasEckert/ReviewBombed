package de.niklaseckert.reviewbombed.feature_review.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import de.niklaseckert.reviewbombed.core.domain.model.GameExcerpt
import de.niklaseckert.reviewbombed.feature_profile.domain.model.Profile
import de.niklaseckert.reviewbombed.feature_review.domain.model.Review
import java.time.LocalDate

/**
 * Data class which represents a Review Entity.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Entity
data class ReviewEntity(

    /** Represents the id of a Review. */
    @PrimaryKey val id: Long,

    /** Represents the title of a Review. */
    val title: String,

    /** Represents the date when the Review got created. */
    val reviewDate: LocalDate,

    /** Represents the rating of the Review. */
    val rate: Int,

    /** Represents the text of the Review. */
    val reviewText: String,

    /** Represents the Game which the Review refers to. */
    val gameExcerpt: GameExcerpt,

    /** Represents who User who created the Review. */
    val user: Profile
) {

    /**
     * Method that converts a Review Entity into a Review.
     *
     * @return the resulting Review.
     */
    fun toReview(): Review {
        return Review(
            id = id,
            title = title,
            reviewDate = reviewDate,
            rate = rate,
            reviewText = reviewText,
            gameExcerpt = gameExcerpt,
            user = user
        )
    }
}