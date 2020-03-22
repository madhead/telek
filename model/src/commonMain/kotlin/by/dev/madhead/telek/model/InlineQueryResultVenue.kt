package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a venue.
 * By default, the venue will be sent by the user.
 * Alternatively, you can use _input_message_content_ to send a message with the specified content instead of the venue.
 */
@Serializable
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
    val foursquareId: String? = null,

    @SerialName("foursquare_type")
    val foursquareType: String? = null,

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
