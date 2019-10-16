package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName

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
    val description: String,

    @SerialName("caption")
    val caption: String,

    @SerialName("parse_mode")
    val parseMode: String,

    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup,

    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent
) : InlineQueryResult
