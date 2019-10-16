package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object contains basic information about a successful payment.
 */
@Serializable
@TelegramBotAPIType(type = "successfulpayment")
data class SuccessfulPayment(
    @SerialName("currency")
    val currency: String,

    @SerialName("total_amount")
    val totalAmount: Int,

    @SerialName("invoice_payload")
    val invoicePayload: String,

    @SerialName("shipping_option_id")
    val shippingOptionId: String? = null,

    @SerialName("order_info")
    val orderInfo: OrderInfo? = null,

    @SerialName("telegram_payment_charge_id")
    val telegramPaymentChargeId: String,

    @SerialName("provider_payment_charge_id")
    val providerPaymentChargeId: String
)
