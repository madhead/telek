package by.dev.madhead.telek.model

import by.dev.madhead.telek.detekt.annotations.TelegramBotAPIType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Contains information about the current status of a webhook.
 */
@Serializable
@TelegramBotAPIType(type = "webhookinfo")
data class WebhookInfo(
    @SerialName("url")
    val url: String,

    @SerialName("has_custom_certificate")
    val hasCustomCertificate: Boolean,

    @SerialName("pending_update_count")
    val pendingUpdateCount: Int,

    @SerialName("last_error_date")
    val lastErrorDate: Int? = null,

    @SerialName("last_error_message")
    val lastErrorMessage: String? = null,

    @SerialName("max_connections")
    val maxConnections: Int? = null,

    @SerialName("allowed_updates")
    val allowedUpdates: List<String>? = null
)
