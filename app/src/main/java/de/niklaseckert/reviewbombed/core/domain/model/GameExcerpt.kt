package de.niklaseckert.reviewbombed.core.domain.model

/**
 * Class which represents a Game Excerpt.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
class GameExcerpt(

    /** Represents the id of a Game. */
    val id: Long,

    /** Represents the title of a Game. */
    val title: String,

    /** Represents the url for the cover of a Game. */
    val coverUrl: String,

    /** Represents the url for the preview image of a Game. */
    val previewImageUrl: String
) {
}