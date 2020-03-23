package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a link to an MP3 audio file.
 * By default, this audio file will be sent by the user.
 * Alternatively, you can use _input_message_content_ to send a message with the specified content instead of the audio.
 */
@Serializable
@TelegramBotAPIType(type = "inlinequeryresultaudio")
data class InlineQueryResultAudio(
    @SerialName("type")
    val type: String,

    @SerialName("id")
    val id: String,

    @SerialName("audio_url")
    val audioUrl: String,

    @SerialName("title")
    val title: String,

    @SerialName("caption")
    val caption: String? = null,

    @SerialName("parse_mode")
    val parseMode: ParseMode? = null,

    @SerialName("performer")
    val performer: String? = null,

    @SerialName("audio_duration")
    val audioDuration: Int? = null,

    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,

    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent? = null
) : InlineQueryResult
