package de.niklaseckert.reviewbombed.feature_profile.domain.use_case

import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_profile.domain.model.Profile
import de.niklaseckert.reviewbombed.feature_profile.domain.repository.ProfileRepository
import kotlinx.coroutines.flow.Flow

/**
 * Use Case for all Profiles.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
*/
class GetProfiles(

    /** Repository which contains the Profiles. */
    private val repository: ProfileRepository
) {

    /**
     * Method to all Profile from the repository.
     *
     * @return a Flow Resource of a list which contains the Profiles.
     */
    operator fun invoke(profileIds: List<Long>): Flow<Resource<List<Profile>>> {
        return repository.getProfiles(profileIds)
    }
}