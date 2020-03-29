plugins {
    kotlin("jvm")
    jacoco
}

sourceSets {
    val smoke by registering {
        compileClasspath += sourceSets.main.get().output
        runtimeClasspath += sourceSets.main.get().output
    }
}

configurations {
    val smokeImplementation by getting {
        extendsFrom(configurations.implementation.get())
    }

    val smokeRuntimeOnly by getting {
        extendsFrom(configurations.runtimeOnly.get())
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    api(project(":telek"))
    implementation("org.apache.httpcomponents:httpasyncclient:${Versions.Dependencies.HTTPASYNCCLIENT}")
    implementation("org.apache.httpcomponents:httpmime:${Versions.Dependencies.HTTPMIME}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Dependencies.KOTLINX_COROUTINES}")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Versions.Dependencies.KOTLINX_SERIALIZATION}")
    implementation(platform("org.apache.logging.log4j:log4j-bom:${Versions.Dependencies.LOG4J}"))
    implementation("org.apache.logging.log4j:log4j-api")

    testImplementation(platform("org.junit:junit-bom:${Versions.Dependencies.JUNIT}"))
    testRuntimeOnly(platform("org.junit:junit-bom:${Versions.Dependencies.JUNIT}"))
    testRuntimeOnly(platform("org.apache.logging.log4j:log4j-bom:${Versions.Dependencies.LOG4J}"))
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("org.junit.jupiter:junit-jupiter-params")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testRuntimeOnly("org.apache.logging.log4j:log4j-core")

    val smokeImplementation by configurations
    val smokeRuntimeOnly by configurations

    smokeImplementation(platform("org.junit:junit-bom:${Versions.Dependencies.JUNIT}"))
    smokeRuntimeOnly(platform("org.junit:junit-bom:${Versions.Dependencies.JUNIT}"))
    smokeRuntimeOnly(platform("org.apache.logging.log4j:log4j-bom:${Versions.Dependencies.LOG4J}"))
    smokeImplementation("org.junit.jupiter:junit-jupiter-api")
    smokeImplementation("org.junit.jupiter:junit-jupiter-params")
    smokeRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    smokeRuntimeOnly("org.apache.logging.log4j:log4j-core")
    smokeRuntimeOnly("org.apache.logging.log4j:log4j-jcl")
}

tasks {
    val smokeTest by registering(Test::class) {
        description = "Smoke tests."
        group = "verification"
        shouldRunAfter("test")
        testClassesDirs = sourceSets["smoke"].output.classesDirs
        classpath = sourceSets["smoke"].runtimeClasspath
    }

    val check by getting {
        dependsOn(smokeTest)
    }

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
