package de.niklaseckert.reviewbombed.feature_list.domain.repository

import de.niklaseckert.reviewbombed.core.domain.model.ListExcerpt
import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_list.domain.model.ListModel
import kotlinx.coroutines.flow.Flow

/**
 * Interface which the List Repository implements.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
interface ListRepository {

    /**
     * Method to get all List Excerpts.
     *
     * @return a Flow Resource of a list which contains List Excerpts.
     */
    fun getListExcerpts(): Flow<Resource<List<ListExcerpt>>>

    /**
     * Method to get a specific List Model.
     *
     * @param id contains the id of a List Model.
     * @return a Flow Resource of a List Model.
     */
    fun getList(id: Long): Flow<Resource<ListModel>>
}