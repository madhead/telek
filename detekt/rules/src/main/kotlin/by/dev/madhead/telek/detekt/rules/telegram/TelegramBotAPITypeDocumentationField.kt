package by.dev.madhead.telek.detekt.rules.telegram

/**
 * [Telegram Bot API type's][https://core.telegram.org/bots/api#available-types] fields descriptor.
 */
data class TelegramBotAPITypeDocumentationField(
    val name: String,
    val type: String,
    val description: String
)
