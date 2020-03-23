package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a link to a file stored on the Telegram servers.
 * By default, this file will be sent by the user with an optional caption.
 * Alternatively, you can use _input_message_content_ to send a message with the specified content instead of the file.
 */
@Serializable
@TelegramBotAPIType(type = "inlinequeryresultcacheddocument")
data class InlineQueryResultCachedDocument(
    @SerialName("type")
    val type: String,

    @SerialName("id")
    val id: String,

    @SerialName("title")
    val title: String,

    @SerialName("document_file_id")
    val documentFileId: String,

    @SerialName("description")
    val description: String? = null,

    @SerialName("caption")
    val caption: String? = null,

    @SerialName("parse_mode")
    val parseMode: ParseMode? = null,

    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,

    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent? = null
) : InlineQueryResult
