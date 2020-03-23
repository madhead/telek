package by.dev.madhead.telek.model.communication

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonParametricSerializer
import kotlinx.serialization.json.booleanOrNull

/**
 * The response contains a JSON object, which always has a Boolean field ‘ok’ and may have an optional String field ‘description’ with a
 * human-readable description of the result. If ‘ok’ equals true, the request was successful and the result of the query can be found in
 * the ‘result’ field. In case of an unsuccessful request, ‘ok’ equals false and the error is explained in the ‘description’. An Integer
 * ‘error_code’ field is also returned, but its contents are subject to change in the future. Some errors may also have an optional field
 * ‘parameters’ of the type [ResponseParameters], which can help to automatically handle the error.
 */

@Suppress("ForbiddenComment") // TODO: sealed class
// https://github.com/Kotlin/kotlinx.serialization/issues/576
// https://github.com/Kotlin/kotlinx.serialization/issues/736
interface Response {
    val ok: Boolean

    val description: String?

    @Serializer(forClass = Response::class)
    companion object : JsonParametricSerializer<Response>(Response::class) {
        override fun selectSerializer(element: JsonElement): KSerializer<out Response> =
            if ((element as JsonObject)["ok"]?.booleanOrNull != true) {
                Unsuccessful.serializer()
            } else {
                Successful.serializer()
            }
    }

    /**
     * Successful API response.
     */
    @Serializable
    data class Successful(
        @SerialName("ok")
        override val ok: Boolean,

        @SerialName("description")
        override val description: String? = null,

        @SerialName("result")
        val result: JsonElement
    ) : Response

    /**
     * Unsuccessful API response.
     */
    @Serializable
    data class Unsuccessful(
        @SerialName("ok")
        override val ok: Boolean,

        @SerialName("description")
        override val description: String? = null,

        @SerialName("error_code")
        val errorCode: Int? = null,

        @SerialName("parameters")
        val parameters: ResponseParameters? = null
    ) : Response
}
