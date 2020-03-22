package by.dev.madhead.telek.detekt.rules.rules

import by.dev.madhead.telek.detekt.rules.telegram.DefaultHtmlTelegramBotAPIDocumentation
import by.dev.madhead.telek.detekt.rules.telegram.TelegramBotAPIDocumentation
import by.dev.madhead.telek.detekt.rules.telegram.TelegramBotAPITypeDocumentation
import by.dev.madhead.telek.detekt.rules.telegram.isOptional
import io.gitlab.arturbosch.detekt.api.CodeSmell
import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.Debt
import io.gitlab.arturbosch.detekt.api.Entity
import io.gitlab.arturbosch.detekt.api.Issue
import io.gitlab.arturbosch.detekt.api.Rule
import io.gitlab.arturbosch.detekt.api.Severity
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.KtNullableType
import org.jetbrains.kotlin.psi.KtParameter

/**
 * Checks that Telegram Bot API type's properties have correct nullability according to the "Optional" markers from the documentation.
 */
class TelegramBotAPITypePropertiesMustHaveCorrectNullability(
    config: Config = Config.empty,
    private val telegramBotAPIDocumentation: TelegramBotAPIDocumentation = DefaultHtmlTelegramBotAPIDocumentation
) : Rule(config) {
    override val issue: Issue
        get() = Issue(
            javaClass.simpleName,
            Severity.Defect,
            "Telegram Bot API type's properties must have correct nullability.",
            Debt.FIVE_MINS
        )

    override fun visitClass(klass: KtClass) {
        super.visitClass(klass)

        if (klass.isTelegramBotAPIType()) {
            telegramBotAPIDocumentation.forType(klass.telegramBotAPIType)?.let { documentation ->
                klass
                    .primaryConstructorParameters
                    .forEach { parameter ->
                        checkParameterNullability(klass, parameter, documentation)
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

    private fun checkParameterNullability(klass: KtClass, parameter: KtParameter, documentation: TelegramBotAPITypeDocumentation) {
        parameter.serialName?.let { serialName ->
            documentation.fields.find { it.name == serialName }?.let { field ->
                val mustBeOptional = field.isOptional
                val optional = parameter.typeReference?.typeElement is KtNullableType

                if (mustBeOptional && !optional) {
                    report(
                        CodeSmell(
                            issue,
                            Entity.from(klass),
                            "${parameter.name} must be nullable."
                        )
                    )
                }
                if (mustBeOptional && optional && !parameter.hasDefaultValue()) {
                    report(
                        CodeSmell(
                            issue,
                            Entity.from(klass),
                            "${parameter.name} must have a default value."
                        )
                    )
                }
                if (!mustBeOptional && optional) {
                    report(
                        CodeSmell(
                            issue,
                            Entity.from(klass),
                            "${parameter.name} must not be nullable."
                        )
                    )
                }
            }
        }
    }
}
