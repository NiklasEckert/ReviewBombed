package de.niklaseckert.reviewbombed.feature_developer.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import de.niklaseckert.reviewbombed.core.data.remote.ReviewBombedApi
import de.niklaseckert.reviewbombed.feature_developer.data.local.DeveloperDb
import de.niklaseckert.reviewbombed.feature_developer.data.remote.DeveloperApi
import de.niklaseckert.reviewbombed.feature_developer.data.repository.DeveloperRepositoryImpl
import de.niklaseckert.reviewbombed.feature_developer.domain.repository.DeveloperRepository
import de.niklaseckert.reviewbombed.feature_developer.domain.use_case.GetDeveloper
import de.niklaseckert.reviewbombed.feature_developer.domain.use_case.GetDevelopers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DeveloperModule {

    @Provides
    @Singleton
    fun provideGetDeveloperUseCase(repository: DeveloperRepository): GetDeveloper {
        return GetDeveloper(repository)
    }

    @Provides
    @Singleton
    fun provideGetDevelopersUseCase(repository: DeveloperRepository): GetDevelopers {
        return GetDevelopers(repository)
    }

    @Provides
    @Singleton
    fun provideDeveloperRepository(
        db: DeveloperDb,
        api: DeveloperApi
    ): DeveloperRepository {
        return DeveloperRepositoryImpl(api, db.developerDao)
    }

    @Provides
    @Singleton
    fun provideReviewBombedDb(app: Application): DeveloperDb {
        return Room.databaseBuilder(
            app,
            DeveloperDb::class.java,
            "ReviewBombedDb"
        )/*.addTypeConverter(GsonParser(Gson()))*/
            .build()
    }

    @Provides
    @Singleton
    fun provideReviewBombedApi(): DeveloperApi {
        return Retrofit.Builder()
            .baseUrl(ReviewBombedApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DeveloperApi::class.java)
    }
}