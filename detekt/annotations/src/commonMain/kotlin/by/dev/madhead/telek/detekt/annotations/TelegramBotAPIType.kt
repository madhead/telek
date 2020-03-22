package by.dev.madhead.telek.detekt.annotations

/**
 * Mark [Telegram Bot API types][https://core.telegram.org/bots/api#available-types] with [TelegramBotAPIType] to enable validity checks:
 * - Types must be data classes
 * - Data classes must be serializable
 * - Class names must correspond to the API documentation
 * - Property names must correspond to the API documentation
 * - Class properties and fields the API documentation must match
 * - Optional fields the API documentation must be nullable with default `null` value
 */
@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.CLASS)
annotation class TelegramBotAPIType(
    val type: String
)
