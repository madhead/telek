package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName

@TelegramBotAPIType(type = "encryptedcredentials")
class EncryptedCredentials(
    @SerialName("data")
    val data: String,

    @SerialName("hash")
    val hash: String,

    @SerialName("secret")
    val secret: String
)
