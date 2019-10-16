package by.dev.madhead.telek.detekt.rules.rules

import by.dev.madhead.telek.detekt.rules.telegram.TelegramBotAPIPage
import by.dev.madhead.telek.detekt.rules.telegram.TelegramBotAPITypeDocumentation
import io.gitlab.arturbosch.detekt.api.CodeSmell
import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.Debt
import io.gitlab.arturbosch.detekt.api.Entity
import io.gitlab.arturbosch.detekt.api.Issue
import io.gitlab.arturbosch.detekt.api.Rule
import io.gitlab.arturbosch.detekt.api.Severity
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.KtStringTemplateExpression
import org.jetbrains.kotlin.psi.psiUtil.plainContent

/**
 * Checks that class's properties match Telegram Bot API type's fields.
 */
class TelegramBotAPITypeMustBeExhaustive(config: Config = Config.empty) : Rule(config) {
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
            loadDocumentation(klass)?.let { documentation ->
                val properties = klass
                    .primaryConstructorParameters
                    .map { property ->
                        val name = property.name
                        val jsonName = (property
                            .annotationEntries
                            .find { "SerialName" == it?.shortName?.asString() }
                            ?.valueArguments?.get(0)?.getArgumentExpression() as? KtStringTemplateExpression
                            )
                            ?.plainContent

                        name to jsonName
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
                    "Telegram Bot API documentation for [${klass.name}] is not found."
                )
            )
        }
    }

    @Suppress("ThrowsCount")
    private fun loadDocumentation(klass: KtClass): TelegramBotAPITypeDocumentation? {
        val annotation = klass
            .annotationEntries
            .find {
                "TelegramBotAPIType" == it?.shortName?.asString()
            }
        val type = (annotation
            ?.valueArguments
            ?.find {
                it.getArgumentName()?.asName?.asString() == "type"
            }
            ?.getArgumentExpression() as? KtStringTemplateExpression)
            ?.takeUnless { it.hasInterpolation() }
            ?.plainContent

        return TelegramBotAPIPage.typeDocumentation(type)
    }
}
