package de.niklaseckert.reviewbombed.feature_review.data.remote

import de.niklaseckert.reviewbombed.feature_review.data.remote.dto.ReviewDto
import de.niklaseckert.reviewbombed.feature_review.data.remote.dto.ReviewPostDto
import de.niklaseckert.reviewbombed.feature_review.domain.model.Review
import retrofit2.http.*

interface ReviewApi {

    @GET("reviews")
    suspend fun getReviews(): List<ReviewDto>

    @GET("reviews/{id}")
    suspend fun getReview(@Path("id") id: Long): ReviewDto

    @POST("reviews")
    suspend fun postReview(@Body review: ReviewPostDto, @Header("gameId") gameId: Long): ReviewDto

    @DELETE("reviews")
    suspend fun deleteReview(@Header("reviewId") reviewId: Long)
}