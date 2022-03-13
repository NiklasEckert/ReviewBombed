package de.niklaseckert.reviewbombed.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import de.niklaseckert.reviewbombed.core.domain.model.ListExcerpt

/**
 * Data class which represents a List Excerpt Entity.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Entity
data class ListExcerptEntity(

    /** Represents the id of the List. */
    @PrimaryKey val id: Long,

    /** Represents the name of the List. */
    val name: String,

    /** Represents the description of the List. */
    val description: String
) {

    /**
     * Method that converts a List Excerpt Entity into a List Excerpt.
     *
     * @return the resulting List Excerpt.
     */
   fun toListExcerpt(): ListExcerpt {
       return ListExcerpt(
           id = id,
           name = name,
           description = description
       )
   }
}