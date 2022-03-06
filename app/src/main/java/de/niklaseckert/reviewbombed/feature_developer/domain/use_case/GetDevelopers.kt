package de.niklaseckert.reviewbombed.feature_developer.domain.use_case

import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_developer.domain.model.Developer
import de.niklaseckert.reviewbombed.feature_developer.domain.repository.DeveloperRepository
import kotlinx.coroutines.flow.Flow


class GetDevelopers(
    private val repository: DeveloperRepository
) {

    operator fun invoke(): Flow<Resource<List<Developer>>> {
        return repository.getDevelopers()
    }
}