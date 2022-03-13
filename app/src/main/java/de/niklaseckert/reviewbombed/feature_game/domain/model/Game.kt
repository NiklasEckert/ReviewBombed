package de.niklaseckert.reviewbombed.feature_game.domain.model

import de.niklaseckert.reviewbombed.core.domain.model.DeveloperExcerpt
import de.niklaseckert.reviewbombed.core.domain.model.PublisherExcerpt
import de.niklaseckert.reviewbombed.core.domain.model.ScreenshotExcerpt
import java.time.LocalDate

/**
 * Class which represents a Game.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
class Game(

    /** Represents the url of the Game cover. */
    val coverUrl: String,

    /** Represents the date when the Game got published. */
    val date: LocalDate,

    /** Represents the description of the Game. */
    val description: String,

    /** Represents the Developers of the Game. */
    val developers: List<DeveloperExcerpt>,

    /** Represents the id of the Game. */
    val id: Long,

    /** Represents the Publishers of the Game. */
    val publishers: List<PublisherExcerpt>,

    /** Represents the Publishers of the Game. */
    val title: String,

    /** Represents the url for the preview image of the Game. */
    val previewImageUrl: String,

    /** Represents the Screenshots of the Game. */
    val screenshots: List<ScreenshotExcerpt>
) {

}