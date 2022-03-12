package de.niklaseckert.reviewbombed.feature_login.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import de.niklaseckert.reviewbombed.core.data.remote.ReviewBombedApi
import de.niklaseckert.reviewbombed.feature_login.data.remote.LoginApi
import de.niklaseckert.reviewbombed.feature_login.data.service.LoginServiceImpl
import de.niklaseckert.reviewbombed.feature_login.domain.service.LoginService
import de.niklaseckert.reviewbombed.feature_login.domain.use_case.PostLogin
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AccountModule {

    @Provides
    @Singleton
    fun providePostLoginUseCase(service: LoginService): PostLogin {
        return PostLogin(service)
    }

    @Provides
    @Singleton
    fun provideAccountService(api: LoginApi): LoginService {
        return LoginServiceImpl(api)
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