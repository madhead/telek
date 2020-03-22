package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object represent a user's profile pictures.
 */
@Serializable
@TelegramBotAPIType(type = "userprofilephotos")
data class UserProfilePhotos(
    @SerialName("total_count")
    val totalCount: Int,
    @SerialName("photos")
    val photos: List<List<PhotoSize>>
)
