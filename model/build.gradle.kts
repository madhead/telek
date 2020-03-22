plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    `maven-publish`
}

kotlin {
    jvm()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib"))
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:${Versions.Dependencies.KOTLINX_SERIALIZATION}")
                compileOnly(project(":detekt:annotations"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Versions.Dependencies.KOTLINX_SERIALIZATION}")
            }
        }
    }
}

dependencies {
    val detektPlugins by configurations

    detektPlugins(project(":detekt:rules"))
}
