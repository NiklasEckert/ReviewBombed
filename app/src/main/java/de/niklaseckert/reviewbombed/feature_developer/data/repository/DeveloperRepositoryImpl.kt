package de.niklaseckert.reviewbombed.feature_developer.data.repository

import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_developer.data.local.dao.DeveloperDao
import de.niklaseckert.reviewbombed.feature_developer.data.remote.DeveloperApi
import de.niklaseckert.reviewbombed.feature_developer.domain.model.Developer
import de.niklaseckert.reviewbombed.feature_developer.domain.repository.DeveloperRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class DeveloperRepositoryImpl(
    private val api: DeveloperApi,
    private val dao: DeveloperDao
) : DeveloperRepository {

    override fun getDeveloper(id: Long): Flow<Resource<Developer>> = flow {
        emit(Resource.Loading())

        val developer = dao.getDeveloperById(id)?.toDeveloper()
        emit(Resource.Loading(data = developer))

        try {
            val remoteDeveloper = api.getDeveloper(id)
            dao.deleteDevelopers(listOf(remoteDeveloper).map { it.id })
            dao.insertDevelopers(listOf(remoteDeveloper).map { it.toDeveloperEntity() })
        } catch (e: HttpException) {
            emit(Resource.Error(
                message = "Oops, something went wrong!",
                data = developer
            ))
        } catch (e: IOException) {
            emit(Resource.Error(
                message = "Couldn't reach server, check your internet connection.",
                data = developer
            ))
        }

        val newDeveloper = dao.getDeveloperById(id).toDeveloper()
        emit(Resource.Success(newDeveloper))
    }

    override fun getDevelopers(): Flow<Resource<List<Developer>>> = flow {
        emit(Resource.Loading())

        val developers = dao.getAllDevelopers().map { it.toDeveloper() }
        emit(Resource.Loading(data = developers))

        try {
            val remoteDevelopers = api.getDevelopers()
            dao.deleteDevelopers(remoteDevelopers.map { it.id })
            dao.insertDevelopers(remoteDevelopers.map { it.toDeveloperEntity() })
        } catch (e: HttpException) {
            emit(Resource.Error(
                message = "Oops, something went wrong!",
                data = developers
            ))
        } catch (e: IOException) {
            emit(Resource.Error(
                message = "Couldn't reach server, check your internet connection.",
                data = developers
            ))
        }

        val newDevelopers = dao.getAllDevelopers().map { it.toDeveloper() }
        emit(Resource.Success(newDevelopers))
    }
}