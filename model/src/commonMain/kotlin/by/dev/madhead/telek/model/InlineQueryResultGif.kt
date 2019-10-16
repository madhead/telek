package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName

@TelegramBotAPIType(type = "inlinequeryresultgif")
data class InlineQueryResultGif(
    @SerialName("type")
    val type: String,

    @SerialName("id")
    val id: String,

    @SerialName("gif_url")
    val gifUrl: String,

    @SerialName("gif_width")
    val gifWidth: Int,

    @SerialName("gif_height")
    val gifHeight: Int,

    @SerialName("gif_duration")
    val gifDuration: Int,

    @SerialName("thumb_url")
    val thumbUrl: String,

    @SerialName("title")
    val title: String,

    @SerialName("caption")
    val caption: String,

    @SerialName("parse_mode")
    val parseMode: String,

    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup,

    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent
) : InlineQueryResult
