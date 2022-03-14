package de.niklaseckert.reviewbombed.feature_login.data.remote.dto

import com.google.gson.annotations.SerializedName
import de.niklaseckert.reviewbombed.feature_login.domain.model.User

/**
 * Data class which represents the data transfer object for a User
 */
data class UserResponse(
    val id: Long,
    @SerializedName("name")
    val username: String,
    val email: String
) {
    fun toUser(): User {
        return User(
            id = id,
            username = username,
            email = email
        )
    }
}
