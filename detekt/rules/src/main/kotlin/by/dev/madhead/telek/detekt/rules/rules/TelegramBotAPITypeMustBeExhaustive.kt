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
 * Checks that class's properties match Telegram Bot API type's fields.
 */
class TelegramBotAPITypeMustBeExhaustive(
    config: Config = Config.empty,
    private val telegramBotAPIDocumentation: TelegramBotAPIDocumentation = DefaultHtmlTelegramBotAPIDocumentation
) : Rule(config) {
    override val issue: Issue
        get() = Issue(
            javaClass.simpleName,
            Severity.Defect,
            "Class properties should match Telegram Bot API documentation.",
            Debt.TEN_MINS
        )

    override fun visitClass(klass: KtClass) {
        super.visitClass(klass)

        if (klass.isTelegramBotAPIType()) {
            telegramBotAPIDocumentation.forType(klass.telegramBotAPIType)?.let { documentation ->
                val properties = klass
                    .primaryConstructorParameters
                    .map {
                        it.name to it.serialName
                    }

                properties
                    .filter { (_, jsonName) ->
                        jsonName !in documentation.fields.map { it.name }
                    }
                    .forEach { (name, jsonName) ->
                        report(
                            CodeSmell(
                                issue,
                                Entity.from(klass),
                                "Property [$name] (JSON name: [$jsonName]) is not declared in the Telegram Bot API documentation."
                            )
                        )
                    }
                documentation
                    .fields
                    .filter { field ->
                        field.name !in properties.map { it.second }
                    }
                    .forEach { field ->
                        report(
                            CodeSmell(
                                issue,
                                Entity.from(klass),
                                "Field [${field.name}] does not have a corresponding property in the data class."
                            )
                        )
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
