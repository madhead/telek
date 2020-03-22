package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents an issue in an unspecified place.
 * The error is considered resolved when new data is added.
 */
@Serializable
@TelegramBotAPIType(type = "passportelementerrorunspecified")
data class PassportElementErrorUnspecified(
    @SerialName("source")
    val source: String,

    @SerialName("type")
    val type: String,

    @SerialName("element_hash")
    val elementHash: String,

    @SerialName("message")
    val message: String
)
