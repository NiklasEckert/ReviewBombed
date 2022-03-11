package de.niklaseckert.reviewbombed.feature_profile.domain.repository

import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_profile.domain.model.Profile
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {

    fun getProfile(profileId: Long): Flow<Resource<Profile>>
    fun getProfiles(profileIds: List<Long>): Flow<Resource<List<Profile>>>
}