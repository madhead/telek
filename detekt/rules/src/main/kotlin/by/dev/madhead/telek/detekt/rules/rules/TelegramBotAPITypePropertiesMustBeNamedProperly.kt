package by.dev.madhead.telek.detekt.rules.rules

import by.dev.madhead.telek.detekt.rules.telegram.DefaultHtmlTelegramBotAPIDocumentation
import by.dev.madhead.telek.detekt.rules.telegram.TelegramBotAPIDocumentation
import io.gitlab.arturbosch.detekt.api.CodeSmell
import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.Debt
import io.gitlab.arturbosch.detekt.api.Entity
import io.gitlab.arturbosch.detekt.api.Issue
import io.gitlab.arturbosch.detekt.api.Rule
import io.gitlab.arturbosch.detekt.api.Severity
import org.jetbrains.kotlin.psi.KtClass

/**
 * Checks that Telegram Bot API types are named properly.
 */
class TelegramBotAPITypePropertiesMustBeNamedProperly(
    config: Config = Config.empty,
    private val telegramBotAPIDocumentation: TelegramBotAPIDocumentation = DefaultHtmlTelegramBotAPIDocumentation
) : Rule(config) {
    override val issue: Issue
        get() = Issue(
            javaClass.simpleName,
            Severity.Style,
            "Telegram Bot API types must be named properly.",
            Debt.FIVE_MINS
        )

    override fun visitClass(klass: KtClass) {
        super.visitClass(klass)

        if (klass.isTelegramBotAPIType()) {
            telegramBotAPIDocumentation.forType(klass.telegramBotAPIType)?.let { _ ->
                klass
                    .primaryConstructorParameters
                    .forEach { parameter ->
                        println(parameter.docComment)
                    }
            } ?: report(
                CodeSmell(
                    issue,
                    Entity.from(klass),
                    "Telegram Bot API documentation for ${klass.name} is not found."
                )
            )
        }
    }
}
