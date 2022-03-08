package de.niklaseckert.reviewbombed.feature_list.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import de.niklaseckert.reviewbombed.core.data.local.entity.ListExcerptEntity
import de.niklaseckert.reviewbombed.feature_list.data.local.entity.ListEntity

@Dao
interface ListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListExcerpts(lists: List<ListExcerptEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLists(list: List<ListEntity>)

    @Query("DELETE FROM listexcerptentity WHERE id IN (:ids)")
    suspend fun deleteListExcerpts(ids: List<Long>)

    @Query("DELETE FROM listentity WHERE id IN (:ids)")
    suspend fun deleteListsByIds(ids: List<Long>)

    @Query("SELECT * FROM listexcerptentity")
    suspend fun getAllListExcerptsEntities(): List<ListExcerptEntity>

    @Query("SELECT * FROM listentity WHERE id = :id LIMIT 1")
    suspend fun getListById(id: Long): ListEntity?
}