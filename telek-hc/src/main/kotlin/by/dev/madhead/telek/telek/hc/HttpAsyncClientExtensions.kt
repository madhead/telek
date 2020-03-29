package by.dev.madhead.telek.telek.hc

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.cancelFutureOnCancellation
import kotlinx.coroutines.suspendCancellableCoroutine
import org.apache.http.HttpResponse
import org.apache.http.client.methods.HttpUriRequest
import org.apache.http.concurrent.FutureCallback
import org.apache.http.nio.client.HttpAsyncClient

/**
 * Execute the [request] adapting future / callback style to the coroutines world.
 * More in [this article](https://ruslan.ibragimov.by/2017/06/08/how-to-use-apache-asynchttpclient-with-kotlin-coroutines).
 */
suspend fun HttpAsyncClient.exekute(request: HttpUriRequest): HttpResponse = suspendCancellableCoroutine {
    val future = this.execute(
        request,
        object : FutureCallback<HttpResponse> {
            override fun completed(result: HttpResponse) {
                it.resumeWith(Result.success(result))
            }

            override fun cancelled() {
                if (it.isCancelled) return
                it.resumeWith(Result.failure(CancellationException()))
            }

            override fun failed(ex: Exception) {
                it.resumeWith(Result.failure(ex))
            }
        }
    )

    it.cancelFutureOnCancellation(future)
}
