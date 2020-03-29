package by.dev.madhead.telek.model.communication

import by.dev.madhead.telek.model.ParseMode
import by.dev.madhead.telek.model.ReplyMarkup
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Request for [sendMessage][by.dev.madhead.telek.telek.Telek#sendMessage].
 */
@Serializable
data class SendMessageRequest(
    @SerialName("chat_id")
    val chatId: ChatId,

    @SerialName("text")
    val text: String,

    @SerialName("parse_mode")
    val parseMode: ParseMode? = null,

    @SerialName("disable_web_page_preview")
    val disableWebPagePreview: Boolean? = null,

    @SerialName("disable_notification")
    val disableNotification: Boolean? = null,

    @SerialName("reply_to_message_id")
    val replyToMessageId: Int? = null,

    @SerialName("reply_markup")
    val replyMarkup: ReplyMarkup? = null
)
