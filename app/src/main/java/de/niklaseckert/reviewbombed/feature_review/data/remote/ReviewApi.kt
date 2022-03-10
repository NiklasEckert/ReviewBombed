package de.niklaseckert.reviewbombed.feature_review.data.remote

import de.niklaseckert.reviewbombed.feature_review.data.remote.dto.ReviewDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ReviewApi {

    @GET("reviews")
    suspend fun getReviews(): List<ReviewDto>

    @GET("reviews/{id}")
    suspend fun getReview(@Path("id") id: Long): ReviewDto
}