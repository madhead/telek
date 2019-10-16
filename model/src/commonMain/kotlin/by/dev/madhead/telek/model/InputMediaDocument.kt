package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a general file to be sent.
 */
@Serializable
@TelegramBotAPIType(type = "inputmediadocument")
data class InputMediaDocument(
    @SerialName("type")
    val type: String,

    @SerialName("media")
    val media: String,

    @SerialName("thumb")
    val thumb: Any? = null,

    @SerialName("caption")
    val caption: String? = null,

    @SerialName("parse_mode")
    val parseMode: String? = null
) : InputMedia
