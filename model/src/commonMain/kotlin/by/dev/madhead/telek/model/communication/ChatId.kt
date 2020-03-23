package by.dev.madhead.telek.model.communication

import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.PrimitiveDescriptor
import kotlinx.serialization.PrimitiveKind
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonLiteral
import kotlinx.serialization.json.JsonParametricSerializer

/**
 * Unique identifier for the target chat or username of the target channel (in the format `@channelusername`).
 */
@Serializable
sealed class ChatId {
    /**
     * String representation of this chat id.
     * Used in multipart/form-data requests.
     */
    abstract fun asString(): String

    @Serializer(forClass = ChatId::class)
    companion object : JsonParametricSerializer<ChatId>(ChatId::class) {
        /**
         * Construct a [ChatId] from the supplied [value].
         */
        fun of(value: Int): ChatId = IntegerChatId(value.toLong())

        /**
         * Construct a [ChatId] from the supplied [value].
         */
        fun of(value: Long): ChatId = IntegerChatId(value)

        /**
         * Construct a [ChatId] from the supplied [value].
         */
        fun of(value: String): ChatId = StringChatId(value)

        override fun selectSerializer(element: JsonElement): KSerializer<out ChatId> = when {
            (element as JsonLiteral).isString -> StringChatId
            else -> IntegerChatId
        }
    }

    /**
     * Integer chat id.
     * This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it.
     * But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
     */
    @Serializable
    data class IntegerChatId(val value: Long) : ChatId() {
        override fun asString(): String = value.toString()

        @Serializer(forClass = IntegerChatId::class)
        companion object : KSerializer<IntegerChatId> {
            override val descriptor: SerialDescriptor = PrimitiveDescriptor("IntegerChatId", PrimitiveKind.LONG)

            override fun serialize(encoder: Encoder, value: IntegerChatId) {
                encoder.encodeLong(value.value)
            }

            override fun deserialize(decoder: Decoder): IntegerChatId {
                return IntegerChatId(decoder.decodeLong())
            }
        }
    }

    /**
     * String chat id, like `@channelusername`.
     */
    @Serializable
    data class StringChatId(val value: String) : ChatId() {
        override fun asString(): String = value

        @Serializer(forClass = StringChatId::class)
        companion object : KSerializer<StringChatId> {
            override val descriptor: SerialDescriptor = PrimitiveDescriptor("StringChatId", PrimitiveKind.STRING)

            override fun serialize(encoder: Encoder, value: StringChatId) {
                encoder.encodeString(value.value)
            }

            override fun deserialize(decoder: Decoder): StringChatId {
                return StringChatId(decoder.decodeString())
            }
        }
    }
}
