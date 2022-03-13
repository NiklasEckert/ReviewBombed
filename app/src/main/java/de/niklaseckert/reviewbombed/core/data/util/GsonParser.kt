package de.niklaseckert.reviewbombed.core.data.util

import com.google.gson.Gson
import java.lang.reflect.Type

/**
 * Class to convert Json and Gson.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
class GsonParser(

    /** The Gson parser that is used to convert. */
    private val gson: Gson
) : JsonParser {

    /**
     * Method to convert Json to Gson.
     *
     * @param json contains the Json that should be converted.
     * @param type contains the type of the Json.
     * @return the resulting Gson.
     */
    override fun <T> fromJson(json: String, type: Type): T? {
        return gson.fromJson(json, type)
    }

    /**
     * Method to convert Gson to Json.
     *
     * @param obj contains the Object that should be converted.
     * @param type contains the type of the Object.
     * @return the resulting Json.
     */
    override fun <T> toJson(obj: T, type: Type): String? {
        return gson.toJson(obj, type)
    }
}