package de.niklaseckert.reviewbombed.feature_list.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import de.niklaseckert.reviewbombed.core.domain.model.GameExcerpt
import de.niklaseckert.reviewbombed.feature_list.domain.model.ListModel

/**
 * Data class which represents a List Entity.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Entity
data class ListEntity(

    /** Represents the id of the List Entity. */
    @PrimaryKey val id: Long,

    /** Represents the name of the List Entity. */
    val name: String,

    /** Represents the description of the List Entity. */
    val description: String,

    /** Represents the Games that are in the List Entity. */
    val games: List<GameExcerpt>
) {

    /**
     * Method that converts a List Entity into a List Model.
     *
     * @return the resulting List Model.
     */
    fun toListModel(): ListModel {
        return ListModel(
            id = id,
            name = name,
            description = description,
            games = games
        )
    }
}