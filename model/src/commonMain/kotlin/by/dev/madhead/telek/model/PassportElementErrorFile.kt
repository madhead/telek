package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents an issue with a document scan.
 * The error is considered resolved when the file with the document scan changes.
 */
@Serializable
@TelegramBotAPIType(type = "passportelementerrorfile")
data class PassportElementErrorFile(
    @SerialName("source")
    val source: String,

    @SerialName("type")
    val type: String,

    @SerialName("file_hash")
    val fileHash: String,

    @SerialName("message")
    val message: String
)
