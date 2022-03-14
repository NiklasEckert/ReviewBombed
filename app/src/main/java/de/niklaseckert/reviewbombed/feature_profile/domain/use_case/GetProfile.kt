package de.niklaseckert.reviewbombed.feature_profile.domain.use_case

import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_profile.domain.model.Profile
import de.niklaseckert.reviewbombed.feature_profile.domain.repository.ProfileRepository
import kotlinx.coroutines.flow.Flow

/**
 * Use Case for one specific Profile.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
class GetProfile(

    /** Repository which contains the Profiles. */
    private val repository: ProfileRepository
) {

    /**
     * Method to get a specific Profile from the repository.
     *
     * @param profileId contains the id of a Profile.
     * @return a Flow Resource of the Profile.
     */
    operator fun invoke(profileId: Long): Flow<Resource<Profile>> {
        return repository.getProfile(profileId)
    }
}