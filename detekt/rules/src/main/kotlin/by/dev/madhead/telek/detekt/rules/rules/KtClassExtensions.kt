package by.dev.madhead.telek.detekt.rules.rules

import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.KtStringTemplateExpression
import org.jetbrains.kotlin.psi.psiUtil.plainContent
import org.jetbrains.kotlin.utils.addToStdlib.safeAs

internal fun KtClass.isTelegramBotAPIType(): Boolean = annotationEntries
    .any {
        "TelegramBotAPIType" == it?.shortName?.asString()
    }

internal fun KtClass.isSerializable(): Boolean = annotationEntries
    .any {
        "Serializable" == it?.shortName?.asString()
    }

internal val KtClass.telegramBotAPIType: String?
    get() = annotationEntries
        .find {
            "TelegramBotAPIType" == it?.shortName?.asString()
        }
        ?.valueArguments
        ?.find {
            it.getArgumentName()?.asName?.asString() == "type"
        }
        ?.getArgumentExpression()
        ?.safeAs<KtStringTemplateExpression>()
        ?.takeUnless { it.hasInterpolation() }
        ?.plainContent
