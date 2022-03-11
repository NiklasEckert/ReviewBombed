package de.niklaseckert.reviewbombed.feature_profile.data.remote.dto

import de.niklaseckert.reviewbombed.core.data.remote.dto.ListExcerptDto
import de.niklaseckert.reviewbombed.feature_profile.data.local.entity.ProfileEntity
import de.niklaseckert.reviewbombed.feature_review.data.remote.dto.ReviewDto

data class ProfileDto(
    val id: Long,
    val name: String,
    val email: String,
    val profileImageUrl: String,
    val lists: List<ListExcerptDto>,
    val reviews: List<ReviewDto>
) {

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
