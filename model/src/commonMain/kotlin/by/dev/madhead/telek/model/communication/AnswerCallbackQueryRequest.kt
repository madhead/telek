package by.dev.madhead.telek.model.communication

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Request for [answerCallbackQuery][by.dev.madhead.telek.telek.Telek#answerCallbackQuery].
 */
@Serializable
data class AnswerCallbackQueryRequest(
    @SerialName("callback_query_id")
    val callbackQueryId: String,

    @SerialName("text")
    val text: String? = null,

    @SerialName("show_alert")
    val showAlert: Boolean = false,

    @SerialName("url")
    val url: String? = null,

    @SerialName("cache_time")
    val cacheTime: Int = 0
)
