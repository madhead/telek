package by.dev.madhead.telek.detekt.rules.telegram

/**
 * [Telegram Bot API type's][https://core.telegram.org/bots/api#available-types] descriptor.
 */
data class TelegramBotAPITypeDocumentation(
    val name: String,
    val fields: List<TelegramBotAPITypeDocumentationField>
)
