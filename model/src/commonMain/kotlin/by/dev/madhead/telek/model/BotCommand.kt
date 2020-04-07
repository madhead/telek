package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object represents a bot command.
 */
@Serializable
@TelegramBotAPIType(type = "botcommand")
data class BotCommand(
    @SerialName("command")
    val command: String,

    @SerialName("description")
    val description: String
)
