package de.niklaseckert.reviewbombed.feature_review.data.remote

import de.niklaseckert.reviewbombed.feature_review.data.remote.dto.ReviewDto
import de.niklaseckert.reviewbombed.feature_review.data.remote.dto.ReviewPostDto
import retrofit2.http.*

/**
 * Interface for the Review API.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
interface ReviewApi {

    /**
     * Get Mapping for all Reviews.
     *
     * @return a list that contains all Reviews.
     */
    @GET("reviews")
    suspend fun getReviews(): List<ReviewDto>

    /**
     * Get Mapping for a specific Review.
     *
     * @param id contains the id of a Review.
     * @return the corresponding Review.
     */
    @GET("reviews/{id}")
    suspend fun getReview(@Path("id") id: Long): ReviewDto

    /**
     * Post Mapping for a Review.
     *
     * @param review contains the Review that should be posted.
     * @param gameId contains the id of the Game which the Review refers to.
     * @return the posted Review.
     */
    @POST("reviews")
    suspend fun postReview(@Body review: ReviewPostDto, @Header("gameId") gameId: Long): ReviewDto

    @DELETE("reviews")
    suspend fun deleteReview(@Header("reviewId") reviewId: Long)
}