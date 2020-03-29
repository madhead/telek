package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a link to a page containing an embedded video player or a video file.
 * By default, this video file will be sent by the user with an optional caption.
 * Alternatively, you can use _input_message_content_ to send a message with the specified content instead of the video.
 */
@Serializable
@TelegramBotAPIType(type = "inlinequeryresultvideo")
data class InlineQueryResultVideo(
    @SerialName("type")
    val type: String,

    @SerialName("id")
    val id: String,

    @SerialName("video_url")
    val videoUrl: String,

    @SerialName("mime_type")
    val mimeType: String,

    @SerialName("thumb_url")
    val thumbUrl: String,

    @SerialName("title")
    val title: String,

    @SerialName("caption")
    val caption: String? = null,

    @SerialName("parse_mode")
    val parseMode: ParseMode? = null,

    @SerialName("video_width")
    val videoWidth: Int? = null,

    @SerialName("video_height")
    val videoHeight: Int? = null,

    @SerialName("video_duration")
    val videoDuration: Int? = null,

    @SerialName("description")
    val description: String? = null,

    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,

    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent? = null
) : InlineQueryResult
