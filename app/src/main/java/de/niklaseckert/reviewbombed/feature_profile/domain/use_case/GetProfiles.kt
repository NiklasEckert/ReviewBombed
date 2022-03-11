package de.niklaseckert.reviewbombed.feature_profile.domain.use_case

import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_profile.domain.model.Profile
import de.niklaseckert.reviewbombed.feature_profile.domain.repository.ProfileRepository
import kotlinx.coroutines.flow.Flow

class GetProfiles(
    private val repository: ProfileRepository
) {

    operator fun invoke(profileIds: List<Long>): Flow<Resource<List<Profile>>> {
        return repository.getProfiles(profileIds)
    }
}