package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Contains information about why a request was unsuccessful.
 */
@Serializable
@TelegramBotAPIType(type = "responseparameters")
data class ResponseParameters(
    @SerialName("migrate_to_chat_id")
    val migrateToChatId: Int? = null,

    @SerialName("retry_after")
    val retryAfter: Int? = null
)
