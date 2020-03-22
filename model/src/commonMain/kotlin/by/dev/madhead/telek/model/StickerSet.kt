package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object represents a sticker set.
 */
@Serializable
@TelegramBotAPIType(type = "stickerset")
data class StickerSet(
    @SerialName("name")
    val name: String,

    @SerialName("title")
    val title: String,

    @SerialName("is_animated")
    val isAnimated: Boolean,

    @SerialName("contains_masks")
    val containsMasks: Boolean,

    @SerialName("stickers")
    val stickers: List<Sticker>
)
