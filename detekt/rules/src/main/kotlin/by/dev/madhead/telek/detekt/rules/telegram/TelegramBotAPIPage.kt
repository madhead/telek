package by.dev.madhead.telek.detekt.rules.telegram

import org.jsoup.Jsoup
import java.net.URL

/**
 * [Telegram Bot API][https://core.telegram.org/bots/api] documentation parser.
 */
object TelegramBotAPIPage {
    private const val TIMEOUT = 10_000

    private val dom by lazy {
        Jsoup.parse(
            URL("https://core.telegram.org/bots/api"),
            TIMEOUT
        )
    }

    @Suppress("ThrowsCount", "ReturnCount")
    fun typeDocumentation(type: String?): TelegramBotAPITypeDocumentation? {
        if (type == null) return null
        val anchor = dom.selectFirst("a[name='$type']") ?: return null
        val header = anchor.parent() ?: return null
        val fieldsTable = header.nextElementSiblings().first { it.tagName() == "table" } ?: return null

        return TelegramBotAPITypeDocumentation(
            header.text(),
            fieldsTable
                .select("tbody>tr")
                ?.map {
                    TelegramBotAPITypeDocumentationField(
                        name = it.select("td")?.get(0)?.text() ?: throw IllegalArgumentException("Unsupported documentation format"),
                        type = it.select("td")?.get(1)?.text() ?: throw IllegalArgumentException("Unsupported documentation format"),
                        description = it.select("td")?.get(2)?.text() ?: throw IllegalArgumentException("Unsupported documentation format")
                    )
                } ?: emptyList()
        )
    }
}
