package de.niklaseckert.reviewbombed.feature_profile.di

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
import de.niklaseckert.reviewbombed.feature_profile.data.local.ProfileConverters
import de.niklaseckert.reviewbombed.feature_profile.data.local.ProfileDb
import de.niklaseckert.reviewbombed.feature_profile.data.remote.ProfileApi
import de.niklaseckert.reviewbombed.feature_profile.data.repository.ProfileRepositoryImpl
import de.niklaseckert.reviewbombed.feature_profile.domain.repository.ProfileRepository
import de.niklaseckert.reviewbombed.feature_profile.domain.use_case.GetProfile
import de.niklaseckert.reviewbombed.feature_profile.domain.use_case.GetProfiles
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ProfileModule {

    @Provides
    @Singleton
    fun provideGetProfile(repository: ProfileRepository): GetProfile {
        return GetProfile(repository)
    }

    @Provides
    @Singleton
    fun provideGetProfiles(repository: ProfileRepository): GetProfiles {
        return GetProfiles(repository)
    }

    @Provides
    @Singleton
    fun provideProfileRepository(db: ProfileDb, api: ProfileApi): ProfileRepository {
        return ProfileRepositoryImpl(api, db.dao)
    }

    @Provides
    @Singleton
    fun provideProfileDb(app: Application): ProfileDb {
        return Room.databaseBuilder(
            app,
            ProfileDb::class.java,
            "ProfileDb"
        )
            .addTypeConverter(ProfileConverters(GsonParser(Gson())))
            .build()
    }

    @Provides
    @Singleton
    fun provideProfileApi(): ProfileApi {
        return Retrofit.Builder()
            .baseUrl(ReviewBombedApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProfileApi::class.java)
    }
}