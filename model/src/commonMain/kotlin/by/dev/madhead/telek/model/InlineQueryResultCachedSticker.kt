package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName

@TelegramBotAPIType(type = "inlinequeryresultcachedsticker")
data class InlineQueryResultCachedSticker(
    @SerialName("type")
    val type: String,

    @SerialName("id")
    val id: String,

    @SerialName("sticker_file_id")
    val stickerFileId: String,

    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup,

    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent
) : InlineQueryResult
