package by.dev.madhead.telek.detekt.rules.rules

import org.jetbrains.kotlin.psi.KtParameter
import org.jetbrains.kotlin.psi.KtStringTemplateExpression
import org.jetbrains.kotlin.psi.psiUtil.plainContent
import org.jetbrains.kotlin.utils.addToStdlib.safeAs

internal val KtParameter.serialName: String?
    get() = annotationEntries
        .find { "SerialName" == it?.shortName?.asString() }
        ?.valueArguments
        ?.get(0)
        ?.getArgumentExpression()
        ?.safeAs<KtStringTemplateExpression>()
        ?.plainContent
