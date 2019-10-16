package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object represents an incoming inline query.
 * When the user sends an empty query, your bot could return some default or trending results.
 */
@Serializable
@TelegramBotAPIType(type = "inlinequery")
data class InlineQuery(
    @SerialName("id")
    val id: String,

    @SerialName("from")
    val from: User,

    @SerialName("location")
    val location: Location? = null,

    @SerialName("query")
    val query: String,

    @SerialName("offset")
    val offset: String
)
