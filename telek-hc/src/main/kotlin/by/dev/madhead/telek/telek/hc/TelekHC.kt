package by.dev.madhead.telek.telek.hc

import by.dev.madhead.telek.model.Message
import by.dev.madhead.telek.model.ReplyMarkup
import by.dev.madhead.telek.model.Update
import by.dev.madhead.telek.model.User
import by.dev.madhead.telek.model.WebhookInfo
import by.dev.madhead.telek.model.communication.AnswerCallbackQueryRequest
import by.dev.madhead.telek.model.communication.EditMessageReplyMarkupRequest
import by.dev.madhead.telek.model.communication.ForwardMessageRequest
import by.dev.madhead.telek.model.communication.GetUpdatesRequest
import by.dev.madhead.telek.model.communication.InputFile
import by.dev.madhead.telek.model.communication.MessageOrBoolean
import by.dev.madhead.telek.model.communication.Response
import by.dev.madhead.telek.model.communication.SendMessageRequest
import by.dev.madhead.telek.model.communication.SendPhotoRequest
import by.dev.madhead.telek.model.communication.SetWebhookRequest
import by.dev.madhead.telek.model.json
import by.dev.madhead.telek.telek.Telek
import by.dev.madhead.telek.telek.TelekException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.ContextSerializer
import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.list
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.methods.HttpPost
import org.apache.http.client.methods.HttpUriRequest
import org.apache.http.entity.BufferedHttpEntity
import org.apache.http.entity.ContentType
import org.apache.http.entity.StringEntity
import org.apache.http.entity.mime.MultipartEntityBuilder
import org.apache.http.entity.mime.content.InputStreamBody
import org.apache.http.entity.mime.content.StringBody
import org.apache.http.impl.nio.client.HttpAsyncClients
import org.apache.http.util.EntityUtils
import org.apache.logging.log4j.LogManager
import java.io.ByteArrayInputStream
import java.io.File
import java.io.FileInputStream
import java.net.URI

/**
 * [Telek] implementation based on [Apache HttpComponents][http://hc.apache.org].
 */
@ImplicitReflectionSerializer
@Suppress("TooManyFunctions")
class TelekHC(private val token: String) : Telek, AutoCloseable {
    companion object {
        val logger = LogManager.getLogger(TelekHC::class.java)
    }

    private val client = HttpAsyncClients.createDefault()

    init {
        client.start()
    }

    override suspend fun getUpdates(request: GetUpdatesRequest): List<Update> {
        val httpRequest = HttpPost().apply {
            uri = methodURI("getUpdates")
            entity = StringEntity(json.stringify(GetUpdatesRequest.serializer(), request), ContentType.APPLICATION_JSON)
        }

        return callApi(httpRequest, Update.serializer().list)
    }

    override suspend fun setWebhook(request: SetWebhookRequest): Boolean {
        val httpRequest = when (val certificate = request.certificate) {
            is InputFile.StringInputFile -> HttpPost().apply {
                uri = methodURI("setWebhook")
                entity = StringEntity(json.stringify(SetWebhookRequest.serializer(), request), ContentType.APPLICATION_JSON)
            }
            else -> HttpPost().apply {
                uri = methodURI("setWebhook")
                entity = withContext(Dispatchers.IO) {
                    BufferedHttpEntity(
                        MultipartEntityBuilder.create().apply {
                            addPart("url", StringBody(request.url, ContentType.MULTIPART_FORM_DATA))

                            when (certificate) {
                                is InputFile.FilePathInputFile -> {
                                    val file = File(certificate.path)

                                    addPart(
                                        "certificate",
                                        InputStreamBody(FileInputStream(file), ContentType.DEFAULT_BINARY, file.name)
                                    )
                                }
                                is InputFile.BytesInputFile -> {
                                    addPart(
                                        "certificate",
                                        InputStreamBody(
                                            ByteArrayInputStream(certificate.bytes),
                                            ContentType.DEFAULT_BINARY,
                                            certificate.filename
                                        )
                                    )
                                }
                            }

                            request.maxConnections?.let {
                                addPart("max_connections", StringBody(it.toString(), ContentType.MULTIPART_FORM_DATA))
                            }
                            addPart(
                                "allowed_updates",
                                StringBody(
                                    json.stringify(String.serializer().list, request.allowedUpdates),
                                    ContentType.MULTIPART_FORM_DATA
                                )
                            )
                        }.build()
                    )
                }
            }
        }

        return callApi(httpRequest, Boolean.serializer())
    }

    override suspend fun deleteWebhook(): Boolean {
        val httpRequest = HttpPost().apply {
            uri = methodURI("deleteWebhook")
        }

        return callApi(httpRequest, Boolean.serializer())
    }

    override suspend fun getWebhookInfo(): WebhookInfo {
        val httpRequest = HttpGet().apply {
            uri = methodURI("getWebhookInfo")
        }

        return callApi(httpRequest, WebhookInfo.serializer())
    }

    override suspend fun getMe(): User {
        val httpRequest = HttpGet().apply {
            uri = methodURI("getMe")
        }

        return callApi(httpRequest, User.serializer())
    }

    override suspend fun sendMessage(request: SendMessageRequest): Message {
        val httpRequest = HttpPost().apply {
            uri = methodURI("sendMessage")
            entity = StringEntity(json.stringify(SendMessageRequest.serializer(), request), ContentType.APPLICATION_JSON)
        }

        return callApi(httpRequest, Message.serializer())
    }

    override suspend fun forwardMessage(request: ForwardMessageRequest): Message {
        val httpRequest = HttpPost().apply {
            uri = methodURI("forwardMessage")
            entity = StringEntity(json.stringify(ForwardMessageRequest.serializer(), request), ContentType.APPLICATION_JSON)
        }

        return callApi(httpRequest, Message.serializer())
    }

    override suspend fun sendPhoto(request: SendPhotoRequest): Message {
        val httpRequest = when (val photo = request.photo) {
            is InputFile.StringInputFile -> HttpPost().apply {
                uri = methodURI("sendPhoto")
                entity = StringEntity(json.stringify(SendPhotoRequest.serializer(), request), ContentType.APPLICATION_JSON)
            }
            else -> HttpPost().apply {
                uri = methodURI("sendPhoto")
                entity = withContext(Dispatchers.IO) {
                    BufferedHttpEntity(
                        MultipartEntityBuilder.create().apply {
                            addPart("chat_id", StringBody(request.chatId.asString(), ContentType.MULTIPART_FORM_DATA))

                            when (photo) {
                                is InputFile.FilePathInputFile -> {
                                    val file = File(photo.path)

                                    addPart(
                                        "photo",
                                        InputStreamBody(FileInputStream(file), ContentType.DEFAULT_BINARY, file.name)
                                    )
                                }
                                is InputFile.BytesInputFile -> {
                                    addPart(
                                        "photo",
                                        InputStreamBody(ByteArrayInputStream(photo.bytes), ContentType.DEFAULT_BINARY, photo.filename)
                                    )
                                }
                            }

                            request.caption?.let {
                                addPart("caption", StringBody(it, ContentType.MULTIPART_FORM_DATA))
                            }
                            request.parseMode?.let {
                                addPart("parse_mode", StringBody(it.name, ContentType.MULTIPART_FORM_DATA))
                            }
                            request.parseMode?.let {
                                addPart("parse_mode", StringBody(it.name, ContentType.MULTIPART_FORM_DATA))
                            }
                            if (request.disableNotification == true) {
                                addPart("disable_notification", StringBody("true", ContentType.MULTIPART_FORM_DATA))
                            }
                            request.replyToMessageId?.let {
                                addPart("reply_to_message_id", StringBody(it.toString(), ContentType.MULTIPART_FORM_DATA))
                            }
                            request.replyMarkup?.let {
                                addPart("reply_markup", StringBody(
                                    json.stringify(ContextSerializer(ReplyMarkup::class), it), ContentType.APPLICATION_JSON
                                ))
                            }
                        }.build()
                    )
                }
            }
        }

        return callApi(httpRequest, Message.serializer())
    }

    override suspend fun sendAudio() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun sendDocument() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun sendVideo() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun sendAnimation() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun sendVoice() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun sendVideoNote() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun sendMediaGroup() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun sendLocation() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun editMessageLiveLocation() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun stopMessageLiveLocation() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun sendVenue() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun sendContact() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun sendPoll() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun sendDice() {
        TODO("Not yet implemented")
    }

    override suspend fun sendChatAction() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getUserProfilePhotos() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getFile() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun kickChatMember() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun unbanChatMember() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun restrictChatMember() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun promoteChatMember() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun setChatAdministratorCustomTitle() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun setChatPermissions() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun exportChatInviteLink() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun setChatPhoto() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun deleteChatPhoto() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun setChatTitle() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun setChatDescription() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun pinChatMessage() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun unpinChatMessage() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun leaveChat() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getChat() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getChatAdministrators() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getChatMembersCount() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getChatMember() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun setChatStickerSet() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun deleteChatStickerSet() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun answerCallbackQuery(request: AnswerCallbackQueryRequest): Boolean {
        val httpRequest = HttpPost().apply {
            uri = methodURI("answerCallbackQuery")
            entity = StringEntity(json.stringify(AnswerCallbackQueryRequest.serializer(), request), ContentType.APPLICATION_JSON)
        }

        return callApi(httpRequest, Boolean.serializer())
    }

    override suspend fun setMyCommands() {
        TODO("Not yet implemented")
    }

    override suspend fun getMyCommands() {
        TODO("Not yet implemented")
    }

    override suspend fun editMessageText() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun editMessageCaption() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun editMessageMedia() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun editMessageReplyMarkup(request: EditMessageReplyMarkupRequest): MessageOrBoolean {
        val httpRequest = HttpPost().apply {
            uri = methodURI("editMessageReplyMarkup")
            entity = StringEntity(json.stringify(EditMessageReplyMarkupRequest.serializer(), request), ContentType.APPLICATION_JSON)
        }

        val httpResponse = client.exekute(httpRequest)
        val response = withContext(Dispatchers.IO) { json.parse(Response.Companion, EntityUtils.toString(httpResponse.entity)) }

        return if (response is Response.Successful) {
            when (response.result) {
                is JsonObject -> MessageOrBoolean.Message(json.fromJson(Message.serializer(), response.result))
                is JsonPrimitive -> MessageOrBoolean.Boolean(json.fromJson(Boolean.serializer(), response.result))
                else -> throw TelekException(response.description, response)
            }
        } else {
            logger.error("${response.description}")

            throw TelekException(response.description, response)
        }
    }

    override suspend fun stopPoll() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun deleteMessage() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun sendSticker() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getStickerSet() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun uploadStickerFile() {
        TODO("Not yet implemented")
    }

    override suspend fun createNewStickerSet() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun addStickerToSet() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun setStickerPositionInSet() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun deleteStickerFromSet() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun setStickerSetThumb() {
        TODO("Not yet implemented")
    }

    override suspend fun answerInlineQuery() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun sendInvoice() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun answerShippingQuery() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun answerPreCheckoutQuery() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun setPassportDataErrors() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun sendGame() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun setGameScore() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getGameHighScores() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override fun close() {
        client.close()
    }

    private fun methodURI(method: String) = URI("https://api.telegram.org/bot$token/$method")

    private suspend fun <T> callApi(httpRequest: HttpUriRequest, serializer: KSerializer<T>): T {
        val httpResponse = client.exekute(httpRequest)
        val response = withContext(Dispatchers.IO) { json.parse(Response.Companion, EntityUtils.toString(httpResponse.entity)) }

        return if (response is Response.Successful) {
            json.fromJson(serializer, response.result)
        } else {
            logger.error("${response.description}")

            throw TelekException(response.description, response)
        }
    }
}
