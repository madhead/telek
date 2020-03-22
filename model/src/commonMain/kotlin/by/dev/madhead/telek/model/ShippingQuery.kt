package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object contains information about an incoming shipping query.
 */
@Serializable
@TelegramBotAPIType(type = "shippingquery")
data class ShippingQuery(
    @SerialName("id")
    val id: String,

    @SerialName("from")
    val from: User,

    @SerialName("invoice_payload")
    val invoicePayload: String,

    @SerialName("shipping_address")
    val shippingAddress: ShippingAddress
)
