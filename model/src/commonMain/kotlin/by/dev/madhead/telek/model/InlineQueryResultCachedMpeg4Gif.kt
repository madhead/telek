package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a link to a video animation (H.264/MPEG-4 AVC video without sound) stored on the Telegram servers.
 * By default, this animated MPEG-4 file will be sent by the user with an optional caption.
 * Alternatively, you can use _input_message_content_ to send a message with the specified content instead of the animation.
 */
@Serializable
@TelegramBotAPIType(type = "inlinequeryresultcachedmpeg4gif")
data class InlineQueryResultCachedMpeg4Gif(
    @SerialName("type")
    val type: String,

    @SerialName("id")
    val id: String,

    @SerialName("mpeg4_file_id")
    val mpeg4FileId: String,

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
