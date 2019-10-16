package by.dev.madhead.telek.detekt.annotations

/**
 * Mark [Telegram Bot API types][https://core.telegram.org/bots/api#available-types] with [TelegramBotAPIType] to enable validity checks:
 * - Telegram Bot API types must be data classes
 * - Data class properties must match declared Telegram Bot API type's fields
 */
@Retention(AnnotationRetention.SOURCE)
annotation class TelegramBotAPIType(
    val type: String
)
