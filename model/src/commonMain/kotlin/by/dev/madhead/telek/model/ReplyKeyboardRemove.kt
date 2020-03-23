package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Upon receiving a message with this object, Telegram clients will remove the current custom keyboard and display the default
 * letter-keyboard. By default, custom keyboards are displayed until a new keyboard is sent by a bot. An exception is made for one-time
 * keyboards that are hidden immediately after the user presses a button (see [ReplyKeyboardMarkup]).
 */
@Serializable
@TelegramBotAPIType(type = "replykeyboardremove")
data class ReplyKeyboardRemove(
    @SerialName("remove_keyboard")
    val removeKeyboard: Boolean = true,

    @SerialName("selective")
    val selective: Boolean? = null
) : ReplyMarkup
