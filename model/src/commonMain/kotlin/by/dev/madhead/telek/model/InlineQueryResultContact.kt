package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a contact with a phone number.
 * By default, this contact will be sent by the user.
 * Alternatively, you can use _input_message_content_ to send a message with the specified content instead of the contact.
 */
@Serializable
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
    val lastName: String? = null,

    @SerialName("vcard")
    val vcard: String? = null,

    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,

    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent? = null,

    @SerialName("thumb_url")
    val thumbUrl: String? = null,

    @SerialName("thumb_width")
    val thumbWidth: Int? = null,

    @SerialName("thumb_height")
    val thumbHeight: Int? = null
) : InlineQueryResult
