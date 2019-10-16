package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName

@TelegramBotAPIType(type = "inputmediaphoto")
data class InputMediaPhoto(
    @SerialName("type")
    val type: String,

    @SerialName("media")
    val media: String,

    @SerialName("caption")
    val caption: String,

    @SerialName("parse_mode")
    val parseMode: String
) : InputMedia
