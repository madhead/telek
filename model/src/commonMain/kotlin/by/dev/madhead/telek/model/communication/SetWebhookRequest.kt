package by.dev.madhead.telek.model.communication

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Request for [setWebhook][by.dev.madhead.telek.telek.Telek#setWebhook].
 */
@Serializable
data class SetWebhookRequest(
    @SerialName("url")
    val url: String,

    @SerialName("certificate")
    val certificate: InputFile,

    @SerialName("max_connections")
    val maxConnections: Int? = 40,

    @SerialName("allowed_updates")
    val allowedUpdates: List<String> = emptyList()
)
