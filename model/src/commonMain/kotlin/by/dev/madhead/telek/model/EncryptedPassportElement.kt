package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Contains information about documents or other Telegram Passport elements shared with the bot by the user.
 */
@Serializable
@TelegramBotAPIType(type = "encryptedpassportelement")
data class EncryptedPassportElement(
    @SerialName("type")
    val type: String,

    @SerialName("data")
    val data: String? = null,

    @SerialName("phone_number")
    val phoneNumber: String? = null,

    @SerialName("email")
    val email: String? = null,

    @SerialName("files")
    val files: List<PassportFile>? = null,

    @SerialName("front_side")
    val frontSide: PassportFile? = null,

    @SerialName("reverse_side")
    val reverseSide: PassportFile? = null,

    @SerialName("selfie")
    val selfie: PassportFile? = null,

    @SerialName("translation")
    val translation: List<PassportFile>? = null,

    @SerialName("hash")
    val hash: String
)
