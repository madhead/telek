package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName

@TelegramBotAPIType(type = "file")
data class File(
    @SerialName("file_id")
    val fileId: String,

    @SerialName("file_size")
    val fileSize: Int? = null,

    @SerialName("file_path")
    val filePath: String? = null
)
