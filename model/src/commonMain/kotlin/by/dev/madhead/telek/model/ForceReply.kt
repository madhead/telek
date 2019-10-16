package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName

@TelegramBotAPIType(type = "forcereply")
data class ForceReply(
    @SerialName("force_reply")
    val forceReply: Boolean? = true,

    @SerialName("selective")
    val selective: Boolean? = null
)
