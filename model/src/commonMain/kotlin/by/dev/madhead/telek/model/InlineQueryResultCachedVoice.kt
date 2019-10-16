package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName

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
    val caption: String,

    @SerialName("parse_mode")
    val parseMode: String,

    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup,

    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent
) : InlineQueryResult
