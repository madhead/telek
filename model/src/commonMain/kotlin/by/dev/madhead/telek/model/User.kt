package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName

@TelegramBotAPIType(type = "user")
data class User(
    @SerialName("id")
    val id: String,

    @SerialName("is_bot")
    val isBot: Boolean
)
