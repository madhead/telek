package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a video to be sent.
 */
@Serializable
@TelegramBotAPIType(type = "inputmediavideo")
data class InputMediaVideo(
    @SerialName("type")
    val type: String,

    @SerialName("media")
    val media: String,

    @SerialName("thumb")
    @ContextualSerialization
    val thumb: Any? = null,

    @SerialName("caption")
    val caption: String? = null,

    @SerialName("parse_mode")
    val parseMode: ParseMode? = null,

    @SerialName("width")
    val width: Int? = null,

    @SerialName("height")
    val height: Int? = null,

    @SerialName("duration")
    val duration: Int? = null,

    @SerialName("supports_streaming")
    val supportsStreaming: Boolean? = null
) : InputMedia
