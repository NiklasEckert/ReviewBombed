package de.niklaseckert.reviewbombed.feature_list.di

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import de.niklaseckert.reviewbombed.core.data.remote.ReviewBombedApi
import de.niklaseckert.reviewbombed.core.data.util.GsonParser
import de.niklaseckert.reviewbombed.feature_list.data.local.FeatureListConverter
import de.niklaseckert.reviewbombed.feature_list.data.local.ListDb
import de.niklaseckert.reviewbombed.feature_list.data.remote.ListApi
import de.niklaseckert.reviewbombed.feature_list.data.repository.ListRepositoryImpl
import de.niklaseckert.reviewbombed.feature_list.domain.repository.ListRepository
import de.niklaseckert.reviewbombed.feature_list.domain.use_case.GetList
import de.niklaseckert.reviewbombed.feature_list.domain.use_case.GetListExcerpts
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ListModule {

    @Provides
    @Singleton
    fun provideGetListUseCase(repository: ListRepository): GetList {
        return GetList(repository)
    }

    @Provides
    @Singleton
    fun provideGetListsUseCase(repository: ListRepository): GetListExcerpts {
        return GetListExcerpts(repository)
    }

    @Provides
    @Singleton
    fun provideListRepository(
        db: ListDb,
        api: ListApi
    ): ListRepository {
        return ListRepositoryImpl(api, db.listDao)
    }

    @Provides
    @Singleton
    fun provideListDb(app: Application): ListDb {
        return Room.databaseBuilder(
            app,
            ListDb::class.java,
            "ListDb"
        ).addTypeConverter(FeatureListConverter(GsonParser(Gson()))).build()
    }

    @Provides
    @Singleton
    fun provideListApi(): ListApi {
        return Retrofit.Builder()
            .baseUrl(ReviewBombedApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ListApi::class.java)
    }
}