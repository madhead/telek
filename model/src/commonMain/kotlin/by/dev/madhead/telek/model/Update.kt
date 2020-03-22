package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This [object][https://core.telegram.org/bots/api#available-types] represents an incoming update.
 * At most **one** of the optional parameters can be present in any given update.
 */
@Serializable
@TelegramBotAPIType(type = "update")
data class Update(
    @SerialName("update_id")
    val updateId: Int,

    @SerialName("message")
    val message: Message? = null,

    @SerialName("edited_message")
    val editedMessage: Message? = null,

    @SerialName("channel_post")
    val channelPost: Message? = null,

    @SerialName("edited_channel_post")
    val editedChannelPost: Message? = null,

    @SerialName("inline_query")
    val inlineQuery: InlineQuery? = null,

    @SerialName("chosen_inline_result")
    val chosenInlineResult: ChosenInlineResult? = null,

    @SerialName("callback_query")
    val callbackQuery: CallbackQuery? = null,

    @SerialName("shipping_query")
    val shippingQuery: ShippingQuery? = null,

    @SerialName("pre_checkout_query")
    val preCheckoutQuery: PreCheckoutQuery? = null,

    @SerialName("poll")
    val poll: Poll? = null,

    @SerialName("poll_answer")
    val pollAnswer: PollAnswer? = null
)
