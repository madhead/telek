package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object represents a phone contact.
 */
@Serializable
@TelegramBotAPIType(type = "contact")
data class Contact(
    @SerialName("phone_number")
    val phoneNumber: String,

    @SerialName("first_name")
    val firstName: String,

    @SerialName("last_name")
    val lastName: String? = null,

    @SerialName("user_id")
    val userId: Int? = null,

    @SerialName("vcard")
    val vcard: String? = null
)
