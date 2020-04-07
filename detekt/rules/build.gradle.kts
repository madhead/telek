plugins {
    kotlin("jvm")
    id("com.github.johnrengelman.shadow")
    jacoco
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("io.gitlab.arturbosch.detekt:detekt-api:${Versions.Dependencies.DETEKT}")
    implementation("org.jsoup:jsoup:${Versions.Dependencies.JSOUP}")

    testImplementation(platform("org.junit:junit-bom:${Versions.Dependencies.JUNIT}"))
    testRuntimeOnly(platform("org.junit:junit-bom:${Versions.Dependencies.JUNIT}"))

    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("org.junit.jupiter:junit-jupiter-params")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks {
    withType<Test> {
        useJUnitPlatform()
        testLogging {
            showStandardStreams = true
        }
    }

    withType<JacocoReport> {
        reports {
            xml.isEnabled = true
            html.isEnabled = true
        }
    }
}
