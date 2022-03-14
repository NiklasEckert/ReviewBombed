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
import de.niklaseckert.reviewbombed.feature_home.domain.use_case.GetCurrentlyPlaying
import de.niklaseckert.reviewbombed.feature_home.domain.use_case.GetFriendsFinished
import de.niklaseckert.reviewbombed.feature_home.domain.use_case.GetFriendsPlaying
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Module that provides all Singletons that are needed for the Home screen.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Module
@InstallIn(SingletonComponent::class)
class HomeModule {

    /**
     * Method that provides the Get Currently Playing Use Case.
     *
     * @param repository contains the Home Repository.
     * @return the Currently Playing Use Case.
     */
    @Provides
    @Singleton
    fun provideGetCurrentlyPlayingUseCase(repository: HomeRepository): GetCurrentlyPlaying {
        return GetCurrentlyPlaying(repository)
    }

    /**
     * Method that provides the Get Friends Playing Use Case.
     *
     * @param repository contains the Home Repository.
     * @return the Get Friends Playing Use Case.
     */
    @Provides
    @Singleton
    fun provideGetFriendsPlayingUseCase(repository: HomeRepository): GetFriendsPlaying {
        return GetFriendsPlaying(repository)
    }

    /**
     * Method that provides the Get Friends Finished Use Case.
     *
     * @param repository contains the Home Repository.
     * @return the Get Friends Finished Use Case.
     */
    @Provides
    @Singleton
    fun provideGetFriendsFinishedUseCase(repository: HomeRepository): GetFriendsFinished {
        return GetFriendsFinished(repository)
    }

    /**
     * Method that provides the Home Repository.
     *
     * @param db contains the Home Database.
     * @param api contains the Home API.
     * @return the Home Repository.
     */
    @Provides
    @Singleton
    fun provideHomeRepository(
        db: HomeDb,
        api: HomeApi
    ): HomeRepository {
        return HomeRepositoryImpl(api, db.homeDao)
    }

    /**
     * Method that provides the Home Database.
     *
     * @param app contains the Application.
     * @return the Home Database.
     */
    @Provides
    @Singleton
    fun provideHomeDb(app: Application): HomeDb {
        return Room.databaseBuilder(
            app,
            HomeDb::class.java,
            "HomeDb"
        ).build()
    }

    /**
     * Method that provides the Home API.
     *
     * @return the Home API.
     */
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