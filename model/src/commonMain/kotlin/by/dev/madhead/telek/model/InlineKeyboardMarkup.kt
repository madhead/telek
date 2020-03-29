package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object represents an [inline keyboard][https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating] that appears right
 * next to the message it belongs to.
 */
@Serializable
@TelegramBotAPIType(type = "inlinekeyboardmarkup")
data class InlineKeyboardMarkup(
    @SerialName("inline_keyboard")
    val inlineKeyboard: List<List<InlineKeyboardButton>>
) : ReplyMarkup
