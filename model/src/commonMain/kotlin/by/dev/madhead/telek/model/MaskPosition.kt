package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This object describes the position on faces where a mask should be placed by default.
 */
@Serializable
@TelegramBotAPIType(type = "maskposition")
data class MaskPosition(
    @SerialName("point")
    val point: String,

    @SerialName("x_shift")
    val xShift: Double,

    @SerialName("y_shift")
    val yShift: Double,

    @SerialName("scale")
    val scale: Double
)
