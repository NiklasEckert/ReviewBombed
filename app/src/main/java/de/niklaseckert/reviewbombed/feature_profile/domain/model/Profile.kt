package de.niklaseckert.reviewbombed.feature_profile.domain.model

import de.niklaseckert.reviewbombed.core.domain.model.ListExcerpt
import de.niklaseckert.reviewbombed.feature_review.domain.model.Review

/**
 * Class which represents a Profile.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
class Profile(

    /** Represents the id of a Profile. */
    val id: Long,

    /** Represents the name of a Profile. */
    val name: String,

    /** Represents the email of a Profile. */
    val email: String,

    /** Represents the url for the profile image of the Profile. */
    val profileImageUrl: String,

    /** Represents the Lists that the Profile created. */
    val listExcerpts: List<ListExcerpt>,

    /** Represents the Reviews that the Profile created. */
    val reviews: List<Review>
) {
}