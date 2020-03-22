package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object represents a file ready to be downloaded.
 * The file can be downloaded via the link `https://api.telegram.org/file/bot<token>/<file_path>`.
 * It is guaranteed that the link will be valid for at least 1 hour.
 * When the link expires, a new one can be requested by calling [getFile][https://core.telegram.org/bots/api#getfile].
 */
@Serializable
@TelegramBotAPIType(type = "file")
data class File(
    @SerialName("file_id")
    val fileId: String,

    @SerialName("file_unique_id")
    val fileUniqueId: String,

    @SerialName("file_size")
    val fileSize: Int? = null,

    @SerialName("file_path")
    val filePath: String? = null
)
