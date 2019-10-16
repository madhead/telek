package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object represents a [video message][https://telegram.org/blog/video-messages-and-telescope] (available in Telegram apps as of
 * [v.4.0][https://telegram.org/blog/video-messages-and-telescope]).
 */
@Serializable
@TelegramBotAPIType(type = "videonote")
data class VideoNote(
    @SerialName("file_id")
    val fileId: String,

    @SerialName("file_unique_id")
    val fileUniqueId: String,

    @SerialName("length")
    val length: Int,

    @SerialName("duration")
    val duration: Int,

    @SerialName("thumb")
    val thumb: PhotoSize? = null,

    @SerialName("file_size")
    val fileSize: Int? = null
)
