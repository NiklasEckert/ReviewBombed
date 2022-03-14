package de.niklaseckert.reviewbombed.feature_login.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import de.niklaseckert.reviewbombed.core.data.remote.ReviewBombedApi
import de.niklaseckert.reviewbombed.feature_login.data.local.SaveAccount
import de.niklaseckert.reviewbombed.feature_login.data.remote.LoginApi
import de.niklaseckert.reviewbombed.feature_login.data.service.LoginServiceImpl
import de.niklaseckert.reviewbombed.feature_login.domain.service.LoginService
import de.niklaseckert.reviewbombed.feature_login.domain.use_case.AutomaticSignIn
import de.niklaseckert.reviewbombed.feature_login.domain.use_case.SignIn
import de.niklaseckert.reviewbombed.feature_login.domain.use_case.SignOut
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


/**
 * Module that provides all Singleton that are needed for the Login.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Module
@InstallIn(SingletonComponent::class)
class AccountModule {

    /**
     * Method that provides the Sign In Use Case.
     *
     * @param service contains the Login Service.
     * @return the Sign In Use Case.
     */
    @Provides
    @Singleton
    fun provideSignInUseCase(service: LoginService): SignIn {
        return SignIn(service)
    }

    /**
     * Method that provides the Automatic Sign In Use Case.
     *
     * @param service contains the Login Service.
     * @return the Automatic Sign In Use Case.
     */
    @Provides
    @Singleton
    fun provideAutomaticSignInUseCase(service: LoginService): AutomaticSignIn {
        return AutomaticSignIn(service)
    }

    /**
     * Method that provides the Sign Out Use Case.
     *
     * @param service contains the Login Service.
     * @return the Sign Out Use Case.
     */
    @Provides
    @Singleton
    fun provideSignOutUseCase(service: LoginService): SignOut {
        return SignOut(service)
    }

    /**
     * Method that provides Save Account class.
     *
     * @param app contains the Application.
     * @return the Save Account class.
     */
    @Provides
    @Singleton
    fun provideSaveAccount(app: Application): SaveAccount {
        return SaveAccount(app.applicationContext)
    }

    /**
     * Method that provides the Login Service.
     *
     * @param api contains the Login API.
     * @param saveAccount contains the Save Account class.
     * @return the Login Service.
     */
    @Provides
    @Singleton
    fun provideAccountService(api: LoginApi, saveAccount: SaveAccount): LoginService {
        return LoginServiceImpl(api, saveAccount)
    }

    /**
     * Method that provides the Login API.
     *
     * @return the Login API.
     */
    @Provides
    @Singleton
    fun provideAccountApi(): LoginApi {
        return Retrofit.Builder()
            .baseUrl(ReviewBombedApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LoginApi::class.java)
    }
}