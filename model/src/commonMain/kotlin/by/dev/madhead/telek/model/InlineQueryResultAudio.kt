package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName

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
    val caption: String,

    @SerialName("parse_mode")
    val parseMode: String,

    @SerialName("performer")
    val performer: String,

    @SerialName("audio_duration")
    val audioDuration: Int,

    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup,

    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent
) : InlineQueryResult
