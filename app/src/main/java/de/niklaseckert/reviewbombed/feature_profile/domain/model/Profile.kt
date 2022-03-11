package de.niklaseckert.reviewbombed.feature_profile.domain.model

import de.niklaseckert.reviewbombed.core.domain.model.ListExcerpt
import de.niklaseckert.reviewbombed.feature_review.domain.model.Review

class Profile(
    val id: Long,
    val name: String,
    val email: String,
    val profileImageUrl: String,
    val listExcerpts: List<ListExcerpt>,
    val reviews: List<Review>
) {
}