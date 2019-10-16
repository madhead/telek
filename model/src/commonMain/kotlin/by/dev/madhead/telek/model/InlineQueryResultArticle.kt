package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName

@TelegramBotAPIType(type = "inlinequeryresultarticle")
data class InlineQueryResultArticle(
    @SerialName("type")
    val type: String,

    @SerialName("id")
    val id: String,

    @SerialName("title")
    val title: String,

    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent,

    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup,

    @SerialName("url")
    val url: String,

    @SerialName("hide_url")
    val hideUrl: Boolean,

    @SerialName("description")
    val description: String,

    @SerialName("thumb_url")
    val thumbUrl: String,

    @SerialName("thumb_width")
    val thumbWidth: Int,

    @SerialName("thumb_height")
    val thumbHeight: Int
) : InlineQueryResult
