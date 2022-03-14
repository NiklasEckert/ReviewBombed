package de.niklaseckert.reviewbombed.feature_list.domain.model

import de.niklaseckert.reviewbombed.core.domain.model.GameExcerpt

/**
 * Class which represents a List Model.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
class ListModel(

    /** Represents the if of the List. */
    val id: Long,

    /** Represents the name of the List. */
    val name: String,

    /** Represents the description of the List. */
    val description: String,

    /** Represents the Games that are in the List. */
    val games: List<GameExcerpt>
) {
}