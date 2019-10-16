package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName

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
    val caption: String,

    @SerialName("parse_mode")
    val parseMode: String,

    @SerialName("video_width")
    val videoWidth: Int,

    @SerialName("video_height")
    val videoHeight: Int,

    @SerialName("video_duration")
    val videoDuration: Int,

    @SerialName("description")
    val description: String,

    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup,

    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent
) : InlineQueryResult
