package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName

@TelegramBotAPIType(type = "inlinequery")
data class InlineQuery(
    @SerialName("id")
    val id: String,

    @SerialName("from")
    val from: User,

    @SerialName("location")
    val location: Location,

    @SerialName("query")
    val query: String,

    @SerialName("offset")
    val offset: String
)
