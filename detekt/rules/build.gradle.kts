plugins {
    kotlin("jvm")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("io.gitlab.arturbosch.detekt:detekt-api:${Versions.Dependencies.DETEKT}")
    implementation("io.gitlab.arturbosch.detekt:detekt-test:${Versions.Dependencies.DETEKT}")
}
