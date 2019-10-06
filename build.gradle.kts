plugins {
    kotlin("multiplatform").version("1.3.50").apply(false)
    kotlin("plugin.serialization").version("1.3.50").apply(false)
}

allprojects {
    repositories {
        jcenter()
    }
}
