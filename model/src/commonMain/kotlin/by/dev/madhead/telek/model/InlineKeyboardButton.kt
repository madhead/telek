package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object represents one button of an inline keyboard. You **must** use exactly one of the optional fields.
 */
@Serializable
@TelegramBotAPIType(type = "inlinekeyboardbutton")
data class InlineKeyboardButton(
    @SerialName("text")
    val text: String,

    @SerialName("url")
    val url: String? = null,

    @SerialName("login_url")
    val loginUrl: LoginUrl? = null,

    @SerialName("callback_data")
    val callbackData: String? = null,

    @SerialName("switch_inline_query")
    val switchInlineQuery: String? = null,

    @SerialName("switch_inline_query_current_chat")
    val switchInlineQueryCurrentChat: String? = null,

    @SerialName("callback_game")
    val callbackGame: CallbackGame? = null,

    @SerialName("pay")
    val pay: Boolean? = null
)
