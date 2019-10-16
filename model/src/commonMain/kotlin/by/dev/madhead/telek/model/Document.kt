package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName

/**
 * This object represents a general file (as opposed to [photos][https://core.telegram.org/bots/api#photosize],
 * [voice messages][https://core.telegram.org/bots/api#voice] and [audio files][https://core.telegram.org/bots/api#audio]).
 */
@TelegramBotAPIType(type = "document")
data class Document(
    @SerialName("file_id")
    val fileId: String,

    @SerialName("thumb")
    val thumb: PhotoSize? = null,

    @SerialName("file_name")
    val fileName: String? = null,

    @SerialName("mime_type")
    val mimeType: String? = null,

    @SerialName("file_size")
    val fileSize: Int? = null
)
