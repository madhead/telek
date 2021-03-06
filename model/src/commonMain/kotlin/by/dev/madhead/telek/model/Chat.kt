package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object represents a chat.
 */
@Serializable
@TelegramBotAPIType(type = "chat")
data class Chat(
    @SerialName("id")
    val id: Long,

    @SerialName("type")
    val type: String,

    @SerialName("title")
    val title: String? = null,

    @SerialName("username")
    val username: String? = null,

    @SerialName("first_name")
    val firstName: String? = null,

    @SerialName("last_name")
    val lastName: String? = null,

    @SerialName("photo")
    val photo: ChatPhoto? = null,

    @SerialName("description")
    val description: String? = null,

    @SerialName("invite_link")
    val inviteLink: String? = null,

    @SerialName("pinned_message")
    val pinnedMessage: Message? = null,

    @SerialName("permissions")
    val permissions: ChatPermissions? = null,

    @SerialName("slow_mode_delay")
    val slowModeDelay: Int? = null,

    @SerialName("sticker_set_name")
    val stickerSetName: String? = null,

    @SerialName("can_set_sticker_set")
    val canSetStickerSet: Boolean? = null
)
