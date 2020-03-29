package by.dev.madhead.telek.model.communication

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Request for [getUpdates][by.dev.madhead.telek.telek.Telek#getUpdates].
 */
@Serializable
data class GetUpdatesRequest(
    @SerialName("offset")
    val offset: Int? = null,

    @SerialName("limit")
    val limit: Int = 100,

    @SerialName("timeout")
    val timeout: Int = 0,

    @SerialName("allowed_updates")
    val allowedUpdates: List<String> = emptyList()
)
