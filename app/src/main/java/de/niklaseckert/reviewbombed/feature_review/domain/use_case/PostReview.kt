package de.niklaseckert.reviewbombed.feature_review.domain.use_case

import de.niklaseckert.reviewbombed.feature_game.domain.model.Game
import de.niklaseckert.reviewbombed.feature_review.data.remote.dto.ReviewDto
import de.niklaseckert.reviewbombed.feature_review.data.remote.dto.ReviewPostDto
import de.niklaseckert.reviewbombed.feature_review.domain.model.Review
import de.niklaseckert.reviewbombed.feature_review.domain.repository.ReviewRepository

class PostReview(
    private val repository: ReviewRepository
) {

    operator fun invoke(review: ReviewPostDto, gameId: Long) {
        repository.postReview(review = review, gameId = gameId)
    }
}