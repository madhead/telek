package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents an issue with the translated version of a document.
 * The error is considered resolved when a file with the document translation change.
 */
@Serializable
@TelegramBotAPIType(type = "passportelementerrortranslationfiles")
data class PassportElementErrorTranslationFiles(
    @SerialName("source")
    val source: String,

    @SerialName("type")
    val type: String,

    @SerialName("file_hashes")
    val fileHashes: List<String>,

    @SerialName("message")
    val message: String
)
