package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object represents one size of a photo or a [file][Document] / [sticker][Sticker] thumbnail.
 */
@Serializable
@TelegramBotAPIType(type = "photosize")
data class PhotoSize(
    @SerialName("file_id")
    val fileId: String,

    @SerialName("file_unique_id")
    val fileUniqueId: String,

    @SerialName("width")
    val width: Int,

    @SerialName("height")
    val height: Int,

    @SerialName("file_size")
    val fileSize: Int? = null
)
