package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramAPIType

@TelegramAPIType(anchor = "user")
data class User(
    val id: String
)
