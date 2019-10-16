package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName

@TelegramBotAPIType(type = "inlinequeryresultlocation")
data class InlineQueryResultLocation(
    @SerialName("type")
    val type: String,

    @SerialName("id")
    val id: String,

    @SerialName("latitude")
    val latitude: Double,

    @SerialName("longitude")
    val longitude: Double,

    @SerialName("title")
    val title: String,

    @SerialName("live_period")
    val livePeriod: Int,

    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup,

    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent,

    @SerialName("thumb_url")
    val thumbUrl: String,

    @SerialName("thumb_width")
    val thumbWidth: Int,

    @SerialName("thumb_height")
    val thumbHeight: Int
) : InlineQueryResult
