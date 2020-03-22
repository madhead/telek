package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Upon receiving a message with this object, Telegram clients will display a reply interface to the user (act as if the user has selected
 * the bot‘s message and tapped ’Reply'). This can be extremely useful if you want to create user-friendly step-by-step interfaces without
 * having to sacrifice [privacy mode][https://core.telegram.org/bots#privacy-mode].
 */
@Serializable
@TelegramBotAPIType(type = "forcereply")
data class ForceReply(
    @SerialName("force_reply")
    val forceReply: Boolean = true,

    @SerialName("selective")
    val selective: Boolean? = null
)
