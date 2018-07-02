import com.bmuschko.gradle.docker.tasks.container.DockerCreateContainer
import com.bmuschko.gradle.docker.tasks.container.DockerRemoveContainer
import com.bmuschko.gradle.docker.tasks.container.DockerStartContainer
import com.bmuschko.gradle.docker.tasks.container.DockerWaitContainer
import com.bmuschko.gradle.docker.tasks.image.DockerPullImage
import org.apache.tools.ant.taskdefs.condition.Os
import org.gradle.internal.os.OperatingSystem

plugins {
	id("com.bmuschko.docker-remote-api").version("3.4.0")
}

tasks {
	val updateProjectLogo by creating

	val pullImage by creating(DockerPullImage::class) {
		repository = "madhead/imagemagick"
		tag = "latest"
	}

	val createContainer by creating(DockerCreateContainer::class) {
		dependsOn(pullImage)
		targetImageId { pullImage.imageId }
		binds = mapOf(
			"$projectDir/src" to "/src",
			"${rootProject.projectDir}" to "/build"
		)
		// FIXME: Not sure what to do with other OSes
		if (OperatingSystem.current().isUnix) {
			user = "ug"
				.map {
					Runtime.getRuntime().exec("id -$it").let {
						it.waitFor(5, TimeUnit.SECONDS)
						if (it.exitValue() != 0) {
							throw GradleException("Failed to get current user details")
						}
						it.inputStream.bufferedReader().use { it.readText() }
					}
				}.map {
					it.trim()
				}.joinToString(":")
		}
		setCmd(
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
	}

	val startContainer by creating(DockerStartContainer::class) {
		dependsOn(createContainer)
		targetContainerId { createContainer.containerId }
	}

	val waitContainer by creating(DockerWaitContainer::class) {
		dependsOn(startContainer)
		targetContainerId { createContainer.containerId }
	}

	val removeContainer by creating(DockerRemoveContainer::class) {
		targetContainerId { createContainer.containerId }
	}

	updateProjectLogo.dependsOn(waitContainer)
	updateProjectLogo.finalizedBy(removeContainer)
}
