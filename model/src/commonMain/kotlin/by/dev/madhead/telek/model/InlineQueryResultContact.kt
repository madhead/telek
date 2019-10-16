package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName

@TelegramBotAPIType(type = "inlinequeryresultcontact")
data class InlineQueryResultContact(
    @SerialName("type")
    val type: String,

    @SerialName("id")
    val id: String,

    @SerialName("phone_number")
    val phoneNumber: String,

    @SerialName("first_name")
    val firstName: String,

    @SerialName("last_name")
    val lastName: String,

    @SerialName("vcard")
    val vcard: String,

    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup,

    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent,

    @SerialName("thumb_url")
    val thumbUrl: String,

    @SerialName("thumb_width")
    val thumbWidth: Int,

    @SerialName("thumb_height")
    val thumbHeight: Int
) : InlineQueryResult
