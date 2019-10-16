package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object represents a game.
 * Use BotFather to create and edit games, their short names will act as unique identifiers.
 */
@Serializable
@TelegramBotAPIType(type = "game")
data class Game(
    @SerialName("title")
    val title: String,

    @SerialName("description")
    val description: String,

    @SerialName("photo")
    val photo: List<PhotoSize>,

    @SerialName("text")
    val text: String? = null,

    @SerialName("text_entities")
    val textEntities: List<MessageEntity>? = null,

    @SerialName("animation")
    val animation: Animation? = null
)
