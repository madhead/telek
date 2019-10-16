package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object represents one button of the reply keyboard. For simple text buttons String can be used instead of this object to specify
 * text of the button. Optional fields [request_contact][requestContact], [request_location][requestLocation], and
 * [request_poll][requestPoll] are mutually exclusive.
 */
@Serializable
@TelegramBotAPIType(type = "keyboardbutton")
data class KeyboardButton(
    @SerialName("text")
    val text: String,

    @SerialName("request_contact")
    val requestContact: Boolean? = null,

    @SerialName("request_location")
    val requestLocation: Boolean? = null,

    @SerialName("request_poll")
    val requestPoll: KeyboardButtonPollType? = null
)
