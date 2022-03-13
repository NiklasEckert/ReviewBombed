package de.niklaseckert.reviewbombed.feature_review.data.remote.dto

import de.niklaseckert.reviewbombed.core.domain.model.GameExcerpt
import de.niklaseckert.reviewbombed.feature_profile.domain.model.Profile
import de.niklaseckert.reviewbombed.feature_review.data.local.entity.ReviewEntity
import de.niklaseckert.reviewbombed.feature_review.domain.model.Review
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class ReviewPostDto(
    val id: Long,
    val title: String,
    val reviewDate: String,
    val rate: Int,
    val reviewText: String
) {
}
