package de.niklaseckert.reviewbombed.feature_profile.domain.repository

import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_profile.domain.model.Profile
import kotlinx.coroutines.flow.Flow

/**
 * Interface which the Profile Repository implements.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
interface ProfileRepository {

    /**
     * Method to get the logged in Profile.
     *
     * @return a Flow Resource of the Profile.
     */
    fun getOwnProfile(): Flow<Resource<Profile>>

    /**
     * Method to get a specific Profile by id.
     *
     * @param profileId contains the id of a Profile.
     * @return a Flow Resource of the corresponding Profile.
     */
    fun getProfile(profileId: Long): Flow<Resource<Profile>>

    /**
     * Method to get multiple Profiles by id.
     *
     * @param profileIds contains a list of ids of Profiles.
     * @return a Flow Resource of list which contains Profiles.
     */
    fun getProfiles(profileIds: List<Long>): Flow<Resource<List<Profile>>>
}