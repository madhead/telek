package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object represents a chat photo.
 */
@Serializable
@TelegramBotAPIType(type = "chatphoto")
data class ChatPhoto(
    @SerialName("small_file_id")
    val smallFileId: String,

    @SerialName("small_file_unique_id")
    val smallFileUniqueId: String,

    @SerialName("big_file_id")
    val bigFileId: String,

    @SerialName("big_file_unique_id")
    val bigFileUniqueId: String
)
