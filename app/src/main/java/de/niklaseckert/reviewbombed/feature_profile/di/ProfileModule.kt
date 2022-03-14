package de.niklaseckert.reviewbombed.feature_profile.di

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import de.niklaseckert.reviewbombed.core.data.remote.ReviewBombedApi
import de.niklaseckert.reviewbombed.core.data.util.GsonParser
import de.niklaseckert.reviewbombed.core.util.BasicAuthInterceptor
import de.niklaseckert.reviewbombed.feature_login.data.local.SaveAccount
import de.niklaseckert.reviewbombed.feature_profile.data.local.ProfileConverters
import de.niklaseckert.reviewbombed.feature_profile.data.local.ProfileDb
import de.niklaseckert.reviewbombed.feature_profile.data.remote.ProfileApi
import de.niklaseckert.reviewbombed.feature_profile.data.repository.ProfileRepositoryImpl
import de.niklaseckert.reviewbombed.feature_profile.domain.repository.ProfileRepository
import de.niklaseckert.reviewbombed.feature_profile.domain.use_case.GetOwnProfile
import de.niklaseckert.reviewbombed.feature_profile.domain.use_case.GetProfile
import de.niklaseckert.reviewbombed.feature_profile.domain.use_case.GetProfiles
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Module that provides all Singletons that are needed for Profiles.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Module
@InstallIn(SingletonComponent::class)
class ProfileModule {

    /**
     * Method that provides the Get Profile Use Case.
     *
     * @param repository contains the Profile Repository
     * @return the Get Profile Use Case.
     */
    @Provides
    @Singleton
    fun provideGetProfile(repository: ProfileRepository): GetProfile {
        return GetProfile(repository)
    }

    /**
     * Method that provides the Get Profiles Use Case.
     *
     * @param repository contains the Profile Repository.
     * @return the Get Profiles Use Case.
     */
    @Provides
    @Singleton
    fun provideGetProfiles(repository: ProfileRepository): GetProfiles {
        return GetProfiles(repository)
    }

    /**
     * Method that provides the Get Own Profile Use Case.
     *
     * @param repository contains the Profile Repository.
     * @return the Get Own Profile Use Case.
     */
    @Provides
    @Singleton
    fun provideGetOwnProfile(repository: ProfileRepository): GetOwnProfile {
        return GetOwnProfile(repository)
    }

    /**
     * Method that provides the Profile Repository.
     *
     * @param db contains the Profile Database.
     * @param api contains the Profile API.
     * @param saveAccount contains the Save Account class.
     * @return the Profile Repository.
     */
    @Provides
    @Singleton
    fun provideProfileRepository(db: ProfileDb, api: ProfileApi, saveAccount: SaveAccount): ProfileRepository {
        return ProfileRepositoryImpl(api, db.dao, saveAccount)
    }

    /**
     * Method that provides the Profile Database.
     *
     * @param app contains the Application.
     * @return the Profile Database.
     */
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

    /**
     * Method that provides the Profile API.
     *
     * @param saveAccount contains the Save Account class.
     * @return the Profile API.
     */
    @Provides
    @Singleton
    fun provideProfileApi(saveAccount: SaveAccount): ProfileApi {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(BasicAuthInterceptor(saveAccount))
            .build()

        return Retrofit.Builder()
            .baseUrl(ReviewBombedApi.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProfileApi::class.java)
    }
}