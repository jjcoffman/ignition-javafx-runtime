
pluginManagement {
    repositories {
        mavenLocal()
        maven {
            url = uri("https://nexus.inductiveautomation.com/repository/inductiveautomation-releases")
            isAllowInsecureProtocol = true
        }
        gradlePluginPortal()
        mavenCentral()
    }
}
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(
    ":",
    ":ignition-javafx-client",
    ":ignition-javafx-designer"
)

dependencyResolutionManagement {
    repositories {
        mavenLocal()
        maven {
            url = uri("https://nexus.inductiveautomation.com/repository/inductiveautomation-releases")
        }
        maven {
            url = uri("https://nexus.inductiveautomation.com/repository/inductiveautomation-snapshots")
        }
        maven {
            url = uri("https://nexus.inductiveautomation.com/repository/inductiveautomation-thirdparty")
        }
        mavenCentral()
    }
}
