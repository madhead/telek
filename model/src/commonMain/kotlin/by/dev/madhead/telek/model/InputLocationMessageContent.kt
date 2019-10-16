package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the [content][InputMessageContent] of a location message to be sent as the result of an inline query.
 */
@Serializable
@TelegramBotAPIType(type = "inputlocationmessagecontent")
data class InputLocationMessageContent(
    @SerialName("latitude")
    val latitude: Double,

    @SerialName("longitude")
    val longitude: Double,

    @SerialName("live_period")
    val livePeriod: Int? = null
)
