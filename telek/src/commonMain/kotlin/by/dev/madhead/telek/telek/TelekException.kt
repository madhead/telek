package by.dev.madhead.telek.telek

import by.dev.madhead.telek.model.communication.Response

/**
 * Thrown upon receiving [unsuccessful][by.dev.madhead.telek.model.communication.Response.Unsuccessful] responses from Telegram Bot API.
 */
class TelekException : RuntimeException {
    val response: Response?

    constructor(response: Response? = null) : super() {
        this.response = response
    }

    constructor(
        message: String?,
        response: Response? = null
    ) : super(message) {
        this.response = response
    }

    constructor(
        message: String?,
        cause: Throwable?,
        response: Response? = null
    ) : super(message, cause) {
        this.response = response
    }

    constructor(
        cause: Throwable?,
        response: Response? = null
    ) : super(cause) {
        this.response = response
    }
}
