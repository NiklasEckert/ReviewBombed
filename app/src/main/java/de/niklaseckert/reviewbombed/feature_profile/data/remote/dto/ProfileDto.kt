package de.niklaseckert.reviewbombed.feature_profile.data.remote.dto

import de.niklaseckert.reviewbombed.core.data.remote.dto.ListExcerptDto
import de.niklaseckert.reviewbombed.feature_profile.data.local.entity.ProfileEntity
import de.niklaseckert.reviewbombed.feature_review.data.remote.dto.ReviewDto

/**
 * Data class which represents the data transfer object for a Profile.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
data class ProfileDto(

    /** Represents the id of a Profile. */
    val id: Long,

    /** Represents the name of a Profile. */
    val name: String,

    /** Represents the email of a Profile. */
    val email: String,

    /** Represents the url for the profile image of the Profile. */
    val profileImageUrl: String,

    /** Represents the Lists that a Profile created. */
    val lists: List<ListExcerptDto>,

    /** Represents the Reviews that a Profile created. */
    val reviews: List<ReviewDto>
) {

    /**
     * Method that converts a Profile Dto into a Profile Entity.
     *
     * @return the resulting Profile Entity.
     */
    fun toProfileEntity(): ProfileEntity {
        return ProfileEntity(
            id = id,
            name = name,
            email = email,
            profileImageUrl = profileImageUrl,
            listExcerpts = lists.map { it.toListExcerpt() },
            reviews = reviews.map { it.toReview() }
        )
    }
}
