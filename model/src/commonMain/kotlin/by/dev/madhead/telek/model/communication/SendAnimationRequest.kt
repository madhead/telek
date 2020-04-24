package by.dev.madhead.telek.model.communication

import by.dev.madhead.telek.model.ParseMode
import by.dev.madhead.telek.model.ReplyMarkup
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Request for [sendAnimation][by.dev.madhead.telek.telek.Telek#sendAnimation].
 */
@Serializable
data class SendAnimationRequest(
    @SerialName("chat_id")
    val chatId: ChatId,

    @SerialName("animation")
    val animation: InputFile,

    @SerialName("duration")
    val duration: Int? = null,

    @SerialName("width")
    val width: Int? = null,

    @SerialName("height")
    val height: Int? = null,

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
