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

@Module
@InstallIn(SingletonComponent::class)
class GameModule {

    @Provides
    @Singleton
    fun provideGetGameUseCase(repository: GameRepository): GetGame {
        return GetGame(repository)
    }

    @Provides
    @Singleton
    fun provideGameRepository(db: GameDb, api: GameApi): GameRepository {
        return GameRepositoryImpl(api, db.dao)
    }

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