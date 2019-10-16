package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a link to a video animation (H.264/MPEG-4 AVC video without sound).
 * By default, this animated MPEG-4 file will be sent by the user with optional caption.
 * Alternatively, you can use _input_message_content_ to send a message with the specified content instead of the animation.
 */
@Serializable
@TelegramBotAPIType(type = "inlinequeryresultmpeg4gif")
data class InlineQueryResultMpeg4Gif(
    @SerialName("type")
    val type: String,

    @SerialName("id")
    val id: String,

    @SerialName("mpeg4_url")
    val mpeg4Url: String,

    @SerialName("mpeg4_width")
    val mpeg4Width: Int? = null,

    @SerialName("mpeg4_height")
    val mpeg4Height: Int? = null,

    @SerialName("mpeg4_duration")
    val mpeg4Duration: Int? = null,

    @SerialName("thumb_url")
    val thumbUrl: String,

    @SerialName("title")
    val title: String? = null,

    @SerialName("caption")
    val caption: String? = null,

    @SerialName("parse_mode")
    val parseMode: String? = null,

    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,

    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent? = null
) : InlineQueryResult
