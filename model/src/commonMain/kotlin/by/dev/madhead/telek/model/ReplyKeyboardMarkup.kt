package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object represents a [custom keyboard][https://core.telegram.org/bots#keyboards] with reply options (see
 * [Introduction to bots][https://core.telegram.org/bots#keyboards] for details and examples).
 */
@Serializable
@TelegramBotAPIType(type = "replykeyboardmarkup")
data class ReplyKeyboardMarkup(
    @SerialName("keyboard")
    val keyboard: List<List<KeyboardButton>>,

    @SerialName("resize_keyboard")
    val resizeKeyboard: Boolean? = null,

    @SerialName("one_time_keyboard")
    val oneTimeKeyboard: Boolean? = null,

    @SerialName("selective")
    val selective: Boolean? = null
) : ReplyMarkup
