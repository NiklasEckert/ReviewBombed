package de.niklaseckert.reviewbombed.feature_review.di

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import de.niklaseckert.reviewbombed.core.data.LocalDateConverter
import de.niklaseckert.reviewbombed.core.data.remote.ReviewBombedApi
import de.niklaseckert.reviewbombed.core.data.util.GsonParser
import de.niklaseckert.reviewbombed.core.util.BasicAuthInterceptor
import de.niklaseckert.reviewbombed.feature_login.data.local.SaveAccount
import de.niklaseckert.reviewbombed.feature_review.data.local.ReviewDb
import de.niklaseckert.reviewbombed.feature_review.data.local.ReviewTypeConverter
import de.niklaseckert.reviewbombed.feature_review.data.remote.ReviewApi
import de.niklaseckert.reviewbombed.feature_review.data.respository.ReviewRepositoryImpl
import de.niklaseckert.reviewbombed.feature_review.domain.repository.ReviewRepository
import de.niklaseckert.reviewbombed.feature_review.domain.use_case.DeleteReview
import de.niklaseckert.reviewbombed.feature_review.domain.use_case.GetReview
import de.niklaseckert.reviewbombed.feature_review.domain.use_case.GetReviews
import de.niklaseckert.reviewbombed.feature_review.domain.use_case.PostReview
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Module that provides all Singletons that are needed for the Reviews.
 */
@Module
@InstallIn(SingletonComponent::class)
class ReviewModule {

    /**
     * Method that provides the Get Review Use Case.
     *
     * @param repository contains the Review Repository.
     * @return the Get Review Use Case.
     */
    @Provides
    @Singleton
    fun provideGetReview(repository: ReviewRepository): GetReview {
        return GetReview(repository)
    }

    /**
     * Method that provides the Get Reviews Use Case.
     *
     * @param repository contains the Review Repository.
     * @return the Get Reviews Use Case.
     */
    @Provides
    @Singleton
    fun provideGetReviews(repository: ReviewRepository): GetReviews {
        return GetReviews(repository)
    }

    /**
     * Method that provides the Post Review Use Case.
     *
     * @param repository contains the Review Repository.
     * @return the Post Review Use Case.
     */
    @Provides
    @Singleton
    fun providePostReview(repository: ReviewRepository): PostReview {
        return PostReview(repository)
    }

    /**
     * Method that provides the Review Repository.
     *
     * @param db contains the Review Database.
     * @param api contains the Review API.
     * @return the Review Repository.
     */
    @Provides
    @Singleton
    fun provideDeleteReview(repository: ReviewRepository): DeleteReview {
        return DeleteReview(repository)
    }

    @Provides
    @Singleton
    fun provideReviewRepository(db: ReviewDb, api: ReviewApi): ReviewRepository {
        return ReviewRepositoryImpl(api, db.dao)
    }

    /**
     * Method that provides the Review Database.
     *
     * @param app contains the Application.
     * @return the Review Database.
     */
    @Provides
    @Singleton
    fun provideReviewDb(app: Application): ReviewDb {
        return Room.databaseBuilder(
            app,
            ReviewDb::class.java,
            "ReviewDb"
        )
            .addTypeConverter(ReviewTypeConverter(GsonParser(Gson())))
            .addTypeConverter(LocalDateConverter())
            .build()
    }

    /**
     * Method that provides the Review API.
     *
     * @param saveAccount contains the Save Account class.
     * @return the Review API.
     */
    @Provides
    @Singleton
    fun provideReviewApi(saveAccount: SaveAccount): ReviewApi {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(BasicAuthInterceptor(saveAccount))
            .build()

        return Retrofit.Builder()
            .baseUrl(ReviewBombedApi.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ReviewApi::class.java)
    }
}