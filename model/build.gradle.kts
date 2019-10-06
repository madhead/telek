plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
}

kotlin {
    jvm()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib"))
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:0.13.0")
                compileOnly(project(":detekt:annotations"))
            }
        }
    }
}

dependencies {
    val detektPlugins by configurations

    detektPlugins(project(":detekt:rules"))
}
