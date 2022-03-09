package de.niklaseckert.reviewbombed.core.data.remote.dto

import de.niklaseckert.reviewbombed.core.domain.model.ScreenshotExcerpt

data class ScreenshotExcerptDto(
    val id: Long,
    val screenshotUrl: String
) {
    fun toScreenshotExcerpt(): ScreenshotExcerpt {
        return ScreenshotExcerpt(
            id = id,
            screenshotUrl = screenshotUrl
        )
    }
}