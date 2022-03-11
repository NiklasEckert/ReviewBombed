package de.niklaseckert.reviewbombed.core.data.remote.dto

import de.niklaseckert.reviewbombed.core.data.local.entity.ListExcerptEntity
import de.niklaseckert.reviewbombed.core.domain.model.ListExcerpt

data class ListExcerptDto(
    val id: Long,
    val name: String,
    val description: String
) {
    fun toListExcerptEntity(): ListExcerptEntity {
        return ListExcerptEntity(
            id = id,
            name = name,
            description = description
        )
    }

    fun toListExcerpt(): ListExcerpt {
        return ListExcerpt(
            id = id,
            name = name,
            description = description
        )
    }
}