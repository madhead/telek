package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a link to an animated GIF file.
 * By default, this animated GIF file will be sent by the user with optional caption.
 * Alternatively, you can use _input_message_content_ to send a message with the specified content instead of the animation.
 */
@Serializable
@TelegramBotAPIType(type = "inlinequeryresultgif")
data class InlineQueryResultGif(
    @SerialName("type")
    val type: String,

    @SerialName("id")
    val id: String,

    @SerialName("gif_url")
    val gifUrl: String,

    @SerialName("gif_width")
    val gifWidth: Int? = null,

    @SerialName("gif_height")
    val gifHeight: Int? = null,

    @SerialName("gif_duration")
    val gifDuration: Int? = null,

    @SerialName("thumb_url")
    val thumbUrl: String,

    @SerialName("title")
    val title: String? = null,

    @SerialName("caption")
    val caption: String? = null,

    @SerialName("parse_mode")
    val parseMode: ParseMode? = null,

    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,

    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent? = null
) : InlineQueryResult
