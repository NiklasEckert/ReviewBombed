package de.niklaseckert.reviewbombed.feature_developer.data.remote.dto

import de.niklaseckert.reviewbombed.feature_developer.data.local.entity.DeveloperEntity
import de.niklaseckert.reviewbombed.feature_developer.domain.model.Developer

data class DeveloperDto(
    val id: Long,
    val name: String
) {
    fun toDeveloper(): Developer {
        return Developer(
            id = id,
            name = name
        )
    }

    fun toDeveloperEntity(): DeveloperEntity {
        return DeveloperEntity(
            id = id,
            name = name
        )
    }
}