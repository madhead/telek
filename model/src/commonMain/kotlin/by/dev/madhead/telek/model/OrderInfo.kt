package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object represents information about an order.
 */
@Serializable
@TelegramBotAPIType(type = "orderinfo")
data class OrderInfo(
    @SerialName("name")
    val name: String? = null,

    @SerialName("phone_number")
    val phoneNumber: String? = null,

    @SerialName("email")
    val email: String? = null,

    @SerialName("shipping_address")
    val shippingAddress: ShippingAddress? = null
)
