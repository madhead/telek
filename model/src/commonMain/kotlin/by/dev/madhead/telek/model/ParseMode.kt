package by.dev.madhead.telek.model

import kotlinx.serialization.Serializable

/**
 * The Bot API supports basic formatting for messages.
 * You can use bold, italic, underlined and strikethrough text, as well as inline links and pre-formatted code in your bots' messages.
 * Telegram clients will render them accordingly.
 * You can use either markdown-style or HTML-style formatting.
 */
@Serializable
enum class ParseMode {
    MarkdownV2,
    HTML,
    Markdown,
}
