package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a photo to be sent.
 */
@Serializable
@TelegramBotAPIType(type = "inputmediaphoto")
data class InputMediaPhoto(
    @SerialName("type")
    val type: String,

    @SerialName("media")
    val media: String,

    @SerialName("caption")
    val caption: String? = null,

    @SerialName("parse_mode")
    val parseMode: String? = null
) : InputMedia
