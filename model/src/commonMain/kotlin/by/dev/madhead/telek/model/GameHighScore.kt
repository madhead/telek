package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName

@TelegramBotAPIType(type = "gamehighscore")
data class GameHighScore(
    @SerialName("position")
    val position: Int,

    @SerialName("user")
    val user: User,

    @SerialName("score")
    val score: Int
)
