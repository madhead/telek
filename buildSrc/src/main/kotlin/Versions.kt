@Suppress("UndocumentedPublicClass")
object Versions {
    object Plugins {
        const val KOTLIN = "1.3.70"
        const val KTLINT = "9.2.1"
        const val DETEKT = "1.7.0"
        const val DOCKER = "6.3.0"
        const val SHADOW = "5.2.0"
    }

    object Dependencies {
        const val DETEKT = Plugins.DETEKT
        const val JSOUP = "1.13.1"
        const val KOTLINX_SERIALIZATION = "0.20.0"
        const val JUNIT = "5.6.0"
    }
}
