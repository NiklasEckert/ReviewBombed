package de.niklaseckert.reviewbombed.feature_profile.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import de.niklaseckert.reviewbombed.feature_profile.data.local.entity.ProfileEntity

/**
 * Interface which represents the Data Access Object for the Profile.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Dao
interface ProfileDao {

    /**
     * Method to insert a list of Profiles.
     *
     * @param reviews contains a list of Profiles which should be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProfile(reviews: List<ProfileEntity>)

    /**
     * Method delete a list of Profiles.
     *
     * @param ids contains a list of ids of the Profiles which should be deleted.
     */
    @Query("DELETE FROM profileentity WHERE id in (:ids)")
    suspend fun deleteProfiles(ids: List<Long>)

    /**
     * Method to get a Profile by the id.
     *
     * @param id contains the id of a Profile.
     * @return the corresponding Profile.
     */
    @Query("SELECT * FROM profileentity WHERE id = :id LIMIT 1")
    suspend fun getProfileById(id: Long): ProfileEntity?

    /**
     * Method to get multiple Profiles by their id.
     *
     * @param ids contains a list of ids of Profiles.
     * @return a list of Profiles.
     */
    @Query("SELECT * FROM profileentity WHERE id in (:ids)")
    suspend fun getProfilesById(ids: List<Long>): List<ProfileEntity>
}