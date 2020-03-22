package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object contains basic information about an invoice.
 */
@Serializable
@TelegramBotAPIType(type = "invoice")
data class Invoice(
    @SerialName("title")
    val title: String,

    @SerialName("description")
    val description: String,

    @SerialName("start_parameter")
    val startParameter: String,

    @SerialName("currency")
    val currency: String,

    @SerialName("total_amount")
    val totalAmount: Int
)
