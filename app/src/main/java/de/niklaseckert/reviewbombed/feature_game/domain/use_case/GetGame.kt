package de.niklaseckert.reviewbombed.feature_game.domain.use_case

import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_game.domain.model.Game
import de.niklaseckert.reviewbombed.feature_game.domain.repository.GameRepository
import kotlinx.coroutines.flow.Flow

class GetGame(
    private val repository: GameRepository
) {
    operator fun invoke(id: Long): Flow<Resource<Game>> {
        return repository.getGame(id)
    }
}