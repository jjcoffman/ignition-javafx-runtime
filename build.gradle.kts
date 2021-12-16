
plugins {
    id("io.ia.sdk.modl") version("0.1.0")
}

allprojects  {
    group = "io.ia.vision.javafx"
    version = "0.0.1-SNAPSHOT"
}

val javafxVersion = "15.0.1" // Update the fields in the javafx.xml too if you change this.

val macJfxDep by configurations.creating { isTransitive = false }
val winJfxDep by configurations.creating { isTransitive = false }
val linuxJfxDep by configurations.creating { isTransitive = false }

dependencies {
    macJfxDep("org.openjfx:javafx-base:${javafxVersion}:mac")
    macJfxDep("org.openjfx:javafx-graphics:${javafxVersion}:mac")
    macJfxDep("org.openjfx:javafx-controls:${javafxVersion}:mac")
    winJfxDep("org.openjfx:javafx-base:${javafxVersion}:win")
    winJfxDep( "org.openjfx:javafx-graphics:${javafxVersion}:win")
    winJfxDep( "org.openjfx:javafx-controls:${javafxVersion}:win")
    linuxJfxDep("org.openjfx:javafx-base:${javafxVersion}:linux")
    linuxJfxDep("org.openjfx:javafx-graphics:${javafxVersion}:linux")
    linuxJfxDep("org.openjfx:javafx-controls:${javafxVersion}:linux")
}

// Add a task to run the functional tests
val buildJavafxOptDir by tasks.registering(Copy::class) {
    from(macJfxDep.files)
    from(winJfxDep.files)
    from(linuxJfxDep.files)
    from("javafx.xml")
    into("build/opt/javafx")
    inputs.property("javafxVersion", javafxVersion)
    outputs.dir("build/opt/javafx")
}

tasks {
    build {
        dependsOn(buildJavafxOptDir)
    }
}


ignitionModule {
    fileName.set("Vision-Javafx-module")

    // module xml configuration
    name.set("Vision Javafx")
    id.set("io.ia.vision.javafx")
    moduleVersion.set(version.toString())
    moduleDescription.set(
        "A module that provides the javafx libraries to vision clients and the designer"
    )
    requiredIgnitionVersion.set("8.1.0")
    requiredFrameworkVersion.set("7")
    projectScopes.putAll(mapOf(
        ":ignition-javafx-client" to "CD",
        ":ignition-javafx-designer" to "D",
    ))
    hooks.putAll(mapOf())
    requireFromPlatform.put("javafx", "CD")

    moduleDependencies.putAll(mapOf(
        "com.inductiveautomation.vision" to "CD"
    ))

    license.set("license.html")
}
