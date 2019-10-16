package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object represents one shipping option.
 */
@Serializable
@TelegramBotAPIType(type = "shippingoption")
data class ShippingOption(
    @SerialName("id")
    val id: String,

    @SerialName("title")
    val title: String,

    @SerialName("prices")
    val prices: List<LabeledPrice>
)
