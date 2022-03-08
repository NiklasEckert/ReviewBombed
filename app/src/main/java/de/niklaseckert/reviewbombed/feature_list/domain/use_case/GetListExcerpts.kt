package de.niklaseckert.reviewbombed.feature_list.domain.use_case

import de.niklaseckert.reviewbombed.core.domain.model.ListExcerpt
import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_list.domain.repository.ListRepository
import kotlinx.coroutines.flow.Flow

class GetListExcerpts(
    private val repository: ListRepository
) {

    operator fun invoke(): Flow<Resource<List<ListExcerpt>>> {
        return repository.getListExcerpts()
    }
}