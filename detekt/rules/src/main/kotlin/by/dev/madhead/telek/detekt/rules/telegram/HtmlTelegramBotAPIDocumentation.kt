package by.dev.madhead.telek.detekt.rules.telegram

import org.jsoup.nodes.Document

/**
 * [Telegram Bot API][TelegramBotAPITypeDocumentation] documentation provider who is able to parse
 * [the official HTML documentation][https://core.telegram.org/bots/api].
 */
interface HtmlTelegramBotAPIDocumentation : TelegramBotAPIDocumentation {
    val dom: Document

    @Suppress("ThrowsCount", "ReturnCount")
    override fun forType(type: String?): TelegramBotAPITypeDocumentation? {
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
