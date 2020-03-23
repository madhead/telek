package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the [content][InputMessageContent] of a text message to be sent as the result of an inline query.
 */
@Serializable
@TelegramBotAPIType(type = "inputtextmessagecontent")
data class InputTextMessageContent(
    @SerialName("message_text")
    val messageText: String,

    @SerialName("parse_mode")
    val parseMode: ParseMode? = null,

    @SerialName("disable_web_page_preview")
    val disableWebPagePreview: Boolean? = null
)
