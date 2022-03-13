package de.niklaseckert.reviewbombed.core.data.util

import java.lang.reflect.Type

/**
 * Interface for Gson Parser.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
interface JsonParser {

    /**
     * Method to convert Json to Gson.
     *
     * @param json contains the Json that should be converted.
     * @param type contains the type of the Json.
     * @return the resulting Gson.
     */
    fun <T> fromJson(json: String, type: Type): T?

    /**
     * Method to convert Gson to Json.
     *
     * @param obj contains the Object that should be converted.
     * @param type contains the type of the Object.
     * @return the resulting Json.
     */
    fun <T> toJson(obj: T, type: Type): String?
}