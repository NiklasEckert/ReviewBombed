package de.niklaseckert.reviewbombed.feature_home.data.repository

import de.niklaseckert.reviewbombed.core.data.local.entity.GameExcerptScope
import de.niklaseckert.reviewbombed.core.domain.model.GameExcerpt
import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_home.data.local.dao.HomeDao
import de.niklaseckert.reviewbombed.feature_home.data.remote.HomeApi
import de.niklaseckert.reviewbombed.feature_home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

/**
 * Repository which contains elements of the Home screen.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
class HomeRepositoryImpl(

    /** API for the Home screen. */
    private val api: HomeApi,

    /** Data Access Object for the Home screen. */
    private val dao: HomeDao
) : HomeRepository {

    /**
     * Method to get all games that are currently played.
     *
     * @return a Flow Resource of a list which contains the Game Excerpts that are currently played.
     */
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

    /**
     * Method to get all Games that friends are currently playing.
     *
     * @return a Flow Resource of a list which contains the Game Excerpts that friends are currently playing.
     */
    override fun getFriendsPlaying(): Flow<Resource<List<GameExcerpt>>> = flow {
        emit(Resource.Loading())

        val friendsPlaying = dao
            .getGameExcerptListWithScope(GameExcerptScope.FRIENDS_PLAYING)
            .map { it.toGameExcerpt() }
        emit(Resource.Loading(data = friendsPlaying))

        try {
            val remoteFriendsPlaying = api.getFriendsPlaying()
            dao.deleteGameExcerptWithScope(GameExcerptScope.FRIENDS_PLAYING)
            dao.insertGameExcerptList(remoteFriendsPlaying
                .map { it.toGameExcerptEntity(GameExcerptScope.FRIENDS_PLAYING) })
        } catch (e: HttpException) {
            emit(Resource.Error(
                message = "Oops, something went wrong!",
                data = friendsPlaying
            ))
        } catch (e: IOException) {
            emit(Resource.Error(
                message = "Couldn't reach server, check your internet connection.",
                data = friendsPlaying
            ))
        }

        val newFriendsPlaying = dao
            .getGameExcerptListWithScope(GameExcerptScope.FRIENDS_PLAYING)
            .map { it.toGameExcerpt() }
        emit(Resource.Success(newFriendsPlaying))
    }


    /**
     * Method to get all Games that friends recently finished.
     *
     * @return a Flow Resource of a list which contains the Game Excerpts that friends recently finished.
     */
    override fun getFriendsFinished(): Flow<Resource<List<GameExcerpt>>> = flow {
        emit(Resource.Loading())

        val friendsFinished = dao
            .getGameExcerptListWithScope(GameExcerptScope.FRIENDS_FINISHED)
            .map { it.toGameExcerpt() }
        emit(Resource.Loading(data = friendsFinished))

        try {
            val remoteFriendsFinished = api.getFriendsFinished()
            dao.deleteGameExcerptWithScope(GameExcerptScope.FRIENDS_FINISHED)
            dao.insertGameExcerptList(remoteFriendsFinished
                .map { it.toGameExcerptEntity(GameExcerptScope.FRIENDS_FINISHED) })
        } catch (e: HttpException) {
            emit(Resource.Error(
                message = "Oops, something went wrong!",
                data = friendsFinished
            ))
        } catch (e: IOException) {
            emit(Resource.Error(
                message = "Couldn't reach server, check your internet connection.",
                data = friendsFinished
            ))
        }

        val newFriendsFinished = dao
            .getGameExcerptListWithScope(GameExcerptScope.FRIENDS_FINISHED)
            .map { it.toGameExcerpt() }
        emit(Resource.Success(newFriendsFinished))
    }
}