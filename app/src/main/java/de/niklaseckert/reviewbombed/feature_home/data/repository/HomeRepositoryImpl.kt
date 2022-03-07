package de.niklaseckert.reviewbombed.feature_home.data.repository

import de.niklaseckert.reviewbombed.core.domain.model.GameExcerpt
import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_home.data.local.dao.HomeDao
import de.niklaseckert.reviewbombed.feature_home.data.remote.HomeApi
import de.niklaseckert.reviewbombed.feature_home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class HomeRepositoryImpl(
    private val api: HomeApi,
    private val dao: HomeDao
) : HomeRepository {

    override fun getCurrentlyPlaying(): Flow<Resource<List<GameExcerpt>>> = flow {
        emit(Resource.Loading())

        val currentlyPlaying = dao
            .getGameExcerptListWithScope(GameExcerptScope.CURRENTLY_PLAYING)
            .map { it.toGameExcerpt() }
        emit(Resource.Loading(data = currentlyPlaying))

        try {
            val remoteCurrentlyPlaying = api.getCurrentlyPlaying()
            dao.deleteGameExcerptWithScope(GameExcerptScope.CURRENTLY_PLAYING)
            dao.insertGameExcerptList(remoteCurrentlyPlaying
                .map { it.toGameExcerptEntity(GameExcerptScope.CURRENTLY_PLAYING) })
        } catch (e: HttpException) {
            emit(Resource.Error(
                message = "Oops, something went wrong!",
                data = currentlyPlaying
            ))
        } catch (e: IOException) {
            emit(Resource.Error(
                message = "Couldn't reach server, check your internet connection.",
                data = currentlyPlaying
            ))
        }

        val newCurrentlyPlaying = dao
            .getGameExcerptListWithScope(GameExcerptScope.CURRENTLY_PLAYING)
            .map { it.toGameExcerpt() }
        emit(Resource.Success(newCurrentlyPlaying))
    }
}