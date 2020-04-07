@Suppress("UndocumentedPublicClass")
object Versions {
    object Plugins {
        const val KOTLIN = "1.3.70"
        const val KTLINT = "9.2.1"
        const val DETEKT = "1.7.0"
        const val DOCKER = "6.3.0"
        const val SHADOW = "5.2.0"
        const val DOKKA = "0.10.1"
        const val ASCIIDOCTOR = "3.1.0"
    }

    object Dependencies {
        const val DETEKT = Plugins.DETEKT
        const val JSOUP = "1.13.1"
        const val KOTLINX_SERIALIZATION = "0.20.0"
        const val KOTLINX_COROUTINES = "1.3.5"
        const val HTTPASYNCCLIENT = "4.1.4"
        const val HTTPMIME = "4.5.12"
        const val LOG4J = "2.13.1"
        const val JUNIT = "5.6.0"
    }
}
