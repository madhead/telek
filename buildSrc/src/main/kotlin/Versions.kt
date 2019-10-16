@Suppress("UndocumentedPublicClass")
object Versions {
    object Plugins {
        const val KOTLIN = "1.3.50"
        const val KTLINT = "9.0.0"
        const val DETEKT = "1.1.0"
        const val DOCKER = "5.2.0"
        const val SHADOW = "5.1.0"
    }

    object Dependencies {
        const val DETEKT = Plugins.DETEKT
        const val JSOUP = "1.12.1"
    }
}
