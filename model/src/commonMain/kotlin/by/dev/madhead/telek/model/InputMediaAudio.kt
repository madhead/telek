package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents an audio file to be treated as music to be sent.
 */
@Serializable
@TelegramBotAPIType(type = "inputmediaaudio")
data class InputMediaAudio(
    @SerialName("type")
    val type: String,

    @SerialName("media")
    val media: String,

    @SerialName("thumb")
    val thumb: Any? = null,

    @SerialName("caption")
    val caption: String? = null,

    @SerialName("parse_mode")
    val parseMode: String? = null,

    @SerialName("duration")
    val duration: Int? = null,

    @SerialName("performer")
    val performer: String? = null,

    @SerialName("title")
    val title: String? = null
) : InputMedia
