package de.niklaseckert.reviewbombed.feature_login.domain.model

/**
 * Class which represents a User.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
class User(

    /** Represents the of a User. */
    val id: Long,

    /** Represents the username of a User. */
    val username: String,

    /** Represents the email of a User. */
    val email: String
) {
}