package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a link to a video file stored on the Telegram servers.
 * By default, this video file will be sent by the user with an optional caption.
 * Alternatively, you can use _input_message_content_ to send a message with the specified content instead of the video.
 */
@Serializable
@TelegramBotAPIType(type = "inlinequeryresultcachedvideo")
data class InlineQueryResultCachedVideo(
    @SerialName("type")
    val type: String,

    @SerialName("id")
    val id: String,

    @SerialName("video_file_id")
    val videoFileId: String,

    @SerialName("title")
    val title: String,

    @SerialName("description")
    val description: String? = null,

    @SerialName("caption")
    val caption: String? = null,

    @SerialName("parse_mode")
    val parseMode: String? = null,

    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,

    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent? = null
) : InlineQueryResult
