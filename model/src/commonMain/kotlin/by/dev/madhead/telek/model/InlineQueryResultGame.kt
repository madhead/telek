package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName

@TelegramBotAPIType(type = "inlinequeryresultgame")
data class InlineQueryResultGame(
    @SerialName("type")
    val type: String,

    @SerialName("id")
    val id: String,

    @SerialName("game_short_name")
    val gameShortName: String,

    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup
) : InlineQueryResult
