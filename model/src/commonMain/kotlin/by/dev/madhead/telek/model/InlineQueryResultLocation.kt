package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a location on a map.
 * By default, the location will be sent by the user.
 * Alternatively, you can use _input_message_content_ to send a message with the specified content instead of the location.
 */
@Serializable
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
    val livePeriod: Int? = null,

    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,

    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent? = null,

    @SerialName("thumb_url")
    val thumbUrl: String? = null,

    @SerialName("thumb_width")
    val thumbWidth: Int? = null,

    @SerialName("thumb_height")
    val thumbHeight: Int? = null
) : InlineQueryResult
