package de.niklaseckert.reviewbombed.feature_game.domain.repository

import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_game.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface GameRepository {

    fun getGame(id: Long): Flow<Resource<Game>>
}