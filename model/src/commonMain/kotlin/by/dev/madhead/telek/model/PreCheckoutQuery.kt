package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object contains information about an incoming pre-checkout query.
 */
@Serializable
@TelegramBotAPIType(type = "precheckoutquery")
data class PreCheckoutQuery(
    @SerialName("id")
    val id: String,

    @SerialName("from")
    val from: User,

    @SerialName("currency")
    val currency: String,

    @SerialName("total_amount")
    val totalAmount: Int,

    @SerialName("invoice_payload")
    val invoicePayload: String,

    @SerialName("shipping_option_id")
    val shippingOptionId: String? = null,

    @SerialName("order_info")
    val orderInfo: OrderInfo? = null
)
