package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the content of a [contact][InputMessageContent] message to be sent as the result of an inline query.
 */
@Serializable
@TelegramBotAPIType(type = "inputcontactmessagecontent")
data class InputContactMessageContent(
    @SerialName("phone_number")
    val phoneNumber: String,

    @SerialName("first_name")
    val firstName: String,

    @SerialName("last_name")
    val lastName: String? = null,

    @SerialName("vcard")
    val vcard: String? = null
)
