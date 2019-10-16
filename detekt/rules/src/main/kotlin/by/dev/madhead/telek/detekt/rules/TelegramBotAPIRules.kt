package by.dev.madhead.telek.detekt.rules

import by.dev.madhead.telek.detekt.rules.rules.TelegramBotAPITypeMustBeADataClass
import by.dev.madhead.telek.detekt.rules.rules.TelegramBotAPITypeMustBeExhaustive
import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.RuleSet
import io.gitlab.arturbosch.detekt.api.RuleSetProvider

/**
 * [Telegram Bot API][https://core.telegram.org/bots/api] rules.
 */
class TelegramBotAPIRules : RuleSetProvider {
    override val ruleSetId: String = "telegram-bot-api"

    override fun instance(config: Config): RuleSet = RuleSet(
        ruleSetId,
        listOf(
            TelegramBotAPITypeMustBeADataClass(config),
            TelegramBotAPITypeMustBeExhaustive(config)
        )
    )
}
