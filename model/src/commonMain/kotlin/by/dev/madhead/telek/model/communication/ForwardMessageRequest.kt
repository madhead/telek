package by.dev.madhead.telek.model.communication

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Request for [forwardMessage][by.dev.madhead.telek.telek.Telek#forwardMessage].
 */
@Serializable
data class ForwardMessageRequest(
    @SerialName("chat_id")
    val chatId: ChatId,

    @SerialName("from_chat_id")
    val fromChatId: ChatId,

    @SerialName("disable_notification")
    val disableNotification: Boolean? = null,

    @SerialName("message_id")
    val messageId: Int
)
