package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the [content][InputMessageContent] of a venue message to be sent as the result of an inline query.
 */
@Serializable
@TelegramBotAPIType(type = "inputvenuemessagecontent")
data class InputVenueMessageContent(
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
    val foursquareType: String? = null
)
