package de.niklaseckert.reviewbombed.feature_home.domain.use_case

import de.niklaseckert.reviewbombed.core.domain.model.GameExcerpt
import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow

class GetCurrentlyPlaying(
    private val repository: HomeRepository
) {

    operator fun invoke(): Flow<Resource<List<GameExcerpt>>> {
        return repository.getCurrentlyPlaying()
    }
}