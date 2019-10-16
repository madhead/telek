package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName

/**
 * This object represents an incoming callback query from a callback button in an
 * [inline keyboard][https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating]. If the button that originated the query
 * was attached to a message sent by the bot, the field _message_ will be present. If the button was attached to a message sent via the bot
 * (in [inline mode][https://core.telegram.org/bots/api#inline-mode]), the field _inline_message_id_ will be present. Exactly one of the
 * fields _data_ or _game_short_name_ will be present.
 */
@TelegramBotAPIType(type = "callbackquery")
data class CallbackQuery(
    @SerialName("id")
    val id: String,

    @SerialName("from")
    val from: User,

    @SerialName("message")
    val message: Message? = null,

    @SerialName("inline_message_id")
    val inlineMeessageId: String? = null,

    @SerialName("chat_instance")
    val chatInstance: String,

    @SerialName("data")
    val data: String? = null,

    @SerialName("game_short_name")
    val gameShortName: String? = null
)
