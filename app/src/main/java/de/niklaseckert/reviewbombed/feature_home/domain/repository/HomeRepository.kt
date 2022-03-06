package de.niklaseckert.reviewbombed.feature_home.domain.repository

import de.niklaseckert.reviewbombed.core.domain.model.GameExcerpt
import de.niklaseckert.reviewbombed.core.util.Resource
import kotlinx.coroutines.flow.Flow

interface HomeRepository {

    fun getCurrentlyPlaying(): Flow<Resource<List<GameExcerpt>>>
}