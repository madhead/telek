package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a link to a sticker stored on the Telegram servers.
 * By default, this sticker will be sent by the user.
 * Alternatively, you can use _input_message_content_ to send a message with the specified content instead of the sticker.
 */
@Serializable
@TelegramBotAPIType(type = "inlinequeryresultcachedsticker")
data class InlineQueryResultCachedSticker(
    @SerialName("type")
    val type: String,

    @SerialName("id")
    val id: String,

    @SerialName("sticker_file_id")
    val stickerFileId: String,

    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,

    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent? = null
) : InlineQueryResult
