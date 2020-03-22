package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object contains information about one member of a chat.
 */
@Serializable
@TelegramBotAPIType(type = "chatmember")
data class ChatMember(
    @SerialName("user")
    val user: User,

    @SerialName("status")
    val status: String,

    @SerialName("custom_title")
    val customTitle: String? = null,

    @SerialName("until_date")
    val untilDate: Int? = null,

    @SerialName("can_be_edited")
    val canBeEdited: Boolean? = null,

    @SerialName("can_post_messages")
    val canPostMessages: Boolean? = null,

    @SerialName("can_edit_messages")
    val canEditMessages: Boolean? = null,

    @SerialName("can_delete_messages")
    val canDeleteMessages: Boolean? = null,

    @SerialName("can_restrict_members")
    val canRestrictMembers: Boolean? = null,

    @SerialName("can_promote_members")
    val canPromoteMembers: Boolean? = null,

    @SerialName("can_change_info")
    val canChangeInfo: Boolean? = null,

    @SerialName("can_invite_users")
    val canInviteUsers: Boolean? = null,

    @SerialName("can_pin_messages")
    val canPinMessages: Boolean? = null,

    @SerialName("is_member")
    val isMember: Boolean? = null,

    @SerialName("can_send_messages")
    val canSendMessages: Boolean? = null,

    @SerialName("can_send_media_messages")
    val canSendMediaMessages: Boolean? = null,

    @SerialName("can_send_polls")
    val canSendPolls: Boolean? = null,

    @SerialName("can_send_other_messages")
    val canSendOtherMessages: Boolean? = null,

    @SerialName("can_add_web_page_previews")
    val canAddWebPagePreviews: Boolean? = null
)
