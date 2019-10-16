package by.dev.madhead.telek.detekt.rules.telegram

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.net.URL

/**
 * Default [TelegramBotAPIDocumentation] implementation. Parses the documentation directly from
 * [the Telegram Bot API page][https://core.telegram.org/bots/api].
 */
object DefaultHtmlTelegramBotAPIDocumentation : HtmlTelegramBotAPIDocumentation {
    private const val TIMEOUT = 10_000

    override val dom: Document by lazy {
        Jsoup.parse(
            URL("https://core.telegram.org/bots/api"),
            TIMEOUT
        )
    }
}
