package by.dev.madhead.telek.detekt.rules.telegram

/**
 * [Telegram Bot API][TelegramBotAPITypeDocumentation] documentation provider.
 */
interface TelegramBotAPIDocumentation {
    /**
     * Retrieve the documentation about the [type] from [the Telegram Bot API page][https://core.telegram.org/bots/api].
     */
    fun forType(type: String?): TelegramBotAPITypeDocumentation?
}
