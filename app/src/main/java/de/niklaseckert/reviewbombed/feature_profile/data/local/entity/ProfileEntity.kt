package de.niklaseckert.reviewbombed.feature_profile.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import de.niklaseckert.reviewbombed.core.domain.model.ListExcerpt
import de.niklaseckert.reviewbombed.feature_profile.domain.model.Profile
import de.niklaseckert.reviewbombed.feature_review.domain.model.Review

/**
 * Data class which represents a Profile Entity.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Entity
data class ProfileEntity(

    /** Represents the id of a Profile. */
    @PrimaryKey val id: Long,

    /** Represents the name of a Profile. */
    val name: String,

    /** Represents the email of a Profile. */
    val email: String,

    /** Represents the url which leads to the Profile image. */
    val profileImageUrl: String,

    /** Represents the lists that a Profile created. */
    val listExcerpts: List<ListExcerpt>,

    /** Represents the reviews that a Profile created. */
    val reviews: List<Review>
) {

    /**
     * Method that converts a Profile Entity into a Profile.
     *
     * @return the resulting Profile.
     */
    fun toProfile(): Profile {
        return Profile(
            id = id,
            name = name,
            email = email,
            profileImageUrl = profileImageUrl,
            listExcerpts = listExcerpts,
            reviews = reviews
        )
    }
}
