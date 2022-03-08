package de.niklaseckert.reviewbombed.feature_list.data.repository

import de.niklaseckert.reviewbombed.core.domain.model.ListExcerpt
import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_list.data.local.dao.ListDao
import de.niklaseckert.reviewbombed.feature_list.data.remote.ListApi
import de.niklaseckert.reviewbombed.feature_list.domain.model.ListModel
import de.niklaseckert.reviewbombed.feature_list.domain.repository.ListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class ListRepositoryImpl(
    private val api: ListApi,
    private val dao: ListDao
) : ListRepository {

    override fun getListExcerpts(): Flow<Resource<List<ListExcerpt>>> = flow {
        emit(Resource.Loading())

        val lists = dao.getAllListExcerptsEntities().map { it.toListExcerpt() }
        emit(Resource.Loading(lists))

        try {
            val remoteListExcerpts = api.getLists()
            dao.deleteListExcerpts(remoteListExcerpts.map { it.id })
            dao.insertListExcerpts(remoteListExcerpts.map { it.toListExcerptEntity() })
        } catch (e: HttpException) {
            emit(Resource.Error(
                message = "Oops, something went wrong!",
                data = lists
            ))
        } catch (e: IOException) {
            emit(Resource.Error(
                message = "Couldn't reach server, check your internet connection.",
                data = lists
            ))
        }

        val newLists = dao.getAllListExcerptsEntities().map { it.toListExcerpt() }
        emit(Resource.Success(newLists))
    }

    override fun getList(id: Long): Flow<Resource<ListModel>> = flow {
        emit(Resource.Loading())

        val list = dao.getListById(id)?.toListModel()
        emit(Resource.Loading(list))

        try {
            val remoteList = api.getList(id)
            dao.deleteListsByIds(listOf(remoteList).map { it.id })
            dao.insertLists(listOf(remoteList).map { it.toListEntity()})
        } catch (e: HttpException) {
            emit(Resource.Error(
                message = "Oops, something went wrong!",
                data = list
            ))
        } catch (e: IOException) {
            emit(Resource.Error(
                message = "Couldn't reach server, check your internet connection.",
                data = list
            ))
        }

        val newList = dao.getListById(id)?.toListModel()
        emit(Resource.Success(newList))
    }
}