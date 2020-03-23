package by.dev.madhead.telek.model.communication

import by.dev.madhead.telek.model.ParseMode
import by.dev.madhead.telek.model.ReplyMarkup
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Request for [sendPhoto][by.dev.madhead.telek.telek.Telek#sendPhoto].
 */
@Serializable
data class SendPhotoRequest(
    @SerialName("chat_id")
    val chatId: ChatId,

    @SerialName("photo")
    val photo: InputFile,

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
