package de.niklaseckert.reviewbombed.feature_list.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import de.niklaseckert.reviewbombed.core.data.local.entity.ListExcerptEntity
import de.niklaseckert.reviewbombed.feature_list.data.local.entity.ListEntity

/**
 * Interface which represents the Data Access Object for Lists.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Dao
interface ListDao {

    /**
     * Method to insert a list of List Excerpt Entities.
     *
     * @param lists contains a list of List Excerpt Entities which should be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListExcerpts(lists: List<ListExcerptEntity>)

    /**
     * Method to insert a list of List Entities.
     *
     * @param list contains a list of List Entities.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLists(list: List<ListEntity>)

    /**
     * Method to delete a list of List Excerpt Entities.
     *
     * @param ids contains a list of ids of the List Excerpt Entities that should be deleted.
     */
    @Query("DELETE FROM listexcerptentity WHERE id IN (:ids)")
    suspend fun deleteListExcerpts(ids: List<Long>)

    /**
     * Method to delete a list of List Entities.
     *
     * @param ids contains a list of ids of the List Entities that should be deleted.
     */
    @Query("DELETE FROM listentity WHERE id IN (:ids)")
    suspend fun deleteListsByIds(ids: List<Long>)

    /**
     * Method to get all List Excerpt Entities.
     *
     * @return a list of all List Excerpt Entities.
     */
    @Query("SELECT * FROM listexcerptentity")
    suspend fun getAllListExcerptsEntities(): List<ListExcerptEntity>

    /**
     * Method to get a specific List Entity.
     *
     * @param id contains the id of a List Entity.
     * @return the specific List Entity.
     */
    @Query("SELECT * FROM listentity WHERE id = :id LIMIT 1")
    suspend fun getListById(id: Long): ListEntity?
}