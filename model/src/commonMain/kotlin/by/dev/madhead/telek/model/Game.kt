package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName

@TelegramBotAPIType(type = "game")
data class Game(
    @SerialName("title")
    val title: String,

    @SerialName("description")
    val description: String,

    @SerialName("photo")
    val photo: List<PhotoSize>,

    @SerialName("text")
    val text: String,

    @SerialName("text_entities")
    val textEntities: List<MessageEntity>,

    @SerialName("animation")
    val animation: Animation
)
