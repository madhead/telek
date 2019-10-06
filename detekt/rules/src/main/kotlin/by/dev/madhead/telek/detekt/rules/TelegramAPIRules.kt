package by.dev.madhead.telek.detekt.rules

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.RuleSet
import io.gitlab.arturbosch.detekt.api.RuleSetProvider

class TelegramAPIRules : RuleSetProvider {
    override val ruleSetId: String = "telegram-api"

    override fun instance(config: Config): RuleSet = RuleSet(
        ruleSetId,
        listOf(
            TelegramAPIFields(config)
        )
    )
}
