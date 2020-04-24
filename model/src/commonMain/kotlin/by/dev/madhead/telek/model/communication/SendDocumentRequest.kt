package by.dev.madhead.telek.model.communication

import by.dev.madhead.telek.model.ParseMode
import by.dev.madhead.telek.model.ReplyMarkup
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Request for [sendDocument][by.dev.madhead.telek.telek.Telek#sendDocument].
 */
@Serializable
data class SendDocumentRequest(
    @SerialName("chat_id")
    val chatId: ChatId,

    @SerialName("document")
    val document: InputFile,

    @SerialName("thumb")
    val thumb: InputFile? = null,

    @SerialName("caption")
    val caption: String? = null,

    @SerialName("parse_mode")
    val parseMode: ParseMode? = null,

    @SerialName("disable_notification")
    val disableNotification: Boolean? = null,

    @SerialName("reply_to_message_id")
    val replyToMessageId: Int? = null,

    @SerialName("reply_markup")
    val replyMarkup: ReplyMarkup? = null
)
