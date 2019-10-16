package by.dev.madhead.telek.detekt.rules.telegram

/**
 * [Telegram Bot API type's][https://core.telegram.org/bots/api#available-types] field descriptor.
 */
data class TelegramBotAPITypeDocumentationField(
    val name: String,
    val type: String,
    val description: String
)

val TelegramBotAPITypeDocumentationField.isOptional: Boolean
    get() = description.startsWith("Optional.")
