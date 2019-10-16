package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Contains data required for decrypting and authenticating [EncryptedPassportElement]. See the
 * [Telegram Passport Documentation][https://core.telegram.org/passport#receiving-information] for a complete description of the data
 * decryption and authentication processes.
 */
@Serializable
@TelegramBotAPIType(type = "encryptedcredentials")
data class EncryptedCredentials(
    @SerialName("data")
    val data: String,

    @SerialName("hash")
    val hash: String,

    @SerialName("secret")
    val secret: String
)
