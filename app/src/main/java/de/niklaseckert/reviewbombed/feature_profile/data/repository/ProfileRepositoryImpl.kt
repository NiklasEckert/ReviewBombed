package de.niklaseckert.reviewbombed.feature_profile.data.repository

import android.util.Log
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

class ProfileRepositoryImpl(
    private val api: ProfileApi,
    private val dao: ProfileDao,
    private val saveAccount: SaveAccount
) : ProfileRepository {

    override fun getOwnProfile(): Flow<Resource<Profile>> = flow {
        emit(Resource.Loading())


        val profileId: Long
        runBlocking {
            profileId = saveAccount.getAccountId()
        }


        val profile = dao.getProfileById(profileId)?.toProfile()
        emit(Resource.Loading(profile))

        try {
//            val remoteProfileResponse = api.getOwnProfile(profileId)
//            val remoteProfile = remoteProfileResponse.body()
//            if (remoteProfileResponse.isSuccessful) {
//                remoteProfile?.let {
//                    dao.deleteProfiles(listOf(remoteProfile).map { it.id })
//                    dao.insertProfile(listOf(remoteProfile).map { it.toProfileEntity() })
//                }
//            }
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

    override fun getProfiles(profileIds: List<Long>): Flow<Resource<List<Profile>>> = flow {
        /*emit(Resource.Loading())

        val profiles = dao.getProfilesById(profileIds).map { it.toProfile() }
        emit(Resource.Loading(profiles))

        try {
            val remoteProfiles = api.ge
        } catch (e: HttpException) {
            emit(Resource.Error(
                message = "Oops, something went wrong!",
                data = profiles
            ))
        } catch (e: IOException) {
            emit(Resource.Error(
                message = "Couldn't reach server, check your internet connection.",
                data = profiles
            ))
        }*/
    }
}