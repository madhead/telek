package by.dev.madhead.telek.model.communication

import by.dev.madhead.telek.model.ReplyMarkup
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Request for [sendVideoNote][by.dev.madhead.telek.telek.Telek#sendVideoNote].
 */
@Serializable
data class SendVideoNoteRequest(
    @SerialName("chat_id")
    val chatId: ChatId,

    @SerialName("video_note")
    val videoNote: InputFile,

    @SerialName("duration")
    val duration: Int? = null,

    @SerialName("length")
    val length: Int? = null,

    @SerialName("thumb")
    val thumb: InputFile? = null,

    @SerialName("disable_notification")
    val disableNotification: Boolean? = null,

    @SerialName("reply_to_message_id")
    val replyToMessageId: Int? = null,

    @SerialName("reply_markup")
    val replyMarkup: ReplyMarkup? = null
)
