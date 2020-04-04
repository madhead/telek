package by.dev.madhead.telek.model.communication

import by.dev.madhead.telek.model.InlineKeyboardMarkup
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Request for [editMessageReplyMarkup][by.dev.madhead.telek.telek.Telek#editMessageReplyMarkup].
 */
@Serializable
data class EditMessageReplyMarkupRequest(
    @SerialName("chat_id")
    val chatId: ChatId? = null,

    @SerialName("message_id")
    val messageId: Int? = null,

    @SerialName("inline_message_id")
    val inlineMessageId: String? = null,

    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null
)
