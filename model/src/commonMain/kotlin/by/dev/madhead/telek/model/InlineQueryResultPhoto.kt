package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName

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
    val photoWidth: Int,

    @SerialName("photo_height")
    val photoHeight: Int,

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
