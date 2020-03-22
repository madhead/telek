package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object represents an answer of a user in a non-anonymous poll.
 */
@Serializable
@TelegramBotAPIType(type = "pollanswer")
data class PollAnswer(
    @SerialName("poll_id")
    val pollId: String,

    @SerialName("user")
    val user: User,

    @SerialName("option_ids")
    val optionIds: List<Int>
)
