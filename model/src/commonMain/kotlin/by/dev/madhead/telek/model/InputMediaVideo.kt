package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName

@TelegramBotAPIType(type = "inputmediavideo")
data class InputMediaVideo(
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

    @SerialName("width")
    val width: Int,

    @SerialName("height")
    val height: Int,

    @SerialName("duration")
    val duration: Int,

    @SerialName("supports_streaming")
    val supportsStreaming: Boolean
) : InputMedia
