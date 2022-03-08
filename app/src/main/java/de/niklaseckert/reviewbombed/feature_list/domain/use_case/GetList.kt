package de.niklaseckert.reviewbombed.feature_list.domain.use_case

import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_list.domain.model.ListModel
import de.niklaseckert.reviewbombed.feature_list.domain.repository.ListRepository
import kotlinx.coroutines.flow.Flow

class GetList(
    private val repository: ListRepository
) {

    operator fun invoke(id: Long): Flow<Resource<ListModel>> {
        return repository.getList(id)
    }
}