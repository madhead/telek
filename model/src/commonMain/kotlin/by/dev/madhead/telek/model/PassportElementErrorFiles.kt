package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents an issue with a list of scans.
 * The error is considered resolved when the list of files containing the scans changes.
 */
@Serializable
@TelegramBotAPIType(type = "passportelementerrorfiles")
data class PassportElementErrorFiles(
    @SerialName("source")
    val source: String,

    @SerialName("type")
    val type: String,

    @SerialName("file_hashes")
    val fileHashes: List<String>,

    @SerialName("message")
    val message: String
)
