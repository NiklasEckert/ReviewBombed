package de.niklaseckert.reviewbombed.core.data.remote.dto

import de.niklaseckert.reviewbombed.core.domain.model.PublisherExcerpt

data class PublisherExcerptDto(
    val id: Long,
    val name: String
) {
    fun toPublisherExcerpt(): PublisherExcerpt {
        return PublisherExcerpt(
            id = id,
            name = name
        )
    }
}