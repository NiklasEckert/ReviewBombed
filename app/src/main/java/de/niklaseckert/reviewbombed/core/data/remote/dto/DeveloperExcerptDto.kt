package de.niklaseckert.reviewbombed.core.data.remote.dto

import de.niklaseckert.reviewbombed.core.domain.model.DeveloperExcerpt

data class DeveloperExcerptDto(
    val id: Long,
    val name: String
) {
    fun toDeveloperExcerpt(): DeveloperExcerpt {
        return DeveloperExcerpt(
            id = id,
            name = name
        )
    }
}