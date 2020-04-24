package by.dev.madhead.telek.telek

import by.dev.madhead.telek.model.Message
import by.dev.madhead.telek.model.Update
import by.dev.madhead.telek.model.User
import by.dev.madhead.telek.model.WebhookInfo
import by.dev.madhead.telek.model.communication.AnswerCallbackQueryRequest
import by.dev.madhead.telek.model.communication.EditMessageReplyMarkupRequest
import by.dev.madhead.telek.model.communication.ForwardMessageRequest
import by.dev.madhead.telek.model.communication.GetUpdatesRequest
import by.dev.madhead.telek.model.communication.MessageOrBoolean
import by.dev.madhead.telek.model.communication.SendAudioRequest
import by.dev.madhead.telek.model.communication.SendMessageRequest
import by.dev.madhead.telek.model.communication.SendPhotoRequest
import by.dev.madhead.telek.model.communication.SetWebhookRequest

/**
 * [Telegram Bot API][https://core.telegram.org/bots/api] client.
 */
@Suppress("TooManyFunctions")
interface Telek {
    /**
     * Use this method to receive incoming updates using long polling ([wiki][https://en.wikipedia.org/wiki/Push_technology#Long_polling]).
     * An Array of [Update] objects is returned.
     */
    suspend fun getUpdates(request: GetUpdatesRequest): List<Update>

    /**
     * Use this method to specify a url and receive incoming updates via an outgoing webhook. Whenever there is an update for the bot,
     * we will send an HTTPS POST request to the specified url, containing a JSON-serialized [Update]. In case of an unsuccessful request,
     * we will give up after a reasonable amount of attempts. Returns *True* on success.
     *
     * If you'd like to make sure that the Webhook request comes from Telegram, we recommend using a secret path in the URL, e.g.
     * `https://www.example.com/<token>`. Since nobody else knows your bot‘s token, you can be pretty sure it’s us.
     */
    suspend fun setWebhook(request: SetWebhookRequest): Boolean

    /**
     * Use this method to remove webhook integration if you decide to switch back to [getUpdates].
     * Returns *True* on success.
     * Requires no parameters.
     */
    suspend fun deleteWebhook(): Boolean

    /**
     * Use this method to get current webhook status.
     * Requires no parameters.
     * On success, returns a [WebhookInfo] object.
     * If the bot is using [getUpdates], will return an object with the url field empty.
     */
    suspend fun getWebhookInfo(): WebhookInfo

    /**
     * A simple method for testing your bot's auth token.
     * Requires no parameters.
     * Returns basic information about the bot in form of a [User] object.
     */
    suspend fun getMe(): User

    /**
     * Use this method to send text messages.
     * On success, the sent [Message] is returned.
     */
    suspend fun sendMessage(request: SendMessageRequest): Message

    /**
     * Use this method to forward messages of any kind.
     * On success, the sent [Message] is returned.
     */
    suspend fun forwardMessage(request: ForwardMessageRequest): Message

    /**
     * Use this method to send photos.
     * On success, the sent [Message] is returned.
     */
    suspend fun sendPhoto(request: SendPhotoRequest): Message

    /**
     * Use this method to send audio files, if you want Telegram clients to display them in the music player.
     * Your audio must be in the .MP3 or .M4A format.
     * On success, the sent [Message] is returned.
     * Bots can currently send audio files of up to 50 MB in size, this limit may be changed in the future.
     *
     * For sending voice messages, use the [sendVoice] method instead.
     */
    suspend fun sendAudio(request: SendAudioRequest): Message

    /**
     * Use this method to send general files.
     * On success, the sent [Message] is returned.
     * Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future.
     */
    suspend fun sendDocument()

    /**
     * Use this method to send video files, Telegram clients support mp4 videos (other formats may be sent as
     * [Document][by.dev.madhead.telek.model.Document]). On success, the sent [Message] is returned. Bots can currently send video files
     * of up to 50 MB in size, this limit may be changed in the future.
     */
    suspend fun sendVideo()

    /**
     * Use this method to send animation files (GIF or H.264/MPEG-4 AVC video without sound).
     * On success, the sent [Message] is returned.
     * Bots can currently send animation files of up to 50 MB in size, this limit may be changed in the future.
     */
    suspend fun sendAnimation()

    /**
     * Use this method to send audio files, if you want Telegram clients to display the file as a playable voice message.
     * For this to work, your audio must be in an .OGG file encoded with OPUS (other formats may be sent as
     * [Audio][by.dev.madhead.telek.model.Audio] or [Document][by.dev.madhead.telek.model.Document]).
     * On success, the sent [Message] is returned. Bots can currently send voice messages of up to 50 MB in size, this limit may be
     * changed in the future.
     */
    suspend fun sendVoice()

    /**
     * As of [v.4.0][https://telegram.org/blog/video-messages-and-telescope], Telegram clients support rounded square mp4 videos of up to
     * 1 minute long. Use this method to send video messages. On success, the sent [Message] is returned.
     */
    suspend fun sendVideoNote()

    /**
     * Use this method to send a group of photos or videos as an album.
     * On success, an array of the sent [Messages][Message] is returned.
     */
    suspend fun sendMediaGroup()

    /**
     * Use this method to send point on the map.
     * On success, the sent [Message] is returned.
     */
    suspend fun sendLocation()

    /**
     * Use this method to edit live location messages.
     * A location can be edited until its `live_period` expires or editing is explicitly disabled by a call to [stopMessageLiveLocation].
     * On success, if the edited message was sent by the bot, the edited [Message] is returned, otherwise *True* is returned.
     */
    suspend fun editMessageLiveLocation()

    /**
     * Use this method to stop updating a live location message before `live_period` expires.
     * On success, if the message was sent by the bot, the sent [Message] is returned, otherwise *True* is returned.
     */
    suspend fun stopMessageLiveLocation()

    /**
     * Use this method to send information about a venue.
     * On success, the sent [Message] is returned.
     */
    suspend fun sendVenue()

    /**
     * Use this method to send phone contacts.
     * On success, the sent [Message] is returned.
     */
    suspend fun sendContact()

    /**
     * Use this method to send a native poll.
     * On success, the sent [Message] is returned.
     */
    suspend fun sendPoll()

    /**
     * Use this method to send a dice, which will have a random value from 1 to 6. On success, the sent [Message] is returned.
     * (Yes, we're aware of the *“proper”* singular of *die*. But it's awkward, and we decided to help it change. One dice at a time!)
     */
    suspend fun sendDice()

    /**
     * Use this method when you need to tell the user that something is happening on the bot's side.
     * The status is set for 5 seconds or less (when a message arrives from your bot, Telegram clients clear its typing status).
     * Returns *True* on success.
     *
     * > Example: The [ImageBot][https://t.me/imagebot] needs some time to process a request and upload the image. Instead of sending a
     * text message along the lines of “Retrieving image, please wait…”, the bot may use [sendChatAction] with `action = upload_photo`.
     * The user will see a “sending photo” status for the bot.
     *
     * We only recommend using this method when a response from the bot will take a **noticeable** amount of time to arrive.
     */
    suspend fun sendChatAction()

    /**
     * Use this method to get a list of profile pictures for a user.
     * Returns a [UserProfilePhotos][by.dev.madhead.telek.model.UserProfilePhotos] object.
     */
    suspend fun getUserProfilePhotos()

    /**
     * Use this method to get basic info about a file and prepare it for downloading. For the moment, bots can download files of up to 20MB
     * in size. On success, a [File][by.dev.madhead.telek.model.File] object is returned. The file can then be downloaded via the link
     * `https://api.telegram.org/file/bot<token>/<file_path>`, where `<file_path>` is taken from the response. It is guaranteed that the
     * link will be valid for at least 1 hour. When the link expires, a new one can be requested by calling [getFile] again.
     *
     * **Note:** This function may not preserve the original file name and MIME type. You should save the file's MIME type and name
     * (if available) when the File object is received.
     */
    suspend fun getFile()

    /**
     * Use this method to kick a user from a group, a supergroup or a channel. In the case of supergroups and channels, the user will not
     * be able to return to the group on their own using invite links, etc., unless
     * [unbanned][https://core.telegram.org/bots/api#unbanchatmember] first. The bot must be an administrator in the chat for this to work
     * and must have the appropriate admin rights. Returns *True* on success.
     */
    suspend fun kickChatMember()

    /**
     * Use this method to unban a previously kicked user in a supergroup or channel.
     * The user will **not** return to the group or channel automatically, but will be able to join via link, etc.
     * The bot must be an administrator for this to work.
     * Returns *True* on success.
     */
    suspend fun unbanChatMember()

    /**
     * Use this method to restrict a user in a supergroup.
     * The bot must be an administrator in the supergroup for this to work and must have the appropriate admin rights.
     * Pass *True* for all permissions to lift restrictions from a user.
     * Returns *True* on success.
     */
    suspend fun restrictChatMember()

    /**
     * Use this method to promote or demote a user in a supergroup or a channel.
     * The bot must be an administrator in the chat for this to work and must have the appropriate admin rights.
     * Pass *False* for all boolean parameters to demote a user.
     * Returns *True* on success.
     */
    suspend fun promoteChatMember()

    /**
     * Use this method to set a custom title for an administrator in a supergroup promoted by the bot.
     * Returns *True* on success.
     */
    suspend fun setChatAdministratorCustomTitle()

    /**
     * Use this method to set default chat permissions for all members.
     * The bot must be an administrator in the group or a supergroup for this to work and must have the *can_restrict_members* admin rights.
     * Returns *True* on success.
     */
    suspend fun setChatPermissions()

    /**
     * Use this method to generate a new invite link for a chat; any previously generated link is revoked.
     * The bot must be an administrator in the chat for this to work and must have the appropriate admin rights.
     * Returns the new invite link as *String* on success.
     */
    suspend fun exportChatInviteLink()

    /**
     * Use this method to set a new profile photo for the chat.
     * Photos can't be changed for private chats.
     * The bot must be an administrator in the chat for this to work and must have the appropriate admin rights.
     * Returns *True* on success.
     */
    suspend fun setChatPhoto()

    /**
     * Use this method to delete a chat photo.
     * Photos can't be changed for private chats.
     * The bot must be an administrator in the chat for this to work and must have the appropriate admin rights.
     * Returns *True* on success.
     */
    suspend fun deleteChatPhoto()

    /**
     * Use this method to change the title of a chat.
     * Titles can't be changed for private chats.
     * The bot must be an administrator in the chat for this to work and must have the appropriate admin rights.
     * Returns *True* on success.
     */
    suspend fun setChatTitle()

    /**
     * Use this method to change the description of a group, a supergroup or a channel.
     * The bot must be an administrator in the chat for this to work and must have the appropriate admin rights.
     * Returns *True* on success.
     */
    suspend fun setChatDescription()

    /**
     * Use this method to pin a message in a group, a supergroup, or a channel. The bot must be an administrator in the chat for this
     * to work and must have the ‘can_pin_messages’ admin right in the supergroup or ‘can_edit_messages’ admin right in the channel.
     * Returns *True* on success.
     */
    suspend fun pinChatMessage()

    /**
     * Use this method to unpin a message in a group, a supergroup, or a channel. The bot must be an administrator in the chat for this
     * to work and must have the ‘can_pin_messages’ admin right in the supergroup or ‘can_edit_messages’ admin right in the channel.
     * Returns *True* on success.
     */
    suspend fun unpinChatMessage()

    /**
     * Use this method for your bot to leave a group, supergroup or channel.
     * Returns *True* on success.
     */
    suspend fun leaveChat()

    /**
     * Use this method to get up to date information about the chat (current name of the user for one-on-one conversations, current
     * username of a user, group or channel, etc.). Returns a [Chat][by.dev.madhead.telek.model.Chat] object on success.
     */
    suspend fun getChat()

    /**
     * Use this method to get a list of administrators in a chat. On success, returns an Array of
     * [ChatMember][by.dev.madhead.telek.model.ChatMember] objects that contains information about all chat administrators except other
     * bots. If the chat is a group or a supergroup and no administrators were appointed, only the creator will be returned.
     */
    suspend fun getChatAdministrators()

    /**
     * Use this method to get the number of members in a chat.
     * Returns *Int* on success.
     */
    suspend fun getChatMembersCount()

    /**
     * Use this method to get information about a member of a chat.
     * Returns a [ChatMember][by.dev.madhead.telek.model.ChatMember] object on success.
     */
    suspend fun getChatMember()

    /**
     * Use this method to set a new group sticker set for a supergroup.
     * The bot must be an administrator in the chat for this to work and must have the appropriate admin rights.
     * Use the field *can_set_sticker_set* optionally returned in [getChat] requests to check if the bot can use this method.
     * Returns *True* on success.
     */
    suspend fun setChatStickerSet()

    /**
     * Use this method to delete a group sticker set from a supergroup.
     * The bot must be an administrator in the chat for this to work and must have the appropriate admin rights.
     * Use the field *can_set_sticker_set* optionally returned in [getChat] requests to check if the bot can use this method.
     * Returns *True* on success.
     */
    suspend fun deleteChatStickerSet()

    /**
     * Use this method to send answers to callback queries sent from
     * [inline keyboards][https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating]. The answer will be displayed to the
     * user as a notification at the top of the chat screen or as an alert. On success, *True* is returned.
     *
     * >Alternatively, the user can be redirected to the specified Game URL.
     * For this option to work, you must first create a game for your bot via [@Botfather][https://t.me/botfather] and accept the terms.
     * Otherwise, you may use links like `t.me/your_bot?start=XXXX` that open your bot with a parameter.
     */
    suspend fun answerCallbackQuery(request: AnswerCallbackQueryRequest): Boolean

    /**
     * Use this method to change the list of the bot's commands.
     * Returns *True* on success.
     */
    suspend fun setMyCommands()

    /**
     * Use this method to get the current list of the bot's commands.
     * Requires no parameters.
     * Returns Array of [BotCommand] on success.
     */
    suspend fun getMyCommands()

    /**
     * Use this method to edit text and [game][https://core.telegram.org/bots/api#games] messages.
     * On success, if edited message is sent by the bot, the edited [Message] is returned, otherwise *True* is returned.
     */
    suspend fun editMessageText()

    /**
     * Use this method to edit captions of messages.
     * On success, if edited message is sent by the bot, the edited [Message] is returned, otherwise *True* is returned.
     */
    suspend fun editMessageCaption()

    /**
     * Use this method to edit animation, audio, document, photo, or video messages.
     * If a message is a part of a message album, then it can be edited only to a photo or a video.
     * Otherwise, message type can be changed arbitrarily.
     * When inline message is edited, new file can't be uploaded.
     * Use previously uploaded file via its file_id or specify a URL.
     * On success, if the edited message was sent by the bot, the edited [Message] is returned, otherwise *True* is returned.
     */
    suspend fun editMessageMedia()

    /**
     * Use this method to edit only the reply markup of messages.
     * On success, if edited message is sent by the bot, the edited [Message] is returned, otherwise *True* is returned.
     */
    suspend fun editMessageReplyMarkup(request: EditMessageReplyMarkupRequest): MessageOrBoolean

    /**
     * Use this method to stop a poll which was sent by the bot.
     * On success, the stopped [Poll][by.dev.madhead.telek.model.Poll] with the final results is returned.
     */
    suspend fun stopPoll()

    /**
     * Use this method to delete a message, including service messages, with the following limitations:
     * - A message can only be deleted if it was sent less than 48 hours ago.
     * - Bots can delete outgoing messages in private chats, groups, and supergroups.
     * - Bots can delete incoming messages in private chats.
     * - Bots granted can_post_messages permissions can delete outgoing messages in channels.
     * - If the bot is an administrator of a group, it can delete any message there.
     * - If the bot has can_delete_messages permission in a supergroup or a channel, it can delete any message there.
     *
     * Returns *True* on success.
     */
    suspend fun deleteMessage()

    /**
     * Use this method to send static .WEBP or [animated][https://telegram.org/blog/animated-stickers] .TGS stickers.
     * On success, the sent [Message] is returned.
     */
    suspend fun sendSticker()

    /**
     * Use this method to get a sticker set.
     * On success, a [StickerSet][by.dev.madhead.telek.model.StickerSet] object is returned.
     */
    suspend fun getStickerSet()

    /**
     * Use this method to upload a .PNG file with a sticker for later use in [createNewStickerSet] and [addStickerToSet] methods
     * (can be used multiple times). Returns the uploaded [File][by.dev.madhead.telek.model.File] on success.
     */
    suspend fun uploadStickerFile()

    /**
     * Use this method to create new sticker set owned by a user.
     * The bot will be able to edit the created sticker set.
     * Returns *True* on success.
     */
    suspend fun createNewStickerSet()

    /**
     * Use this method to add a new sticker to a set created by the bot.
     * Returns *True* on success.
     */
    suspend fun addStickerToSet()

    /**
     * Use this method to move a sticker in a set created by the bot to a specific position.
     * Returns *True* on success.
     */
    suspend fun setStickerPositionInSet()

    /**
     * Use this method to delete a sticker from a set created by the bot.
     * Returns *True* on success.
     */
    suspend fun deleteStickerFromSet()

    /**
     * Use this method to set the thumbnail of a sticker set.
     * Animated thumbnails can be set for animated sticker sets only.
     * Returns *True* on success.
     */
    suspend fun setStickerSetThumb()

    /**
     * Use this method to send answers to an inline query.
     * On success, *True* is returned.
     * No more than **50** results per query are allowed.
     */
    suspend fun answerInlineQuery()

    /**
     * Use this method to send invoices.
     * On success, the sent [Message] is returned.
     */
    suspend fun sendInvoice()

    /**
     * If you sent an invoice requesting a shipping address and the parameter *is_flexible* was specified, the Bot API will send an
     * [Update] with a *shipping_query* field to the bot. Use this method to reply to shipping queries. On success, *True* is returned.
     */
    suspend fun answerShippingQuery()

    /**
     * Once the user has confirmed their payment and shipping details, the Bot API sends the final confirmation in the form of an [Update]
     * with the field *pre_checkout_query*. Use this method to respond to such pre-checkout queries. On success, *True* is returned.
     * **Note:** The Bot API must receive an answer within 10 seconds after the pre-checkout query was sent.
     */
    suspend fun answerPreCheckoutQuery()

    /**
     * Informs a user that some of the Telegram Passport elements they provided contains errors. The user will not be able to re-submit
     * their Passport to you until the errors are fixed (the contents of the field for which you returned the error must change).
     * Returns *True* on success.
     *
     * Use this if the data submitted by the user doesn't satisfy the standards your service requires for any reason.
     * For example, if a birthday date seems invalid, a submitted document is blurry, a scan shows evidence of tampering, etc.
     * Supply some details in the error message to make sure the user knows how to correct the issues.
     */
    suspend fun setPassportDataErrors()

    /**
     * Use this method to send a game.
     * On success, the sent [Message] is returned.
     */
    suspend fun sendGame()

    /**
     * Use this method to set the score of the specified user in a game.
     * On success, if the message was sent by the bot, returns the edited [Message], otherwise returns *True*.
     * Returns an error, if the new score is not greater than the user's current score in the chat and *force* is *False*.
     */
    suspend fun setGameScore()

    /**
     * Use this method to get data for high score tables.
     * Will return the score of the specified user and several of his neighbors in a game.
     * On success, returns an *Array* of [GameHighScore][by.dev.madhead.telek.model.GameHighScore] objects.
     *
     * >This method will currently return scores for the target user, plus two of his closest neighbors on each side.
     * Will also return the top three users if the user and his neighbors are not among them.
     * Please note that this behavior is subject to change.
     */
    suspend fun getGameHighScores()
}
