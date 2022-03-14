package de.niklaseckert.reviewbombed.feature_list.domain.use_case

import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_list.domain.model.ListModel
import de.niklaseckert.reviewbombed.feature_list.domain.repository.ListRepository
import kotlinx.coroutines.flow.Flow

/**
 * Use Case to get a specific List.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
class GetList(

    /** Repository which contains the lists. */
    private val repository: ListRepository
) {

    /**
     * Method to get one specific List Model.
     *
     * @param id contains the id of a List.
     * @return a Flow Resource of a List Model.
     */
    operator fun invoke(id: Long): Flow<Resource<ListModel>> {
        return repository.getList(id)
    }
}