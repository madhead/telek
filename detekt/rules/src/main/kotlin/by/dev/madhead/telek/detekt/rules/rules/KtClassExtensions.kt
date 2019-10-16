package by.dev.madhead.telek.detekt.rules.rules

import org.jetbrains.kotlin.psi.KtClass

internal fun KtClass.isTelegramBotAPIType(): Boolean = annotationEntries
    .any {
        "TelegramBotAPIType" == it?.shortName?.asString()
    }
