package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object contains information about one answer option in a poll.
 */
@Serializable
@TelegramBotAPIType(type = "polloption")
data class PollOption(
    @SerialName("text")
    val text: String,

    @SerialName("voter_count")
    val voterCount: Int
)
