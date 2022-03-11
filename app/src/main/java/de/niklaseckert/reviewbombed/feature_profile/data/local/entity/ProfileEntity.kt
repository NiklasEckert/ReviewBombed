package de.niklaseckert.reviewbombed.feature_profile.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import de.niklaseckert.reviewbombed.core.domain.model.ListExcerpt
import de.niklaseckert.reviewbombed.feature_profile.domain.model.Profile
import de.niklaseckert.reviewbombed.feature_review.domain.model.Review

@Entity
data class ProfileEntity(
    @PrimaryKey val id: Long,
    val name: String,
    val email: String,
    val profileImageUrl: String,
    val listExcerpts: List<ListExcerpt>,
    val reviews: List<Review>
) {

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
