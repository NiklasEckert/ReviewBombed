package de.niklaseckert.reviewbombed.feature_list.domain.repository

import de.niklaseckert.reviewbombed.core.domain.model.ListExcerpt
import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_list.domain.model.ListModel
import kotlinx.coroutines.flow.Flow

interface ListRepository {

    fun getListExcerpts(): Flow<Resource<List<ListExcerpt>>>
    fun getList(id: Long): Flow<Resource<ListModel>>
}