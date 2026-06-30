import java.util.Locale

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://repo.papermc.io/repository/maven-public/")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

if (!file(".git").exists()) {
    val errorText = """
        
        =====================[ ERROR ]=====================
         The Nitrogen project directory is not a properly cloned Git repository.
         
         In order to build Nitrogen from source you must clone
         the Nitrogen repository using Git, not download a code
         zip from GitHub.
         
         Built Nitrogen jars are available for download at
         https://github.com/Biquaternions/Nitrogen
         
         See https://github.com/Biquaternions/Nitrogen/blob/HEAD/CONTRIBUTING.md
         for further information on building and modifying Nitrogen.
        ===================================================
    """.trimIndent()
    error(errorText)
}

rootProject.name = "nitrogen"
for (name in listOf("nitrogen-api", "nitrogen-server")) {
    val projName = name.lowercase(Locale.ENGLISH)
    include(projName)
    findProject(":$projName")!!.projectDir = file(name)
}

gradle.lifecycle.beforeProject {
    val mcVersion = providers.gradleProperty("mcVersion").get().trim()
    val versionChannel = providers.gradleProperty("channel").get().trim()
    val buildNumber = providers.environmentVariable("BUILD_NUMBER").orNull?.trim()?.toInt()
    val versionString = if (buildNumber == null) {
        "$mcVersion.local-SNAPSHOT"
    } else {
        "$mcVersion.build.$buildNumber-${versionChannel.lowercase()}"
    }
    version = versionString
}
