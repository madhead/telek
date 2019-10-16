package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object represents a shipping address.
 */
@Serializable
@TelegramBotAPIType(type = "shippingaddress")
data class ShippingAddress(
    @SerialName("country_code")
    val countryCode: String,

    @SerialName("state")
    val state: String,

    @SerialName("city")
    val city: String,

    @SerialName("street_line1")
    val streetLine1: String,

    @SerialName("street_line2")
    val streetLine2: String,

    @SerialName("post_code")
    val postCode: String
)
