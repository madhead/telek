import com.bmuschko.gradle.docker.tasks.container.DockerCreateContainer
import com.bmuschko.gradle.docker.tasks.container.DockerRemoveContainer
import com.bmuschko.gradle.docker.tasks.container.DockerStartContainer
import com.bmuschko.gradle.docker.tasks.container.DockerWaitContainer
import com.bmuschko.gradle.docker.tasks.image.DockerPullImage
import org.gradle.internal.os.OperatingSystem

plugins {
    id("com.bmuschko.docker-remote-api").version(Versions.Plugins.DOCKER)
}

tasks {
    val updateProjectLogo by creating

    val pullImage by creating(DockerPullImage::class) {
        repository.set("madhead/imagemagick")
        tag.set("latest")
    }

    val createContainer by creating(DockerCreateContainer::class) {
        dependsOn(pullImage)
        targetImageId { pullImage.imageId.get() }
        binds.set(
            mapOf(
                "$projectDir/src" to "/src",
                "${rootProject.projectDir}" to "/build"
            )
        )
        if (OperatingSystem.current().isUnix) {
            user.set(
                "ug"
                    .map {
                        Runtime.getRuntime().exec("id -$it").let {
                            it.waitFor(@Suppress("MagicNumber") 5, TimeUnit.SECONDS)
                            if (it.exitValue() != 0) {
                                throw GradleException("Failed to get current user details")
                            }
                            it.inputStream.bufferedReader().use { it.readText() }
                        }
                    }.joinToString(":") {
                        it.trim()
                    }
            )
        }
        cmd.set(
            listOf(
                "convert",
                "-background",
                "none",
                "-density",
                "300",
                "-resize",
                "128x128",
                "/src/logo.svg",
                "/build/logo.png"
            )
        )
    }

    val startContainer by creating(DockerStartContainer::class) {
        dependsOn(createContainer)
        targetContainerId { createContainer.containerId.get() }
    }

    val waitContainer by creating(DockerWaitContainer::class) {
        dependsOn(startContainer)
        targetContainerId { createContainer.containerId.get() }
    }

    val removeContainer by creating(DockerRemoveContainer::class) {
        targetContainerId { createContainer.containerId.get() }
    }

    updateProjectLogo.dependsOn(waitContainer)
    updateProjectLogo.finalizedBy(removeContainer)
}
