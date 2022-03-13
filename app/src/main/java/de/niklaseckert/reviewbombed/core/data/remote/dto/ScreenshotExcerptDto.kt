package de.niklaseckert.reviewbombed.core.data.remote.dto

import de.niklaseckert.reviewbombed.core.domain.model.ScreenshotExcerpt

/**
 * Data class which represents the data transfer object for a Screenshot Excerpt.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
data class ScreenshotExcerptDto(

    /** Represents the id of the Screenshot. */
    val id: Long,

    /** Represents the url for the Screenshot. */
    val screenshotUrl: String
) {

    /**
     * Method that converts a Screenshot Excerpt Dto into a Screenshot Excerpt.
     *
     * @return the resulting Screenshot Excerpt.
     */
    fun toScreenshotExcerpt(): ScreenshotExcerpt {
        return ScreenshotExcerpt(
            id = id,
            screenshotUrl = screenshotUrl
        )
    }
}