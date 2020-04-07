plugins {
    id("org.asciidoctor.jvm.convert")
}

tasks {
    asciidoctor {
        sources {
            include("index.adoc")
        }

        resources {
            from("../assets/src/logo.svg") {
                into("images")
            }
        }
    }
}
