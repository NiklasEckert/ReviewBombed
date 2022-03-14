package de.niklaseckert.reviewbombed.feature_review.data.respository

import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_game.domain.model.Game
import de.niklaseckert.reviewbombed.feature_review.data.local.dao.ReviewDao
import de.niklaseckert.reviewbombed.feature_review.data.remote.ReviewApi
import de.niklaseckert.reviewbombed.feature_review.data.remote.dto.ReviewDto
import de.niklaseckert.reviewbombed.feature_review.data.remote.dto.ReviewPostDto
import de.niklaseckert.reviewbombed.feature_review.domain.model.Review
import de.niklaseckert.reviewbombed.feature_review.domain.repository.ReviewRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import retrofit2.HttpException
import java.io.IOException

class ReviewRepositoryImpl(
    private val api: ReviewApi,
    private val dao: ReviewDao
) : ReviewRepository {
    override fun getReviews(): Flow<Resource<List<Review>>> = flow {
        emit(Resource.Loading())

        val reviews = dao.getAllReviews().map { it.toReview() }
        emit(Resource.Loading(reviews))

        try {
            val remoteReviews = api.getReviews()
            dao.deleteReviews(remoteReviews.map { it.id })
            dao.insertReviews(remoteReviews.map { it.toReviewEntity() })
        } catch (e: HttpException) {
            emit(Resource.Error(
                message = "Oops, something went wrong!",
                data = reviews
            ))
        } catch (e: IOException) {
            emit(Resource.Error(
                message = "Couldn't reach server, check your internet connection.",
                data = reviews
            ))
        }

        val newReviews = dao.getAllReviews().map { it.toReview() }
        emit(Resource.Success(newReviews))
    }

    override fun getReview(reviewId: Long): Flow<Resource<Review>> = flow {
        emit(Resource.Loading())

        val review = dao.getReviewById(reviewId)?.toReview()
        emit(Resource.Loading(review))

        try {
            val remoteReview = api.getReview(reviewId)
            dao.deleteReviews(listOf(remoteReview).map { it.id })
            dao.insertReviews(listOf(remoteReview).map { it.toReviewEntity() })
        } catch (e: HttpException) {
            emit(Resource.Error(
                message = "Oops, something went wrong!",
                data = review
            ))
        } catch (e: IOException) {
            emit(Resource.Error(
                message = "Couldn't reach server, check your internet connection.",
                data = review
            ))
        }

        val newReview = dao.getReviewById(reviewId)?.toReview()
        emit(Resource.Success(newReview))
    }

    override fun postReview(review: ReviewPostDto, gameId: Long) {
        runBlocking {
            api.postReview(review = review, gameId = gameId)
        }
    }

    override fun deleteReview(reviewId: Long) {
        runBlocking {
            api.deleteReview(reviewId = reviewId)
            dao.deleteReviews(listOf(reviewId))
        }
    }
}