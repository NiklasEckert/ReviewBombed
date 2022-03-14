package de.niklaseckert.reviewbombed.feature_profile.data.repository

import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_login.data.local.SaveAccount
import de.niklaseckert.reviewbombed.feature_profile.data.local.dao.ProfileDao
import de.niklaseckert.reviewbombed.feature_profile.data.remote.ProfileApi
import de.niklaseckert.reviewbombed.feature_profile.domain.model.Profile
import de.niklaseckert.reviewbombed.feature_profile.domain.repository.ProfileRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import retrofit2.HttpException
import java.io.IOException

/**
 * Repository which contains elements of Profiles.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
class ProfileRepositoryImpl(

    /** API for the Profiles. */
    private val api: ProfileApi,

    /** Data Access Object for the Profiles. */
    private val dao: ProfileDao,

    /** To get currently logged in account. */
    private val saveAccount: SaveAccount
) : ProfileRepository {

    /**
     * Method to get the logged in Profile.
     *
     * @return a Flow Resource of the Profile.
     */
    override fun getOwnProfile(): Flow<Resource<Profile>> = flow {
        emit(Resource.Loading())

        val profileId: Long
        runBlocking {
            profileId = saveAccount.getAccountId()
        }

        val profile = dao.getProfileById(profileId)?.toProfile()
        emit(Resource.Loading(profile))

        try {
            val remoteProfile = api.getProfile(profileId)
            dao.deleteProfiles(listOf(remoteProfile).map { it.id })
            dao.insertProfile(listOf(remoteProfile).map { it.toProfileEntity() })
        } catch (e: HttpException) {
            emit(Resource.Error(
                message = "Oops, something went wrong!",
                data = profile
            ))
        } catch (e: IOException) {
            emit(Resource.Error(
                message = "Couldn't reach server, check your internet connection.",
                data = profile
            ))
        }

        val newProfile = dao.getProfileById(profileId)?.toProfile()
        emit(Resource.Success(newProfile))
    }

    /**
     * Method to get a specific Profile by id.
     *
     * @param profileId contains the id of a Profile.
     * @return a Flow Resource of the corresponding Profile.
     */
    override fun getProfile(profileId: Long): Flow<Resource<Profile>> = flow {
        emit(Resource.Loading())

        val profile = dao.getProfileById(profileId)?.toProfile()
        emit(Resource.Loading(profile))

        try {
            val remoteProfile = api.getProfile(profileId)
            dao.deleteProfiles(listOf(remoteProfile).map { it.id })
            dao.insertProfile(listOf(remoteProfile).map { it.toProfileEntity() })
        } catch (e: HttpException) {
            emit(Resource.Error(
                message = "Oops, something went wrong!",
                data = profile
            ))
        } catch (e: IOException) {
            emit(Resource.Error(
                message = "Couldn't reach server, check your internet connection.",
                data = profile
            ))
        }

        val newProfile = dao.getProfileById(profileId)?.toProfile()
        emit(Resource.Success(newProfile))
    }

    /**
     * Method to get multiple Profiles by id.
     *
     * @param profileIds contains a list of ids of Profiles.
     * @return a Flow Resource of list which contains Profiles.
     */
    override fun getProfiles(profileIds: List<Long>): Flow<Resource<List<Profile>>> = flow {

    }
}