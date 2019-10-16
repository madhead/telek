package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a link to a photo.
 * By default, this photo will be sent by the user with optional caption.
 * Alternatively, you can use _input_message_content_ to send a message with the specified content instead of the photo.
 */
@Serializable
@TelegramBotAPIType(type = "inlinequeryresultphoto")
data class InlineQueryResultPhoto(
    @SerialName("type")
    val type: String,

    @SerialName("id")
    val id: String,

    @SerialName("photo_url")
    val photoUrl: String,

    @SerialName("thumb_url")
    val thumbUrl: String,

    @SerialName("photo_width")
    val photoWidth: Int? = null,

    @SerialName("photo_height")
    val photoHeight: Int? = null,

    @SerialName("title")
    val title: String? = null,

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
