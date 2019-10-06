package by.dev.madhead.telek.detekt.rules

import io.gitlab.arturbosch.detekt.api.*
import org.jetbrains.kotlin.psi.KtClass

const val DESCRIPTION = "Class properties should match Telegram API documentation"
const val MESSAGE = "Message"

class TelegramAPIFields(config: Config = Config.empty) : Rule(config) {
    override val issue: Issue
        get() = Issue(
            javaClass.simpleName,
            Severity.Defect,
            DESCRIPTION,
            Debt.TEN_MINS
        )

    override fun visitClass(klass: KtClass) {
        super.visitClass(klass)

        if (isTelegramAPIType(klass)) {
            report(
                CodeSmell(
                    issue,
                    Entity.from(klass),
                    MESSAGE
                )
            )
        }
    }

    private fun isTelegramAPIType(klass: KtClass): Boolean {
        return klass
            .annotationEntries
            .any {
                "TelegramAPIType" == it?.shortName?.asString()
            }
    }
}
