package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a link to a photo stored on the Telegram servers.
 * By default, this photo will be sent by the user with an optional caption.
 * Alternatively, you can use _input_message_content_ to send a message with the specified content instead of the photo.
 */
@Serializable
@TelegramBotAPIType(type = "inlinequeryresultcachedphoto")
data class InlineQueryResultCachedPhoto(
    @SerialName("type")
    val type: String,

    @SerialName("id")
    val id: String,

    @SerialName("photo_file_id")
    val photoFileId: String,

    @SerialName("title")
    val title: String? = null,

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
