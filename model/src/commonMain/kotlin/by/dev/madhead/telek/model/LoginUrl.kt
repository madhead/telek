package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object represents a parameter of the inline keyboard button used to automatically authorize a user.
 * Serves as a great replacement for the [Telegram Login Widget][https://core.telegram.org/widgets/login] when the user is coming from
 * Telegram. All the user needs to do is tap/click a button and confirm that they want to log in.
 */
@Serializable
@TelegramBotAPIType(type = "loginurl")
data class LoginUrl(
    @SerialName("url")
    val url: String,

    @SerialName("forward_text")
    val forwardText: String? = null,

    @SerialName("bot_username")
    val botUsername: String? = null,

    @SerialName("request_write_access")
    val requestWriteAccess: Boolean? = null
)
