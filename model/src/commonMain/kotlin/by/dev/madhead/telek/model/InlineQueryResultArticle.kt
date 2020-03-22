package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a link to an article or web page.
 */
@Serializable
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
    val replyMarkup: InlineKeyboardMarkup? = null,

    @SerialName("url")
    val url: String? = null,

    @SerialName("hide_url")
    val hideUrl: Boolean? = null,

    @SerialName("description")
    val description: String? = null,

    @SerialName("thumb_url")
    val thumbUrl: String? = null,

    @SerialName("thumb_width")
    val thumbWidth: Int? = null,

    @SerialName("thumb_height")
    val thumbHeight: Int? = null
) : InlineQueryResult
