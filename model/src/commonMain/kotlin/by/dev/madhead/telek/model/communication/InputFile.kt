package by.dev.madhead.telek.model.communication

import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.PrimitiveDescriptor
import kotlinx.serialization.PrimitiveKind
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer

/**
 * This object represents the contents of a file to be uploaded.
 * There are three ways to send files (photos, stickers, audio, media, etc.):
 * - If the file is already stored somewhere on the Telegram servers, you don't need to reupload it: each file object has a file_id field,
 * simply pass this file_id as a parameter instead of uploading. There are no limits for files sent this way.
 * - Provide Telegram with an HTTP URL for the file to be sent. Telegram will download and send the file. 5 MB max size for photos and
 * 20 MB max for other types of content.
 * - Post the file using multipart/form-data in the usual way that files are uploaded via the browser. 10 MB max size for photos,
 * 50 MB for other files.
 */
@Serializable
sealed class InputFile {
    @Serializer(forClass = InputFile::class)
    companion object : KSerializer<InputFile> {
        override val descriptor: SerialDescriptor = PrimitiveDescriptor("InputFile", PrimitiveKind.STRING)

        override fun serialize(encoder: Encoder, value: InputFile) = when (value) {
            is StringInputFile -> encoder.encodeString(value.value)
            else -> throw IllegalArgumentException("This InputFile should not be sent in JSON payload.")
        }
    }

    /**
     * Used to pass *URL* or *file_id* as InputFile.
     */
    data class StringInputFile(val value: String) : InputFile()

    /**
     * Used to pass a local file as InputFile.
     */
    data class FilePathInputFile(val path: String) : InputFile()

    /**
     * Used to pass raw bytes as InputFile.
     */
    @Suppress("ForbiddenComment") // TODO: Use kotlinx.io
    data class BytesInputFile(@Suppress("ArrayInDataClass") val bytes: ByteArray, val filename: String? = null) : InputFile()
}

typealias FileIdInputFile = InputFile.StringInputFile

typealias URLInputFile = InputFile.StringInputFile
