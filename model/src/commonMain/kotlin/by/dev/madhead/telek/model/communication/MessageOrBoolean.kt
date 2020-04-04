package by.dev.madhead.telek.model.communication

/**
 * Response for [some][https://core.telegram.org/bots/api#updating-messages] message updating methods.
 */
sealed class MessageOrBoolean {
    /**
     * [Message] response.
     */
    data class Message(val message: by.dev.madhead.telek.model.Message) : MessageOrBoolean()

    /**
     * [Boolean] response.
     */
    data class Boolean(val value: kotlin.Boolean) : MessageOrBoolean()
}
