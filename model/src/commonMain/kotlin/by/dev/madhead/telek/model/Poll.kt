package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object contains information about a poll.
 */
@Serializable
@TelegramBotAPIType(type = "poll")
data class Poll(
    @SerialName("id")
    val id: String,

    @SerialName("question")
    val question: String,

    @SerialName("options")
    val options: List<PollOption>,

    @SerialName("total_voter_count")
    val totalVoterCount: Int,

    @SerialName("is_closed")
    val isClosed: Boolean,

    @SerialName("is_anonymous")
    val isAnonymous: Boolean,

    @SerialName("type")
    val type: String,

    @SerialName("allows_multiple_answers")
    val allowsMultipleAnswers: Boolean,

    @SerialName("correct_option_id")
    val correctOptionId: Int? = null,

    @SerialName("explanation")
    val explanation: String? = null,

    @SerialName("explanation_entities")
    val explanationEntities: List<MessageEntity>? = null,

    @SerialName("open_period")
    val openPeriod: Int? = null,

    @SerialName("close_date")
    val closeDate: Int? = null
)
