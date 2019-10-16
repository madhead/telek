plugins {
    kotlin("jvm")
    id("com.github.johnrengelman.shadow").version("${Versions.Plugins.SHADOW}")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("io.gitlab.arturbosch.detekt:detekt-api:${Versions.Dependencies.DETEKT}")
    implementation("org.jsoup:jsoup:${Versions.Dependencies.JSOUP}")
}
