package by.dev.madhead.telek.detekt.rules.rules

import io.gitlab.arturbosch.detekt.api.CodeSmell
import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.Debt
import io.gitlab.arturbosch.detekt.api.Entity
import io.gitlab.arturbosch.detekt.api.Issue
import io.gitlab.arturbosch.detekt.api.Rule
import io.gitlab.arturbosch.detekt.api.Severity
import org.jetbrains.kotlin.psi.KtClass

/**
 * Checks that Telegram Bot API types are data classes.
 */
class TelegramBotAPITypeMustBeADataClass(config: Config = Config.empty) : Rule(config) {
    override val issue: Issue
        get() = Issue(
            javaClass.simpleName,
            Severity.Defect,
            "Telegram Bot API types must be data classes.",
            Debt.FIVE_MINS
        )

    override fun visitClass(klass: KtClass) {
        super.visitClass(klass)

        if (klass.isTelegramBotAPIType() && !klass.isData()) {
            report(
                CodeSmell(
                    issue,
                    Entity.from(klass),
                    "${klass.name} must be a data class."
                )
            )
        }
    }
}
