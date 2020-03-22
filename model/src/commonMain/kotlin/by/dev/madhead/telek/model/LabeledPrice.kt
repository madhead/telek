package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object represents a portion of the price for goods or services.
 */
@Serializable
@TelegramBotAPIType(type = "labeledprice")
data class LabeledPrice(
    @SerialName("label")
    val label: String,

    @SerialName("amount")
    val amount: Int
)
