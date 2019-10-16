package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName

/**
 * Represents a [result][https://core.telegram.org/bots/api#inlinequeryresult] of an inline query that was chosen by the user and sent to
 * their chat partner.
 */
@TelegramBotAPIType(type = "choseninlineresult")
data class ChosenInlineResult(
    @SerialName("result_id")
    val resultId: String,

    @SerialName("from")
    val from: User,

    @SerialName("location")
    val location: Location,

    @SerialName("inline_message_id")
    val inlineMessageId: String,

    @SerialName("query")
    val query: String
)
