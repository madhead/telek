package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object represents an audio file to be treated as music by the Telegram clients.
 */
@Serializable
@TelegramBotAPIType(type = "audio")
data class Audio(
    @SerialName("file_id")
    val fileId: String,

    @SerialName("file_unique_id")
    val fileUniqueId: String,

    @SerialName("duration")
    val duration: Int,

    @SerialName("performer")
    val performer: String? = null,

    @SerialName("title")
    val title: String? = null,

    @SerialName("mime_type")
    val mimeType: String? = null,

    @SerialName("file_size")
    val fileSize: Int? = null,

    @SerialName("thumb")
    val thumb: PhotoSize? = null
)
