package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName

/**
 * This object represents a chat photo.
 */
@TelegramBotAPIType(type = "chatphoto")
data class ChatPhoto(
    @SerialName("small_file_id")
    val smallFileId: String,

    @SerialName("big_file_id")
    val bigFileId: String
)
