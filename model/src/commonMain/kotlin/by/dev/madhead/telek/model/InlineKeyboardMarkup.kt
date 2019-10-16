package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName

@TelegramBotAPIType(type = "inlinekeyboardmarkup")
data class InlineKeyboardMarkup(
    @SerialName("inline_keyboard")
    val inlineKeyboard: List<List<InlineKeyboardButton>>
)
