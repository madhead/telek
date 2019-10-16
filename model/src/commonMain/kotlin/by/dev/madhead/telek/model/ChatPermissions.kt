package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName

/**
 * Describes actions that a non-administrator user is allowed to take in a chat.
 */
@TelegramBotAPIType(type = "chatpermissions")
data class ChatPermissions(
    @SerialName("can_send_messages")
    val canSendMessages: Boolean? = null,

    @SerialName("can_send_media_messages")
    val canSendMediaMessages: Boolean? = null,

    @SerialName("can_send_polls")
    val canSendPolls: Boolean? = null,

    @SerialName("can_send_other_messages")
    val canSendOtherMessages: Boolean? = null,

    @SerialName("can_add_web_page_previews")
    val canAddWebPagePreviews: Boolean? = null,

    @SerialName("can_change_info")
    val canChangeInfo: Boolean? = null,

    @SerialName("can_invite_users")
    val canInviteUsers: Boolean? = null,

    @SerialName("can_pin_messages")
    val canPinMessages: Boolean? = null
)
