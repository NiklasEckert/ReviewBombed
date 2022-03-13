package de.niklaseckert.reviewbombed.feature_game.di

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
import de.niklaseckert.reviewbombed.feature_game.data.local.Converters
import de.niklaseckert.reviewbombed.feature_game.data.local.GameDb
import de.niklaseckert.reviewbombed.feature_game.data.remote.GameApi
import de.niklaseckert.reviewbombed.feature_game.data.repository.GameRepositoryImpl
import de.niklaseckert.reviewbombed.feature_game.domain.repository.GameRepository
import de.niklaseckert.reviewbombed.feature_game.domain.use_case.GetGame
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Module that provides all Singletons that are needed for the Games.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Module
@InstallIn(SingletonComponent::class)
class GameModule {

    /**
     * Method that provide the Get Game Use Case.
     *
     * @param repository contains the Game Repository.
     * @return the Get Game Use Case.
     */
    @Provides
    @Singleton
    fun provideGetGameUseCase(repository: GameRepository): GetGame {
        return GetGame(repository)
    }

    /**
     * Method that provide the Game Repository.
     *
     * @param db contains the Game Database.
     * @param api contains the Game API.
     * @return the Game Repository.
     */
    @Provides
    @Singleton
    fun provideGameRepository(db: GameDb, api: GameApi): GameRepository {
        return GameRepositoryImpl(api, db.dao)
    }

    /**
     * Method that provides the Game Database.
     *
     * @param app contains the Application.
     * @return the Game Database.
     */
    @Provides
    @Singleton
    fun provideGameDb(app: Application): GameDb {
        return Room.databaseBuilder(
            app,
            GameDb::class.java,
            "GameDb"
        )
            .addTypeConverter(Converters(GsonParser(Gson())))
            .addTypeConverter(LocalDateConverter())
            .build()
    }

    /**
     * Method that provides the Game API.
     *
     * @return the Game API.
     */
    @Provides
    @Singleton
    fun provideGameApi(): GameApi {
        return Retrofit.Builder()
            .baseUrl(ReviewBombedApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GameApi::class.java)
    }
}