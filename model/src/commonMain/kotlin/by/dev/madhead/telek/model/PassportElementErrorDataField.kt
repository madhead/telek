package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents an issue in one of the data fields that was provided by the user.
 * The error is considered resolved when the field's value changes.
 */
@Serializable
@TelegramBotAPIType(type = "passportelementerrordatafield")
data class PassportElementErrorDataField(
    @SerialName("source")
    val source: String,

    @SerialName("type")
    val type: String,

    @SerialName("field_name")
    val fieldName: String,

    @SerialName("data_hash")
    val dataHash: String,

    @SerialName("message")
    val message: String
)
