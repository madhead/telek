package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a link to an MP3 audio file stored on the Telegram servers.
 * By default, this audio file will be sent by the user.
 * Alternatively, you can use _input_message_content_ to send a message with the specified content instead of the audio.
 */
@Serializable
@TelegramBotAPIType(type = "inlinequeryresultcachedaudio")
data class InlineQueryResultCachedAudio(
    @SerialName("type")
    val type: String,

    @SerialName("id")
    val id: String,

    @SerialName("audio_file_id")
    val audioFileId: String,

    @SerialName("caption")
    val caption: String? = null,

    @SerialName("parse_mode")
    val parseMode: String? = null,

    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,

    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent? = null
) : InlineQueryResult
