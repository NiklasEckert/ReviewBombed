package de.niklaseckert.reviewbombed.feature_review.domain.model

import de.niklaseckert.reviewbombed.core.domain.model.GameExcerpt
import de.niklaseckert.reviewbombed.feature_profile.domain.model.Profile
import java.time.LocalDate

/**
 * Class which represents a Review.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
class Review(

    /** Represents the id of a Review. */
    val id: Long,

    /** Represents the title of Review. */
    val title: String,

    /** Represents the date when Review got created. */
    val reviewDate: LocalDate,

    /** Represents the rating of the Review. */
    val rate: Int,

    /** Represents the text of the Review. */
    val reviewText: String,

    /** Represents the Game which the Review refers to. */
    val gameExcerpt: GameExcerpt,

    /** Represents the User which created the Review. */
    val user: Profile
) {
}