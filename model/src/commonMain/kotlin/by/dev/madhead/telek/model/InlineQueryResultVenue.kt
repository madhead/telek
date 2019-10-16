package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName

@TelegramBotAPIType(type = "inlinequeryresultvenue")
data class InlineQueryResultVenue(
    @SerialName("type")
    val type: String,

    @SerialName("id")
    val id: String,

    @SerialName("latitude")
    val latitude: Float,

    @SerialName("longitude")
    val longitude: Float,

    @SerialName("title")
    val title: String,

    @SerialName("address")
    val address: String,

    @SerialName("foursquare_id")
    val foursquareId: String,

    @SerialName("foursquare_type")
    val foursquareType: String,

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
