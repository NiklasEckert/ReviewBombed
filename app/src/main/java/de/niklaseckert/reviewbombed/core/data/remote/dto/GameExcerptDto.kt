package de.niklaseckert.reviewbombed.core.data.remote.dto

import de.niklaseckert.reviewbombed.core.data.local.entity.GameExcerptEntity
import de.niklaseckert.reviewbombed.core.data.local.entity.GameExcerptScope
import de.niklaseckert.reviewbombed.core.domain.model.GameExcerpt

data class GameExcerptDto(
    val id: Long,
    val title: String,
    val coverUrl: String,
    val previewImageUrl: String
) {
    fun toGameExcerptEntity(scope: GameExcerptScope): GameExcerptEntity {
        return GameExcerptEntity(
            id = id,
            title = title,
            coverUrl = coverUrl,
            previewImageUrl = previewImageUrl,
            scope = scope
        )
    }

    fun toGameExcerpt(): GameExcerpt {
        return GameExcerpt(
            id = id,
            title = title,
            coverUrl = coverUrl,
            previewImageUrl = previewImageUrl
        )
    }
}