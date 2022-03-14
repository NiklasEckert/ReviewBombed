package de.niklaseckert.reviewbombed.feature_profile.domain.use_case

import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_profile.domain.model.Profile
import de.niklaseckert.reviewbombed.feature_profile.domain.repository.ProfileRepository
import kotlinx.coroutines.flow.Flow

/**
 * Use Case for the own Profile.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
class GetOwnProfile(

    /** Repository which contains the Profiles. */
    private val repository: ProfileRepository
) {

    /**
     * Method to get the own Profile from the repository.
     *
     * @return a Flow Resource of the Profile.
     */
    operator fun invoke(): Flow<Resource<Profile>> {
        return repository.getOwnProfile()
    }
}