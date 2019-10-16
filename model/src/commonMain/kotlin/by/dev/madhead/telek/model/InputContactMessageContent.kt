package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName

@TelegramBotAPIType(type = "inputcontactmessagecontent")
data class InputContactMessageContent(
    @SerialName("phone_number")
    val phoneNumber: String,

    @SerialName("first_name")
    val firstName: String,

    @SerialName("last_name")
    val lastName: String,

    @SerialName("vcard")
    val vcard: String
)
