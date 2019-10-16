package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName

@TelegramBotAPIType(type = "inlinequeryresultdocument")
data class InlineQueryResultDocument(
    @SerialName("type")
    val type: String,

    @SerialName("id")
    val id: String,

    @SerialName("title")
    val title: String,

    @SerialName("caption")
    val caption: String,

    @SerialName("parse_mode")
    val parseMode: String,

    @SerialName("document_url")
    val documentUrl: String,

    @SerialName("mime_type")
    val mimeType: String,

    @SerialName("description")
    val description: String,

    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup,

    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent,

    @SerialName("thumb_url")
    val thumbUrl: String,

    @SerialName("thumb_width")
    val thumbWidth: Int,

    @SerialName("thumb_height")
    val thumbHeight: Int
) : InlineQueryResult
