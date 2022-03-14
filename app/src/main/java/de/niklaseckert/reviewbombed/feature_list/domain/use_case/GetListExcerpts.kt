package de.niklaseckert.reviewbombed.feature_list.domain.use_case

import de.niklaseckert.reviewbombed.core.domain.model.ListExcerpt
import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_list.domain.repository.ListRepository
import kotlinx.coroutines.flow.Flow

/**
 * Use Case to get all List Excerpts.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
class GetListExcerpts(

    /** Repository which contains the Lists. */
    private val repository: ListRepository
) {

    /**
     * Method to get all List Excerpts.
     *
     * @return a Flow Resource of a List which contains all List Excerpts.
     */
    operator fun invoke(): Flow<Resource<List<ListExcerpt>>> {
        return repository.getListExcerpts()
    }
}