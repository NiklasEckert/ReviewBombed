package de.niklaseckert.reviewbombed.feature_game.data.repository

import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_game.data.local.dao.GameDao
import de.niklaseckert.reviewbombed.feature_game.data.remote.GameApi
import de.niklaseckert.reviewbombed.feature_game.domain.model.Game
import de.niklaseckert.reviewbombed.feature_game.domain.repository.GameRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

/**
 * Repository which contains elements of Games.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
class GameRepositoryImpl(

    /** API for the Games. */
    private val api: GameApi,

    /** Data Access Object for the Games. */
    private val dao: GameDao
) : GameRepository {

    /**
     * Method to get a specific Game.
     *
     * @param id contains the id of a Game.
     * @return a Flow Resource of the Game.
     */
    override fun getGame(id: Long): Flow<Resource<Game>> = flow {
        emit(Resource.Loading())

        val game = dao.getGameById(id)?.toGame()
        emit(Resource.Loading(data = game))

        try {
            val remoteGame = api.getGame(id)
            dao.deleteGames(listOf(remoteGame.id))
            dao.insertGames(listOf(remoteGame.toGameEntity()))
        } catch (e: HttpException) {
            emit(Resource.Error(
                message = "Oops, something went wrong!",
                data = game
            ))
        } catch (e: IOException) {
            emit(Resource.Error(
                message = "Couldn't reach server, check your internet connection.",
                data = game
            ))
        }

        val newGame = dao.getGameById(id)?.toGame()
        emit(Resource.Success(data = newGame))
    }
}