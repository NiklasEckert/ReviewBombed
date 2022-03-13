package de.niklaseckert.reviewbombed.feature_game.data.remote.dto

import de.niklaseckert.reviewbombed.core.data.remote.dto.DeveloperExcerptDto
import de.niklaseckert.reviewbombed.core.data.remote.dto.PublisherExcerptDto
import de.niklaseckert.reviewbombed.core.domain.model.ScreenshotExcerpt
import de.niklaseckert.reviewbombed.feature_game.data.local.entity.GameEntity
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * Data class which represents the data transfer object for a Game.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
data class GameDto(

    /** Represents the url for the Game cover. */
    val coverUrl: String,

    /** Represents the date when the Game got published. */
    val date: String,

    /** Represents the description of the Game. */
    val description: String,

    /** Represents the Developers of the Game. */
    val developers: List<DeveloperExcerptDto>,

    /** Represents the id of the Game. */
    val id: Long,

    /** Represents the Publishers of the Game. */
    val publishers: List<PublisherExcerptDto>,

    /** Represents the title of the Game. */
    val title: String,

    /** Represents the url for the preview image of the Game. */
    val previewImageUrl: String,

    /** Represents the Screenshots of the Game. */
    val screenshots: List<ScreenshotExcerpt>
) {

    /**
     * Method that converts a Game Dto into a Game Entity
     *
     * @return the resulting Game Entity.
     */
    fun toGameEntity(): GameEntity {
        return GameEntity(
            id = id,
            title = title,
            description = description,
            date = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")),
            coverUrl = coverUrl,
            developers = developers.map { it.toDeveloperExcerpt() },
            publishers = publishers.map { it.toPublisherExcerpt() },
            previewImageUrl = previewImageUrl,
            screenshots = screenshots
        )
    }
}