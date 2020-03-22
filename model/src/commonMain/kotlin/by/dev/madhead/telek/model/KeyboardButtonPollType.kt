package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object represents type of a poll, which is allowed to be created and sent when the corresponding button is pressed.
 */
@Serializable
@TelegramBotAPIType(type = "keyboardbuttonpolltype")
data class KeyboardButtonPollType(
    @SerialName("type")
    val text: String? = null
)
