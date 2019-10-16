package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName

@TelegramBotAPIType(type = "inputmediaaudio")
data class InputMediaAudio(
    @SerialName("type")
    val type: String,

    @SerialName("media")
    val media: String,

    @SerialName("thumb")
    val thumb: Any,

    @SerialName("caption")
    val caption: String,

    @SerialName("parse_mode")
    val parseMode: String,

    @SerialName("duration")
    val duration: Int,

    @SerialName("performer")
    val performer: String,

    @SerialName("title")
    val title: String
) : InputMedia
