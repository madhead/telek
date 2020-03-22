package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a link to a file.
 * By default, this file will be sent by the user with an optional caption.
 * Alternatively, you can use _input_message_content_ to send a message with the specified content instead of the file.
 * Currently, only **.PDF** and **.ZIP** files can be sent using this method.
 */
@Serializable
@TelegramBotAPIType(type = "inlinequeryresultdocument")
data class InlineQueryResultDocument(
    @SerialName("type")
    val type: String,

    @SerialName("id")
    val id: String,

    @SerialName("title")
    val title: String,

    @SerialName("caption")
    val caption: String? = null,

    @SerialName("parse_mode")
    val parseMode: String? = null,

    @SerialName("document_url")
    val documentUrl: String,

    @SerialName("mime_type")
    val mimeType: String,

    @SerialName("description")
    val description: String? = null,

    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,

    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent? = null,

    @SerialName("thumb_url")
    val thumbUrl: String? = null,

    @SerialName("thumb_width")
    val thumbWidth: Int? = null,

    @SerialName("thumb_height")
    val thumbHeight: Int? = null
) : InlineQueryResult
