package by.dev.madhead.telek.model.communication

import by.dev.madhead.telek.model.ParseMode
import by.dev.madhead.telek.model.ReplyMarkup
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Request for [sendAudio][by.dev.madhead.telek.telek.Telek#sendAudio].
 */
@Serializable
data class SendAudioRequest(
    @SerialName("chat_id")
    val chatId: ChatId,

    @SerialName("audio")
    val audio: InputFile,

    @SerialName("caption")
    val caption: String? = null,

    @SerialName("parse_mode")
    val parseMode: ParseMode? = null,

    @SerialName("duration")
    val duration: Int? = null,

    @SerialName("performer")
    val performer: String? = null,

    @SerialName("title")
    val title: String? = null,

    @SerialName("thumb")
    val thumb: InputFile? = null,

    @SerialName("disable_notification")
    val disableNotification: Boolean? = null,

    @SerialName("reply_to_message_id")
    val replyToMessageId: Int? = null,

    @SerialName("reply_markup")
    val replyMarkup: ReplyMarkup? = null
)
