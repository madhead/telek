package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object represents a point on the map.
 */
@Serializable
@TelegramBotAPIType(type = "location")
data class Location(
    @SerialName("longitude")
    val longitude: Double,

    @SerialName("latitude")
    val latitude: Double
)
