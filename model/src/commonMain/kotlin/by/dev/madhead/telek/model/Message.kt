package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object represents a message.
 */
@Serializable
@TelegramBotAPIType(type = "message")
data class Message(
    @SerialName("message_id")
    val messageId: Int,

    @SerialName("from")
    val from: User? = null,

    @SerialName("date")
    val date: Int,

    @SerialName("chat")
    val chat: Chat,

    @SerialName("forward_from")
    val forwardFrom: User? = null,

    @SerialName("forward_from_chat")
    val forwardFromChat: Chat? = null,

    @SerialName("forward_from_message_id")
    val forwardFromMessageId: Int? = null,

    @SerialName("forward_signature")
    val forwardSignature: String? = null,

    @SerialName("forward_sender_name")
    val forwardSenderName: String? = null,

    @SerialName("forward_date")
    val forwardDate: Int? = null,

    @SerialName("reply_to_message")
    val replyToMessage: Message? = null,

    @SerialName("edit_date")
    val editDate: Int? = null,

    @SerialName("media_group_id")
    val mediaGroupId: String? = null,

    @SerialName("author_signature")
    val authorSignature: String? = null,

    @SerialName("text")
    val text: String? = null,

    @SerialName("entities")
    val entities: List<MessageEntity>? = null,

    @SerialName("caption_entities")
    val captionEntities: List<MessageEntity>? = null,

    @SerialName("audio")
    val audio: Audio? = null,

    @SerialName("document")
    val document: Document? = null,

    @SerialName("animation")
    val animation: Animation? = null,

    @SerialName("game")
    val game: Game? = null,

    @SerialName("photo")
    val photo: List<PhotoSize>? = null,

    @SerialName("sticker")
    val sticker: Sticker? = null,

    @SerialName("video")
    val video: Video? = null,

    @SerialName("voice")
    val voice: Voice? = null,

    @SerialName("video_note")
    val videoNote: VideoNote? = null,

    @SerialName("caption")
    val caption: String? = null,

    @SerialName("contact")
    val contact: Contact? = null,

    @SerialName("location")
    val location: Location? = null,

    @SerialName("venue")
    val venue: Venue? = null,

    @SerialName("poll")
    val poll: Poll? = null,

    @SerialName("new_chat_members")
    val newChatMembers: List<User>? = null,

    @SerialName("left_chat_member")
    val leftChatMember: User? = null,

    @SerialName("new_chat_title")
    val newChatTitle: String? = null,

    @SerialName("new_chat_photo")
    val newChatPhoto: List<PhotoSize>? = null,

    @SerialName("delete_chat_photo")
    val deleteChatPhoto: Boolean? = null,

    @SerialName("group_chat_created")
    val groupChatCreated: Boolean? = null,

    @SerialName("supergroup_chat_created")
    val supergroupChatCreated: Boolean? = null,

    @SerialName("channel_chat_created")
    val channelChatCreated: Boolean? = null,

    @SerialName("migrate_to_chat_id")
    val migrateToChatId: Int? = null,

    @SerialName("migrate_from_chat_id")
    val migrateFromChatId: Int? = null,

    @SerialName("pinned_message")
    val pinnedMessage: Message? = null,

    @SerialName("invoice")
    val invoice: Invoice? = null,

    @SerialName("successful_payment")
    val successfulPayment: SuccessfulPayment? = null,

    @SerialName("connected_website")
    val connectedWebsite: String? = null,

    @SerialName("passport_data")
    val passportData: PassportData? = null,

    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null
)
