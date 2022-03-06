package de.niklaseckert.reviewbombed.feature_developer.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import de.niklaseckert.reviewbombed.feature_developer.domain.model.Developer

@Entity
data class DeveloperEntity(
    @PrimaryKey val id: Long? = null,
    val name: String
) {
  fun toDeveloper(): Developer {
      return Developer(
          id = id ?: -1,
          name = name
      )
  }
}
