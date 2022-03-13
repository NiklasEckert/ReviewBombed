package de.niklaseckert.reviewbombed.core.util

typealias SimpleResource = Resource<Unit>

/**
 * Sealed class which represents the states of a Resource.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
sealed class Resource<T>(val data: T? = null, val message: String? = null) {

    /** Class that represents a loading Resource. */
    class Loading<T>(data: T? = null): Resource<T>(data)

    /** Class that represents a successful Resource. */
    class Success<T>(data: T?): Resource<T>(data)

    /** Class that represents an error Resource. */
    class Error<T>(message: String, data: T? = null): Resource<T>(data, message)
}
