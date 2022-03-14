package de.niklaseckert.reviewbombed.feature_review.data.remote.dto

data class ReviewPostDto(
    val id: Long,
    val title: String,
    val reviewDate: String,
    val rate: Int,
    val reviewText: String
) {
}
