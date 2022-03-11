package de.niklaseckert.reviewbombed.feature_profile.domain.use_case

import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_profile.domain.model.Profile
import de.niklaseckert.reviewbombed.feature_profile.domain.repository.ProfileRepository
import kotlinx.coroutines.flow.Flow

class GetProfile(
    private val repository: ProfileRepository
) {

    operator fun invoke(profileId: Long): Flow<Resource<Profile>> {
        return repository.getProfile(profileId)
    }
}