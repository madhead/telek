package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName

@TelegramBotAPIType(type = "inlinequeryresultmpeg4gif")
data class InlineQueryResultMpeg4Gif(
    @SerialName("type")
    val type: String,

    @SerialName("id")
    val id: String,

    @SerialName("mpeg4_url")
    val mpeg4Url: String,

    @SerialName("mpeg4_width")
    val mpeg4Width: Int,

    @SerialName("mpeg4_height")
    val mpeg4Height: Int,

    @SerialName("mpeg4_duration")
    val mpeg4Duration: Int,

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
