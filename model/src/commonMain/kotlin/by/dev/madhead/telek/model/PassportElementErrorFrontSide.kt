package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents an issue with the front side of a document.
 * The error is considered resolved when the file with the front side of the document changes.
 */
@Serializable
@TelegramBotAPIType(type = "passportelementerrorfrontside")
data class PassportElementErrorFrontSide(
    @SerialName("source")
    val source: String,

    @SerialName("type")
    val type: String,

    @SerialName("file_hash")
    val fileHash: String,

    @SerialName("message")
    val message: String
)
