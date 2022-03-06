package de.niklaseckert.reviewbombed.feature_home.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import de.niklaseckert.reviewbombed.core.data.remote.ReviewBombedApi
import de.niklaseckert.reviewbombed.feature_home.data.local.HomeDb
import de.niklaseckert.reviewbombed.feature_home.data.remote.HomeApi
import de.niklaseckert.reviewbombed.feature_home.data.repository.HomeRepositoryImpl
import de.niklaseckert.reviewbombed.feature_home.domain.repository.HomeRepository
import de.niklaseckert.reviewbombed.feature_home.domain.use_case.GetAllCurrentlyPlaying
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class HomeModule {

    @Provides
    @Singleton
    fun provideGetAllCurrentlyPlayingUseCase(repository: HomeRepository): GetAllCurrentlyPlaying {
        return GetAllCurrentlyPlaying(repository)
    }

    @Provides
    @Singleton
    fun provideHomeRepository(
        db: HomeDb,
        api: HomeApi
    ): HomeRepository {
        return HomeRepositoryImpl(api, db.homeDao)
    }

    @Provides
    @Singleton
    fun provideHomeDb(app: Application): HomeDb {
        return Room.databaseBuilder(
            app,
            HomeDb::class.java,
            "HomeDb"
        ).build()
    }

    @Provides
    @Singleton
    fun provideHomeApi(): HomeApi {
        return Retrofit.Builder()
            .baseUrl(ReviewBombedApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HomeApi::class.java)
    }
}