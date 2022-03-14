package de.niklaseckert.reviewbombed.feature_review.domain.use_case

import de.niklaseckert.reviewbombed.feature_review.domain.repository.ReviewRepository

class FetchFromServer(
    private val repository: ReviewRepository
) {
    operator fun invoke() {
        repository.fetchFromServer()
    }
}