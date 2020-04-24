package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object represents a dice with random value from 1 to 6.
 * (Yes, we're aware of the *“proper”* singular of *die*. But it's awkward, and we decided to help it change. One dice at a time!)
 */
@Serializable
@TelegramBotAPIType(type = "dice")
data class Dice(
    @SerialName("emoji")
    val emoji: String,

    @SerialName("value")
    val value: Int
)
