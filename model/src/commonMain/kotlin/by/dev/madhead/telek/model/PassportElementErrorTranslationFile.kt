package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents an issue with one of the files that constitute the translation of a document.
 * The error is considered resolved when the file changes.
 */
@Serializable
@TelegramBotAPIType(type = "passportelementerrortranslationfile")
data class PassportElementErrorTranslationFile(
    @SerialName("source")
    val source: String,

    @SerialName("type")
    val type: String,

    @SerialName("file_hash")
    val fileHash: String,

    @SerialName("message")
    val message: String
)
