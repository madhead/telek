import org.jlleitschuh.gradle.ktlint.KtlintExtension
import org.jlleitschuh.gradle.ktlint.KtlintPlugin
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

plugins {
    kotlin("multiplatform").version(Versions.Plugins.KOTLIN).apply(false)
    kotlin("plugin.serialization").version(Versions.Plugins.KOTLIN).apply(false)
    id("org.jlleitschuh.gradle.ktlint").version(Versions.Plugins.KTLINT).apply(false)
}

allprojects {
    repositories {
        jcenter()
    }
}

allprojects {
    apply<KtlintPlugin>()

    configure<KtlintExtension> {
        verbose.set(true)
        reporters {
            reporter(ReporterType.PLAIN)
            reporter(ReporterType.CHECKSTYLE)
        }
    }
}
