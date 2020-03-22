package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Contains information about Telegram Passport data shared with the bot by the user.
 */
@Serializable
@TelegramBotAPIType(type = "passportdata")
data class PassportData(
    @SerialName("data")
    val data: List<EncryptedPassportElement>,

    @SerialName("credentials")
    val credentials: EncryptedCredentials
)
