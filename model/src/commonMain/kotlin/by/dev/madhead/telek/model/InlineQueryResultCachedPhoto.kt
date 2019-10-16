package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName

@TelegramBotAPIType(type = "inlinequeryresultcachedphoto")
data class InlineQueryResultCachedPhoto(
    @SerialName("type")
    val type: String,

    @SerialName("id")
    val id: String,

    @SerialName("photo_file_id")
    val photoFileId: String,

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
