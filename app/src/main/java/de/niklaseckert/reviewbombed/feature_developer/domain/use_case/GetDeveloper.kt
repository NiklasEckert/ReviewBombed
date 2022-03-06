package de.niklaseckert.reviewbombed.feature_developer.domain.use_case

import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_developer.domain.model.Developer
import de.niklaseckert.reviewbombed.feature_developer.domain.repository.DeveloperRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetDeveloper(
    private val repository: DeveloperRepository
) {
    operator fun invoke(id: Long): Flow<Resource<Developer>> {
        if (id.equals(-1)) {
            return flow {  }
        }
        return repository.getDeveloper(id)
    }
}