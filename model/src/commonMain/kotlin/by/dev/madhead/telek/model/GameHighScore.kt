package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object represents one row of the high scores table for a game.
 */
@Serializable
@TelegramBotAPIType(type = "gamehighscore")
data class GameHighScore(
    @SerialName("position")
    val position: Int,

    @SerialName("user")
    val user: User,

    @SerialName("score")
    val score: Int
)
