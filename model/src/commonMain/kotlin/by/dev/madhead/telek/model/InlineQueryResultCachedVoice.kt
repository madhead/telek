package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a link to a voice message stored on the Telegram servers.
 * By default, this voice message will be sent by the user.
 * Alternatively, you can use _input_message_content_ to send a message with the specified content instead of the voice message.
 */
@Serializable
@TelegramBotAPIType(type = "inlinequeryresultcachedvoice")
data class InlineQueryResultCachedVoice(
    @SerialName("type")
    val type: String,

    @SerialName("id")
    val id: String,

    @SerialName("voice_file_id")
    val voiceFileId: String,

    @SerialName("title")
    val title: String,

    @SerialName("caption")
    val caption: String? = null,

    @SerialName("parse_mode")
    val parseMode: String? = null,

    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,

    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent? = null
) : InlineQueryResult
