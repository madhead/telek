package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName

/**
 * This object represents a Telegram user or bot.
 */
@TelegramBotAPIType(type = "user")
data class User(
    @SerialName("id")
    val id: Int,

    @SerialName("is_bot")
    val isBot: Boolean,

    @SerialName("first_name")
    val firstName: String,

    @SerialName("last_name")
    val lastName: String? = null,

    @SerialName("username")
    val username: String? = null,

    @SerialName("language_code")
    val languageCode: String? = null
)
