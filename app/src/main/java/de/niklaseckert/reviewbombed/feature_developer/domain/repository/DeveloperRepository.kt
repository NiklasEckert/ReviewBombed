package de.niklaseckert.reviewbombed.feature_developer.domain.repository

import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_developer.domain.model.Developer
import kotlinx.coroutines.flow.Flow


interface DeveloperRepository {

    fun getDeveloper(id: Long): Flow<Resource<Developer>>
    fun getDevelopers(): Flow<Resource<List<Developer>>>
}