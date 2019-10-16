package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object represents one special entity in a text message.
 * For example, hashtags, usernames, URLs, etc.
 */
@Serializable
@TelegramBotAPIType(type = "messageentity")
data class MessageEntity(
    @SerialName("type")
    val type: String,

    @SerialName("offset")
    val offset: Int,

    @SerialName("length")
    val length: Int,

    @SerialName("url")
    val url: String? = null,

    @SerialName("user")
    val user: User? = null,

    @SerialName("language")
    val language: String? = null
)
