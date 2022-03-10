package de.niklaseckert.reviewbombed.feature_review.di

import android.app.Application
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.room.Room
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import de.niklaseckert.reviewbombed.core.data.remote.ReviewBombedApi
import de.niklaseckert.reviewbombed.core.data.util.GsonParser
import de.niklaseckert.reviewbombed.feature_review.data.local.ReviewDb
import de.niklaseckert.reviewbombed.feature_review.data.local.ReviewTypeConverter
import de.niklaseckert.reviewbombed.feature_review.data.remote.ReviewApi
import de.niklaseckert.reviewbombed.feature_review.data.respository.ReviewRepositoryImpl
import de.niklaseckert.reviewbombed.feature_review.domain.repository.ReviewRepository
import de.niklaseckert.reviewbombed.feature_review.domain.use_case.GetReview
import de.niklaseckert.reviewbombed.feature_review.domain.use_case.GetReviews
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ReviewModule {

    @Provides
    @Singleton
    fun provideGetReview(repository: ReviewRepository): GetReview {
        return GetReview(repository)
    }

    @Provides
    @Singleton
    fun provideGetReviews(repository: ReviewRepository): GetReviews {
        return GetReviews(repository)
    }

    @Provides
    @Singleton
    fun provideReviewRepository(db: ReviewDb, api: ReviewApi): ReviewRepository {
        return ReviewRepositoryImpl(api, db.dao)
    }

    @Provides
    @Singleton
    fun provideReviewDb(app: Application): ReviewDb {
        return Room.databaseBuilder(
            app,
            ReviewDb::class.java,
            "ReviewDb"
        ).addTypeConverter(ReviewTypeConverter(GsonParser(Gson())))
            .build()
    }

    @Provides
    @Singleton
    fun provideReviewApi(): ReviewApi {
        return Retrofit.Builder()
            .baseUrl(ReviewBombedApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ReviewApi::class.java)
    }
}