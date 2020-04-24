package by.dev.madhead.telek.telek.hc

import by.dev.madhead.telek.model.InlineKeyboardButton
import by.dev.madhead.telek.model.InlineKeyboardMarkup
import by.dev.madhead.telek.model.Message
import by.dev.madhead.telek.model.ParseMode
import by.dev.madhead.telek.model.communication.AnswerCallbackQueryRequest
import by.dev.madhead.telek.model.communication.ChatId
import by.dev.madhead.telek.model.communication.EditMessageReplyMarkupRequest
import by.dev.madhead.telek.model.communication.FileIdInputFile
import by.dev.madhead.telek.model.communication.ForwardMessageRequest
import by.dev.madhead.telek.model.communication.GetUpdatesRequest
import by.dev.madhead.telek.model.communication.InputFile
import by.dev.madhead.telek.model.communication.SendAudioRequest
import by.dev.madhead.telek.model.communication.SendMessageRequest
import by.dev.madhead.telek.model.communication.SendPhotoRequest
import by.dev.madhead.telek.model.communication.URLInputFile
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.ImplicitReflectionSerializer
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestMethodOrder

@ImplicitReflectionSerializer
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Suppress("TooManyFunctions", "MaxLineLength")
internal class TelekHCTest {
    private val telek = TelekHC(System.getenv("TELEK_HC_TEST_POLL_BOT_TOKEN")!!)
    private val qaUser = System.getenv("TELEK_HC_TEST_POLL_BOT_QA_USER").toInt()
    private val qaGroup = System.getenv("TELEK_HC_TEST_POLL_BOT_QA_GROUP").toLong()
    private val qaChannel = System.getenv("TELEK_HC_TEST_POLL_BOT_QA_CHANNEL").toLong()
    private val qaPublicChannel = System.getenv("TELEK_HC_TEST_POLL_BOT_QA_PUBLIC_CHANNEL")
    private val verificationInlineKeyboard: InlineKeyboardMarkup = InlineKeyboardMarkup(
        inlineKeyboard = listOf(
            listOf(
                InlineKeyboardButton(text = "OKAY", callbackData = "OKAY"),
                InlineKeyboardButton(text = "NOT OKAY", callbackData = "NOT OKAY")
            )
        )
    )
    private var offset: Int? = null

    @BeforeAll
    fun setUp() = runBlocking {
        telek.sendMessage(SendMessageRequest(
            chatId = ChatId.of(qaUser),
            text = """
                *${telek::class.simpleName} smoke test started\!*

                Job: [${System.getenv("CI_JOB_ID")}](${System.getenv("CI_JOB_URL")})
            """.trimIndent(),
            parseMode = ParseMode.MarkdownV2,
            disableWebPagePreview = true
        ))
        Unit
    }

    @Test
    @Order(1)
    fun getWebhookInfo() = runBlocking {
        telek.sendMessage(SendMessageRequest(
            chatId = ChatId.of(qaUser),
            text = """
                Webhook status:

                ```
                ${telek.getWebhookInfo()}
                ```
            """.trimIndent(),
            parseMode = ParseMode.MarkdownV2,
            replyMarkup = verificationInlineKeyboard
        )).verify()
    }

    @Test
    @Order(2)
    fun getMe() = runBlocking {
        telek.sendMessage(SendMessageRequest(
            chatId = ChatId.of(qaUser),
            text = """
                Bot info:
                
                ```
                ${telek.getMe()}
                ```
            """.trimIndent(),
            parseMode = ParseMode.MarkdownV2,
            replyMarkup = verificationInlineKeyboard
        )).verify()
    }

    @Test
    @Order(3)
    fun sendMessageSimpleByIntChatId() = runBlocking {
        telek.sendMessage(SendMessageRequest(
            chatId = ChatId.of(qaUser),
            text = "This is a simple message send to $qaUser",
            replyMarkup = verificationInlineKeyboard
        )).verify()
    }

    @Test
    @Order(4)
    fun sendMessageSimpleByStringChatId() = runBlocking {
        telek.sendMessage(SendMessageRequest(
            chatId = ChatId.of("$qaUser"),
            text = "This is a simple message send to \"$qaUser\"",
            replyMarkup = verificationInlineKeyboard
        )).verify()
    }

    @Test
    @Order(5)
    fun sendMessageMarkdownV2() = runBlocking {
        telek.sendMessage(SendMessageRequest(
            chatId = ChatId.of(qaUser),
            text = """
                *MarkdownV2 test*
                
                Italic: _italic_
                Underline: __underline__ 
                Strikethrough: ~strikethrough~
                Markup nesting: *bold _italic bold ~italic bold strikethrough~ __underline italic bold___ bold*
                
                [Google](https://google.com)
                
                Your TG profile: [$qaUser](tg://user?id=$qaUser)
                
                `rm -rf /`
                
                ```
                data class User(
                    val id: Int,
                    val name: String
                )
                ```
                
                ```kotlin
                data class User(
                    val id: Int,
                    val name: String
                )
                ```
            """.trimIndent(),
            parseMode = ParseMode.MarkdownV2,
            replyMarkup = verificationInlineKeyboard
        )).verify()
    }

    @Test
    @Order(6)
    fun sendMessageMarkdown() = runBlocking {
        telek.sendMessage(SendMessageRequest(
            chatId = ChatId.of(qaUser),
            text = """
                *Markdown test*
                
                Italic: _italic_
                
                [Google](https://google.com)
                
                Your TG profile: [$qaUser](tg://user?id=$qaUser)
                
                `rm -rf /`
                
                ```
                data class User(
                    val id: Int,
                    val name: String
                )
                ```
                
                ```kotlin
                data class User(
                    val id: Int,
                    val name: String
                )
                ```
            """.trimIndent(),
            parseMode = ParseMode.Markdown,
            replyMarkup = verificationInlineKeyboard
        )).verify()
    }

    @Test
    @Order(7)
    fun sendMessageHTML() = runBlocking {
        telek.sendMessage(SendMessageRequest(
            chatId = ChatId.of(qaUser),
            text = """
                <b>HTML test</b>
                
                Strong: <strong>strong</strong>
                Italic: <i>italic</i>
                Emphasis: <em>emphasis</em>
                Underline: <u>underline</u>
                Inserted: <ins>inserted</ins>
                Strikethrough (&lt;s&gt;): <s>strikethrough</s>
                Strikethrough (&lt;strike&gt;): <strike>strikethrough</strike>
                Deleted: <del>strikethrough</del>
                <b>bold <i>italic bold <s>italic bold strikethrough</s> <u>underline italic bold</u></i> bold</b>
                
                <a href="https://google.com">Google</a>
                
                Your TG profile: <a href="tg://user?id=$qaUser">$qaUser</a>
                
                <code>rm -rf /</code>
                
                <pre>
                data class User(
                    val id: Int,
                    val name: String
                )
                </pre>
                
                <pre>
                    <code class="language-kotlin">
                data class User(
                    val id: Int,
                    val name: String
                )
                    </code>
                </pre>
            """.trimIndent(),
            parseMode = ParseMode.HTML,
            replyMarkup = verificationInlineKeyboard
        )).verify()
    }

    @Test
    @Order(8)
    fun sendMessageLinkWithNoPreview() = runBlocking {
        telek.sendMessage(SendMessageRequest(
            chatId = ChatId.of(qaUser),
            text = "Link with no preview: https://www.youtube.com/watch?v=dQw4w9WgXcQ",
            disableWebPagePreview = true,
            replyMarkup = verificationInlineKeyboard
        )).verify()
    }

    @Test
    @Order(9)
    fun sendMessageLinkWithPreview() = runBlocking {
        telek.sendMessage(SendMessageRequest(
            chatId = ChatId.of(qaUser),
            text = "Link with a preview: https://www.youtube.com/watch?v=dQw4w9WgXcQ",
            disableWebPagePreview = false,
            replyMarkup = verificationInlineKeyboard
        )).verify()
    }

    @Test
    @Order(10)
    fun sendMessageSilent() = runBlocking {
        telek.sendMessage(SendMessageRequest(
            chatId = ChatId.of(qaUser),
            text = "Are you ready for a silent message? Unfocus Telegram client and listen carefully!",
            replyMarkup = verificationInlineKeyboard
        )).verify()
        delay(5000)
        telek.sendMessage(SendMessageRequest(
            chatId = ChatId.of(qaUser),
            text = "This is a silent message",
            disableNotification = true,
            replyMarkup = verificationInlineKeyboard
        )).verify()
    }

    @Test
    @Order(11)
    fun sendMessageReply() = runBlocking {
        val message = telek.sendMessage(SendMessageRequest(
            chatId = ChatId.of(qaUser),
            text = "The bot will reply to this message in 1 second"
        ))
        delay(1000)
        telek.sendMessage(SendMessageRequest(
            chatId = ChatId.of(qaUser),
            text = "This is a reply",
            replyToMessageId = message.messageId,
            replyMarkup = verificationInlineKeyboard
        )).verify()
    }

    @Test
    @Order(12)
    fun sendMessageToGroup() = runBlocking {
        telek.sendMessage(SendMessageRequest(
            chatId = ChatId.of(qaGroup),
            text = "Message for group $qaGroup",
            replyMarkup = verificationInlineKeyboard
        )).verify()
    }

    @Test
    @Order(13)
    fun sendMessageToChannel() = runBlocking {
        telek.sendMessage(SendMessageRequest(
            chatId = ChatId.of(qaChannel),
            text = "Message for channel $qaChannel",
            replyMarkup = verificationInlineKeyboard
        )).verify()
    }

    @Test
    @Order(14)
    fun sendMessageToPublicChannel() = runBlocking {
        telek.sendMessage(SendMessageRequest(
            chatId = ChatId.of(qaPublicChannel),
            text = "Message for public channel $qaPublicChannel",
            replyMarkup = verificationInlineKeyboard
        )).verify()
    }

    @Test
    @Order(15)
    fun forwardMessage() = runBlocking {
        val message = telek.sendMessage(SendMessageRequest(
            chatId = ChatId.of(qaPublicChannel),
            text = "Message for public channel $qaPublicChannel",
            replyMarkup = verificationInlineKeyboard
        ))

        telek.forwardMessage(ForwardMessageRequest(
            chatId = ChatId.of(qaUser),
            fromChatId = ChatId.of(message.chat.id),
            messageId = message.messageId
        )).verify()
    }

    @Test
    @Order(16)
    fun sendPhotoByURL() = runBlocking {
        telek.sendPhoto(SendPhotoRequest(
            chatId = ChatId.of(qaUser),
            photo = URLInputFile("https://pixabay.com/get/54e6dc464f54a514f1dc8460da293276103bdee35a5271_640.jpg"),
            caption = "[Photo](https://pixabay.com/photos/milky-way-starry-sky-night-sky-star-2695569) by URL",
            parseMode = ParseMode.MarkdownV2,
            replyMarkup = verificationInlineKeyboard
        )).verify()
    }

    @Test
    @Order(17)
    fun sendPhotoById() = runBlocking {
        telek.sendPhoto(SendPhotoRequest(
            chatId = ChatId.of(qaUser),
            photo = FileIdInputFile("AgACAgQAAxkDAAICU15_ZERJnTId9SNEfmKXd8jPyzASAALgqjEb0Un8U9vMJXKk7C4iTpegGwAEAQADAgADeAADUykJAAEYBA"),
            caption = "[Photo](https://pixabay.com/photos/milky-way-starry-sky-night-sky-star-2695569) by file\\_id",
            parseMode = ParseMode.MarkdownV2,
            replyMarkup = verificationInlineKeyboard
        )).verify()
    }

    @Test
    @Order(18)
    fun sendPhotoByBytes() = runBlocking {
        telek.sendPhoto(SendPhotoRequest(
            chatId = ChatId.of(qaUser),
            photo = InputFile.BytesInputFile(
                bytes = TelekHCTest::class.java.getResource("/stars.jpg").readBytes(),
                filename = "logo.png"
            ),
            caption = "[Photo](https://pixabay.com/photos/milky-way-starry-sky-night-sky-star-2695569) by local file",
            parseMode = ParseMode.MarkdownV2,
            replyMarkup = verificationInlineKeyboard
        )).verify()
    }

    //    @Test
    //    @Order(19)
    //    fun sendAudioByURL() = runBlocking {
    //        telek.sendPhoto(SendPhotoRequest(
    //            chatId = ChatId.of(qaUser),
    //            photo = URLInputFile("https://pixabay.com/get/54e6dc464f54a514f1dc8460da293276103bdee35a5271_640.jpg"),
    //            caption = "[Photo](https://pixabay.com/photos/milky-way-starry-sky-night-sky-star-2695569) by URL",
    //            parseMode = ParseMode.MarkdownV2,
    //            replyMarkup = verificationInlineKeyboard
    //        )).verify()
    //    }

    //    @Test
    //    @Order(20)
    //    fun sendAudioById() = runBlocking {
    //        telek.sendPhoto(SendPhotoRequest(
    //            chatId = ChatId.of(qaUser),
    //            photo = FileIdInputFile("AgACAgQAAxkDAAICU15_ZERJnTId9SNEfmKXd8jPyzASAALgqjEb0Un8U9vMJXKk7C4iTpegGwAEAQADAgADeAADUykJAAEYBA"),
    //            caption = "[Photo](https://pixabay.com/photos/milky-way-starry-sky-night-sky-star-2695569) by file\\_id",
    //            parseMode = ParseMode.MarkdownV2,
    //            replyMarkup = verificationInlineKeyboard
    //        )).verify()
    //    }

    @Test
    @Order(21)
    fun sendAudioByBytes() = runBlocking {
        telek.sendAudio(SendAudioRequest(
            chatId = ChatId.of(qaUser),
            audio = InputFile.BytesInputFile(
                bytes = TelekHCTest::class.java.getResource("/telek.mp3").readBytes(),
                filename = "telek.mp3"
            ),
            caption = "Audio by local file",
            parseMode = ParseMode.MarkdownV2,
            duration = 1,
            performer = "Google",
            title = "Telek",
            thumb = InputFile.BytesInputFile(
                bytes = TelekHCTest::class.java.getResource("/stars.jpg").readBytes(),
                filename = "stars.jpg"
            ),
            replyMarkup = verificationInlineKeyboard
        )).verify()
    }

    @Test
    @Order(22)
    fun editMessageReplyMarkup() = runBlocking {
        val message = telek.sendMessage(SendMessageRequest(
            chatId = ChatId.of(qaUser),
            text = "My reply markup will change several times"
        ))
        delay(1000)
        telek.editMessageReplyMarkup(EditMessageReplyMarkupRequest(
            chatId = ChatId.of(qaUser),
            messageId = message.messageId,
            replyMarkup = InlineKeyboardMarkup(listOf(
                listOf(
                    InlineKeyboardButton(text = "1", callbackData = "1"),
                    InlineKeyboardButton(text = "2", callbackData = "2")
                )
            ))
        ))
        delay(1000)
        telek.editMessageReplyMarkup(EditMessageReplyMarkupRequest(
            chatId = ChatId.of(qaUser),
            messageId = message.messageId,
            replyMarkup = InlineKeyboardMarkup(listOf(
                listOf(
                    InlineKeyboardButton(text = "1", callbackData = "1"),
                    InlineKeyboardButton(text = "2", callbackData = "2")
                ),
                listOf(
                    InlineKeyboardButton(text = "3", callbackData = "3"),
                    InlineKeyboardButton(text = "4", callbackData = "4")
                )
            ))
        ))
        delay(1000)
        telek.editMessageReplyMarkup(EditMessageReplyMarkupRequest(
            chatId = ChatId.of(qaUser),
            messageId = message.messageId,
            replyMarkup = InlineKeyboardMarkup(listOf(
                listOf(
                    InlineKeyboardButton(text = "1", callbackData = "1"),
                    InlineKeyboardButton(text = "2", callbackData = "2"),
                    InlineKeyboardButton(text = "3", callbackData = "3")
                ),
                listOf(
                    InlineKeyboardButton(text = "4", callbackData = "4"),
                    InlineKeyboardButton(text = "5", callbackData = "5")
                ),
                listOf(
                    InlineKeyboardButton(text = "6", callbackData = "6")
                )
            ))
        ))
        delay(1000)
        telek.sendMessage(SendMessageRequest(
            chatId = ChatId.of(qaUser),
            text = "Did the reply markup under the previous message changed?",
            replyMarkup = verificationInlineKeyboard
        )).verify()
    }

    @AfterAll
    fun tearDown() = runBlocking {
        telek.sendMessage(SendMessageRequest(
            chatId = ChatId.of(qaUser),
            text = """
                *${telek::class.simpleName} smoke test finished\!*

                Job: [${System.getenv("CI_JOB_ID")}](${System.getenv("CI_JOB_URL")})
            """.trimIndent(),
            parseMode = ParseMode.MarkdownV2,
            disableWebPagePreview = true
        ))
        telek.close()
    }

    private suspend fun Message.verify() {
        while (true) {
            telek
                .getUpdates(GetUpdatesRequest(offset = offset, allowedUpdates = listOf("callback_query")))
                .find { (it.callbackQuery?.message?.messageId == this.messageId) && (it.callbackQuery?.from?.id == qaUser) }
                ?.let { update ->
                    Assertions.assertTrue(
                        telek.answerCallbackQuery(AnswerCallbackQueryRequest(callbackQueryId = update.callbackQuery?.id!!))
                    )
                    offset = update.updateId + 1
                    Assertions.assertEquals("OKAY", update.callbackQuery?.data)

                    return
                }
        }
    }
}
