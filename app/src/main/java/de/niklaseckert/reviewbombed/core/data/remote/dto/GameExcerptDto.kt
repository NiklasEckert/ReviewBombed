package de.niklaseckert.reviewbombed.core.data.remote.dto

import de.niklaseckert.reviewbombed.core.data.local.entity.GameExcerptEntity
import de.niklaseckert.reviewbombed.core.data.local.entity.GameExcerptScope

data class GameExcerptDto(
    val id: Long,
    val title: String,
    val coverUrl: String
) {
    fun toGameExcerptEntity(scope: GameExcerptScope): GameExcerptEntity {
        return GameExcerptEntity(
            id = id,
            title = title,
            coverUrl = coverUrl,
            scope = scope
        )
    }
}