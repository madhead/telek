import io.gitlab.arturbosch.detekt.DetektPlugin
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.jlleitschuh.gradle.ktlint.KtlintExtension
import org.jlleitschuh.gradle.ktlint.KtlintPlugin
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

plugins {
    kotlin("multiplatform").version(Versions.Plugins.KOTLIN).apply(false)
    kotlin("plugin.serialization").version(Versions.Plugins.KOTLIN).apply(false)
    id("org.jlleitschuh.gradle.ktlint").version(Versions.Plugins.KTLINT).apply(false)
    id("io.gitlab.arturbosch.detekt").version(Versions.Plugins.DETEKT).apply(false)
}

allprojects {
    repositories {
        jcenter()
    }
}

allprojects {
    apply<KtlintPlugin>()
    apply<DetektPlugin>()

    configure<KtlintExtension> {
        verbose.set(true)
        reporters {
            reporter(ReporterType.PLAIN)
            reporter(ReporterType.CHECKSTYLE)
        }
    }
    configure<DetektExtension> {
        parallel = true
        config = files("$rootDir/config/detekt/detekt.yml")
        buildUponDefaultConfig = false
        input = files(projectDir)
    }
}

dependencies {
    val detektPlugins by configurations

    detektPlugins(project(":detekt:rules"))
}
