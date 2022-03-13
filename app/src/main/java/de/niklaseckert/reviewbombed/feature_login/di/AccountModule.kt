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

@Module
@InstallIn(SingletonComponent::class)
class AccountModule {
    @Provides
    @Singleton
    fun provideSignInUseCase(service: LoginService) : SignIn {
        return SignIn(service)
    }

    @Provides
    @Singleton
    fun provideAutomaticSignInUseCase(service: LoginService) : AutomaticSignIn {
        return AutomaticSignIn(service)
    }

    @Provides
    @Singleton
    fun provideSignOutUseCase(service: LoginService) : SignOut {
        return SignOut(service)
    }

    @Provides
    @Singleton
    fun provideSaveAccount(app: Application): SaveAccount {
        return SaveAccount(app.applicationContext)
    }

    @Provides
    @Singleton
    fun provideAccountService(api: LoginApi, saveAccount: SaveAccount): LoginService {
        return LoginServiceImpl(api, saveAccount)
    }

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