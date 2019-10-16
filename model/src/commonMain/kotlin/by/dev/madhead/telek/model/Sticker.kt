package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object represents a sticker.
 */
@Serializable
@TelegramBotAPIType(type = "sticker")
data class Sticker(
    @SerialName("file_id")
    val fileId: String,

    @SerialName("file_unique_id")
    val fileUniqueId: String,

    @SerialName("width")
    val width: Int,

    @SerialName("height")
    val height: Int,

    @SerialName("is_animated")
    val isAnimated: Boolean,

    @SerialName("thumb")
    val thumb: PhotoSize? = null,

    @SerialName("emoji")
    val emoji: String? = null,

    @SerialName("set_name")
    val setName: String? = null,

    @SerialName("mask_position")
    val maskPosition: MaskPosition? = null,

    @SerialName("file_size")
    val fileSize: Int? = null
)
