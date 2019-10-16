package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object represents a venue.
 */
@Serializable
@TelegramBotAPIType(type = "venue")
data class Venue(
    @SerialName("location")
    val location: Location,

    @SerialName("title")
    val title: String,

    @SerialName("address")
    val address: String,

    @SerialName("foursquare_id")
    val foursquareId: String? = null,

    @SerialName("foursquare_type")
    val foursquareType: String? = null
)
